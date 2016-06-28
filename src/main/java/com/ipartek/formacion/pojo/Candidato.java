package com.ipartek.formacion.pojo;

import java.util.Date;

import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.pojo.exception.DniException;
import com.ipartek.formacion.service.Util;

public class Candidato {
	public static final int CODIGO_ALUMNO=-1;
	private int codigo;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String dni;
	private Double nota;
	/**
	 * @throws CandidatoException 
	 * 
	 */
	public Candidato() throws CandidatoException {
		super();
		setCodigo(CODIGO_ALUMNO);
		setNombre("");
		setApellidos("");
		this.dni="";//setDni("");
		setfNacimiento(new Date());
		setNota(0.0);
	}
	
	
	
	/**
	 * @param dni
	 */
	public Candidato(String dni) {
		super();
		this.dni = dni;
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimiento(Date fNacimiento) throws CandidatoException {
		if(fNacimiento.compareTo(new Date())>0){
			throw new CandidatoException(CandidatoException.CODIGO_ERROR_FECHA_NACIMIENTO,CandidatoException.MSG_ERROR_FECHA_NACIMIENTO);
		}else{
			this.fNacimiento = fNacimiento;
		}
		
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) throws CandidatoException, DniException {
		if(!Util.validarDni(dni)){
			throw new CandidatoException(CandidatoException.CODIGO_ERROR_LETRA_DNI,CandidatoException.MSG_ERROR_LETRA_DNI);
		}
		this.dni = dni;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	protected String mostrarDatos(){
		return this.apellidos + ", " + this.nombre;
	}
	
	
}
