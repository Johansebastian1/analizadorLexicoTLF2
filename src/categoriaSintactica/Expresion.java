package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa las expresiones presentes en el codigo
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class Expresion 
{
	/**
	 * Atributo que representa un terminno
	 */
	private Termino termino;
	
	/**
	 * Simbolo lexico que hace referencia al operador de adición
	 */
	private SimboloLexico operadorAditivo;
	
	/**
	 * Atributo que representa una expresión
	 */
	private Expresion expresion;
	
	/**
	 * Constructor de la expresión
	 * @param termino, El termino que pertenece a la expresión
	 * @param operadorAditivo, Operador de adicion empleado en la adición
	 * @param expresion, La Expresión manejada
	 */
	public Expresion(Termino termino, SimboloLexico operadorAditivo,
			Expresion expresion) {
		super();
		this.termino = termino;
		this.operadorAditivo = operadorAditivo;
		this.expresion = expresion;
	}
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public MutableTreeNode getArbolVisual() 
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("expresion");
		if(operadorAditivo!=null)
			raiz.add(new DefaultMutableTreeNode("nombre:"+operadorAditivo.getLexema()));
		if(expresion!=null)
			raiz.add(expresion.getArbolVisual());
		raiz.add(termino.getArbolVisual());
		return raiz;
	}

	

	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code="";
		if(operadorAditivo!=null)
			code+= operadorAditivo.getLexema();
		if(expresion!=null)
			code+= expresion.getJavaCode();
		code+= termino.getJavaCode();
		return code;
	}
	
	//Getters And Setters
	public Termino getTermino() {
		return termino;
	}

	public void setTermino(Termino termino) {
		this.termino = termino;
	}

	public SimboloLexico getOperadorAditivo() {
		return operadorAditivo;
	}

	public void setOperadorAditivo(SimboloLexico operadorAditivo) {
		this.operadorAditivo = operadorAditivo;
	}

	public Expresion getExpresion() {
		return expresion;
	}

	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}


	
	
}
