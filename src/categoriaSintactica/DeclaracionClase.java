package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

import mundo.SimboloLexico;

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
	private Visibilidad visibilidad;
	
	/**
	 * Constructor de clase
	 * @param declaraciones, Las declaraciones instanciadas
	 * @param identificadorClase, identificador indicado
	 * @param acceso,Tipo de acceso creado
	 */
	public DeclaracionClase(Declaracion declaraciones, SimboloLexico identificadorClase,Visibilidad visibilidad) {
		this.declaraciones = declaraciones;
		this.identificadorClase = identificadorClase;
		this.visibilidad = visibilidad;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Declaracion Clase");
		if(visibilidad != null){
			raiz.add(visibilidad.getArbolVisual());
		}
		if(identificadorClase != null){
			raiz.add(new DefaultMutableTreeNode("Nombre:" + identificadorClase.getLexema()));
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

	/**
	 * @return the visibilidad
	 */
	public Visibilidad getVisibilidad() {
		return visibilidad;
	}

	/**
	 * @param visibilidad the visibilidad to set
	 */
	public void setVisibilidad(Visibilidad visibilidad) {
		this.visibilidad = visibilidad;
	}

}
