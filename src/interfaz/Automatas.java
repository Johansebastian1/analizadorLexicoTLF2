package interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;



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
public class Automatas extends javax.swing.JFrame implements ActionListener{
	private JLabel jLOpcionAutomata;
	private JComboBox jCBOpcionAutomata;
	private JLabel jLAutomatas;
	private JPanel jPAutomatas;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Automatas inst = new Automatas();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Automatas() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Automatas");
			getContentPane().setLayout(null);
			{
				jLOpcionAutomata = new JLabel();
				getContentPane().add(jLOpcionAutomata);
				jLOpcionAutomata.setText("Seleccione:");
				jLOpcionAutomata.setBounds(12, 12, 68, 16);
			}
			{
				ComboBoxModel jCBOpcionAutomataModel = 
						new DefaultComboBoxModel(
								new String[] { "Seleccionar","Break","Bring","Cadena de Caracteres","Clase","CLS",
										"Division","Palabra reservada entero","Entero","Llave Apertura","LLave Cierre",
										"Metodo","Mientras","Multiplicacion","Dividido Igual","Mas Igual",
										"Menos Igual","Por Igual","Negador","Operador Logico - O","Operador Logico - Y",
										"Diferente","Igual","Mayor o Igual", "Mayor","Menor o Igual"
										,"Menor","Paquete","Para","Parentesis Apertura","Parentesis Cierre",
										"Private","Public","Real","Reales","Resta",
										"Return","Separador","Suma","Terminales","Variable"});
				jCBOpcionAutomata = new JComboBox();
				getContentPane().add(jCBOpcionAutomata);
				jCBOpcionAutomata.setModel(jCBOpcionAutomataModel);
				jCBOpcionAutomata.setBounds(92, 9, 266, 23);
				jCBOpcionAutomata.addActionListener(this);
				
			}
			{
				jPAutomatas = new JPanel();
				getContentPane().add(jPAutomatas);
				jPAutomatas.setBounds(12, 44, 763, 440);
				jPAutomatas.setLayout(null);
				{
					jLAutomatas = new JLabel();
					jPAutomatas.add(jLAutomatas);
					jLAutomatas.setBounds(12, 12, 739, 411);
					jLAutomatas.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				}
			}
			pack();
			this.setSize(803, 534);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(jCBOpcionAutomata.getSelectedIndex()==0){
			jLAutomatas.setIcon(null);
			jPAutomatas.updateUI();
				
		}
		
		if(jCBOpcionAutomata.getSelectedIndex()==1){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Break.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==2){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Bring.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==3){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Cadena de Caracteres.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==4){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Clase.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==5){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/CLS.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==6){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Division.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==7){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Entero.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==8){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Entrar.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==9){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Llave Apertura.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==10){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Llave Cierre.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==11){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Metodo.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==12){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Mientras.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==13){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Multiplicacion.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==14){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador de Asignacion - Dividido Igual.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==15){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador de Asignacion - Mas Igual.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==16){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador de Asignacion - Menos Igual.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==17){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador de Asignacion - Por Igual.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==18){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Logico - Negador.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==19){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Logico - O.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==20){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Logico - Y.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==21){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Relacional - Diferente.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==22){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Relacional - Igual.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==23){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Relacional - Mayor O Igual.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==24){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Relacional - Mayor.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==25){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Relacional - Menor O Igual.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==26){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Operador Relacional - Menor.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==27){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Paquete.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==28){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Para Fur.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==29){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Parentesis Apertura.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==30){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Parentesis Cierre.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==31){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Priv.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==32){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Public.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==33){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Real.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==34){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Reales.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==35){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Resta.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==36){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Return.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==37){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Separador.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==38){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Suma.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==39){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Terminales.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		if(jCBOpcionAutomata.getSelectedIndex()==40){
			ImageIcon img=new ImageIcon("C:/Users/personal/Desktop/analizadorLexicoTLF2/src/res/Variable.jpg");
			jLAutomatas.setIcon(img);
			jPAutomatas.updateUI();
				
		}
		
		
	}

}
