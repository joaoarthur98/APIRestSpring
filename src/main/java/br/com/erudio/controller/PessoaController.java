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

import br.com.erudio.data.vo.PessoaVO;
import br.com.erudio.data.vo.v2.PessoaVOV2;
import br.com.erudio.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoa;
	
	// Método que retorna uma PessoaVO na busca pelo ID
	@GetMapping(value="/{id}")
	public PessoaVO findById(@PathVariable("id") Long id) {
		return pessoa.findById(id); 
	}
	
	// Método que retorna uma lista com PessoaVOs
	@GetMapping
	public List<PessoaVO> findAll(){
		return pessoa.findAll(); 
	}
	
	@PostMapping
	public PessoaVO criarPessoaVO(@RequestBody PessoaVO p){
		return pessoa.criarPessoa(p);
	}
	
	@PostMapping("v2")
	public PessoaVOV2 criarPessoaVOv2(@RequestBody PessoaVOV2 p){
		return pessoa.criarPessoaV2(p);
	}
	
	@PutMapping
	public PessoaVO atualizarPessoaVO(@RequestBody PessoaVO p){
		return pessoa.atualizarPessoa(p);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deletarPessoaVO(@PathVariable("id") Long id){
		 pessoa.deletarPessoa(id);
		 return ResponseEntity.ok().build();
	}
}
