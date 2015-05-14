package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase representativa de la categoria sintactica Datos
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class Datos 
{
	/**
	 * Colección atributos del tipo dato
	 */
	private ArrayList<Dato> datos;

	/**
	 * Constructor de clase
	 * @param datos, los datos que componen la clase
	 */
	public Datos(ArrayList<Dato> datos) 
	{
		this.datos = datos;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Datos");
		
		for (Dato iterable : datos) {
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
		
		for (int i = 0; i < datos.size(); i++) 
		{
			code+=datos.get(i).getJavaCode()+"            ;           ";
		}
		return code;
	}
	
	
	//Getters And Setters
	public ArrayList<Dato> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Dato> datos) {
		this.datos = datos;
	}

}
