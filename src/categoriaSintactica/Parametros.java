package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa un listado de parametros
 * @author Carlos Daniel Londo�o Torres - Camilo Andres Martinez Casta�o - Jorge Hernan Casta�o Barraza - Christian Giovani Cachaya 
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
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Parametros");
		
		for (Parametro iterable : parametros) {
			raiz.add(iterable.getArbolVisual());
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
