package com.wordpress.carledwinj.projecttdd.validator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.wordpress.carledwinj.projecttdd.exception.CPFInvalidoException;
import com.wordpress.carledwinj.projecttdd.validator.ValidadorCPFRefatorado;

public class ValidadorCPFRefatoradoTest {

	/**
	 * RED - Write tests that fails
	 * @throws CPFInvalidoException
	 */
	@Test(expected= CPFInvalidoException.class)
	public void deveValidarCPFInvalido() throws CPFInvalidoException {
		try {
			ValidadorCPFRefatorado.isCPFValido(ValidadorCPFRefatorado.CPF_INVALIDO_6581552021L);
		} catch (Exception e) {
			assertEquals(ValidadorCPFRefatorado.MENSAGEM_CPF_INVALIDO, e.getMessage());
 			throw e;
		}
	}
	
	@Test(expected = CPFInvalidoException.class)
	public void deveValidarCPFNumeroNegativo() throws CPFInvalidoException {
		try {
			ValidadorCPFRefatorado.isCPFValido(ValidadorCPFRefatorado.CPF_INVALIDO_NUMERO_NEGATIVO);
		} catch (Exception e) {
			assertEquals(ValidadorCPFRefatorado.MENSAGEM_CPF_INFORMADO_E_NUMERO_NEGATIVO, e.getMessage());
			throw e;
		}
	}
		
	@Test(expected= CPFInvalidoException.class)
	public void deveValidarCPFNull() throws CPFInvalidoException {
		try {
			ValidadorCPFRefatorado.isCPFValido(null);
		} catch (Exception e) {
			assertEquals(ValidadorCPFRefatorado.MENSAGEM_CPF_NULO, e.getMessage());
			throw e;
		}
	}
	
	@Test(expected= CPFInvalidoException.class)
	public void deveValidarCPFNumerosRepetidos() throws CPFInvalidoException {
		try {
			ValidadorCPFRefatorado.isCPFValido(Long.parseLong(ValidadorCPFRefatorado.SEQUENCIA_7));
		} catch (Exception e) {
			assertEquals(ValidadorCPFRefatorado.MENSAGEM_CPF_COM_TODOS_NUMEROS_IGUAIS, e.getMessage());
			throw e;
		}
	}
	
	/**
	 * GREEN - Make the code work
	 * @throws CPFInvalidoException
	 */
	@Test
	public void deveValidarCPFValido10Digitos() throws CPFInvalidoException {
		assertTrue(ValidadorCPFRefatorado.isCPFValido(ValidadorCPFRefatorado.CPF_VALIDO_10_DIGITOS_6581552020L));
	}
	
	@Test
	public void deveValidarCPFValido11Digitos() throws CPFInvalidoException {
		assertTrue(ValidadorCPFRefatorado.isCPFValido(ValidadorCPFRefatorado.CPF_VALIDO_11_DIGITOS_98536222204L));
	}
	
}
