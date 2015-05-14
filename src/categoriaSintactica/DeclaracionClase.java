package categoriaSintactica;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa la categoria sintactica Declaración de clase
 * @author  Mateo Toquica - Angie Maldonado
 *
 */
public class DeclaracionClase 
{
	
	/**
	 * Atributo que representa las declaraciones contenidas en esta clase
	 */
	private Declaracion declaraciones;
	
	/**
	 * Atributo que representa la clase
	 */
	private SimboloLexico identificadorClase;
	
	/**
	 * Atributo que indica el acceso a la clase, publico o privado
	 */
	private Visibilidad acceso;
	
	/**
	 * Constructor de clase
	 * @param declaraciones, Las declaraciones instanciadas
	 * @param identificadorClase, identificador indicado
	 * @param acceso,Tipo de acceso creado
	 */
	public DeclaracionClase(Declaracion declaraciones, SimboloLexico identificadorClase,Visibilidad acceso) {
		this.declaraciones = declaraciones;
		this.identificadorClase = identificadorClase;
		this.acceso = acceso;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("declaracionClase");
		if(acceso != null){
			raiz.add(acceso.getArbolVisual());
		}
		if(identificadorClase != null){
			raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorClase.getLexema()));
		}
		if(declaraciones != null){
			raiz.add(declaraciones.getArbolVisual());
		}
		
		return raiz;
	}
	

	
	//Getters and Setters
	public Declaracion getDeclaraciones() {
		return declaraciones;
	}

	public void setDeclaraciones(Declaracion declaraciones) {
		this.declaraciones = declaraciones;
	}

	public SimboloLexico getIdentificadorClase() {
		return identificadorClase;
	}

	public void setIdentificadorClase(SimboloLexico identificadorClase) {
		this.identificadorClase = identificadorClase;
	}

	public Visibilidad getAcceso() {
		return acceso;
	}

	public void setAcceso(Visibilidad acceso) {
		this.acceso = acceso;
	}

	
	
	
}
