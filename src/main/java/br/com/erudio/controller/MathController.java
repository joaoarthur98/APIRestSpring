package br.com.erudio.controller;

import static br.com.erudio.math.MathOperacao.*;
import static br.com.erudio.math.MathVerificacao.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.NaoEhQuadradoPerfeito;
import br.com.erudio.exceptions.OperacaoNaoSuportada;
import br.com.erudio.math.MathOperacao;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable("numero1") String numero1, 
			@PathVariable("numero2") String numero2)
			throws Exception {
		
		if (!isNumeric(numero1) || !isNumeric(numero1)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		return soma(convertToDouble(numero1), convertToDouble(numero2));
	}
	
	@RequestMapping(value = "/sub/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double sub(
			@PathVariable("numero1") String numero1, 
			@PathVariable("numero2") String numero2) 
			throws Exception {
		
		if (!isNumeric(numero1) || !isNumeric(numero1)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		Double opr = MathOperacao.subtracao(convertToDouble(numero1), convertToDouble(numero2));
		
		return opr;
	}
	
	@RequestMapping(value = "/mult/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double mult(
			@PathVariable("numero1") String numero1,
			@PathVariable("numero2") String numero2)
			throws Exception {
		
		if (!isNumeric(numero1) || !isNumeric(numero1)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		Double opr = MathOperacao.multiplicacao(convertToDouble(numero1), convertToDouble(numero2));
		
		return opr;
	}
	
	@RequestMapping(value = "/div/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double div(
			@PathVariable("numero1") String numero1, 
			@PathVariable("numero2") String numero2)
			throws Exception {
		
		if (!isNumeric(numero1) || !isNumeric(numero2)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		if(denominadorEhZero(numero2)) 
			throw new OperacaoNaoSuportada("O denominador não pode ser 0 em uma divisão!");
		
		return divisao(convertToDouble(numero1), convertToDouble(numero2));
	}

	@RequestMapping(value = "/media/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double mean(
			@PathVariable("numero1") String numero1, 
			@PathVariable("numero2") String numero2)
			throws Exception {
		
		if (!isNumeric(numero1) || !isNumeric(numero2)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		return media(convertToDouble(numero1), convertToDouble(numero2));
	}
	
	@RequestMapping(value = "/raiz/{numero1}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("numero1") String numero1)
			throws Exception {
		
		if (!isNumeric(numero1)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		if(!ehQuadradoPerfeito(numero1)) 
			throw new NaoEhQuadradoPerfeito("O número não é um quadrado perfeito!");
		
		return raizQuadrada(convertToDouble(numero1));
	}

}