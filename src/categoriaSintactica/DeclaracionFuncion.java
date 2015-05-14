package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

import mundo.SimboloLexico;

/**
 * Clase que representa la categoria sintactica Declaración de clase
 * @author 
 *
 */
public class DeclaracionFuncion 
{
	/**
	 * Atributo que representa la clase
	 */
	private SimboloLexico identificadorFuncion;
	
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
	private BloqueSentencias sentencias;
	
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
		this.identificadorFuncion = identificadorfuncion;
		this.parametros = parametros;
		this.tipoRetorno = tipoRetorno;
		this.visibilidad = visibilidad;
		this.sentencias = sentencias;
	}

	/**
	 * funcion encargada de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Declaracion Funcion");
		
		if(visibilidad != null){
			raiz.add(visibilidad.getArbolVisual());
		}
		
		DefaultMutableTreeNode r=new DefaultMutableTreeNode("Tipo Retorno");
		
		if(tipoRetorno != null){
			r.add(new DefaultMutableTreeNode("Nombre:" + tipoRetorno.getLexema()));
			raiz.add(r);
		}
		
		if(identificadorFuncion != null){
			raiz.add(new DefaultMutableTreeNode("Nombre:" + identificadorFuncion.getLexema()));
		}
		
		if(parametros != null){
			raiz.add(parametros.getArbolVisual());
		}
		
		if(sentencias != null){
			raiz.add(sentencias.getArbolVisual());
		}
		
		return raiz;
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

	/**
	 * @return the identificadorFuncion
	 */
	public SimboloLexico getIdentificadorFuncion() {
		return identificadorFuncion;
	}

	/**
	 * @param identificadorFuncion the identificadorFuncion to set
	 */
	public void setIdentificadorFuncion(SimboloLexico identificadorFuncion) {
		this.identificadorFuncion = identificadorFuncion;
	}

	/**
	 * @return the sentencias
	 */
	public BloqueSentencias getSentencias() {
		return sentencias;
	}

	/**
	 * @param sentencias the sentencias to set
	 */
	public void setSentencias(BloqueSentencias sentencias) {
		this.sentencias = sentencias;
	}

	/**
	 * @param visibilidad the visibilidad to set
	 */
	public void setVisibilidad(Visibilidad visibilidad) {
		this.visibilidad = visibilidad;
	}

}
