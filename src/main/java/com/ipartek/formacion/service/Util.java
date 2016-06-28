package com.ipartek.formacion.service;

import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.pojo.exception.DniException;

public class Util {
	public static boolean validarDni(String dni) throws CandidatoException{
		//si es falso, lanzar excepcion
		boolean valido=false;

		String letras[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T"};
		String letraDni=dni.substring(8);
		String dniSinLetra=dni.substring(0,8);
		int dniAInt=Integer.parseInt(dniSinLetra);
		int resultado=dniAInt%23;
		
		if(letraDni.equals(letras[resultado])){
			valido=true;
			
		}else{
			valido=false;
			throw new CandidatoException(CandidatoException.CODIGO_ERROR_LETRA_DNI,CandidatoException.MSG_ERROR_LETRA_DNI);
		}
		return valido;
	}
	
	/*public static boolean validarDni(String dni){
	 * 		boolean valido=false;
	 * 		dni=dni.toUpperCase();
	 * 		int nDni=Integer.parseInt(dni.substring(0,dni.length()-1));
	 * 		char lDni=dni.substring(dni.length()-2,dni.length()-1).charAt(0));
	 * 		if(calcularletra(lDni)==
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * */
	 

}
