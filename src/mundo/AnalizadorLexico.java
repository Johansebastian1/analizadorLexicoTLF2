package mundo;

import java.util.ArrayList;

public class AnalizadorLexico {

	//atributos
	int filaActual ; 
	int columnaActual;
	int posicionActual;
	char  caracterActual;


	public void setTablaSimbolos(ArrayList<SimboloLexico> tablaSimbolos) {
		this.tablaSimbolos = tablaSimbolos;
	}

	public void setTablaErrores(ArrayList<SimboloLexico> tablaErrores) {
		this.tablaErrores = tablaErrores;
	}

	public char getCaracterActual() {
		return caracterActual;
	}

	public void setCaracterActual(char caracterActual) {
		this.caracterActual = caracterActual;
	}

	String codigoFuente;

	ArrayList<SimboloLexico> tablaSimbolos;
	ArrayList<SimboloLexico> tablaErrores;

	//constante EOC para indicar fin del archivo
	static final char EOC=0;

	/* A este m�todo le ingresa como par�metro el c�digo Fuente
	 * su funci�n es llamar los diferentes m�todos que definen la clasificaci�n del token, el lexema
	 * y posici�n  
	 */
	public void analizar(String codigoFuente)
	{
		/*Inicializa la posici�n Fila y Columna en 1. Y la posici�n Actual que recorre
	      el c�digo en 0.*/
		filaActual=columnaActual=1;
		this.codigoFuente=codigoFuente;
		posicionActual=0;
		//Crea una tabla de s�mbolos y de errores de tipo ArrayList de S�mbolos L�xicos
		//para almacenar los simbolos l�xicos
		tablaSimbolos=new ArrayList<SimboloLexico>();
		//para almacenar los errores l�xicos
		tablaErrores=new ArrayList<SimboloLexico>();

		//si no se ha terminado el archivo
		if (codigoFuente.length()!=EOC) 
		{
			//extraigo el primer caracter del C�digo Fuente
			caracterActual = codigoFuente.charAt(posicionActual);
		}
		else
		{
			//a caracterActual le asigno EOC que indica la finalizaci�n del codigoFuente
			caracterActual=EOC;
		}	

		/*
		 * Mientras existan caracteres por analizar se van llamando diferentes m�todos
		 * predicados que definir�n el s�mbolo L�xico
		 */
		while (caracterActual!=EOC)
		{
			//van todos los m�todos predicado
			if(esCadenaDeCaracteres())
				continue;
			if (esEntero())
				continue;
			if(esReal())
				continue;
			if(esSaltoLinea())
				continue;
			if(esMetodo())
				continue;
			if(esVariable())
				continue;
			if(esSumaResta())
				continue;
			if(esMultDiv())
				continue;
			if(esClase())
				continue;
			if (esPalabraReservadaNUM())
				continue;
			if (esPalabraReservadaReales())
				continue;
			//			if (esPalabraReservadaPara())
			//				continue;
			//			if (esPalabraReservadaMientras())
			//				continue;
			if (esPalabraReservadaPrivate())
				continue;
			if (esPalabraReservadaPublic())
				continue;
			if (esPalabraReservadaPaquete())
				continue;			
			if (esPalabraReservadaImportar())
				continue;
			if (esPalabraReservadaClase())
				continue;
			if (esPalabraReservadaReturn())
				continue;
			if (esPalabraReservadaBreak())
				continue;
			if (esOperadorRelacionalMenorQue())
				continue;
			if (esOperadorRelacionalMayorQue())
				continue;
			if (esOperadorRelacionalIgualQue())
				continue;
			if (esOperadorRelacionalDiferente())
				continue;
			if (esOperadorAsignacionMasIgual())
				continue;
			if (esOperadorAsignacionMenosIgual())
				continue;
			if (esOperadorAsignacionPorIgual())
				continue;
			if (esOperadorAsignacionDivididoIgual())
				continue;
			if(esSaltoLinea())
				continue;
			if(esMayor())
				continue;
			if(esMenor())
				continue;
			if(esOperadorLogicoY())
				continue;
			if(esOperadorLogicoO())
				continue;
			if(esNegado())
				continue;
			if(esParentesisApertura())
				continue;
			if(esParentesisCierre())
				continue;
			if(esLlavesApertura())
				continue;
			if(esLlavesCierre())
				continue;
			if(esTerminal())
				continue;
			if(esSeparador())
				continue;
			if(esImprimir())
				continue;
			if(esEspacio())
				continue;
			//			if(esCadenaDeCaracter())
			//				continue;

			//si no pertenece a nuestro lenguaje lo almacena como un s�mbolo no identificado
			almacenarToken(""+caracterActual,"DESCONOCIDO",filaActual,columnaActual);
			sigteCaracter();
		}
	}


	/*
	 * Este m�todo esEntero() define si el s�mbolo l�xico es un Entero y returna FALSE o TRUE	
	 */

	//cacha


	private boolean esEspacio() {

		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual==' ')
		{

		
			sigteCaracter();
			
			return true;

		}
		
		return false;
	}

	/*
	 * Este m�todo esClase() define si el s�mbolo l�xico es una clase y retorna FALSE o TRUE	
	 */
	public boolean esClase()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es una clase. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='-')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='C'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='-'){
					lexema += caracterActual;
					sigteCaracter();
					// Si el d�gito NO es letra retorna FALSE
					if(!Character.isLetter(caracterActual))
					{
						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;  
					}
					//se almacena el caracterActual en la cadena lexema
					//			lexema = caracterActual + "";
					lexema += caracterActual;
					//si el caracter actual es una letra, entonces llama al siguiente caracter
					if(Character.isLetter((caracterActual)))
						sigteCaracter();

					//Mientras el caracter sea una letra, adiciona al lexema ese caracter y sigue revisando
					//el siguiente caracter.
					while (Character.isLetter (caracterActual))
					{   

						lexema += caracterActual;
						//Avanza al siguiente caracter sobre el codigo fuente 
						sigteCaracter();	
					}

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es una letra, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a Clase
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es una clase entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"clase",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esOperadorRelacionalMenorQue() define si el s�mbolo l�xico es el
	 * operador relacional menor que y retorna FALSE o TRUE	
	 */
	public boolean esOperadorRelacionalMenorQue()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador relacional menor que. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='-')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='='){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='<'){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es un operador, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es el operador relacional menor que, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Menor que",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esOperadorRelacionalMayorQue() define si el s�mbolo l�xico es 
	 *el operador relacional mayor que y retorna FALSE o TRUE	
	 */
	public boolean esOperadorRelacionalMayorQue()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador relacional mayor que. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='+')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='='){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='>'){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador relacional mayor que, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es el operador relacional mayor que, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Mayor que",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esOperadorRelacionalIgualQue() define si el s�mbolo l�xico es 
	 * el operador relacional igual que y retorna FALSE o TRUE	
	 */
	public boolean esOperadorRelacionalIgualQue()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador relacional igual que. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='-')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='='){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='-'){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador relacional igual que, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es el operador relacional igual que, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Igual que",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esOperadorRelacionalDiferente() define si el s�mbolo l�xico es 
	 * el operador relacional diferente que y retorna FALSE o TRUE	
	 */
	public boolean esOperadorRelacionalDiferente()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador relacional diferente. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='<')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='='){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='>'){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador relacional diferente, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es el operador relacional diferente, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Diferente",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/*
	 * Este m�todo esOperadorAsignacionMasIgual() define si el s�mbolo l�xico es 
	 * el operador de asignacion mas igual y retorna FALSE o TRUE	
	 */
	public boolean esOperadorAsignacionMasIgual()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion mas igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='+')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='+'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='='){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion mas igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es el operador de asignacion mas igual, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Mas igual",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esOperadorAsignacionMenosIgual() define si el s�mbolo l�xico es 
	 * el operador de asignacion menos igual y retorna FALSE o TRUE	
	 */
	public boolean esOperadorAsignacionMenosIgual()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion menos igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='-')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='-'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='='){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion menos igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es el operador de asignacion menos igual, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Menos igual",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esOperadorAsignacionPorIgual() define si el s�mbolo l�xico es 
	 * el operador de asignacion por igual y retorna FALSE o TRUE	
	 */
	public boolean esOperadorAsignacionPorIgual()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion por igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='*')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='*'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='='){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion por igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es el operador de asignacion por igual, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Por igual",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/*
	 * Este m�todo esOperadorAsignacionDivididoIgual() define si el s�mbolo l�xico es 
	 * el operador de asignacion dividido igual y retorna FALSE o TRUE	
	 */
	public boolean esOperadorAsignacionDivididoIgual()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='/')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='/'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='='){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es el operador de asignacion dividido igual, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Dividido igual",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esPalabraReservadaReturn() define si el s�mbolo l�xico es 
	 * la palabra reservada return y retorna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaReturn()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si la palabra reservada return. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='d')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='e'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='v'){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada return, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es la palabra reservada return, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Return",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/*
	 * Este m�todo esPalabraReservadaClase() define si el s�mbolo l�xico es 
	 *la palabra reservada clase y returna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaClase()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es la palabra reservada clase. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='C')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='L'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='S'){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada clase, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es la palabra reservada clase, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Clase",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	//	/*
	//	 * Este m�todo esPalabraReservadaPara() define si el s�mbolo l�xico es 
	//	 * la palabra reservada para y returna FALSE o TRUE	
	//	 */
	//	public boolean esPalabraReservadaPara()
	//	{
	//		/*
	//		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
	//		 *  para definir si es la palabra reservada para. En caso de no serlo, debe iniciar el recorrido en 
	//		 *  esta posici�n para continuar con otro m�todo Predicado
	//		 */
	//		//posicionParaBactraking = posicionActual;
	//		int posicionParaBactraking = posicionActual;
	//		// posicion para guardar los lexemas en la tabla de s�mbolos
	//		int filaIniToken = filaActual; 
	//		int columnaInicialToken = columnaActual;
	//		if(caracterActual=='F')
	//		{
	//			//se almacena el caracterActual en la cadena lexema
	//			String lexema = caracterActual + "";
	//			sigteCaracter();
	//
	//			if(caracterActual=='u'){
	//
	//				lexema += caracterActual;
	//				sigteCaracter();
	//
	//				if(caracterActual=='r'){
	//					lexema += caracterActual;
	//
	//					/*
	//						Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada para, por lo tanto
	//						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
	//						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
	//						y retorna FALSO a ENTERO
	//					 */
	//					if((caracterActual==',')||(Character.isDigit(caracterActual)))
	//					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//					return false;
	//					}
	//					/*
	//					 * Es la palabra reservada para, entonces almacena el s�mbolo l�xico
	//					 */
	//					else
	//					{	
	//						almacenarToken(lexema,"p.r Para",filaIniToken,columnaInicialToken);
	//						sigteCaracter();
	//						return true;
	//					}
	//				}
	//				else
	//				{
	//					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//					return false;
	//				}
	//			}
	//			else
	//			{
	//				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//				return false;
	//			}
	//
	//		}
	//		else
	//		{
	//			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//			return false;
	//		}
	//	}
	/*
	 * Este m�todo esPalabraReservadaImportar() define si el s�mbolo l�xico es 
	 * la palabra reservada importar y returna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaImportar()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es la palabra reservada importar. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='b')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='r'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='i'){
					lexema += caracterActual;
					sigteCaracter();

					if(caracterActual=='n'){
						lexema += caracterActual;
						sigteCaracter();

						if(caracterActual=='g'){
							lexema += caracterActual;
							/*
							Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada importar, por lo tanto
							debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
							ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
							y retorna FALSO a ENTERO
							 */
							if((caracterActual==',')||(Character.isDigit(caracterActual)))
							{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
							}
							/*
							 * Es la palabra reservada importar, entonces almacena el s�mbolo l�xico
							 */
							else
							{	
								almacenarToken(lexema,"p.r Importar",filaIniToken,columnaInicialToken);
								sigteCaracter();
								return true;
							}
						}
						else{
							bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
						}
					}
					else{

						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esPalabraReservadaBreak() define si el s�mbolo l�xico es 
	 * la palabra reservada break y returna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaBreak()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es la palabra reservada break. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='P')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='a'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='r'){
					lexema += caracterActual;
					sigteCaracter();

					if(caracterActual=='.'){
						lexema += caracterActual;
						sigteCaracter();

						if(caracterActual=='t'){
							lexema += caracterActual;
							/*
							Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada break, por lo tanto
							debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
							ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
							y retorna FALSO a ENTERO
							 */
							if((caracterActual==',')||(Character.isDigit(caracterActual)))
							{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
							}
							/*
							 * Es la palabra reservada break, entonces almacena el s�mbolo l�xico
							 */
							else
							{	
								almacenarToken(lexema,"p.r Break",filaIniToken,columnaInicialToken);
								sigteCaracter();
								return true;
							}
						}
						else{
							bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
						}
					}
					else{

						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esPalabraReservadaMientras() define si el s�mbolo l�xico es 
	 * la palabra reservada mientras y returna FALSE o TRUE	
	 */
	//	public boolean esPalabraReservadaMientras()
	//	{
	//		/*
	//		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
	//		 *  para definir si es la palabra reservada mientras. En caso de no serlo, debe iniciar el recorrido en 
	//		 *  esta posici�n para continuar con otro m�todo Predicado
	//		 */
	//		//posicionParaBactraking = posicionActual;
	//		int posicionParaBactraking = posicionActual;
	//		// posicion para guardar los lexemas en la tabla de s�mbolos
	//		int filaIniToken = filaActual; 
	//		int columnaInicialToken = columnaActual;
	//		if(caracterActual=='_')
	//		{
	//			//se almacena el caracterActual en la cadena lexema
	//			String lexema = caracterActual + "";
	//			sigteCaracter();
	//
	//			if(caracterActual=='m'){
	//
	//				lexema += caracterActual;
	//				sigteCaracter();
	//
	//				if(caracterActual=='i'){
	//					lexema += caracterActual;
	//					sigteCaracter();
	//
	//					if(caracterActual=='e'){
	//						lexema += caracterActual;
	//						sigteCaracter();
	//
	//						if(caracterActual=='n'){
	//							lexema += caracterActual;
	//							/*
	//							Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada mientras, por lo tanto
	//							debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
	//							ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
	//							y retorna FALSO a ENTERO
	//							 */
	//							if((caracterActual==',')||(Character.isDigit(caracterActual)))
	//							{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//							return false;
	//							}
	//							/*
	//							 * Es la palabra reservada mientras, entonces almacena el s�mbolo l�xico
	//							 */
	//							else
	//							{	
	//								almacenarToken(lexema,"p.r Mientras",filaIniToken,columnaInicialToken);
	//								sigteCaracter();
	//								return true;
	//							}
	//						}
	//						else{
	//							bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//							return false;
	//						}
	//					}
	//					else{
	//
	//						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//						return false;
	//					}
	//				}
	//				else
	//				{
	//					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//					return false;
	//				}
	//			}
	//			else
	//			{
	//				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//				return false;
	//			}
	//
	//		}
	//		else
	//		{
	//			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
	//			return false;
	//		}
	//	}
	/*
	 * Este m�todo esPalabraReservadaNUM() define si el s�mbolo l�xico es 
	 * la palabra reservada num y returna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaNUM()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es la palabra reservada num. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='n')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='u'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='m'){
					lexema += caracterActual;

					/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada num, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
					 */
					if((caracterActual==',')||(Character.isDigit(caracterActual)))
					{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
					}
					/*
					 * Es la palabra reservada num, entonces almacena el s�mbolo l�xico
					 */
					else
					{	
						almacenarToken(lexema,"p.r Entero",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esPalabraReservadaPaquete() define si el s�mbolo l�xico es 
	 * la palabra reservada paquete y returna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaPaquete()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es la palabra reservada paquete. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='P')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='a'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='c'){
					lexema += caracterActual;
					sigteCaracter();

					if(caracterActual=='k'){
						lexema += caracterActual;

						/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada paquete, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
						 */
						if((caracterActual==',')||(Character.isDigit(caracterActual)))
						{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
						}
						/*
						 * Es la palabra reservada paquete, entonces almacena el s�mbolo l�xico
						 */
						else
						{	
							almacenarToken(lexema,"p.r Paquete",filaIniToken,columnaInicialToken);
							sigteCaracter();
							return true;
						}
					}
					else{

						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esPalabraReservadaPublic() define si el s�mbolo l�xico es 
	 * la palabra reservada public y returna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaPublic()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es la palabra reservada public. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='_')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='P'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='u'){
					lexema += caracterActual;
					sigteCaracter();

					if(caracterActual=='b'){
						lexema += caracterActual;

						/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada public, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
						 */
						if((caracterActual==',')||(Character.isDigit(caracterActual)))
						{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
						}
						/*
						 * Es la palabra reservada public, entonces almacena el s�mbolo l�xico
						 */
						else
						{	
							almacenarToken(lexema,"p.r Public",filaIniToken,columnaInicialToken);
							sigteCaracter();
							return true;
						}
					}
					else{

						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esPalabraReservadaPrivate() define si el s�mbolo l�xico es 
	 * la palabra reservada private y returna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaPrivate()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es la palabra reservada private. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='P')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='r'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='i'){
					lexema += caracterActual;
					sigteCaracter();

					if(caracterActual=='v'){
						lexema += caracterActual;

						/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada private, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
						 */
						if((caracterActual==',')||(Character.isDigit(caracterActual)))
						{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
						}
						/*
						 * Es la palabra reservada private, entonces almacena el s�mbolo l�xico
						 */
						else
						{	
							almacenarToken(lexema,"p.r Private",filaIniToken,columnaInicialToken);
							sigteCaracter();
							return true;
						}
					}
					else{

						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esPalabraReservadaReales() define si el s�mbolo l�xico es 
	 * la palabra reservada reales y returna FALSE o TRUE	
	 */
	public boolean esPalabraReservadaReales()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es la palabra reservada reales. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='F')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='r'){

				lexema += caracterActual;
				sigteCaracter();

				if(caracterActual=='a'){
					lexema += caracterActual;
					sigteCaracter();

					if(caracterActual=='c'){
						lexema += caracterActual;

						/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es la palabra reservada reales, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
						 */
						if((caracterActual==',')||(Character.isDigit(caracterActual)))
						{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
						}
						/*
						 * Es la palabra reservada reales, entonces almacena el s�mbolo l�xico
						 */
						else
						{	
							almacenarToken(lexema,"p.r Real",filaIniToken,columnaInicialToken);
							sigteCaracter();
							return true;
						}
					}
					else{

						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	//mateo

	/*
	 * Este m�todo esEntero() define si el s�mbolo l�xico es 
	 * la palabra es entero y returna FALSE o TRUE	
	 */
	public boolean esEntero()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es un entero. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		if(caracterActual=='*')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();
			// Si el d�gito NO es entero retorna FALSE
			if(!Character.isDigit(caracterActual))
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;  
			}
			//se almacena el caracterActual en la cadena lexema
			//			lexema = caracterActual + "";
			lexema += caracterActual;
			//si el caracter actual es un D�gito, entonces llama al siguiente caracter
			if(Character.isDigit((caracterActual)))
			{
				sigteCaracter();
			}
			//Mientras el caracter sea un d�gito, adiciona al lexema ese caracter y sigue revisando
			//el siguiente caracter.

			while (caracterActual!='*' && Character.isDigit (caracterActual))
			{   

				lexema += caracterActual;
				//Avanza al siguiente caracter sobre el codigo fuente 
				sigteCaracter();	
			}
			if(caracterActual=='*')
			{
				lexema += caracterActual;
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

			/*
				Si el caracterActual en una coma (,) entonces el token NO es un entero, por lo tanto
				debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
				ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
				y retorna FALSO a ENTERO
			 */
			if(caracterActual==','||Character.isLetter(caracterActual))
			{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
			}
			/*
			 * Es un ENTERO entonces almacena el s�mbolo l�xico
			 */
			else
			{	
				almacenarToken(lexema,"entero",filaIniToken,columnaInicialToken);
				sigteCaracter();
				return true;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

	}

	/*
	 * Este m�todo esReal() define si el s�mbolo l�xico es 
	 * palabra es entero y returna FALSE o TRUE	
	 */
	public boolean esReal()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es un entero. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		//garantiza que el primer caracter sea un asterisco (*)
		if(caracterActual=='*')
		{
			String lexema = caracterActual + "";//guarda el caracter actual
			sigteCaracter();//Avanza al siguiente caracter sobre el codigo fuente 

			//garantiza que el siguiente caracter a el asterisco (*) sea un numero
			if(!(Character.isDigit (caracterActual)))
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
			else
			{
				//sertifica que lo que se encuentre sean numeros
				while (Character.isDigit (caracterActual))
				{   

					lexema += caracterActual;//guarda el caracter actual

					sigteCaracter();//Avanza al siguiente caracter sobre el codigo fuente 

				}
				//despues de los numeros se tiene que encontrar una coma
				if(caracterActual==',')
				{
					lexema += caracterActual;//guarda el caracter actual

					sigteCaracter();//Avanza al siguiente caracter sobre el codigo fuente 

					//garantiza que el siguiente caracter a el asterisco (*) sea un numero
					if(!(Character.isDigit (caracterActual)))
					{
						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
					}
					else
					{
						//sertifica que lo que se encuentre sean numeros
						while (Character.isDigit (caracterActual))
						{   

							lexema += caracterActual;//guarda el caracter actual
							//Avanza al siguiente caracter sobre el codigo fuente 
							sigteCaracter();

						}
						//el ultimo digito tiene que ser un asterisco (*)
						if(caracterActual=='*')
						{
							lexema += caracterActual;//guarda el caracter actual
							almacenarToken(lexema,"Reales",filaIniToken,columnaInicialToken);
							sigteCaracter();//Avanza al siguiente caracter sobre el codigo fuente 
							return true;
						}
						else
						{
							bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
						}
					}

				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

	}


	/*
	 * Este m�todo esCadenaDeCaracteres() define si el s�mbolo l�xico es 
	 * palabra es Cadena De Caracteres y returna FALSE o TRUE	 
	 */
	public boolean esCadenaDeCaracteres()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es un entero. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		if(caracterActual == '$')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();
			if(caracterActual == '*')
			{
				lexema += caracterActual;
				//Avanza al siguiente caracter sobre el codigo fuente 
				sigteCaracter();

				while(Character.isLetter(caracterActual) || Character.isDigit(caracterActual))
				{
					lexema += caracterActual;
					//Avanza al siguiente caracter sobre el codigo fuente 
					sigteCaracter();
				}
				if(caracterActual == '*')
				{
					lexema += caracterActual;
					//Avanza al siguiente caracter sobre el codigo fuente 
					sigteCaracter();

					if(caracterActual == '$')
					{
						lexema += caracterActual;

						almacenarToken(lexema,"Cadena de caracteres",filaIniToken,columnaInicialToken);
						sigteCaracter();
						return true;
					}
					else
					{
						bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
						return false;
					}
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * 
	 */
	public boolean esMetodo()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es un entero. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		//
		if(Character.isLetter(caracterActual))
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			while (Character.isLetter(caracterActual))
			{   

				lexema += caracterActual;
				//Avanza al siguiente caracter sobre el codigo fuente 
				sigteCaracter();	
			}

			if(caracterActual != '$')
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
			else
			{
				almacenarToken(lexema,"Metodo",filaIniToken,columnaInicialToken);
				sigteCaracter();
				return true;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

	}
	public boolean esVariable()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es un entero. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;



		if(caracterActual == '-')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual == '_')
			{
				//se almacena el caracterActual en la cadena lexema
				lexema += caracterActual;
				sigteCaracter();
				while (Character.isLetter(caracterActual))
				{   

					lexema += caracterActual;
					//Avanza al siguiente caracter sobre el codigo fuente 
					sigteCaracter();	
				}
				if(caracterActual != ' ' || caracterActual != ',' || caracterActual != '\n' )
				{
					almacenarToken(lexema,"Variable",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}

			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

		}


		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

	}

	public boolean esSumaResta()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es un entero. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		//se almacena el caracterActual en la cadena lexema


			if(caracterActual == '-')
			{
				String lexema = caracterActual+"";
				//Avanza al siguiente caracter sobre el codigo fuente 
				sigteCaracter();	

				if(caracterActual == '+')
				{
					lexema += caracterActual;
					//Avanza al siguiente caracter sobre el codigo fuente 
					sigteCaracter();	

	

						if(caracterActual != ' ' || caracterActual != ',' || caracterActual != '\n' || !(Character.isLetter(caracterActual)))
						{
							almacenarToken(lexema,"Resta",filaIniToken,columnaInicialToken);

							return true;
						}
						else
						{
							bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
						}
	
				}

				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			if(caracterActual == '+')
			{
				String lexema = caracterActual+"";
				//Avanza al siguiente caracter sobre el codigo fuente 
				sigteCaracter();	

				if(caracterActual == '+')
				{
					lexema += caracterActual;
					//Avanza al siguiente caracter sobre el codigo fuente 
					sigteCaracter();	


						if(caracterActual != ' ' || caracterActual != ',' || caracterActual != '\n' || !(Character.isLetter(caracterActual)))
						{
							almacenarToken(lexema,"Suma",filaIniToken,columnaInicialToken);

							return true;
						}
						else
						{
							bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
						}

				}

				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

	}
	public boolean esMultDiv()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es un entero. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		//se almacena el caracterActual en la cadena lexema




			if(caracterActual == '*')
			{
				String lexema = caracterActual+"";
				//Avanza al siguiente caracter sobre el codigo fuente 
				sigteCaracter();	

				if(caracterActual == '*')
				{
					lexema += caracterActual;
					//Avanza al siguiente caracter sobre el codigo fuente 
					sigteCaracter();	

						if(caracterActual != ' ' || caracterActual != ',' || caracterActual != '\n' || !(Character.isLetter(caracterActual)))
						{
							almacenarToken(lexema,"Multiplicacion",filaIniToken,columnaInicialToken);

							return true;
						}
						else
						{
							bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
						}
	
				}

				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			if(caracterActual == '/')
			{
				String lexema = caracterActual+"";
				//Avanza al siguiente caracter sobre el codigo fuente 
				sigteCaracter();	

				if(caracterActual == '*')
				{
					lexema += caracterActual;
					//Avanza al siguiente caracter sobre el codigo fuente 
					sigteCaracter();	


						if(caracterActual != ' ' || caracterActual != ',' || caracterActual != '\n' || !(Character.isLetter(caracterActual)))
						{
							almacenarToken(lexema,"Division",filaIniToken,columnaInicialToken);

							return true;
						}
						else
						{
							bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
							return false;
						}
	
				}

				else
				{
					bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
					return false;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}


	}
	public boolean esMayor()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='+')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='>'){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es el operador de relacion Mayor, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"Mayor",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esMenor() define si el s�mbolo l�xico es 
	 * menor y returna FALSE o TRUE	
	 */
	public boolean esMenor()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='-')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='<'){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es el operador de relacional Menor, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"Menor",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/*
	 * Este m�todo esOperadorLogicoY() define si el s�mbolo l�xico es 
	 * un operador logico "Y" y returna FALSE o TRUE	
	 */
	public boolean esOperadorLogicoY()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='%')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='&'){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es el operador logico Y, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"O. Logico Y",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esOperadorLogicoO() define si el s�mbolo l�xico es 
	 * un operador logico "O" y returna FALSE o TRUE	
	 */
	public boolean esOperadorLogicoO()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='%')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='|'){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es el operador logico o, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"O. Logico O",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esNegado() define si el s�mbolo l�xico es 
	 * un operador logico "Negado" y returna FALSE o TRUE	
	 */
	public boolean esNegado()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='N')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='G'){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es el operador logico negado, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"O.L.Negado",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/*
	 * Este m�todo esParentesisApertura() define si el s�mbolo l�xico es 
	 * un parentecis de apertura "((" y returna FALSE o TRUE	
	 */
	public boolean esParentesisApertura()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='(')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='('){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es parentesis apertura, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"P. apertura",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/**
	 * Este m�todo esParentesisCierre define si el s�mbolo l�xico es 
	 * un parentecis de cierre "))" y returna FALSE o TRUE	
	 */
	public boolean esParentesisCierre()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual==')')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual==')'){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es parentesis cierre, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"P. Cierre",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 * Este m�todo LlavesApertura define si el s�mbolo l�xico es 
	 * una llave de apertura "{{" y returna FALSE o TRUE	
	 */
	public boolean esLlavesApertura()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='{')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='{'){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es llaves apertura, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"L. Apertura",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/**
	 * Este m�todo LlavesApertura define si el s�mbolo l�xico es 
	 * una llave de cierre "}}" y returna FALSE o TRUE	
	 */
	public boolean esLlavesCierre()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='}')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual=='}'){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((caracterActual==',')||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es llaves de cierre, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"L. Cierre",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}
	/**
	 * Este m�todo esTerminal() define si el s�mbolo l�xico es 
	 * un terminal y returna FALSE o TRUE	
	 */
	public boolean esTerminal()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual=='.')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual==','){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((Character.isLetter(caracterActual))||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es Terminal, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"Terminal",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 * Este m�todo esSeparador() define si el s�mbolo l�xico es 
	 * un separador y returna FALSE o TRUE	
	 */
	public boolean esSeparador()
	{
		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es el operador de asignacion dividido igual. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		if(caracterActual==',')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();

			if(caracterActual==','){

				lexema += caracterActual;



				/*
						Si el caracterActual en una coma (,) o un numero, entonces el token NO es el operador de asignacion dividido igual, por lo tanto
						debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
						ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
						y retorna FALSO a ENTERO
				 */
				if((Character.isLetter(caracterActual))||(Character.isDigit(caracterActual)))
				{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
				}
				/*
				 * Es separador, entonces almacena el s�mbolo l�xico
				 */
				else
				{	
					almacenarToken(lexema,"Separador",filaIniToken,columnaInicialToken);
					sigteCaracter();
					return true;
				}
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}
		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 * Reconoce salto de l�nea
	 */
	private boolean esSaltoLinea()
	{
		if(caracterActual=='\n')
		{	sigteCaracter();
		return true;
		}
		return false;
	}

	private boolean esImprimir() {

		/*
		 * Se almacena la pocisi�n Actual en posicionParaBactraking en que inicia el recorrido
		 *  para definir si es un entero. En caso de no serlo, debe iniciar el recorrido en 
		 *  esta posici�n para continuar con otro m�todo Predicado
		 */
		//posicionParaBactraking = posicionActual;
		int posicionParaBactraking = posicionActual;
		// posicion para guardar los lexemas en la tabla de s�mbolos
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		
		
		if(caracterActual=='i')
		{
			//se almacena el caracterActual en la cadena lexema
			String lexema = caracterActual + "";
			sigteCaracter();
			
			if(caracterActual=='m')
			{
				//se almacena el caracterActual en la cadena lexema
				lexema += caracterActual;
				sigteCaracter();
				
				if(caracterActual=='p')
				{
					//se almacena el caracterActual en la cadena lexema
					lexema += caracterActual;
					sigteCaracter();
					
					if(caracterActual=='(')
					{
						//se almacena el caracterActual en la cadena lexema
						lexema += caracterActual;
						sigteCaracter();
	
//						//si el caracter actual es un D�gito, entonces llama al siguiente caracter
//						if(Character.isDigit((caracterActual)))
//						{
//							sigteCaracter();
//						}
						//Mientras el caracter sea un d�gito, adiciona al lexema ese caracter y sigue revisando
						//el siguiente caracter.

						while (caracterActual!=')' && (Character.isDigit (caracterActual) || (Character.isLetter(caracterActual))))
						{   

							lexema += caracterActual;
							//Avanza al siguiente caracter sobre el codigo fuente 
							sigteCaracter();	
							
						}
					}
					
				}
			
			}

			if(caracterActual==')')
			{
				lexema += caracterActual;
			}
			else
			{
				bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
				return false;
			}

			/*
				Si el caracterActual en una coma (,) entonces el token NO es un entero, por lo tanto
				debemos reiniciar la b�squeda en el c�digo fuente. Se llama el metodo backtracking()
				ingresandole como par�metros (posicionParaBactraking, filaIniToken, columnaInicialToken)
				y retorna FALSO a ENTERO
			 */
			if(caracterActual==',')
			{	bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
			}
			/*
			 * Es un ENTERO entonces almacena el s�mbolo l�xico
			 */
			else
			{	
				almacenarToken(lexema,"Imprimir",filaIniToken,columnaInicialToken);
				sigteCaracter();
				return true;
			}

		}
		else
		{
			bactracking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

	}

	/*
	 * El m�todo bactracking se encarga de reiniciar la posicionActual, caracterActual,
	 * columnaActual,filaActual para comenzar de nuevo la b�squeda en el c�digo Fuente de un
	 * nuevo lexema
	 */
	private void bactracking(int posicionParaBactraking, int filaInicialToken, int columnaInicialToken) 
	{
		posicionActual=posicionParaBactraking;
		caracterActual=codigoFuente.charAt(posicionActual);

		columnaActual=columnaInicialToken;
		filaActual=filaInicialToken;

	}

	/*
	 * El metodo sigteCaracter() se encarga de adelantar una posici�n en el c�digo Fuente
	 */
	private void sigteCaracter()
	{    //Si el caracter le�do el igual a la EOC terminaci�n del archivo, entonces a
		//caracterActual le asigna EOC
		if(codigoFuente.charAt(posicionActual+1)==EOC)
		{
			caracterActual=EOC;
		}
		else
		{   //Si el caracter le�do del c�digoFuente es un Salto de L�nea '\n' entonces incrementa
			//la fila e inicializa la columnaActual en 0
			if(codigoFuente.charAt(posicionActual+1)=='\n')
			{
				filaActual++;
				columnaActual=0;
			}
			else 
				//Si el caracter le�do del c�digoFuente es un tabulador '\t' entonces incrementa
				//la fila e inicializa la columnaActual en 4
				if(codigoFuente.charAt(posicionActual+1)=='\t')
					columnaActual+=4;
				else
					columnaActual++;

			posicionActual++;
			caracterActual=codigoFuente.charAt(posicionActual);
		}
	}

	/*
	 * El m�todo almacenarToken() recibe como par�metros (lexema, token, filaInicial, columnaInicial)
	 * y almacena en la tabla de s�mbolos l�xicos el nuevo s�mboloLexico
	 */
	private void almacenarToken(String lexema, String token, int filaInicial, int columnaInicial) 
	{
		SimboloLexico auxiliar = new SimboloLexico(lexema, token, filaInicial, columnaInicial);
		tablaSimbolos.add(auxiliar);
	}

	/*
	 * El m�todo almacenarError() recibe como par�metros (lexema, error, filaInicial, columnaInicial)
	 * y almacena en la tabla de s�mbolos de errores el nuevo error
	 */
	private void almacenarError(String lexema, String error, int filaInicial, int columnaInicial)
	{
		SimboloLexico auxiliar = new SimboloLexico(lexema, error, filaInicial, columnaInicial);
		tablaErrores.add(auxiliar);

	}

	/*
	 * El m�todo getTablaSimbolos() retorna el arreglo de s�mbolos l�xicos encontrados en el c�digo Fuente
	 */
	public ArrayList<SimboloLexico> getTablaSimbolos() {
		return tablaSimbolos;
	}

	public String getCodigoFuente() {
		return codigoFuente;
	}

	public void setCodigoFuente(String codigoFuente) {
		this.codigoFuente = codigoFuente;
	}

	/*
	 * El m�todo getTablaErrores() retorna la tabla de errores encontrados en el c�digo Fuente
	 */
	public ArrayList<SimboloLexico> getTablaErrores() {
		return tablaErrores;
	}





}
