package br.com.erudio.math;

public class MathVerificacao {
	
	// Verifica se o número é um quadrado perfeito
	public static boolean ehQuadradoPerfeito(String numeroString) {
		Double num = convertToDouble(numeroString);
		
		Double quadrado = Math.sqrt(num);
		
		if((quadrado - Math.floor(quadrado) == 0)) 
			return true;
		
		return false;
	}
	
	// Verifica se na request de divisão o denominador é igual a zeros
	public static boolean denominadorEhZero(String numeroString) {
		Double num = convertToDouble(numeroString);
		
		if(num == 0)
			return true;
		
		return false;
	}
	
	// Converte uma String para Double
	public static Double convertToDouble(String numeroString) {
		if (numeroString == null)
			return 0D;

		String number = numeroString.replaceAll(",", ".");

		if (isNumeric(number)) 
			return Double.parseDouble(number);
		
		return 0D;
	}
	
	// Verifica se a String possui apenas números
	public static boolean isNumeric(String numeroString) {
		if (numeroString == null)
			return false;

		String number = numeroString.replaceAll(",", ".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}