
package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 * Clase  encargada de crear el arbol para la visualizacion a la hora de compilar
 * @author Mateo Toquica - Angie Maldonado 
 */
public interface Sentencia 
{
	/**
	 * @return El Arbol relacionado con la sentencia
	 */
	DefaultMutableTreeNode getArbolVisual();
}
