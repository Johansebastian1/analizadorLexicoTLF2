package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa las expresiones aritmeticas presentes en el codigo
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class ExpresionAritmetica implements Sentencia
{
	/**
	 * Expresión empleada en esta categoria sintactica
	 */
	private Expresion expresion;
	
	/**
	 * Atributo que representa el termino de la expresion aritmetica
	 */
	private Termino termino;
	
	/**
	 * Factor empleado en la expresión aritmetica
	 */
	private Factor factor;
	
	
	/**
	 * Constructor de clase
	 * @param expresion, La expresion 
	 * @param termino, El termino operando
	 * @param factor, El factor con que se opera
	 */
	public ExpresionAritmetica(Expresion expresion, Termino termino,Factor factor) 
	{
		this.expresion = expresion;
		this.termino = termino;
		this.factor = factor;
	}
	
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("expresionAritmetica");
		if(expresion!=null)
			raiz.add(expresion.getArbolVisual());
		if(factor!=null)
			raiz.add(factor.getArbolVisual());
		if(termino!=null)
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
		if(expresion!=null)
			code+= expresion.getJavaCode()+ " ";
		if(factor!=null)
			code+= factor.getJavaCode();
		if(termino!=null)
			code+= termino.getJavaCode();
		return code;
	}
	
	
	
	//Getters And Setters
	public Expresion getExpresion() {
		return expresion;
	}

	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}

	public Termino getTermino() {
		return termino;
	}

	public void setTermino(Termino termino) {
		this.termino = termino;
	}

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	
	
	
}
