package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.NaoEhQuadradoPerfeito;
import br.com.erudio.exceptions.OperacaoNaoSuportada;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double soma(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberOne)) {
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		}
		Double opr = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return opr;
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtracao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberOne)) {
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		}
		Double opr = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return opr;
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberOne)) {
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		}
		Double opr = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return opr;
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divisao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		}
		
		if(denominadorEhZero(numberTwo)) {
			throw new OperacaoNaoSuportada("O denominador não pode ser 0 em uma divisão!");
		}
		
		Double opr = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return opr;
	}

	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		}
		Double opr = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		return opr;
	}
	
	@RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne)
			throws Exception {
		if (!isNumeric(numberOne)) {
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		}
		
		if(!ehQuadradoPerfeito(numberOne)) {
			throw new NaoEhQuadradoPerfeito("O número não é um quadrado perfeito!");
		}
		Double opr = Math.sqrt(convertToDouble(numberOne));
		return opr;
	}
	
	// Verifica se o número é um quadrado perfeito
	private boolean ehQuadradoPerfeito(String strNumber) {
		Double num = convertToDouble(strNumber);
		
		Double quadrado = Math.sqrt(num);
		
		if((quadrado - Math.floor(quadrado) == 0)) {
			return true;
		}
		return false;
	}
	
	// Verifica se na request de divisão o denominador é igual a zeros
	private boolean denominadorEhZero(String strNumber) {
		Double num = convertToDouble(strNumber);
		
		if(num == 0)
			return true;
		
		return false;
	}
	
	// Converte uma String para Double
	private Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;

		String number = strNumber.replaceAll(",", ".");

		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}
	
	// Verifica se a String possui apenas números
	private boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;

		String number = strNumber.replaceAll(",", ".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}