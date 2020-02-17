package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Pessoa;
import br.com.erudio.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoa;
	
	// Método que retorna uma pessoa na busca pelo ID
	@GetMapping(value="/{id}")
	public Pessoa findById(@PathVariable("id") Long id) {
		return pessoa.findById(id); 
	}
	
	// Método que retorna uma lista com pessoas
	@GetMapping
	public List<Pessoa> findAll(){
		return pessoa.findAll(); 
	}
	
	@PostMapping
	public Pessoa criarPessoa(@RequestBody Pessoa p){
		return pessoa.criarPessoa(p);
	}
	
	@PutMapping
	public Pessoa atualizarPessoa(@RequestBody Pessoa p){
		return pessoa.atualizarPessoa(p);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deletarPessoa(@PathVariable("id") Long id){
		 pessoa.deletarPessoa(id);
		 return ResponseEntity.ok().build();
	}
}
