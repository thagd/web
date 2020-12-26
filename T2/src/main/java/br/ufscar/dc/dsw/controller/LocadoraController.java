package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.IUsuarioService;

@Controller
@RequestMapping("/locadoras")
public class LocadoraController {
	
	@Autowired
	private IUsuarioService service;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		return "locadora/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		String role = "ROLE_LOCADORA";
		model.addAttribute("locadoras", service.buscarTodosRole(role));
		return "locadora/lista";
	}

    @GetMapping("/listar-cidade")
	public String listar_cidade(String cidade, ModelMap model) {
		model.addAttribute("locadoras", service.buscarTodosCidade(cidade));
		return "locadora/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locadora/cadastro";
		}
		
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuario.setRole("ROLE_LOCADORA");

		service.salvar(usuario);
		attr.addFlashAttribute("sucess", "Locadora inserida com sucesso.");
		return "redirect:/locadoras/listar";
	}

    @GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", service.buscarPorId(id));
		return "locadora/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locadora/cadastro";
		}

		usuario.setRole("ROLE_LOCADORA");

		service.salvar(usuario);
		attr.addFlashAttribute("sucess", "Locadora editada com sucesso.");
		return "redirect:/locadoras/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		/*
		if (service.locadoraTemLocacoes(id)) {
			model.addAttribute("fail", "Locadora não excluída. Possui locações vinculadas.");
		} else {
			service.excluir(id);
			model.addAttribute("sucess", "Locadora excluída com sucesso.");
		}*/
		service.excluir(id);
		model.addAttribute("sucess", "Locadora excluída com sucesso.");
		return listar(model);
	}
}