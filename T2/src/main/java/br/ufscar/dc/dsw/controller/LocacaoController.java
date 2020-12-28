package br.ufscar.dc.dsw.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;
import br.ufscar.dc.dsw.security.UsuarioDetails;

@Controller
@RequestMapping("/locacoes")
public class LocacaoController {
	
	@Autowired
	private ILocacaoService service;

	@Autowired
	private ILocadoraService locadoraService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Locacao locacao) {
		return "locacao/cadastro";
	}

	private String getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsername();
	}

	private String getRole() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Usuario usuario = usuarioDetails.getUsuario();
		return usuario.getRole();
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		if(this.getRole().equals("ROLE_CLIENTE")){
			model.addAttribute("locacoes", service.buscarTodosCliente(this.getUsuario()));
		} else if(this.getRole().equals("ROLE_LOCADORA")){
			model.addAttribute("locacoes", service.buscarTodosLocadora(this.getUsuario()));
		}
		return "locacao/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Locacao locacao, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "locacao/cadastro";
		}
		
		locacao.setCliente(this.getUsuario());
		
		if (service.verificaLocacao(this.getUsuario(), locacao.getLocadora(), locacao.getHorario(), locacao.getData())) {
			attr.addFlashAttribute("fail", "Locação não permitida nesta data/horário.");
			return "redirect:/locacoes/cadastrar";
		}

		service.salvar(locacao);
		attr.addFlashAttribute("sucess", "Locação inserida com sucesso.");
		return "redirect:/locacoes/listar";
	}

	@ModelAttribute("locadoras")
	public List<Locadora> listaLocadoras() {
		return locadoraService.buscarTodos();
	}
}