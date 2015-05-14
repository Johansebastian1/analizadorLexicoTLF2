package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
/**
 * Clase que representa un listado de sentencias
 * @author Mateo Toquica-Angie Maldonado 
 *
 */
public class BloqueSentencias 
{
	/**
	 * Lista de las sentencias
	 */
	private ArrayList<Sentencia> sentencias;
	
	/**
	 * Constructor de la clase
	 * @param sentencias, La lista de sentencias declaradas
	 */
	public BloqueSentencias(ArrayList<Sentencia> sentencias)
	{
		this.sentencias=sentencias;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("sentencias");
		for (int i = 0; i < sentencias.size(); i++) 
		{
			raiz.add(sentencias.get(i).getArbolVisual());
		}
		return raiz;
	}
	
	//Getters and setters
	public ArrayList<Sentencia> getSentencias() {
		return sentencias;
	}

	public void setSentencias(ArrayList<Sentencia> sentencias) {
		this.sentencias = sentencias;
	}

}
