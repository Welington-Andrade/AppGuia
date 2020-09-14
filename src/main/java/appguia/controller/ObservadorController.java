package appguia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import appguia.model.negocio.Observador;
import appguia.model.service.ObservadorService;

@Controller
public class ObservadorController {

@Autowired private ObservadorService observadorService;
	
	@GetMapping(value = "/observador")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "observador/detalhe";
	}
	
	@GetMapping(value = "/observadores")
	public String lista(
				Model model
			) {
		model.addAttribute("observadores", observadorService.obterLista()); 
		
		return "observador/lista";
	}
	
	@PostMapping(value = "/observador/incluir")
	public String incluir(
				Observador observador
			) {
		
		observadorService.incluir(observador);
		
		return "redirect:/observadores";
	}
	
	@GetMapping(value = "/observador/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			observadorService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/observadores";
	}
	
	@GetMapping(value = "/observador/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "alteração");
		
		model.addAttribute("observador", observadorService.obterPorId(id));
		
		return "observador/detalhe";
	}
}
