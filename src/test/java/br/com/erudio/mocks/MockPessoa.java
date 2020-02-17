package br.com.erudio.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.data.model.Pessoa;
import br.com.erudio.data.vo.PessoaVO;

public class MockPessoa {

	public Pessoa mockEntity() {
		return mockEntity(0);
	}
	
	public PessoaVO mockVO() {
		return mockVO(0);
	}

	public List<Pessoa> mockEntityList() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		for (int i = 0; i < 14; i++) {
			pessoas.add(mockEntity(i));
		}

		return pessoas;
	}
	
	public List<PessoaVO> mockVOList(){
		List<PessoaVO> pessoas = new ArrayList<>();
		
		for (int i = 0; i < 14; i++) {
			pessoas.add(mockVO(i));
		}
		
		return pessoas;
	}

	private Pessoa mockEntity(Integer num) {
		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Nome teste " + num);
		pessoa.setSobrenome("Sobrenome teste " + num);
		pessoa.setEndereco("Endereço teste " + num);
		pessoa.setSexo((num % 2) == 0 ? "Masculino" : "Feminino");
		pessoa.setId(num.longValue());

		return pessoa;
	}

	private PessoaVO mockVO(Integer num) {
		PessoaVO pessoa = new PessoaVO();

		pessoa.setNome("Nome teste " + num);
		pessoa.setSobrenome("Sobrenome teste " + num);
		pessoa.setEndereco("Endereço teste " + num);
		pessoa.setSexo((num % 2) == 0 ? "Masculino" : "Feminino");
		pessoa.setId(num.longValue());

		return pessoa;
	}

}
