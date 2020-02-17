package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.NaoEncontradoException;
import br.com.erudio.model.Pessoa;
import br.com.erudio.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	public Pessoa findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new NaoEncontradoException("Nenhum registro encontrado para esse id!"));
	}	
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa criarPessoa(Pessoa p) {
		return repository.save(p);
	}
	
	public Pessoa atualizarPessoa(Pessoa p) {
		Pessoa entidade = repository.findById(p.getId()).orElseThrow(
				() -> new NaoEncontradoException("Nenhum registro encontrado para esse id!"));
		
		entidade.setNome(p.getNome());
		entidade.setSobrenome(p.getSobrenome());
		entidade.setEndereco(p.getEndereco());
		entidade.setSexo(p.getSexo());
		return repository.save(entidade);
	}
	
	public void deletarPessoa(Long id) {
		Pessoa entidade = repository.findById(id).orElseThrow(
				() -> new NaoEncontradoException("Nenhum registro encontrado para esse id!"));
		
		repository.delete(entidade);
	}
	
}
