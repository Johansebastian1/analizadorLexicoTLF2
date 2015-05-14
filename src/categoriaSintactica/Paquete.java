package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa un paquete del codigo
 * @author Mateo Toquica-Angie Maladonado  
 *
 */
public class Paquete 
{
	/**
	 * Simbolo lexico que representa el identificador de paquete
	 */
	private SimboloLexico identificadorPaquete;
	
	/**
	 * constructor de la clase
	 * @param identificadorPaquete, El identificador
	 */
	public Paquete(SimboloLexico identificadorPaquete) {
		super();
		this.identificadorPaquete = identificadorPaquete;
	}
	
	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Pack");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorPaquete.getLexema()));
		return raiz;
	}
	
	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code=""+identificadorPaquete.getLexema()+" ";
		return code;
	}
	
	
	//Getters And Setters
	public SimboloLexico getIdentificadorPaquete() {
		return identificadorPaquete;
	}
	public void setIdentificadorPaquete(SimboloLexico identificadorPaquete) {
		this.identificadorPaquete = identificadorPaquete;
	}

	
}
