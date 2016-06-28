package com.ipartek.formacion.pojo.exception;

public class CursoException extends Exception{
	public final static int CODIGO_ERROR_FECHA_NACIMIENTO=100;
	public static final String MSG_ERROR_FECHA_NACIMIENTO="La fecha introducida no es válida";
	private int codigo;
	private String mensaje;
	
	public CursoException(int codigo, String mensaje) {
		super();
		this.codigo=codigo;
		this.mensaje=mensaje;
		
	}

	/**
	 * 
	 */
	public CursoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CursoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CursoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public CursoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public CursoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
