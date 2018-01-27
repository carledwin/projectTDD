package com.wordpress.carledwinj.projecttdd.validator.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.wordpress.carledwinj.projecttdd.validator.ValidadorCPF;

public class ValidadorCPFTestRefatorado {

	/**
	 * RED - Write tests that fails
	 */
	@Test
	public void deveValidarCPFInvalido() {
		assertFalse(ValidadorCPF.isCPFValido(6581552021l));
	}
	
	@Test(expected=NumberFormatException.class)
	public void deveRetornarNumberFormatException() {
		assertTrue(ValidadorCPF.isCPFValido(-6581552020l));
	}
		
	@Test
	public void deveValidarCPFNull() {
		assertFalse(ValidadorCPF.isCPFValido(null));
	}
	
	@Test
	public void deveValidarCPFNumerosRepetidos() {
		assertFalse(ValidadorCPF.isCPFValido(11111111111l));
		assertFalse(ValidadorCPF.isCPFValido(22222222222l));
		assertFalse(ValidadorCPF.isCPFValido(33333333333l));
		assertFalse(ValidadorCPF.isCPFValido(44444444444l));
		assertFalse(ValidadorCPF.isCPFValido(55555555555l));
		assertFalse(ValidadorCPF.isCPFValido(66666666666l));
		assertFalse(ValidadorCPF.isCPFValido(77777777777l));
		assertFalse(ValidadorCPF.isCPFValido(88888888888l));
		assertFalse(ValidadorCPF.isCPFValido(99999999999l));
		assertFalse(ValidadorCPF.isCPFValido(00000000000l));
	}
	
	/**
	 * GREEN - Make the code work
	 */
	@Test
	public void deveValidarCPFValido10Digitos() {
		assertTrue(ValidadorCPF.isCPFValido(6581552020l));
	}
	
	@Test
	public void deveValidarCPFValido11Digitos() {
		assertTrue(ValidadorCPF.isCPFValido(98536222204l));
	}
	
}
