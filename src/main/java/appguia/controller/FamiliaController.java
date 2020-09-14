package appguia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import appguia.model.negocio.Familia;
import appguia.model.service.FamiliaService;

@Controller
public class FamiliaController {
	
	@Autowired private FamiliaService familiaService;
	
	@GetMapping(value = "/familia")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "familia/detalhe";
	}
	
	@GetMapping(value = "/familias")
	public String lista(
				Model model
			) {
		model.addAttribute("familias", familiaService.obterLista());
		
		return "familia/lista";
	}
	
	@PostMapping(value = "/familia/incluir")
	public String incluir(
				Familia familia
				) {
		
		familiaService.incluir(familia);
		
		return "redirect:/familias";
	}

	@GetMapping(value = "/familia/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			familiaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão deste item!!");
			return this.lista(model);
		}
		
		return "redirect:/familias";
	}
	
	@GetMapping(value = "/familia/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		
		model.addAttribute("familia", familiaService.obterPorId(id));
		model.addAttribute("operacao", "alteração");
		
		return "familia/detalhe";
	}
}