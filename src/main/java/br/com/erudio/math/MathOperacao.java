package br.com.erudio.math;

public class MathOperacao {
	
	public static Double soma(Double n1, Double n2) {
		return n1+n2;
	}
	
	public static Double subtracao(Double n1, Double n2) {
		return n1-n2;
	}
	
	public static Double multiplicacao(Double n1, Double n2) {
		return n1*n2;
	}
	
	public static Double divisao(Double n1, Double n2) {
		return n1/n2;
	}
	
	public static Double media(Double n1, Double n2) {
		return (n1+n2)/2;
	}
	
	public static Double raizQuadrada(Double n1) {
		return Math.sqrt(n1);
	}
}