
package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;


/**
 * Clase que representa un retorno en el codigo 
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class Retorno implements Sentencia
{
	/**
	 * Atributo del dato que se va a retornar
	 */
	private Dato datoRetornar;
	
	/**
	 * Constructor de la clase retorno
	 * @param datoRetornar, El dato a mostrar
	 */
	public Retorno(Dato datoRetornar)
	{
		this.datoRetornar = datoRetornar;	
	}

	/**
	 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
	 * @return raiz,  El Arbol que representa esta categoria sintactica
	 */
	public DefaultMutableTreeNode getArbolVisual() 
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Retorno");
		if(datoRetornar != null){
			raiz.add(datoRetornar.getArbolVisual());
		}
		return raiz;
	}
	
	/**
	 * Metodo encargado de crear el codigo java
	 * @return codigo,  el cogido de esta categoria
	 */
	public String getJavaCode() 
	{
		String code="return "+datoRetornar.getJavaCode()+";";
		return code;
	}
	
	//Getters and setters
	public Dato getDatoRetornar() {
		return datoRetornar;
	}

	public void setDatoRetornar(Dato datoRetornar) {
		this.datoRetornar = datoRetornar;
	}
}
