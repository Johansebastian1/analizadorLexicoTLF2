package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

import mundo.SimboloLexico;

/**
 * Clase que representa un listado de parametros
 * @author Mateo Toquica- Angie Maldonado 
 *
 */
public class Visibilidad 
{
		/**
	 	* Simbolo lexico que representa el tipo de acceso(publico o privado)
	 	*/
		private SimboloLexico visibilidad;

		/**
		 * Constructor de la clase
		 * @param tipoAcceso, El tipo de acceso definido
		 */
		public Visibilidad(SimboloLexico visibilidad) 
		{
			this.visibilidad = visibilidad;
		}

		/**
		 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
		 * @return raiz,  El Arbol que representa esta categoria sintactica
		 */
		public DefaultMutableTreeNode getArbolVisual()
		{
			DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Visibilidad");
			if(visibilidad != null){
				raiz.add(new DefaultMutableTreeNode("Nombre:" + visibilidad.getLexema()));
			}
			return raiz;
		}
		
		/**
		 * Metodo encargado de crear el codigo java
		 * @return codigo,  el cogido de esta categoria
		 */
		public String getJavaCode() 
		{
			String code=""+visibilidad.getLexema()+" ";
			return code;
		}
		
		//Getters and setters
		public SimboloLexico getVisibilidad() {
			return visibilidad;
		}

		public void setVisibilidad(SimboloLexico visibilidad) {
			this.visibilidad = visibilidad;
		}
		
}
