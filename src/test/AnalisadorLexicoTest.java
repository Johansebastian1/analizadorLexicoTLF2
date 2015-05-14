package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mundo.*;


public class AnalisadorLexicoTest {
	

	//variables
	public int filaActual ; 
	public int columnaActual;
	public int posicionActual;
	public boolean error;
	public AnalizadorLexico aux;
	public String codigoFuente;
	public char  caracterActual;
	public char num;


	ArrayList<SimboloLexico> tablaSimbolos = new ArrayList<SimboloLexico>();
	ArrayList<SimboloLexico> tablaErrores = new ArrayList<SimboloLexico>();
	static final char EOC=0;


	@Before
	public void setUp() throws Exception 
	{
		aux = new AnalizadorLexico(); 
		num = 0;
		
		aux.setTablaErrores(tablaErrores);
		aux.setTablaSimbolos(tablaSimbolos);

		filaActual=columnaActual=1;

		posicionActual=0;

	}
	@Test 
	public void testEntero() 
	{ 
		codigoFuente = "*123*";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esEntero()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testClase() 
	{ 
		codigoFuente = "-C-mateo";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esClase()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorRelacionalMenorQue() 
	{ 
		codigoFuente = "-=<";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorRelacionalMenorQue()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}

	@Test 
	public void testOperadorRelacionalMayorQue() 
	{ 
		codigoFuente = "+=>";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorRelacionalMayorQue()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorRelacionalIgualQue() 
	{ 
		codigoFuente = "-=-";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorRelacionalIgualQue()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorRelacionalDiferente() 
	{ 
		codigoFuente = "<=>";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorRelacionalDiferente()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorAsignacionMasIgual() 
	{ 
		codigoFuente = "++=";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorAsignacionMasIgual()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorAsignacionMenosIgual() 
	{ 
		codigoFuente = "--=";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorAsignacionMenosIgual()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorAsignacionPorIgual() 
	{ 
		codigoFuente = "**=";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorAsignacionPorIgual()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorAsignacionDivididoIgual() 
	{ 
		codigoFuente = "//=";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorAsignacionDivididoIgual()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testPalabraReservadaReturn() 
	{ 
		codigoFuente = "dev";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaReturn()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testPalabraReservadaClase() 
	{ 
		codigoFuente = "CLS";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaClase()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
//	@Test 
//	public void testPalabraReservadaPara() 
//	{ 
//		codigoFuente = "Fur";
//		caracterActual=codigoFuente.charAt(posicionActual);
//		aux.setCaracterActual(caracterActual);
//		aux.setCodigoFuente(codigoFuente+num);
//
//		try
//		{ 
//			Assert.assertTrue(aux.esPalabraReservadaPara()); 
//		} 
//		catch (Exception e) 
//		{ 
//			e.printStackTrace(); 
//		} 
//	}
	@Test 
	public void testPalabraReservadaImportar() 
	{ 
		codigoFuente = "bring";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaImportar()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testPalabraReservadaBreak() 
	{ 
		codigoFuente = "Par.t";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaBreak()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
//	@Test 
//	public void testPalabraReservadaMientras() 
//	{ 
//		codigoFuente = "_mien";
//		caracterActual=codigoFuente.charAt(posicionActual);
//		aux.setCaracterActual(caracterActual);
//		aux.setCodigoFuente(codigoFuente+num);
//
//		try
//		{ 
//			Assert.assertTrue(aux.esPalabraReservadaMientras()); 
//		} 
//		catch (Exception e) 
//		{ 
//			e.printStackTrace(); 
//		} 
//	}
	@Test 
	public void testCadenaDeCaracteres() 
	{ 
		codigoFuente = "$*mateo123*$";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esCadenaDeCaracteres()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testPalabraReservadaNUM() 
	{ 
		codigoFuente = "num";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaNUM()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testPalabraReservadaPaquete() 
	{ 
		codigoFuente = "Pack";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaPaquete()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testPalabraReservadaPublic() 
	{ 
		codigoFuente = "_Pub";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaPublic()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testPalabraReservadaPrivate() 
	{ 
		codigoFuente = "Priv";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaPrivate()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testPalabraReservadaReales() 
	{ 
		codigoFuente = "Frac";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esPalabraReservadaReales()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testMetodo() 
	{ 
		codigoFuente = "christian$";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esMetodo()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testVariable() 
	{ 
		codigoFuente = "-_123";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esVariable()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testResta() 
	{ 
		codigoFuente = "123-+123";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esSumaResta()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testSuma() 
	{ 
		codigoFuente = "123++123";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esSumaResta()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testMultiplicacion() 
	{ 
		codigoFuente = "123**123";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esMultDiv()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testDivision() 
	{ 
		codigoFuente = "123/*123";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esMultDiv()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testMayor() 
	{ 
		codigoFuente = "+>";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esMayor()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testMenor() 
	{ 
		codigoFuente = "-<";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esMenor()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorLogicoY() 
	{ 
		codigoFuente = "%&";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorLogicoY()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testOperadorLogicoO() 
	{ 
		codigoFuente = "%|";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esOperadorLogicoO()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testNegado() 
	{ 
		codigoFuente = "NG";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esNegado()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testParentesisApertura() 
	{ 
		codigoFuente = "((";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esParentesisApertura()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testParentesisCierre() 
	{ 
		codigoFuente = "))";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esParentesisCierre()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testLlavesApertura() 
	{ 
		codigoFuente = "{{";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esLlavesApertura()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testLlavesCierre() 
	{ 
		codigoFuente = "}}";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esLlavesCierre()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testTerminal() 
	{ 
		codigoFuente = ".,";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esTerminal()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testSeparador() 
	{ 
		codigoFuente = ",,";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esSeparador()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	@Test 
	public void testReal() 
	{ 
		codigoFuente = "*2342,242*";
		caracterActual=codigoFuente.charAt(posicionActual);
		aux.setCaracterActual(caracterActual);
		aux.setCodigoFuente(codigoFuente+num);

		try
		{ 
			Assert.assertTrue(aux.esReal()); 
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	
}
