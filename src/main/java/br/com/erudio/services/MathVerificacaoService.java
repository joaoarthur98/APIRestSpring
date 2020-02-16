package br.com.erudio.services;

import org.springframework.stereotype.Service;

@Service
public class MathVerificacaoService {
	// Verifica se o número é um quadrado perfeito
	public boolean ehQuadradoPerfeito(String numeroString) {
		Double num = convertToDouble(numeroString);

		Double quadrado = Math.sqrt(num);

		if ((quadrado - Math.floor(quadrado) == 0))
			return true;

		return false;
	}

	// Verifica se na request de divisão o denominador é igual a zeros
	public boolean denominadorEhZero(String numeroString) {
		Double num = convertToDouble(numeroString);

		if (num == 0)
			return true;

		return false;
	}

	// Converte uma String para Double
	public Double convertToDouble(String numeroString) {
		if (numeroString == null)
			return 0D;

		String number = numeroString.replaceAll(",", ".");

		if (isNumeric(number))
			return Double.parseDouble(number);

		return 0D;
	}

	// Verifica se a String possui apenas números
	public boolean isNumeric(String numeroString) {
		if (numeroString == null)
			return false;

		String number = numeroString.replaceAll(",", ".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
