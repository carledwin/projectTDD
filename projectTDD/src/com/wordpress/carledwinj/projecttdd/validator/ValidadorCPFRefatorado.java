package com.wordpress.carledwinj.projecttdd.validator;

import com.wordpress.carledwinj.projecttdd.exception.CPFInvalidoException;

public abstract class ValidadorCPFRefatorado {

	
	
	public static final String SEQUENCIA_1 = "11111111111";
	public static final String SEQUENCIA_2 = "22222222222";
	public static final String SEQUENCIA_3 = "33333333333";
	public static final String SEQUENCIA_4 = "44444444444";
	public static final String SEQUENCIA_5 = "55555555555";
	public static final String SEQUENCIA_6 = "66666666666";
	public static final String SEQUENCIA_7 = "77777777777";
	public static final String SEQUENCIA_8 = "88888888888";
	public static final String SEQUENCIA_9 = "99999999999";
	public static final String SEQUENCIA_0 = "00000000000";
	
	public static final long CPF_INVALIDO_6581552021L = 6581552021l;
	public static final long CPF_INVALIDO_NUMERO_NEGATIVO = -6581552020l;
	public static final long CPF_VALIDO_11_DIGITOS_98536222204L = 98536222204l;
	public static final long CPF_VALIDO_10_DIGITOS_6581552020L = 6581552020l;


	public static final String MENSAGEM_FALHA_AO_TENTAR_NORMALIZAR_CPF = "Falha ao tentar normalizar CPF!";
	public static final String MENSAGEM_CPF_INVALIDO = "CPF invalido!";
	public static final String MENSAGEM_CPF_COM_TODOS_NUMEROS_IGUAIS = "CPF com todos numeros iguais!";
	public static final String MENSAGEM_CPF_INFORMADO_E_NUMERO_NEGATIVO = "CPF informado e numero negativo!";
	public static final String MENSAGEM_CPF_NULO = "CPF nulo!";

	private static final String FORMAT_011D = "%011d";
	private static final String ZERO = "0";

	public static boolean isCPFValido(Long cpf) throws CPFInvalidoException {
		
		if(cpf == null) {
			throw new CPFInvalidoException(MENSAGEM_CPF_NULO);
		}
		
		if(isCPFNumeroNegativo(cpf)) {
			throw new CPFInvalidoException(MENSAGEM_CPF_INFORMADO_E_NUMERO_NEGATIVO);
		}
		
		String cpfNormalizado = normalizaCPF(cpf);
		
		if(    cpfNormalizado.equals(SEQUENCIA_1) || cpfNormalizado.equals(SEQUENCIA_2) || cpfNormalizado.equals(SEQUENCIA_3) || cpfNormalizado.equals(SEQUENCIA_4) 
			|| cpfNormalizado.equals(SEQUENCIA_5) || cpfNormalizado.equals(SEQUENCIA_6) || cpfNormalizado.equals(SEQUENCIA_7) || cpfNormalizado.equals(SEQUENCIA_8) 
			|| cpfNormalizado.equals(SEQUENCIA_9) || cpfNormalizado.equals(SEQUENCIA_0)) {
			throw new CPFInvalidoException(MENSAGEM_CPF_COM_TODOS_NUMEROS_IGUAIS);
		}
		
		if(!isDigitosValidos(cpfNormalizado)) {
			throw new CPFInvalidoException(MENSAGEM_CPF_INVALIDO);
		}

		return true;
	}

	private static boolean isCPFNumeroNegativo(Long cpf) {
		
		if(cpf == null || cpf < 0) {
			return true;
		}
		
		return false;
	}

	private static boolean isDigitosValidos(String cpf) {
		
		String digitos = cpf.substring(0, 9);
		String digitosVerificadores = cpf.substring(9, 11);
		String digitoVerificador_1 = geraDigitoVerificador(digitos);
		String digitoVerificador_2 = geraDigitoVerificador(digitos + digitoVerificador_1);
		
		return digitosVerificadores.equals(digitoVerificador_1.concat(digitoVerificador_2));
	}

	private static String geraDigitoVerificador(String digitos) {
		
		int peso = digitos.length() + 1;
		int digitoVerificador = 0;
		
		for(int i = 0; i < digitos.length(); i++) {
			digitoVerificador += Integer.parseInt(digitos.substring(i,  i + 1)) * peso;
			peso--;
		}
		
		digitoVerificador = 11 - (digitoVerificador % 11);
		
		if(digitoVerificador > 9) {
			return ZERO;
		}
		
		return String.valueOf(digitoVerificador);
	}
	

	private static String normalizaCPF(Long cpf) throws CPFInvalidoException {
		
		try {
			return String.format(FORMAT_011D, cpf);
		}catch(Exception e) {
			throw new CPFInvalidoException(MENSAGEM_FALHA_AO_TENTAR_NORMALIZAR_CPF);
		}
	}

	public static void main(String[] args) throws CPFInvalidoException {
		
		//System.out.println("Valido10 >> " + ValidadorCPFRefatorado.isCPFValido(6581552020l));
		//System.out.println("Valido11 >> " + ValidadorCPFRefatorado.isCPFValido(98536222204l));
		//System.out.println("Invalido10 >> " + ValidadorCPFRefatorado.isCPFValido(6581552021l));
		//System.out.println("Invalido11 >> " + ValidadorCPFRefatorado.isCPFValido(98536222201l));
		//System.out.println("Null >> " + ValidadorCPFRefatorado.isCPFValido(null));
	}
}
