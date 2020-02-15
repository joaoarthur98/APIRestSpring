package br.com.erudio.math;

import static br.com.erudio.math.MathVerificacao.denominadorEhZero;
import static br.com.erudio.math.MathVerificacao.ehQuadradoPerfeito;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MathVerificacaoTest {

	@Test
	public void deveVerificarSeNumeroEhQuadradoPerfeito() {
		String num = "144";

		assertTrue(ehQuadradoPerfeito(num));
	}

	@Test
	public void deveVerificarSeDenominadorEhZero() {
		String num = "0";

		assertTrue(denominadorEhZero(num));
	}

	@Test
	public void deveConverterStringPraDouble() {
		String num = "12.0";

		assertEquals(12.0, MathVerificacao.convertToDouble(num));
	}

	@Test
	public void deveVerificarSeStringPossuiApenasNumeros() {
		String palavra1 = "Joãozinho123";
		String palavra2 = "250.0";

		assertFalse(MathVerificacao.isNumeric(palavra1));
		assertTrue(MathVerificacao.isNumeric(palavra2));
	}
}