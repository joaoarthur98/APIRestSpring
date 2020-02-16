package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Pessoa;

@Service
public class PessoaService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Pessoa findById(String id) {
		Pessoa p = new Pessoa();
	
		p.setId(counter.incrementAndGet());
		p.setNome("João");
		p.setSobrenome("Arthur");
		p.setEndereco("Rua dos pardais - RN - Brasil");
		p.setSexo("Masculino");
		return p;
	}
	
	public List<Pessoa> findAll() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();		
		
		for (int i = 0; i < 7; i++) {
			Pessoa p = mockPessoa(i);
			pessoas.add(p);
		}
	
		return pessoas;
	}
	
	public Pessoa criarPessoa(Pessoa p) {
		return p;
	}
	
	public Pessoa atualizarPessoa(Pessoa p) {
		return p;
	}
	
	public void deletarPessoa(String id) {
		
	}
	
	public Pessoa mockPessoa(int i) {
		Pessoa p = new Pessoa();
		
		p.setId(counter.incrementAndGet());
		p.setNome("João " + i);
		p.setSobrenome("Arthur " + i);
		p.setEndereco("Rua dos pardais - RN - Brasil " + i);
		p.setSexo("Masculino");
		
		return p;
	}
}
