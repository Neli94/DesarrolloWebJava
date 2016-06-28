package com.ipartek.formacion.pojo.exception;

public class DniException extends Exception{
	public final static int CODIGO_ERROR_LETRA_DNI=100;
	public static final String MSG_ERROR_LETRA_DNI="La letra introducida no es válida";
	private int codigo;
	private String mensaje;
	
	public DniException(int codigo, String mensaje){
		super();
		this.codigo=codigo;
		this.mensaje=mensaje;
	}

	/**
	 * 
	 */
	public DniException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DniException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DniException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DniException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DniException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		System.out.println("errorrrrrrr de mierda");
		return super.getMessage();
	}
	
	
}
