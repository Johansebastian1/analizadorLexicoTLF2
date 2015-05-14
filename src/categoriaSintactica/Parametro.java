package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

import mundo.SimboloLexico;

/**
 * Clase que representa un parametro en el codigo
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class Parametro 
{
	/**
	 * Simbolo lexico que identifica la variable
	 */
	private SimboloLexico identificadorVariable;
	
	/**
	 * El tipo de dato  que llega como parametro
	 */
	private SimboloLexico tipoDato;
	
	/**
	 * Constructor de la clase
	 * @param identificadorVariable
	 * @param tipoDato
	 */
	public Parametro(SimboloLexico identificadorVariable, SimboloLexico tipoDato) 
	{
		this.identificadorVariable = identificadorVariable;
		this.tipoDato = tipoDato;
	}

	

	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("parametro");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorVariable.getLexema()));
		return raiz;
	}
	
	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code=""+identificadorVariable.getLexema();
		return code;
	}
	
	//Getters and Setters
	public SimboloLexico getIdentificadorVariable() {
		return identificadorVariable;
	}

	public void setIdentificadorVariable(SimboloLexico identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
	}

	public SimboloLexico getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(SimboloLexico tipoDato) {
		this.tipoDato = tipoDato;
	}
	
}
