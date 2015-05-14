package mundo;

//La clase SimboloLexico define los atributos de los símbolos y sus métodos
public class SimboloLexico {	
	String lexema;
	String token;
	int fila, columna;
	
	public SimboloLexico(String lexema, String token, int fila, int columna) 
	{
		this.columna = columna;
		this.fila = fila;
		this.lexema = lexema;
		this.token = token;
	}
	
	public String getLexema() {
		return lexema;
	}
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	
}

