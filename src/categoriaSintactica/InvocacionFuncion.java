package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

import mundo.*;

/**
 * Clase que representa la invocación dentro del codigo
 * @author Carlos Daniel Londoño Torres - Camilo Andres Martinez Castaño - Jorge Hernan Castaño Barraza - Christian Giovani Cachaya 
 *
 */
public class InvocacionFuncion implements Sentencia
{
	/**
	 * Datos ingresados al funcion
	 */
	private Datos datos;
	
	/**
	 * simbolo lexico del identificador del funcion
	 */
	private SimboloLexico identificadorfuncion;
	
	/**
	 * Constructor de la clase
	 * @param datos, Los datos invocados
	 * @param identificadorfuncion, El simbolo lexico quelo identifica
	 */
	public InvocacionFuncion(Datos datos, SimboloLexico identificadorfuncion) 
	{
		this.datos = datos;
		this.identificadorfuncion = identificadorfuncion;
	}

	/**
	 * funcion encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("invocacionfuncion");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorfuncion.getLexema()));
		raiz.add(datos.getArbolVisual());
		return raiz;
	}
	
	/**
	 * funcion encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code=""+identificadorfuncion.getLexema();
		code+=datos.getJavaCode()+";";
		return code;
	}
	
	
	//Getters and Setters
	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	public SimboloLexico getIdentificadorfuncion() {
		return identificadorfuncion;
	}

	public void setIdentificadorfuncion(SimboloLexico identificadorfuncion) {
		this.identificadorfuncion = identificadorfuncion;
	}
	
}
