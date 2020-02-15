package br.com.erudio.math;

import static br.com.erudio.math.MathOperacao.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MathOperacaoTest {
	
	@Test
	public void deveSomarDoisNumeros() {
		Double n1 = 25.0;
		Double n2 = 35.0;
		
		assertEquals(60.0, soma(n1, n2));
	}
	
	@Test
	public void deveSubtrairDoisNumeros() {
		Double n1 = 25.0;
		Double n2 = 35.0;
		
		assertEquals(-10.0, subtracao(n1, n2));
	}
	
	@Test
	public void deveMultiplicarDoisNumeros() {
		Double n1 = 25.0;
		Double n2 = 5.0;
		
		assertEquals(125.0, multiplicacao(n1, n2));
	}
	
	@Test
	public void deveDividirDoisNumeros() {
		Double n1 = 25.0;
		Double n2 = 5.0;
		
		assertEquals(5.0, divisao(n1, n2));
	}
	
	@Test
	public void deveFazerAMediaAritmeticaEntreDoisNumeros() {
		Double n1 = 25.0;
		Double n2 = 5.0;
		
		assertEquals(15.0, media(n1, n2));
	}
	
	@Test
	public void deveRealizarARaizQuadrada() {
		Double n1 = 144.0;
		
		assertEquals(12.0, raizQuadrada(n1));
	}
}