package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import mundo.*;

/**
 * Clase que representa la importacion en el codigo
 * @author Mateo Toquica-Angie Maldonado 
 *
 */
public class Importacion 
{
	
	/**
	 * Simbolo lexico que representa identificador de importación
	 */
	private SimboloLexico identificadorImportacion;
	
	/**
	 * Constructor de clase
	 * @param identificadorImportacion, el identificador de importación
	 */
	public Importacion(SimboloLexico identificadorImportacion) {
		this.identificadorImportacion = identificadorImportacion;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("importacion");
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorImportacion.getLexema()));
		return raiz;
	}
	
	
	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code=""+identificadorImportacion.getLexema()+" IMPORTACIONN   ";
		return code;
	}
	
	//Getters And Setter
	
	public SimboloLexico getIdentificadorImportacion() {
		return identificadorImportacion;
	}

	public void setIdentificadorImportacion(SimboloLexico identificadorImportacion) {
		this.identificadorImportacion = identificadorImportacion;
	}

	
	
}
