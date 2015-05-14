
package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa la unidad de compilación
 * @author Mateo Toquica- Angie Maldonado
 */
public class UnidadCompilacion 
{
	/**
	 * Las declaraciones de clase que comprenden la unidad de compilacón
	 */
	private DeclaracionClase declaracionClase;
	
	/**
	 * Las imporataciones hechas en el codigo
	 */
	private BloqueImportaciones importaciones;
	
	/**
	 * Los paquete declarados en el codigo
	 */
	private BloquePaquetes paquete;
	
	/**
	 * Constructor de la clase unidad de compilación
	 * @param declaracionClase, La declaración hecha
	 * @param importaciones, Las imporataciones relizadas
	 * @param paquete, El paquete instanciado
	 */
	public UnidadCompilacion(BloquePaquetes paquete,BloqueImportaciones importaciones, DeclaracionClase declaracionClase) {
		this.declaracionClase = declaracionClase;
		this.importaciones = importaciones;
		this.paquete = paquete;
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Unidad Compilacion");
		
		if (paquete != null) {

			raiz.add(paquete.getArbolVisual());
		}
		
		if(importaciones != null)
		{	
			raiz.add(importaciones.getArbolVisual());
		}
		
		if(declaracionClase != null){
			raiz.add(declaracionClase.getArbolVisual());
		}
		
		return raiz;
	}

	
	//Getters and setters
	public DeclaracionClase getDeclaracionClase() {
		return declaracionClase;
	}

	public void setDeclaracionClase(DeclaracionClase declaracionClase) {
		this.declaracionClase = declaracionClase;
	}

	public BloqueImportaciones getImportaciones() {
		return importaciones;
	}

	public void setImportaciones(BloqueImportaciones importaciones) {
		this.importaciones = importaciones;
	}

	public BloquePaquetes getPaquete() {
		return paquete;
	}

	public void setPaquete(BloquePaquetes paquete) {
		this.paquete = paquete;
	}

	
	
}
