package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa un listado de parametros
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class Termino 
{
	/**
	 * Factor que representa un termino
	 */
	private Factor factor;
	
	/**
	 * El termino que se esta representando
	 */
	private Termino Termino;
	
	/**
	 * simbolo lexico que representa el operador multiplicativo
	 */
	private SimboloLexico operadorMultiplicativo;
	
	/**
	 * Constructor de la clase
	 * @param factor,  El factor
	 * @param termino, el termino a contener
	 * @param operadorMultiplicativo, El operador de operación
	 */
	public Termino(Factor factor, Termino termino,
			SimboloLexico operadorMultiplicativo) {
		this.factor = factor;
		Termino = termino;
		this.operadorMultiplicativo = operadorMultiplicativo;
	}

	//Getters and setters
	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	public Termino getTermino() {
		return Termino;
	}

	public void setTermino(Termino termino) {
		Termino = termino;
	}

	public SimboloLexico getOperadorMultiplicativo() {
		return operadorMultiplicativo;
	}

	public void setOperadorMultiplicativo(SimboloLexico operadorMultiplicativo) {
		this.operadorMultiplicativo = operadorMultiplicativo;
	}
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public MutableTreeNode getArbolVisual() 
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("termino");
		if(operadorMultiplicativo!=null)
			raiz.add(new DefaultMutableTreeNode("nombre:"+operadorMultiplicativo.getLexema()));
		if(Termino!=null)
			raiz.add(Termino.getArbolVisual());
		raiz.add(factor.getArbolVisual());
		return raiz;
	}
	
	
	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code="";
		if(operadorMultiplicativo!=null)
			code+= operadorMultiplicativo.getLexema()+" ";
		if(Termino!=null)
			code+= Termino.getJavaCode();
		code+= factor.getJavaCode();
		
		return code;
	}
	
	
}
