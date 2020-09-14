package appguia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import appguia.model.negocio.Especie;
import appguia.model.service.EspecieService;

@Controller
public class EspecieController {

	@Autowired private EspecieService especieService;
	
	@GetMapping(value = "/especie")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "especie/detalhe";
	}
	
	@GetMapping(value = "/especies")
	public String lista(
				Model model
			) {
		model.addAttribute("especies", especieService.obterLista());
		
		return "especie/lista";
	}
	
	@PostMapping(value = "/especie/incluir")
	public String incluir(
				Especie especie
				) {
		
		especieService.incluir(especie);
		
		return "redirect:/especies";
	}

	@GetMapping(value = "/especie/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			especieService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão deste item!!");
			return this.lista(model);
		}
		
		return "redirect:/especies";
	}
	
	@GetMapping(value = "/especie/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		
		model.addAttribute("especie", especieService.obterPorId(id));
		model.addAttribute("operacao", "alteração");
		
		return "especie/detalhe";
	}
}