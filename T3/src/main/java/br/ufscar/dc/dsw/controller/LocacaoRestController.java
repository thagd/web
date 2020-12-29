package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@CrossOrigin
@RestController
public class LocacaoRestController {

	@Autowired
 private ILocacaoService service;

	@GetMapping(path = "/locacoes")
	public ResponseEntity<List<Locacao>> lista() {
		List<Locacao> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
    }

	@GetMapping(path = "/locacoes/{id}")
	public ResponseEntity<Locacao> lista(@PathVariable("id") long id) {
		Locacao locacao = service.buscarPorId(id);
		if (locacao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(locacao);
    }

    @GetMapping(path = "/locacoes/clientes/{id}")
	public ResponseEntity<List<Locacao>> listaCliente(@PathVariable("id") long id) {
		List<Locacao> lista = service.buscarTodosClienteById(id);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
    }

    @GetMapping(path = "/locacoes/locadoras/{id}")
	public ResponseEntity<List<Locacao>> listaLocadora(@PathVariable("id") long id) {
		List<Locacao> lista = service.buscarTodosLocadoraById(id);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
    }
}