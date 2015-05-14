package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.SimboloLexico;

/**
 * Clase que representa la categoria sintactica Dato
 * @author Mateo Toquica-Angie Maldonado 
 *
 */
public class Dato 
{
	/**
	 * Atributo el cual es un simbolo lexico dato
	 */
	private SimboloLexico dato;

	/**
	 * Constructor de clase
	 * @param dato
	 */
	public Dato(SimboloLexico dato) 
	{
		this.dato = dato;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("dato");
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

	

}
