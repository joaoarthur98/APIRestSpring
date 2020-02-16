package br.com.erudio.controller;

import static br.com.erudio.math.MathVerificacao.isNumeric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.NaoEhQuadradoPerfeito;
import br.com.erudio.exceptions.OperacaoNaoSuportada;
import br.com.erudio.services.MathOperacaoService;
import br.com.erudio.services.MathVerificacaoService;

@RestController
public class MathController {
	
	@Autowired
	private MathOperacaoService operacao;
	
	@Autowired
	private MathVerificacaoService verificacao;

	@RequestMapping(value = "/sum/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable("numero1") String numero1, 
			@PathVariable("numero2") String numero2)
			throws Exception {
		
		if (!isNumeric(numero1) || !isNumeric(numero1)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		return operacao.soma(
				verificacao.convertToDouble(numero1),
				verificacao.convertToDouble(numero2));
	}
	
	@RequestMapping(value = "/sub/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double sub(
			@PathVariable("numero1") String numero1, 
			@PathVariable("numero2") String numero2) 
			throws Exception {
		
		if (!verificacao.isNumeric(numero1) || !verificacao.isNumeric(numero2)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		return operacao.subtracao(
				verificacao.convertToDouble(numero1),
				verificacao.convertToDouble(numero2));
	}
	
	@RequestMapping(value = "/mult/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double mult(
			@PathVariable("numero1") String numero1,
			@PathVariable("numero2") String numero2)
			throws Exception {
		
		if (!verificacao.isNumeric(numero1) || !verificacao.isNumeric(numero2)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		return operacao.multiplicacao(
				verificacao.convertToDouble(numero1), 
				verificacao.convertToDouble(numero2));
	}
	
	@RequestMapping(value = "/div/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double div(
			@PathVariable("numero1") String numero1, 
			@PathVariable("numero2") String numero2)
			throws Exception {
		
		if (!verificacao.isNumeric(numero1) || !verificacao.isNumeric(numero2)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		if(verificacao.denominadorEhZero(numero2)) 
			throw new OperacaoNaoSuportada("O denominador não pode ser 0 em uma divisão!");
		
		return operacao.divisao(
				verificacao.convertToDouble(numero1), 
				verificacao.convertToDouble(numero2));
	}

	@RequestMapping(value = "/media/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double mean(
			@PathVariable("numero1") String numero1, 
			@PathVariable("numero2") String numero2)
			throws Exception {
		
		if (!verificacao.isNumeric(numero1) || !verificacao.isNumeric(numero2)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		return operacao.media(
				verificacao.convertToDouble(numero1), 
				verificacao.convertToDouble(numero2));
	}
	
	@RequestMapping(value = "/raiz/{numero1}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("numero1") String numero1)
			throws Exception {
		
		if (!verificacao.isNumeric(numero1)) 
			throw new OperacaoNaoSuportada("Use apenas valores numéricos!");
		
		if(!verificacao.ehQuadradoPerfeito(numero1)) 
			throw new NaoEhQuadradoPerfeito("O número não é um quadrado perfeito!");
		
		return operacao.raizQuadrada(verificacao.convertToDouble(numero1));
	}

}