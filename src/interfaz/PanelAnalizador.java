package interfaz;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.WindowConstants;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;

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
public class PanelAnalizador extends javax.swing.JPanel implements ActionListener{
	private JTable jTableTokens;
	private JTable jTableSintactico;
	private InterfazAnalizadorLexico principal;
	private JMenuBar jMenuBar1;
	private JButton botonAnalizar;
	private JTree jTree;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JMenuItem jMenuItemAnalizador;
	private JMenu jMenuSintactico;
	private JScrollBar jScrollBar1;
	private JMenuItem jMenuItemAutores;
	private JMenuItem jMenuItemInfo;
	private JMenu jMenuAyuda;
	private JMenuItem jMenuItemCargarA;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu2;
	private JLabel jLabelTitulo;
	private JTextArea campoCodigoFuente;
	private JLabel jLabelTabla;
	private JMenu jMenu1;
	private JInternalFrame jInternalFrame1;

	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	/*	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PanelAnalizador());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	 */
	public PanelAnalizador(InterfazAnalizadorLexico principal) {
		super();
		this.principal=principal;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(773, 658));
			this.setLayout(null);
			{
				jInternalFrame1 = new JInternalFrame();
				this.add(jInternalFrame1);
				jInternalFrame1.setLayout(null);
				jInternalFrame1.setBounds(0, 0, 773, 658);
				jInternalFrame1.setVisible(true);
				jInternalFrame1.getContentPane().setLayout(null);
				{
					jLabelTabla = new JLabel();
					jInternalFrame1.getContentPane().add(jLabelTabla);
					jLabelTabla.setText("Tabla de Símbolos Léxicos:");
					jLabelTabla.setBounds(335, 28, 323, 16);
				}
				{
					botonAnalizar = new JButton();
					jInternalFrame1.getContentPane().add(botonAnalizar);
					botonAnalizar.setText("Analizar");
					botonAnalizar.setBounds(383, 573, 129, 22);
					botonAnalizar.addActionListener(this);
				}
				{
					campoCodigoFuente = new JTextArea();
					jInternalFrame1.getContentPane().add(campoCodigoFuente);
					campoCodigoFuente.setBounds(39, 56, 267, 198);
				}
				{
					jLabelTitulo = new JLabel();
					jInternalFrame1.getContentPane().add(jLabelTitulo);
					jLabelTitulo.setText("Digite el código fuente a analizar:");
					jLabelTitulo.setBounds(39, 28, 312, 16);
				}
				{
					jScrollBar1 = new JScrollBar();
					jInternalFrame1.getContentPane().add(jScrollBar1);
					jScrollBar1.setBounds(288, 62, 17, 174);
				}
				{
					jLabel1 = new JLabel();
					jInternalFrame1.getContentPane().add(jLabel1);
					jLabel1.setText("Arbol Sintactico:");
					jLabel1.setBounds(46, 287, 103, 16);
				}
				{
					jLabel2 = new JLabel();
					jInternalFrame1.getContentPane().add(jLabel2);
					jLabel2.setText("Tabla Sintactica");
					jLabel2.setBounds(505, 287, 119, 16);
				}

				{
					jMenuBar1 = new JMenuBar();
					jInternalFrame1.setJMenuBar(jMenuBar1);
					{
						jMenu1 = new JMenu();
						jMenuBar1.add(jMenu1);
						jMenu1.setText("Archivo");
						{
							jMenuItem1 = new JMenuItem();
							jMenu1.add(jMenuItem1);
							jMenuItem1.setText("Guardar archivo");
							jMenuItem1.addActionListener(this);
						}
						{
							jMenuItemCargarA = new JMenuItem();
							jMenu1.add(jMenuItemCargarA);
							jMenuItemCargarA.setText("Cargar archivo");
							jMenuItemCargarA.addActionListener(this);
						}
					}
					{
						jMenu2 = new JMenu();
						jMenuBar1.add(jMenu2);
						jMenu2.setText("AFD");
						{
							jMenuItem2 = new JMenuItem();
							jMenu2.add(jMenuItem2);
							jMenuItem2.setText("Ver automatas");
							jMenuItem2.addActionListener(this);
						}
					}
					{
						jMenuAyuda = new JMenu();
						jMenuBar1.add(jMenuAyuda);
						jMenuAyuda.setText("Ayuda");
						{
							jMenuItemInfo = new JMenuItem();
							jMenuAyuda.add(jMenuItemInfo);
							jMenuItemInfo.setText("Informacion de la aplicación");
							jMenuItemInfo.addActionListener(this);
						}
						{
							jMenuItemAutores = new JMenuItem();
							jMenuAyuda.add(jMenuItemAutores);
							jMenuItemAutores.setText("Autores");
							jMenuItemAutores.addActionListener(this);
						}
					}
					{
						jMenuSintactico = new JMenu();
						jMenuBar1.add(jMenuSintactico);
						jMenuSintactico.setText("Sintactico");
						{
							jMenuItemAnalizador = new JMenuItem();
							jMenuSintactico.add(jMenuItemAnalizador);
							jMenuItemAnalizador.setText("Analizador Sintactico");
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==botonAnalizar)
		{
			char a=0;
			principal.analizarCodigo(campoCodigoFuente.getText()+ a);

		}

		if(e.getSource()==jMenuItem1){

			JFileChooser selector = new JFileChooser();

			int opcion = selector.showSaveDialog(null);

			if (opcion == JFileChooser.APPROVE_OPTION) {

				try {
					generarArchivo(selector.getSelectedFile());
					JOptionPane.showMessageDialog(null, "Archivo generado");
					campoCodigoFuente.setText(null);
				} catch (IOException e1) {

					JOptionPane.showMessageDialog(null, "Se ha producido un erro al generar"
							+ "el archivo");
				}
			}

		}
		if(e.getSource()==jMenuItemCargarA){
			
			campoCodigoFuente.setText(null);

			JFileChooser chooser=new  JFileChooser();

			int res=chooser.showOpenDialog(null);
			if(res==chooser.APPROVE_OPTION)
			{
				File texto=chooser.getSelectedFile();
				String ruta=texto.getAbsolutePath();
				try {
					String codigoF=leerArchivo(ruta);
					campoCodigoFuente.setText(codigoF);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()== jMenuItemAutores){
			
			JOptionPane.showMessageDialog(null, "Aplicacion desarrollada por:"
					+ "\nChristian Cachaya\nMateo Toquica");
			
		}
		if(e.getSource()==jMenuItemInfo){
			
			JOptionPane.showMessageDialog(null, "Este analizador lexico tiene como objetivo idenfificar"
					+ " cada \nuno de los tokens que contiene un determinado texto,\nes decir"
					+ " que identifica por medio de los automatas implementados\nque tipo de token "
					+ "contiene el texto.");
			
		}
		if(e.getSource()==jMenuItem2){
			
			new Automatas().setVisible(true);
			
		}


	}
	
	public void setJtree(JTree tree)
	{
		jTree = tree;
		
		jTree.setEnabled(false);
		jTree.setBounds(39, 322, 267, 234);

		this.add(jTree);
	
	}

	public void setJTableTokens(JTable tableTokens) {
		jTableTokens = tableTokens;
		//va title
		jTableTokens.setEnabled(false);
		jTableTokens.setRowSelectionAllowed( true );
		jTableTokens.setColumnSelectionAllowed( true);

		this.add(jTableTokens);
		
		jTableTokens.setBounds(335, 106, 289, 198);



	}
	public void setJTableSintactico(JTable tableSintactico) {
		jTableSintactico = tableSintactico;
		//va title
		jTableSintactico.setEnabled(false);
		jTableSintactico.setRowSelectionAllowed( true );
		jTableSintactico.setColumnSelectionAllowed( true);

		this.add(jTableSintactico);
		
		jTableSintactico.setBounds(351, 359, 384, 252);



	}

	/**
	 * Metodo que genera un archivo de texto con la informacion del area de txt
	 *
	 * @param archivo
	 * @throws IOException
	 */
	public void generarArchivo(File archivo) throws IOException {

		try {

			PrintWriter escritor = new PrintWriter(archivo);

			escritor.println(campoCodigoFuente.getText());

			escritor.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error al guardar el archivo");

		}
	}

	/**
	 * Metodo que permite leer un archivo de texto
	 * @param ruta
	 * @return
	 * @throws IOException
	 */
	public String leerArchivo(String ruta) throws IOException{

		File file;
		FileReader reader;
		BufferedReader bufferedReader;

		file=new File(ruta);
		reader=new FileReader(file);
		bufferedReader=new BufferedReader(reader);

		String linea=" ";
		String cadena="";

		while((linea=bufferedReader.readLine())!=null){

			cadena+=linea+"\n";			
		}
		return cadena;
	}


}
