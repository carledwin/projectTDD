package com.wordpress.carledwinj.projecttdd.validator.test;

import org.junit.Test;

import com.wordpress.carledwinj.projecttdd.validator.ValidadorCPF;

import junit.framework.Assert;

public class ValidadorCPFTest {

	//RED - Write tests that fails
	@Test
	public void deveValidarCPFInvalido() {
		
		Assert.assertFalse(ValidadorCPF.isCPFValido(6581552021l));
	}
	
	@Test(expected=NumberFormatException.class)
	public void deveRetornarNumberFormatException() {
		
		Assert.assertTrue(ValidadorCPF.isCPFValido(-6581552020l));
	}
		
	@Test
	public void deveValidarCPFNull() {
		
		Assert.assertFalse(ValidadorCPF.isCPFValido(null));
	}
	
	@Test
	public void deveValidarCPFNumerosRepetidos() {
		
		Assert.assertFalse(ValidadorCPF.isCPFValido(11111111111l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(22222222222l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(33333333333l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(44444444444l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(55555555555l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(66666666666l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(77777777777l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(88888888888l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(99999999999l));
		Assert.assertFalse(ValidadorCPF.isCPFValido(00000000000l));
	}
	
	//GREEN - Make the code work
	@Test
	public void deveValidarCPFValido10Digitos() {
		
		Assert.assertTrue(ValidadorCPF.isCPFValido(6581552020l));
	}
	
	@Test
	public void deveValidarCPFValido11Digitos() {
		
		Assert.assertTrue(ValidadorCPF.isCPFValido(98536222204l));
	}
	
}
