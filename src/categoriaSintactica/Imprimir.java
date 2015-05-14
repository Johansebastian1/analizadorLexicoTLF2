package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa el listado de importaciones del codigo
 * @author Mateo Toquica-Angie Maldonado 
 *
 */
public class Imprimir implements Sentencia
{
	/**
	 * Atributo de tipo dato que se imprime
	 */
	Dato dato;

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Imprimir");
		
		if(dato != null){
			raiz.add(dato.getArbolVisual());
		}
		
		return raiz;
	}

	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code=dato.getJavaCode();
		return code;
	}
	
	
	//Getters And Setters
	public Dato getDato() 
	{
		return dato;
	}

	public void setDato(Dato dato) {
		this.dato = dato;
	}

	public Imprimir(Dato dato) 
	{
		this.dato = dato;
	}

	
}
