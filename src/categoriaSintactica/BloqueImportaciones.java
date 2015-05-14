
package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa el listado de importaciones del codigo
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class BloqueImportaciones 
{
	/**
	 * Lista de las importaciones
	 */
	ArrayList<Importacion> importaciones;
	
	/**
	 * Constructor de clase
	 * @param importaciones,Las lista de importaciones
	 */
	public BloqueImportaciones(ArrayList<Importacion> importaciones)
	{
		this.importaciones=importaciones;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Importaciones");
		
		for (Importacion iterable : importaciones) {
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
		for (int i = 0; i < importaciones.size(); i++) 
		{
			code+=importaciones.get(i).getJavaCode()+"  ";
		}
		return code;
	}
	
	//Getters And Setters
	public ArrayList<Importacion> getImportaciones() {
		return importaciones;
	}

	public void setImportaciones(ArrayList<Importacion> importaciones) {
		this.importaciones = importaciones;
	}
	
}
