package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
/**
 * Clase que representa todas las declaraciones de variables hechas en el codigo
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class DeclaracionVariables
{
	/**
	 * Colección de todas las variables indicadas en el codigo
	 */
	private ArrayList<DeclaracionVariable> variables;
	
	/**
	 * Constructor de clase
	 * @param variables, Las vvariables utilizadas en el codigo
	 */
	public DeclaracionVariables(ArrayList<DeclaracionVariable> variables)
	{
		this.variables=variables;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("declaracionVariables");
		
		for (DeclaracionVariable iterable : variables) {
			raiz.add(iterable.getArbolVisual());
		}
		
		return raiz;
	}
	
//	/**
//	 * Metodo encargado de crear el codigo java
//	 * @return codigo,  el cogido de esta categoria
//	 */
//	public String getJavaCode() 
//	{
//		String code="";
//		for (int i = 0; i < variables.size(); i++) 
//		{
//			code+=variables.get(i).getJavaCode()+"   ";
//		}
//		return code;
//	}
	
	
	//Getters and Setters
	public ArrayList<DeclaracionVariable> getVariables() {
		return variables;
	}

	public void setVariables(ArrayList<DeclaracionVariable> variables) {
		this.variables = variables;
	}
	
}

