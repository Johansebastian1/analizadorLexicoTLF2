
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazAnalizadorLexico.java,v 1.0 2008/08/17 10:39:08 da-romer Exp $
 * Universidad del Quindío (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas y Computación
 *
 * Asignatura Teoría de Lenguajes Formales
 * Ejercicio : Analizador léxico
 * Autor inicial: Leonardo A. Hernández R. - Agosto 17 de 2008
 * Autor:
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package interfaz;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import mundo.AnalizadorLexico;
import mundo.SimboloLexico;
import analizadorSintactico.AnalizadorSintactico;
import analizadorSintactico.ErrorSintactico;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * Ventana principal de la aplicación
 */
public class InterfazAnalizadorLexico extends JFrame
{

    // -----------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------

	private JTree arbol;
    /**
     * Panel donde se muestran los resultados
     */
    private PanelAnalizador  panelEntradaCodigo;

       /**
     * Analizador léxico
     */
    private AnalizadorLexico analizadorLexico;
    
    /**
     * Analizador Sintactico
     */
    private AnalizadorSintactico analizadorSintactico;

    // -----------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------

    /**
     * Constructor de la interfaz
     */
    public InterfazAnalizadorLexico( )
    {
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setVisible( true );
        setResizable( false );
        setTitle( "Analizador 1.2" );
        setLayout( new GridLayout( 1, 1 ) );
        {
        	panelEntradaCodigo = new PanelAnalizador( this );
			
        	getContentPane().add(panelEntradaCodigo);
        }
        analizadorLexico = new AnalizadorLexico( );
        
        pack( );
        centrarFrame( );

    }

    // -----------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------

    /**
     * Centra el frame en la pantalla según resolución
     */
    private void centrarFrame( )
    {
        Dimension screenSize = getToolkit( ).getScreenSize( );
        int screenWidth = ( int )screenSize.getWidth( );
        int screenHeight = ( int )screenSize.getHeight( );
        setLocation( ( ( screenWidth / 2 ) - ( getWidth( ) / 2 ) ), ( ( screenHeight / 2 ) - ( getHeight( ) / 2 ) ) );
    }

   
   /**
    * Invoca el método que analiza el código fuente
    * y guarda los tokens a una tabla de simbolos léxicos  
    */
    
    public void analizarCodigo(String codigoFuente)
    {
    	if(codigoFuente.length() == 0)
    		JOptionPane.showMessageDialog( this, "Debe ingresar una codigo fuente", "Error", JOptionPane.ERROR_MESSAGE );
    	else
    	{
    		//enviamos el codigo fuente para ser analizado
    		analizadorLexico.analizar(codigoFuente);
    		
    		ArrayList<SimboloLexico> simboloLexicos = analizadorLexico.getTablaSimbolos();
    		mostrarTokens(simboloLexicos);
    		
    		analizadorSintactico = new AnalizadorSintactico(simboloLexicos);

       		mostrarAnalisisSintactico();
    	}
    }
    
    private void mostrarAnalisisSintactico() {

    	
		DefaultMutableTreeNode raiz = analizadorSintactico.getUnidadDeCompilacion().getArbolVisual();
		
		arbol=new JTree(raiz); 
		panelEntradaCodigo.setJtree(arbol);
		arbol.updateUI();


		ArrayList<ErrorSintactico> erroressintactico;
		erroressintactico = analizadorSintactico.getListaErrores();


		String [][]matriz = new String[erroressintactico.size()][4];
		int i=0;
		while(i<erroressintactico.size())
		{
			matriz[i][0]=erroressintactico.get(i).getMsgError();
			matriz[i][1]=""+erroressintactico.get(i).getFila();
			matriz[i][2]=""+erroressintactico.get(i).getColumna();
			i++;

		}
		DefaultTableModel model =	new DefaultTableModel(matriz,new String[] {"Error sintactico", "Fila", "Columna" });
		JTable aux =new JTable();
		
		aux.setModel(model);
		panelEntradaCodigo.setJTableSintactico(aux);

		
	
}

	/**
     * Método usado para ver los tokens del código ingresado
     */
    public void mostrarTokens(ArrayList<SimboloLexico> miTablaDeSimbolos)
    {
    	//ArrayList<SimboloLexico> miTablaDeSimbolos;
		miTablaDeSimbolos = analizadorLexico.getTablaSimbolos();
		System.out.println(miTablaDeSimbolos.get(0).getToken());
		
		
		String [][]matriz = new String[miTablaDeSimbolos.size()][4];
		int i=0;
		
				
		while(i<miTablaDeSimbolos.size())
		{
			matriz[i][0]=miTablaDeSimbolos.get(i).getLexema();
			matriz[i][1]=miTablaDeSimbolos.get(i).getToken();
			matriz[i][2]=""+miTablaDeSimbolos.get(i).getFila();
			matriz[i][3]=""+miTablaDeSimbolos.get(i).getColumna();
			i++;
		}
		
		DefaultTableModel model =	new DefaultTableModel(matriz,new String[] { "Lexema", "Token", "Fil", "Col" });
		JTable tablaAux = new JTable();
		tablaAux.setModel(model);
		panelEntradaCodigo.setJTableTokens(tablaAux);
		

		
    }
    
    
                
        /**
     * Calcula el punto que indica la posición centrada del frame
     * @param componentePadre - Ventana Padre del componente - !=null
     * @param componenteHijo - Ventana Hija del componente - !=null
     * @return punto - Localizacion en coordinadas x,y del nuevo componente - !=null
     */
    private Point calculaPosicionCentral( Component componentePadre, Component componenteHijo )
    {
        Dimension tamanoPantalla, tamanoPadre, tamanoHijo;
        Point localizacionPadre;

        // Centra la ventana y verifica que no sea mayor que la resolución
        // actual
        tamanoPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int max_y = tamanoPantalla.height;
        int min_y = 0;

        // Tamaño de la resolucion de la pantalla
        tamanoPadre = componentePadre.getSize( );
        localizacionPadre = componentePadre.getLocation( );
        tamanoHijo = componenteHijo.getSize( );
        int x = ( tamanoPadre.width - tamanoHijo.width ) / 2 + localizacionPadre.x;
     // int y = ( tamanoPadre.height - tamanoHijo.height ) / 2 + localizacionPadre.y;
        int y = tamanoPadre.height + localizacionPadre.y;

        // Ajuste para abajo
        if( y + tamanoHijo.height > max_y )
        {
            y = max_y - tamanoHijo.height;
        }

        // Ajuste para arriba
        if( y < min_y )
        {
            y = 0;
        }
        return new Point( x, y );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación
     * @param args Son los parámetros de la línea de comandos. No se utilizan.
     */
    public static void main( String[] args )
    {
    	InterfazAnalizadorLexico interfaz = new InterfazAnalizadorLexico( );
        interfaz.setVisible( true );
    }
}
