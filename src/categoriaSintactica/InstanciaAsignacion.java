package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa una instancia de asignación del codigo
 * @author Carlos Daniel Londoño Torres - Camilo Andres Martinez Castaño - Jorge Hernan Castaño Barraza - Christian Giovani Cachaya 
 *
 */
public class InstanciaAsignacion implements Sentencia
{
	/**
	 * Simbolo lexico que representa un identificador de variable
	 */
	private SimboloLexico identificadorVariable;
	
	/**
	 * Dato instanciado
	 */
	private Dato dato;
	
	/**
	 * Expresión de asignación
	 */
	private ExpresionAritmetica expresion;
	
	/**
	 * Constructor de la clase
	 * @param identificadorVariable, El identificador de la variable asignar
	 * @param dato, El dato asignado
	 * @param expresion, La expresión de asignación
	 */
	public InstanciaAsignacion(SimboloLexico identificadorVariable, Dato dato,
			ExpresionAritmetica expresion) 
	{
		this.identificadorVariable = identificadorVariable;
		this.dato = dato;
		this.expresion = expresion;
	}
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual() 
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("instanciaAsiganacion");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorVariable.getLexema()));
		if(dato!=null)
			raiz.add(dato.getArbolVisual());
		else if(expresion!=null) 
			raiz.add(expresion.getArbolVisual());
		return raiz;
	}
	
	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code=" "+identificadorVariable.getLexema();
		if(dato!=null)
			code+= dato.getJavaCode();
		else if(expresion!=null) 
			code+= expresion.getJavaCode();
		
		return code;
	}
	
	
	//Getters and Setters
	public SimboloLexico getIdentificadorVariable() {
		return identificadorVariable;
	}
	public void setIdentificadorVariable(SimboloLexico identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
	}
	public Dato getDato() {
		return dato;
	}
	public void setDato(Dato dato) {
		this.dato = dato;
	}
	public ExpresionAritmetica getExpresion() {
		return expresion;
	}
	public void setExpresion(ExpresionAritmetica expresion) {
		this.expresion = expresion;
	}
	
	
}
