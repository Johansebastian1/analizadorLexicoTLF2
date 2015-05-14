package categoriaSintactica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa las incluciones del codigo
 * @author Mateo Toquica-Angie Maldonado
 *
 */
public class BloquePaquetes 
{
	/**
	 * Lista de los paquetes
	 */
	ArrayList<Paquete> paquete;

	/**
	 * Constructor de clase
	 * @param inlcuds, Los paquetes a instanciar
	 */
	public BloquePaquetes(ArrayList<Paquete> paquete) 
	{
		this.paquete=paquete;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Paquete");
		
		for (Paquete iterable : paquete) {
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
		for (int i = 0; i < paquete.size(); i++) 
		{
			code+=paquete.get(i).getJavaCode()+"  ";
		}
		return code;
	}
	
	//Getters and setters
	public List<Paquete> getPaquete() {
		return paquete;
	}

	public void setPaquete(ArrayList<Paquete> paquete) 
	{
		this.paquete = paquete;
	}
	
}
