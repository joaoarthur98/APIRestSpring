package br.com.erudio.services;

import org.springframework.stereotype.Service;

@Service
public class MathOperacaoService {
	
	public Double soma(Double n1, Double n2) {
		return n1+n2;
	}

	public Double subtracao(Double n1, Double n2) {
		return n1-n2;
	}

	public Double multiplicacao(Double n1, Double n2) {
		return n1*n2;
	}

	public Double divisao(Double n1, Double n2) {
		return n1/n2;
	}

	public Double media(Double n1, Double n2) {
		return soma(n1,n2)/2;
	}

	public Double raizQuadrada(Double num) {
		return Math.sqrt(num);
	}
}
