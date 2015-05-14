package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa un listado de parametros
 * @author Carlos Daniel Londoño Torres - Camilo Andres Martinez Castaño - Jorge Hernan Castaño Barraza - Christian Giovani Cachaya 
 *
 */
public class Parametros 
{
	/**
	 * Listado de los parametros
	 */
	private ArrayList<Parametro> parametros;
	
	/**
	 * Constructor de clase
	 * @param parametros, Los parametros inicializados
	 */
	public Parametros(ArrayList<Parametro> parametros)
	{
		this.parametros=parametros;
	}

	
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("parametros");
		for (int i = 0; i < parametros.size(); i++) 
		{
			raiz.add(parametros.get(i).getArbolVisual());
		}
		return raiz;
	}
	
	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code="";
		for (int i = 0; i < parametros.size(); i++) 
		{
			code+=parametros.get(i).getJavaCode()+" ";
		}
		return code;
	}
	
	//Getters And setters
	public ArrayList<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(ArrayList<Parametro> parametros) {
		this.parametros = parametros;
	}

	
}
