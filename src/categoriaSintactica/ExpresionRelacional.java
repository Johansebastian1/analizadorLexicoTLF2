package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa las expresiones relacionales presentes en el codigo
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class ExpresionRelacional {

	/**
	 * Atributo de representa la variable comparada
	 */
	private SimboloLexico identificadorVariable1;
	
	/**
	 * Atributo que representa la variable a comparar
	 */
	private SimboloLexico identificadorVariable2;
	
	
	/**
	 * Constructor de clase
	 * @param identificadorVariable1
	 * @param identificadorVariable2
	 */
	public ExpresionRelacional(SimboloLexico identificadorVariable1,
			SimboloLexico identificadorVariable2) {
		this.identificadorVariable1 = identificadorVariable1;
		this.identificadorVariable2 = identificadorVariable2;
	}
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public MutableTreeNode getArbolVisual() 
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Condiciones");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorVariable1.getLexema()));
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorVariable2.getLexema()));
		return raiz;
	}

	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code="";
		code+=identificadorVariable1.getLexema()+"			";
		code+=identificadorVariable2.getLexema()+"		";
		return code;

	}
	
	
	//Getters And Setters
	public SimboloLexico getIdentificadorVariable1() {
		return identificadorVariable1;
	}

	public void setIdentificadorVariable1(SimboloLexico identificadorVariable1) {
		this.identificadorVariable1 = identificadorVariable1;
	}

	public SimboloLexico getIdentificadorVariable2() {
		return identificadorVariable2;
	}

	public void setIdentificadorVariable2(SimboloLexico identificadorVariable2) {
		this.identificadorVariable2 = identificadorVariable2;
	}

	

}
