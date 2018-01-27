package com.wordpress.carledwinj.projecttdd.validator;

import com.wordpress.carledwinj.projecttdd.exception.CPFInvalidoException;

public abstract class ValidadorCPF {

	public static boolean isCPFValido(Long cpf){
		boolean retorno = true;
		if(cpf == null) {
			retorno = false;
			return retorno;
		}else {
			if(cpf < 0) {
				retorno = false;
			}
			String cpf2 = String.format("%011d", cpf);
			if(    cpf2.equals("11111111111") || cpf2.equals("22222222222") || cpf2.equals("33333333333") || cpf2.equals("44444444444")	|| cpf2.equals("55555555555") 
				|| cpf2.equals("66666666666") || cpf2.equals("77777777777") || cpf2.equals("88888888888") || cpf2.equals("99999999999") || cpf2.equals("00000000000")) {
				
				retorno = false;
				return retorno;
			}
			String d = cpf2.substring(0, 9);
			String dvs = cpf2.substring(9, 11);
			String dv1 = geraDigitoVerificador(d);
			String dv2 = geraDigitoVerificador(d + dv1);
			retorno = dvs.equals(dv1.concat(dv2));
			return retorno;
		}
	}


	private static String geraDigitoVerificador(String d) {
		int p = d.length() + 1;
		int dv = 0;
		for(int i = 0; i < d.length(); i++) {
			dv += Integer.parseInt(d.substring(i,  i + 1)) * p;
			p--;
		}
		dv = 11 - (dv % 11);
		if(dv > 9) {
			return "0";
		}
		return String.valueOf(dv);
	}
	

	public static void main(String[] args) throws CPFInvalidoException {
		
		System.out.println("Valido10 >> " + ValidadorCPF.isCPFValido(6581552020l));
		System.out.println("Valido11 >> " + ValidadorCPF.isCPFValido(98536222204l));
		System.out.println("Invalido10 >> " + ValidadorCPF.isCPFValido(6581552021l));
		System.out.println("Invalido11 >> " + ValidadorCPF.isCPFValido(98536222201l));
		System.out.println("Null >> " + ValidadorCPF.isCPFValido(null));
	}

			
}
