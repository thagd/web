package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@Controller
@RequestMapping("/locacoes")
public class LocacaoController {
	
	@Autowired
	private ILocacaoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Locacao locacao) {
		return "locacao/cadastro";
	}
	
    /*
	@GetMapping("/listar")
	public String listar(ModelMap model) {
        // pegar valor do email do usuario logado
		model.addAttribute("locacoes", service.buscarTodos(email));
		return "locacao/lista";
	}
    */
	
	@PostMapping("/salvar")
	public String salvar(@Valid Locacao locacao, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locacao/cadastro";
		}
		
		service.salvar(locacao);
		attr.addFlashAttribute("sucess", "Locacao inserida com sucesso.");
		return "redirect:/locacoes/listar";
	}
}