package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa la categoria sintactica Declaración
 * @author Mateo Toquica-Angie Maldonado 
 *
 */
public class Declaracion 
{
	/**
	 * Atributo que representa las variables de la declaración
	 */
	private DeclaracionVariables variables;
	
	/**
	 * Atributo que representa los metodos contenidos en la declaración
	 */
	private DeclaracionFunciones metodos;
	
	/**
	 * Constructor  de la clase declaracion 
	 * @param variables, Las variables declaradas
	 * @param metodos, Los metodos declarados
	 */
	public Declaracion(DeclaracionVariables variables, DeclaracionFunciones metodos) {
		super();
		this.variables = variables;
		this.metodos = metodos;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("declaracion");
		if(variables != null)
		{
			raiz.add(variables.getArbolVisual());
		}
		if(metodos != null){
			raiz.add(metodos.getArbolVisual());
		}
		return raiz;
	}
	
	
	//Getters And Setters
	public DeclaracionVariables getVariables() {
		return variables;
	}

	public void setVariables(DeclaracionVariables variables) {
		this.variables = variables;
	}

	public DeclaracionFunciones getMetodos() {
		return metodos;
	}

	public void setMetodos(DeclaracionFunciones metodos) {
		this.metodos = metodos;
	}


	
	
	
}
