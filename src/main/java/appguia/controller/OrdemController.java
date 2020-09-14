package appguia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import appguia.model.negocio.Ordem;
import appguia.model.service.OrdemService;

@Controller
public class OrdemController {

	@Autowired private OrdemService ordemService;
	
	@GetMapping(value = "/ordem")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "ordem/detalhe";
	}
	
	@GetMapping(value = "/ordens")
	public String lista(
				Model model
			) {
		model.addAttribute("ordens", ordemService.obterLista());
		
		return "ordem/lista";
	}
	
	@PostMapping(value = "/ordem/incluir")
	public String incluir(
				Ordem ordem
				) {
		
		ordemService.incluir(ordem);
		
		return "redirect:/ordens";
	}

	@GetMapping(value = "/ordem/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			ordemService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão deste item!!");
			return this.lista(model);
		}
		
		return "redirect:/ordens";
	}
	
	@GetMapping(value = "/ordem/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		
		model.addAttribute("ordem", ordemService.obterPorId(id));
		model.addAttribute("operacao", "alteração");
		
		return "ordem/detalhe";
	}
}