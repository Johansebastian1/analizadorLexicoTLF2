
package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

import mundo.*;

/**
 * Clase que representa la cateogria sintactica variable
 * @author Mateo Toquica- Angie Maldonado 
 *
 */
public class Variable implements Sentencia
{
	/**
	 * El tipo de dato que representa la variable
	 */
	private SimboloLexico tipoDato;
	
	/**
	 * Simbolo identificador devariable
	 */
	private SimboloLexico identificadorVariable;
	
	/**
	 * Constructor de clase
	 * @param tipoDato, tipo de dato a  almacenar
	 * @param identificadorVariable, identificador de variable a almacenar
	 */
	public Variable(SimboloLexico tipoDato, SimboloLexico identificadorVariable) 
	{
		super();
		this.tipoDato = tipoDato;
		this.identificadorVariable = identificadorVariable;
	}
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("variable");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorVariable.getLexema()));
		DefaultMutableTreeNode r=new DefaultMutableTreeNode("Tipo Retorno");
		r.add(new DefaultMutableTreeNode("nombre:"+tipoDato.getLexema()));
		raiz.add(r);
		return raiz;
	}
	
//	/**
//	 * Metodo encargado de crear el codigo java
//	 * @return codigo,  el cogido de esta categoria
//	 */
//	public String getJavaCode() 
//	{
//		String code=""+identificadorVariable.getLexema();
//		code+=tipoDato.getJavaCode()+";";
//		return code;
//	}
//	
	
	//Getters and setters

	public SimboloLexico getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(SimboloLexico tipoDato) {
		this.tipoDato = tipoDato;
	}

	public SimboloLexico getIdentificadorVariable() {
		return identificadorVariable;
	}

	public void setIdentificadorVariable(SimboloLexico identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
	}
	
	
}
