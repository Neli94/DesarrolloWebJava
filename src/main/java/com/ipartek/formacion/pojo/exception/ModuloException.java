package com.ipartek.formacion.pojo.exception;

public class ModuloException extends Exception{
	public final static int CODIGO_ERROR_FECHA_NACIMIENTO=100;
	public static final String MSG_ERROR_FECHA_NACIMIENTO="La fecha introducida no es válida";
	private int codigo;
	private String mensaje;
	
	public ModuloException(int codigo, String mensaje) {
		super();
		this.codigo=codigo;
		this.mensaje=mensaje;
		
	}

	/**
	 * 
	 */
	public ModuloException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ModuloException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ModuloException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ModuloException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ModuloException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
