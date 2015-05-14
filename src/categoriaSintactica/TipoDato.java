package categoriaSintactica;

import javax.swing.tree.DefaultMutableTreeNode;

import mundo.SimboloLexico;

/**
 * Clase que representa un listado de parametros
 * @author Mateo Toquica - Angie Maldonado 
 *
 */
public class TipoDato
{
		/**
		 * Simbolo lexico que representa el tipo de dato(entero o reales)
		 */
		private SimboloLexico tipoDato;

		/**
		 * Constructor de la clase
		 * @param tipoAcceso, El tipo de acceso definido
		 */
		public TipoDato(SimboloLexico tipoDato) 
		{
			this.tipoDato =tipoDato;
		}

		/**
		 * Metodo encargado de crear el arbol para la visualizacion a la hora de compilar
		 * @return raiz,  El Arbol que representa esta categoria sintactica
		 */
		public DefaultMutableTreeNode getArbolVisual()
		{
			DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Tipo Dato");
			if(tipoDato != null){
				raiz.add(new DefaultMutableTreeNode("Nombre:" + tipoDato.getLexema()));
			}
			return raiz;
		}
		
		/**
		 * Metodo encargado de crear el codigo java
		 * @return codigo,  el cogido de esta categoria
		 */
		public String getJavaCode() 
		{
			String code=""+tipoDato.getLexema()+" ";
			return code;
		}
		
		//Getters and setters
		public SimboloLexico getTipoDato() {
			return tipoDato;
		}

		public void setTipoDato(SimboloLexico tipoDato) {
			this.tipoDato = tipoDato;
		}
		
}