package com.ipartek.formacion.pojo;

public class Modulo {
	public static int CODIGO_MODULO=-1;
	private int codigo;
	private String nombre;
	/**
	 * 
	 */
	public Modulo() {
		super();
		setCodigo(CODIGO_MODULO);
		setNombre("");
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
//Cuando getIndex==-1, exeption
}
