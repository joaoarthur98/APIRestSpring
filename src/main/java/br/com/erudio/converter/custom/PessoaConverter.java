package br.com.erudio.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.model.Pessoa;
import br.com.erudio.data.vo.v2.PessoaVOV2;

@Service
public class PessoaConverter {
	
	public PessoaVOV2 converterEntidadeParaVO(Pessoa pessoa) {
		PessoaVOV2 vo = new PessoaVOV2();
		vo.setId(pessoa.getId());
		vo.setEndereco(pessoa.getEndereco());
		vo.setAniversario(new Date());
		vo.setNome(pessoa.getNome());
		vo.setSobrenome(pessoa.getSobrenome());
		vo.setSexo(pessoa.getSexo());
		return vo;
	}
	
	public Pessoa converterVOParaEntidade(PessoaVOV2 pessoa) {
		Pessoa entidade = new Pessoa();
		entidade.setId(pessoa.getId());
		entidade.setEndereco(pessoa.getEndereco());
		entidade.setNome(pessoa.getNome());
		entidade.setSobrenome(pessoa.getSobrenome());
		entidade.setSexo(pessoa.getSexo());
		return entidade;
	}
	

}
