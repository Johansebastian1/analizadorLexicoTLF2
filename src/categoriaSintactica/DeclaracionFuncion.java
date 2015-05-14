package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa la categoria sintactica Declaración de clase
 * @author Carlos Daniel Londoño Torres - Camilo Andres Martinez Castaño - Jorge Hernan Castaño Barraza - Christian Giovani Cachaya 
 *
 */
public class DeclaracionFuncion 
{
	/**
	 * Atributo que representa la clase
	 */
	private SimboloLexico identificadorfuncion;
	
	/**
	 * Atributo de tipo parametro, que contiene los parametros
	 */
	private Parametros parametros;
	
	/**
	 * Atributo que indica el retorno del funcion
	 */
	private SimboloLexico tipoRetorno;
	
	/**
	 * Atributo que representa el tipo de visibilidad indicado del funcion
	 */
	private Visibilidad visibilidad;
	
	/**
	 * Atributo que representa las sentencias hechas en la funcion
	 */
	private BloqueSentencias Sentencias;
	
	/**
	 * Constructor de la clase declaración funcion
	 * @param identificadorfuncion, El identificador de la funcion
	 * @param parametros, Los parametros de la funcion
	 * @param tipoRetorno, El tipo de retorno de la funcion
	 * @param visibilidad, El visibilidad indicado para la funcion
	 * @param sentencias, Las sentencias contenidas en la funcion
	 */
	public DeclaracionFuncion(Visibilidad visibilidad,SimboloLexico identificadorfuncion, Parametros parametros, SimboloLexico tipoRetorno,
			 BloqueSentencias sentencias) 
	{
		this.identificadorfuncion = identificadorfuncion;
		this.parametros = parametros;
		this.tipoRetorno = tipoRetorno;
		this.visibilidad = visibilidad;
		Sentencias = sentencias;
	}

	/**
	 * funcion encargada de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("declaracionfuncion");
		raiz.add(visibilidad.getArbolVisual());
		DefaultMutableTreeNode r=new DefaultMutableTreeNode("Tipo Retorno");
		r.add(new DefaultMutableTreeNode("nombre:"+tipoRetorno.getLexema()));
		raiz.add(r);
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorfuncion.getLexema()));
		raiz.add(parametros.getArbolVisual());
		raiz.add(Sentencias.getArbolVisual());
		return raiz;
	}	
	
	
	public SimboloLexico getIdentificadorfuncion() {
		return identificadorfuncion;
	}

	public void setIdentificadorfuncion(SimboloLexico identificadorfuncion) {
		this.identificadorfuncion = identificadorfuncion;
	}

	public Parametros getParametros() {
		return parametros;
	}

	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}
	public SimboloLexico getTipoRetorno() {
		return tipoRetorno;
	}

	public void setTipoRetorno(SimboloLexico tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

	public Visibilidad getVisibilidad() {
		return visibilidad;
	}

	public void setvisibilidad(Visibilidad visibilidad) {
		this.visibilidad = visibilidad;
	}

	public BloqueSentencias getSentencias() {
		return Sentencias;
	}

	public void setSentencias(BloqueSentencias sentencias) {
		Sentencias = sentencias;
	}


	
}
