package analizadorSintactico;


// errores que se pueden ejecutar en el analizador sintactico

/**
 * 
 * @author Carlos Daniel Londoño Torres - Camilo Andres Martinez Castaño - Jorge Hernan Castaño Barraza - Christian Giovani Cachaya
 *
 */
public class ErrorSintactico {
	
	/**
	 * Variable que representa el mensaje de error del error sintactico
	 */
	private String msgError; 
	/**
	 * Variables que representan la fila y la columna del error sintactico
	 */
	private int fila, columna; 
	/**
	 * Metodo constructor
	 */
	public ErrorSintactico( String msgError, int fila, int columna) 
	{ 
		this.msgError=msgError; 
		this.fila = fila; 
		this.columna = columna ; 
	} 
	// Metodos get y set
	public String getMsgError () {return this. msgError;} 
	public void setMsgError (String msgError) {this. msgError = msgError;} 
	public int getFila() {return this.fila;} 
	public void setFila(int codigo) {this.fila = fila;} 
	public int getColumna () {return this.columna;} 
	public void setColumna (int columna) {this.columna = columna;} 
	

}
