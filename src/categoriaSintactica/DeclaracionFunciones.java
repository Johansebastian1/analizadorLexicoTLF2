package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import mundo.*;

/**
 * Clase que representa todas las declaraciones de funciones hechas en un codigo
 * @author Carlos Daniel Londo�o Torres - Camilo Andres Martinez Casta�o - Jorge Hernan Casta�o Barraza - Christian Giovani Cachaya 
 *
 */
public class DeclaracionFunciones 
{
	/**
	 * Colecci�n de los funciones creados en el codigo
	 */
	private ArrayList<DeclaracionFuncion> funciones;
	
	/**
	 * Constructor de clase
	 * @param funciones, Los funciones del codigo
	 */
	public DeclaracionFunciones(ArrayList<DeclaracionFuncion> funciones)
	{
		this.funciones=funciones;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("declaracionfunciones");
		for (int i = 0; i < funciones.size(); i++) 
		{
			raiz.add(funciones.get(i).getArbolVisual());
		}
		return raiz;
	}

	
	//Getters And Setters
	public ArrayList<DeclaracionFuncion> getfunciones() {
		return funciones;
	}

	public void setfunciones(ArrayList<DeclaracionFuncion> funciones) {
		this.funciones = funciones;
	}
	
	
}

