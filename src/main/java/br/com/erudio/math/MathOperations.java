package br.com.erudio.math;

public class MathOperations {
	
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