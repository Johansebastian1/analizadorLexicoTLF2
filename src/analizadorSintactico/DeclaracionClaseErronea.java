package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import categoriaSintactica.*;
import mundo.*;

/**
 * Clase 
 * @author Carlos Daniel Londoño Torres - Camilo Andres Martinez Castaño - Jorge Hernan Castaño Barraza - Christian Giovani Cachaya 
 *
 */
public class DeclaracionClaseErronea extends DeclaracionClase
{
	private Declaracion declaraciones;
	private SimboloLexico identificadorClase;
	private Visibilidad acceso;
	
	public DeclaracionClaseErronea(Declaracion declaraciones, SimboloLexico identificadorClase,
			Visibilidad acceso) 
	{
		super(declaraciones, identificadorClase, acceso);
		this.declaraciones = declaraciones;
		this.identificadorClase = identificadorClase;
		this.acceso = acceso;
	}

	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("declaracionClaseErronea");
		raiz.add(acceso.getArbolVisual());
		raiz.add(new DefaultMutableTreeNode("nombre:"+identificadorClase.getLexema()));
		raiz.add(declaraciones.getArbolVisual());
		return raiz;
	}
	
	
}
