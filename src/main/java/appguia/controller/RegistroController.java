package appguia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import appguia.model.negocio.Registro;
import appguia.model.negocio.Ave;
import appguia.model.service.RegistroService;
import appguia.model.service.AveService;
import appguia.model.service.ObservadorService;

@Controller
public class RegistroController {
	@Autowired private AveService aveService;
	@Autowired private RegistroService registroService;
	@Autowired private ObservadorService observadorService;

	@GetMapping(value = "/registro")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		model.addAttribute("aves", aveService.obterLista());
		model.addAttribute("observadores", observadorService.obterLista());
		
		return "registro/detalhe";
	}

	@GetMapping(value = "/registros")
	public String lista(
				Model model
			) {
		model.addAttribute("registros", registroService.obterLista());
		
		return "registro/lista";
	}
	
	@PostMapping(value = "/registro/incluir")
	public String incluir(
				Model model,
				@RequestParam String[] avesIds,
				Registro registro
			) {
		
		List<Ave> lista = new ArrayList<Ave>();
		
		for(String id : avesIds) {
			lista.add(new Ave(Integer.valueOf(id)));
		}
		
		registro.setAves(lista);
		
		registroService.incluir(registro);

		return "redirect:/registros";
	}
	
	@GetMapping(value = "/registro/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			registroService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão deste item!!");
			return this.lista(model);
		}
		
		return "redirect:/registros";
	}
	@GetMapping(value = "/registro/{id}/consultar")
	public String consultar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "consulta");
		
		model.addAttribute("registro", registroService.obterPorId(id));
		
		return "registro/consulta";
	}
}
