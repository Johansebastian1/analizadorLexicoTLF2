package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa los factores presentes en el codigo
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class Factor 
{
	/**
	 * Sinbolo lexico que representa un dato
	 */
	private SimboloLexico dato;
	
	/**
	 * Expresión usada 
	 */
	private Expresion expresion;
	
	/**
	 * Constructor de la clase factor
	 * @param dato, El dato empleado
	 * @param expresion,La expresión
	 */
	public Factor(SimboloLexico dato, Expresion expresion) 
	{
		this.dato = dato;
		this.expresion = expresion;
	}
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public MutableTreeNode getArbolVisual() 
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("factor");
		raiz.add(new DefaultMutableTreeNode("nombre:"+dato.getLexema()));
		return raiz;
	}
	
	
	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code=" "+dato.getLexema();
		return code;
	}
	
	//Getters And Setters
	public SimboloLexico getDato() {
		return dato;
	}
	public void setDato(SimboloLexico dato) {
		this.dato = dato;
	}
	public Expresion getExpresion() {
		return expresion;
	}
	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}
	
}
