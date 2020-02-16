package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Pessoa;
import br.com.erudio.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoa;
	
	// Método que retorna uma pessoa na busca pelo ID
	@RequestMapping(value="/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa findById(@PathVariable("id") String id) {
		return pessoa.findById(id); 
	}
	
	// Método que retorna uma lista com pessoas
	@RequestMapping(method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> findAll(){
		return pessoa.findAll(); 
	}
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa criarPessoa(@RequestBody Pessoa p){
		return pessoa.criarPessoa(p);
	}
	
	@RequestMapping(method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa atualizarPessoa(@RequestBody Pessoa p){
		return pessoa.atualizarPessoa(p);
	}
	
	@RequestMapping(value="/{id}",
			method = RequestMethod.DELETE)
	public void deletarPessoa(@PathVariable("id") String id){
		 pessoa.deletarPessoa(id);
	}
}
