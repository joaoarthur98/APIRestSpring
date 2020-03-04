package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Pessoa;
import br.com.erudio.data.vo.PessoaVO;
import br.com.erudio.data.vo.v2.PessoaVOV2;
import br.com.erudio.exceptions.NaoEncontradoException;
import br.com.erudio.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	public PessoaVO findById(Long id) {
		var entidade = repository.findById(id).orElseThrow(
				() -> new NaoEncontradoException("Nenhum registro encontrado para esse id!"));
		
		return DozerConverter.parseObject(entidade, PessoaVO.class);
	}	
	
	public List<PessoaVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PessoaVO.class);
	}
	
	public PessoaVO criarPessoa(PessoaVO p) {
		var entidade = DozerConverter.parseObject(p, Pessoa.class);
		var vo = DozerConverter.parseObject(repository.save(entidade), PessoaVO.class);
		return vo;
	}
	
	public PessoaVOV2 criarPessoaV2(PessoaVOV2 p) {
		var entidade = DozerConverter.parseObject(p, Pessoa.class);
		var vo = DozerConverter.parseObject(repository.save(entidade), PessoaVOV2.class);
		return vo;
	}
	
	public PessoaVO atualizarPessoa(PessoaVO p) {
		var entidade = repository.findById(p.getId()).orElseThrow(
				() -> new NaoEncontradoException("Nenhum registro encontrado para esse id!"));
		
		entidade.setNome(p.getNome());
		entidade.setSobrenome(p.getSobrenome());
		entidade.setEndereco(p.getEndereco());
		entidade.setSexo(p.getSexo());
		var vo = DozerConverter.parseObject(repository.save(entidade), PessoaVO.class);
		
		return vo;
	}
	
	public void deletarPessoa(Long id) {
		Pessoa entidade = repository.findById(id).orElseThrow(
				() -> new NaoEncontradoException("Nenhum registro encontrado para esse id!"));
		
		repository.delete(entidade);
	}
	
}
