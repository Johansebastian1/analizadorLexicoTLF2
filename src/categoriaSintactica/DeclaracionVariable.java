package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import mundo.*;

/**
 * Clase que representa la categoria sintactica Declaración de variable
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class DeclaracionVariable 
{	
	/**
	 *Simbolo lexico del tipo identificador de variable
	 */
	private SimboloLexico identificadorVariable;
	
	/**
	 * Atributo que representa el tipo de dato de la variable
	 */
	private SimboloLexico tipoDato;
	
	/**
	 * Atributo que indica el acceso indicado para la variable
	 */
	private Visibilidad acceso;
	
	/**
	 * Metodo constructor de la clase
	 * @param identificadorVariable, El identificador de la variable
	 * @param tipoDato, El tipo de datos que representa la variable
	 * @param acceso, El acceso indicado para la variable
	 */
	public DeclaracionVariable(Visibilidad acceso,SimboloLexico tipoDato,SimboloLexico identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
		this.tipoDato = tipoDato;
		this.acceso = acceso;
	}
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("declaracionVariable");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorVariable.getLexema()));
		if(tipoDato!=null){
			DefaultMutableTreeNode r=new DefaultMutableTreeNode("TipoDato");
			r.add(new DefaultMutableTreeNode("nombre:"+tipoDato.getLexema()));
			raiz.add(r);
		}
		if(acceso!=null)
			raiz.add(acceso.getArbolVisual());
		return raiz;
	}
	
//	/**
//	 * Metodo encargado de crear el codigo java
//	 * @return codigo,  el cogido de esta categoria
//	 */
//	public String getJavaCode() 
//	{
//		String code=""+identificadorVariable.getLexema()+"  ";
//		if(tipoDato!=null)
//			code+=tipoDato.getJavaCode();
//		if(acceso!=null)
//			code+=acceso.getJavaCode();
//		return code;
//	}
//	
	
	
	//Getters And Setter

	public SimboloLexico getTipoDato() {
		return tipoDato;
	}

	public SimboloLexico getIdentificadorVariable() {
		return identificadorVariable;
	}

	public void setIdentificadorVariable(SimboloLexico identificadorVariable) {
		identificadorVariable = identificadorVariable;
	}

	public void setTipoDato(SimboloLexico tipoDato) {
		this.tipoDato = tipoDato;
	}

	public Visibilidad getAcceso() {
		return acceso;
	}

	public void setAcceso(Visibilidad acceso) {
		this.acceso = acceso;
	}


	

}
