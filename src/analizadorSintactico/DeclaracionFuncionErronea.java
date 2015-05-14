package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import categoriaSintactica.*;
import mundo.*;

/**
 * Clase 
 * @author Carlos Daniel Londoño Torres - Camilo Andres Martinez Castaño - Jorge Hernan Castaño Barraza - Christian Giovani Cachaya 
 *
 */
public class DeclaracionFuncionErronea extends DeclaracionFuncion
{
	private SimboloLexico identificadorfuncion;
	private Parametros parametros;
	private SimboloLexico tipoRetorno;
	private Visibilidad visibilidad;
	private BloqueSentencias Sentencias;
	
	public DeclaracionFuncionErronea(SimboloLexico identificadorfuncion, Parametros parametros, SimboloLexico tipoRetorno,
			Visibilidad visibilidad, BloqueSentencias sentencias) 
	{
		super(visibilidad, identificadorfuncion, parametros, tipoRetorno, sentencias);
		this.identificadorfuncion = identificadorfuncion;
		this.parametros = parametros;
		this.tipoRetorno = tipoRetorno;
		this.visibilidad = visibilidad;
		Sentencias = sentencias;
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

	public void setVisibilidad(Visibilidad visibilidad) {
		this.visibilidad = visibilidad;
	}

	public BloqueSentencias getSentencias() {
		return Sentencias;
	}

	public void setSentencias(BloqueSentencias sentencias) {
		Sentencias = sentencias;
	}

	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("declaracionfuncionErronea");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorfuncion.getLexema()));
		raiz.add(parametros.getArbolVisual());
		DefaultMutableTreeNode r=new DefaultMutableTreeNode("Tipo Retorno");
		r.add(new DefaultMutableTreeNode("nombre:"+tipoRetorno.getLexema()));
		raiz.add(r);
		raiz.add(visibilidad.getArbolVisual());
		raiz.add(Sentencias.getArbolVisual());
		return raiz;
	}
}
