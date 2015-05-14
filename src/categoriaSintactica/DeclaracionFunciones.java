package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa todas las declaraciones de funciones hechas en un codigo
 * @author Carlos
 *
 */
public class DeclaracionFunciones 
{
	/**
	 * Colección de los funciones creados en el codigo
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
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Declaracion Funciones");
	
		for (DeclaracionFuncion iterable : funciones) {
			raiz.add(iterable.getArbolVisual());
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

