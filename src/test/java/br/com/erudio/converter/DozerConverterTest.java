package br.com.erudio.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.erudio.data.model.Pessoa;
import br.com.erudio.data.vo.PessoaVO;
import br.com.erudio.mocks.MockPessoa;

public class DozerConverterTest {
	
	MockPessoa inputObject;
	
	@Before
	public void setup(){
		inputObject = new MockPessoa();
	}
	
	@Test
	public void deveConverterEntityQualquerParaVO() {
		PessoaVO teste = DozerConverter.parseObject(inputObject.mockEntity(), PessoaVO.class);
		
		assertEquals(Long.valueOf(0L), teste.getId());
		assertEquals("Nome teste 0", teste.getNome());
		assertEquals("Sobrenome teste 0", teste.getSobrenome());
		assertEquals("Endereço teste 0", teste.getEndereco());
		assertEquals("Masculino", teste.getSexo());
	}
	
	@Test
	public void deveConverterListParaListVO() {
		List<PessoaVO> listaTeste = DozerConverter.parseListObjects(inputObject.mockEntityList(), PessoaVO.class);
		PessoaVO teste = listaTeste.get(0);
		
		assertEquals(Long.valueOf(0L), teste.getId());
		assertEquals("Nome teste 0", teste.getNome());
		assertEquals("Sobrenome teste 0", teste.getSobrenome());
		assertEquals("Endereço teste 0", teste.getEndereco());
		assertEquals("Masculino", teste.getSexo());
	}
	
	 @Test
	    public void parseEntityListToVOListTest() {
	        List<PessoaVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PessoaVO.class);
	        PessoaVO teste = outputList.get(0);
	        
	        assertEquals(Long.valueOf(0L), teste.getId());
	        assertEquals("Nome teste 0", teste.getNome());
			assertEquals("Sobrenome teste 0", teste.getSobrenome());
			assertEquals("Endereço teste 0", teste.getEndereco());
			assertEquals("Masculino", teste.getSexo());
	        
	        PessoaVO teste7 = outputList.get(7);
	        
	        assertEquals(Long.valueOf(7L), teste7.getId());
	        assertEquals("Nome teste 7", teste7.getNome());
			assertEquals("Sobrenome teste 7", teste7.getSobrenome());
			assertEquals("Endereço teste 7", teste7.getEndereco());
			assertEquals("Feminino", teste7.getSexo());
	        
	        PessoaVO teste12 = outputList.get(12);
	        
	        assertEquals(Long.valueOf(12L), teste12.getId());
	        assertEquals("Nome teste 12", teste12.getNome());
			assertEquals("Sobrenome teste 12", teste12.getSobrenome());
			assertEquals("Endereço teste 12", teste12.getEndereco());
			assertEquals("Masculino", teste12.getSexo());
	    }

	    @Test
	    public void parserVOListToEntityListTest() {
	        List<Pessoa> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Pessoa.class);
	        Pessoa teste = outputList.get(0);
	        
	        assertEquals(Long.valueOf(0L), teste.getId());
	        assertEquals("Nome teste 0", teste.getNome());
			assertEquals("Sobrenome teste 0", teste.getSobrenome());
			assertEquals("Endereço teste 0", teste.getEndereco());
			assertEquals("Masculino", teste.getSexo());
	        
	        Pessoa teste7 = outputList.get(7);
	        
	        assertEquals(Long.valueOf(7L), teste7.getId());
	        assertEquals("Nome teste 7", teste7.getNome());
			assertEquals("Sobrenome teste 7", teste7.getSobrenome());
			assertEquals("Endereço teste 7", teste7.getEndereco());
			assertEquals("Feminino", teste7.getSexo());
	        
	        Pessoa teste12 = outputList.get(12);
	        
	        assertEquals(Long.valueOf(12L), teste12.getId());
	        assertEquals("Nome teste 12", teste12.getNome());
			assertEquals("Sobrenome teste 12", teste12.getSobrenome());
			assertEquals("Endereço teste 12", teste12.getEndereco());
			assertEquals("Masculino", teste12.getSexo());
	    }
}
