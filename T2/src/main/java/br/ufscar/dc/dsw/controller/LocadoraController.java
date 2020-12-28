package br.ufscar.dc.dsw.controller;

import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Endereco;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Controller
@RequestMapping("/locadoras")
public class LocadoraController {
	
	@Autowired
	private ILocadoraService service;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Locadora locadora) {
		return "locadora/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("locadoras", service.buscarTodos());
		return "locadora/lista";
	}

	@GetMapping("/procurar")
	public String procurar(ModelMap model) {
		model.addAttribute("endereco", new Endereco());
		return "locadora/lista-cidade";
	}

	@PostMapping("/listar-cidade")
	public String listar_cidade(Endereco endereco, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "locadora/listar-cidade";
		}

		model.addAttribute("locadoras", service.buscarTodosPorCidade(endereco.getCidade()));
		return "locadora/lista-cidade";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locadora/cadastro";
		}
		
		locadora.setSenha(encoder.encode(locadora.getSenha()));
		locadora.setRole("ROLE_LOCADORA");

		service.salvar(locadora);
		attr.addFlashAttribute("sucess", "Locadora inserida com sucesso.");
		return "redirect:/locadoras/listar";
	}

    @GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("locadora", service.buscarPorId(id));
		return "locadora/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locadora/cadastro";
		}

		locadora.setRole("ROLE_LOCADORA");

		service.salvar(locadora);
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

	private List<Locadora> removeRepeteco(List<Locadora> locadoras) {
		List<Locadora> newLocadoras = new ArrayList<Locadora>();

		for(Locadora locadora : locadoras){
			boolean tem = false;

			for(Locadora newLocadora : newLocadoras){
				if(locadora.getCidade().equals(newLocadora.getCidade())){
					tem = true;
				}
			}

			if(!tem){
				newLocadoras.add(locadora);
			}
		}
		
		return newLocadoras;
	}

	@ModelAttribute("locadorasCidade")
	public List<Locadora> listaLocadoras() {
		return this.removeRepeteco(service.buscarTodos());
	}
}