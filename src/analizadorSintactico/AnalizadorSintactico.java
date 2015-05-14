package analizadorSintactico;

import java.util.ArrayList;

import mundo.SimboloLexico;
import categoriaSintactica.BloqueImportaciones;
import categoriaSintactica.BloquePaquetes;
import categoriaSintactica.BloqueSentencias;
import categoriaSintactica.Dato;
import categoriaSintactica.Datos;
import categoriaSintactica.Declaracion;
import categoriaSintactica.DeclaracionClase;
import categoriaSintactica.DeclaracionFuncion;
import categoriaSintactica.DeclaracionFunciones;
import categoriaSintactica.DeclaracionVariable;
import categoriaSintactica.DeclaracionVariables;
import categoriaSintactica.Expresion;
import categoriaSintactica.ExpresionAritmetica;
import categoriaSintactica.Factor;
import categoriaSintactica.Importacion;
import categoriaSintactica.Imprimir;
import categoriaSintactica.InstanciaAsignacion;
import categoriaSintactica.InvocacionFuncion;
import categoriaSintactica.Paquete;
import categoriaSintactica.Parametro;
import categoriaSintactica.Parametros;
import categoriaSintactica.Retorno;
import categoriaSintactica.Sentencia;
import categoriaSintactica.Termino;
import categoriaSintactica.TipoDato;
import categoriaSintactica.UnidadCompilacion;
import categoriaSintactica.Variable;
import categoriaSintactica.Visibilidad;

public class AnalizadorSintactico {
	

	public ArrayList<SimboloLexico> getSimbolosLexicos() {
		return simbolosLexicos;
	}



	public void setSimbolosLexicos(ArrayList<SimboloLexico> simbolosLexicos) {
		this.simbolosLexicos = simbolosLexicos;
	}

	/**
	 * Colección de los simbolos lexicos encontrados en el codigo
	 */
	private ArrayList<SimboloLexico> simbolosLexicos;

	/**
	 * Atributo que contendra el token que se esta revisando
	 */
	private SimboloLexico tokenActual;

	/**
	 * Atributo que representa la posicion de revisión
	 */
	private int indice;

	/**
	 * Unidad de compilación con todas las categorias sintacticas
	 */
	private UnidadCompilacion unidadDeCompilacion;

	/**
	 * Listado de todos los errores contenidos
	 */
	private ArrayList<ErrorSintactico> listaErrores;
	
	int cont=0;
		
		/* A este método le ingresa como parámetro el código Fuente
		 * su función es llamar los diferentes métodos que definen la clasificación del token, el lexema
		 * y posición  
		 */
		public AnalizadorSintactico(ArrayList<SimboloLexico> tablaSimbolos)
		{			
			this.simbolosLexicos = tablaSimbolos;
			listaErrores=new ArrayList<>();
			this.indice = 0;
			this.tokenActual = simbolosLexicos.get(indice);
			this.unidadDeCompilacion = esUnidadCompilacion();	

		}
		/**
		 * funcion que cambia el indice hasta la posicion indicada, de igual modo busca el token asociado a esa posicioón
		 * @param pos, La posición hacia donde se movio el indice
		 */
		public void bactracking(int pos)
		{
			indice=pos;
			tokenActual=simbolosLexicos.get(indice);
		}
		
		/**
		 * funcion que cambia el tokenActual
		 */
		public void darSiguienteToken()
		{
			if(indice == simbolosLexicos.size()-1)
			{
				return;
			}
			else
			{
				indice++;
				tokenActual=simbolosLexicos.get(indice);
			}
		}

		
		/**
		 * @param lexema
		 * @param msgError
		 */
		public void modoPanico(int indice)
		{
			while(true)
			{
				if(tokenActual.getLexema().equals(".,") || tokenActual.getLexema().equals("}}"))
				break;
				else darSiguienteToken();	
			}
			
		}
		
		/**
		 * @param lexema
		 * @param msgError
		 */
		public void modoPanico2(String lexema ,String msgError)
		{
			int num=0;
			SimboloLexico aux=tokenActual;
			while(true)
			{
				if(tokenActual.getLexema().equals("_/"))
				{
					num++;
				}
				else if(tokenActual.getLexema().equals("_\\"))
				{
					num--;
				}
				darSiguienteToken();
				if(tokenActual.getLexema().equals(lexema) && num==0)
				{
					break;
				}
			}
			reportarError(msgError, aux.getFila(), aux.getColumna());
		}

		
		/**
		 * funcion que crea una lista de paquetes
		 * @BNF <BloquePaquetes> ::= <Paquete>[<BloquePaquetes>] 
		 * @return, Los paquetes creados
		 */
		public BloquePaquetes esBloqueInclude() 
		{
			ArrayList<Paquete> incluir=new ArrayList<>();
			Paquete include=esIncluir();
			while(include!=null)
			{
				incluir.add(include);
				include=esIncluir();

			}
			return new BloquePaquetes(incluir);
		}
		
		
		
		/**
		 * funcion que se encarga de crear un paquete basadon en el @BNF
		 * @BNF("<Paquete> ::= @package cadenaCaracteres Terminal")
		 * @return el Paquete creado
		 */
		public Paquete esIncluir()
		{
			SimboloLexico identificador = null; 

			if(tokenActual.getToken().equals("p.r Paquete"))
			{ 

				darSiguienteToken(); 
			} 
			else
			{
				return null;
			} 

			if(tokenActual.getToken().equals("Cadena de Caracteres"))
			{ 
				identificador = tokenActual; 
				darSiguienteToken(); 
			} 
			else
			{
				return null;
			} 

			if(tokenActual.getToken().equals("Terminal"))
			{ 
				darSiguienteToken(); 
				return new Paquete(identificador);
			} 
			else
			{ 
				return null;
			}
		}
		
		/**
		 * funcion que crea una colección de paquetes
		 * @BNF <BloqueImportaciones> ::= <Importación>[<BloqueImportaciones>]
		 * @return, La lista de importaciones
		 */
		public BloqueImportaciones esBloqueImportaciones() {
			ArrayList<Importacion> importaciones=new ArrayList<>();
			Importacion importacion=esImportacion();
			while(importacion!=null)
			{
				importaciones.add(importacion);
				importacion=esImportacion();
			}
			return new BloqueImportaciones(importaciones);
		}

		/**
		 * funcion encargado de crear una importación
		 * @BNF("<Importación> ::= bring cadenaCaracteres Terminal")
		 * @return, La importación
		 */
		public Importacion esImportacion()
		{
			SimboloLexico identificador = null; 

			if(tokenActual.getLexema().equals("bring"))
			{ 
				darSiguienteToken(); 
			} 
			else
			{
				return null;
			}

			if(tokenActual.getToken().equals("Cadena de caracteres"))
			{ 
				identificador = tokenActual; 
				darSiguienteToken(); 
			} 
			else
			{
				return null;
			} 

			if(tokenActual.getToken().equals("Terminal"))
			{ 
				darSiguienteToken(); 
				return new Importacion(identificador);
			} 
			else
			{
				return null;
			}
		}
		   
		public UnidadCompilacion esUnidadCompilacion()
		{
			
			BloquePaquetes paquetes = esBloqueInclude();
			BloqueImportaciones importaciones=esBloqueImportaciones();
			int ind=indice;
			SimboloLexico aux=tokenActual;
			DeclaracionClase declaracionClase=esDeclaracionClase();
			
			if(declaracionClase!=null)
			{
				return new UnidadCompilacion(paquetes, importaciones, declaracionClase);
			}
			else
			{
				bactracking(ind);
				declaracionClase=null;
				declaracionClase=esDeclaracionClaseErroneaApertura();
				if(declaracionClase!=null)
				{
					reportarError("declaracion de clase erronea, falta {{", aux.getFila(), aux.getColumna());
					
					cont ++;
					
					if(cont==3)
					{
						modoPanico(indice);
					}
					
					return new UnidadCompilacion(paquetes, importaciones, declaracionClase);
				}
				else
				{
					bactracking(ind);
					declaracionClase=null;
					declaracionClase=esDeclaracionClaseErroneaCierre();
					reportarError("declaracion de clase erronea, falta }}", aux.getFila(), aux.getColumna());
					
					cont ++;
					
					if(cont==3)
					{
						modoPanico(indice);
					}
					
					return new UnidadCompilacion(paquetes, importaciones, declaracionClase);
				}
			}
		}
		
		/**
		 * @BNF <Dec. ClaseErroneaApertura> ::=  <Visibilidad> CLS <I. clase> [<Declaraciones>] }} 
		 * funcion que crea una declaración de clase sin la Llave de apertura
		 * @return, La declaración erronea de clase
		 */
		public DeclaracionClaseErronea esDeclaracionClaseErroneaApertura() 
		{

			SimboloLexico identificador=null;		

			Visibilidad tipo= esVisibilidad();
			if(tipo==null)
			{
				RecuperacionAnivelDeFrase("falta la visibilidad de la clase clase");
			}
			if(tokenActual.getLexema().equals("CLS"))
			{
				darSiguienteToken();
			}
			else
			{
				RecuperacionAnivelDeFrase("falta palabra reservada clase en la declaracion de clase");
			}

			if(tokenActual.getToken().equals("p.r Clase"))
			{
				identificador=tokenActual;
				darSiguienteToken();
			}
			else return null;

			Declaracion declaraciones= esDeclaracion();

			if(tokenActual.getToken().equals("Llave de Cierre"))
			{
				darSiguienteToken();
			}
			else return null;

			return new DeclaracionClaseErronea(declaraciones, identificador, tipo);
		}

		/**
		 * funcion que crea la declaración de clase basado en el BNF
		 * @BNF <Declaracion Clase> ::= <Visibilidad> CLS <I. clase> {{ [<Declaracion>] }}
		 * @return la declaración de clase
		 */
		public DeclaracionClase esDeclaracionClase() 
		{
			//DeclaracionClase declaracionClase=null;
			SimboloLexico identificador=null;		

			Visibilidad tipo= esVisibilidad();
			if(tipo==null)
			{
				RecuperacionAnivelDeFrase("falta la visibilidad de la clase clase");
			}
			if(tokenActual.getLexema().equals("CLS"))
			{
				darSiguienteToken();
			}
			else
			{
				RecuperacionAnivelDeFrase("falta palabra reservada clase en la declaracion de clase");
			}

			if(tokenActual.getToken().equals("Metodo"))
			{
				identificador=tokenActual;
				darSiguienteToken();
			}
			else return null;

			if(tokenActual.getToken().equals("P. apertura"))
			{
				darSiguienteToken();
			}
			else return null;
			
			if(tokenActual.getToken().equals("P. Cierre"))
			{
				darSiguienteToken();
			}
			else return null;
			
			if(tokenActual.getToken().equals("L. Apertura"))
			{
				darSiguienteToken();
			}
			else return null;

			Declaracion declaraciones= esDeclaracion();
			

			
			if(tokenActual.getToken().equals("L. Cierre"))
			{
				darSiguienteToken();
			}
			else return null;



			return new DeclaracionClase(declaraciones, identificador, tipo);

		}

		/**
		 * @BNF <Dec. ClaseErroneacierre> ::= <Visibilidad> CLS <I. clase> {{ [<Declaraciones>] 
		 * funcion que crea una declaración de clase sin la Llave de cierre basandose en el BNF
		 * @return, La declaración erronea de clase erronea
		 */
		public DeclaracionClaseErronea esDeclaracionClaseErroneaCierre() 
		{
			//		DeclaracionClaseErronea declaracionClase=null;
			SimboloLexico identificador=null;		

			Visibilidad tipo= esVisibilidad();
			if(tipo==null)
			{
				RecuperacionAnivelDeFrase("falta la visibilidad de la clase clase");
			}
			if(tokenActual.getLexema().equals("CLS"))
			{
				darSiguienteToken();
			}
			else
			{
				RecuperacionAnivelDeFrase("falta palabra reservada clase en la declaracion de clase");
			}

			if(tokenActual.getToken().equals("p.r Clase"))
			{
				identificador=tokenActual;
				darSiguienteToken();
			}
			else return null;

			if(tokenActual.getToken().equals("L. Apertura"))
			{
				darSiguienteToken();
			}
			else return null;

			Declaracion declaraciones= esDeclaracion();


			return new DeclaracionClaseErronea(declaraciones, identificador, tipo);
		}
		
		/**
		 * funcion encargado de crear una declaración basado en el BNF
		 * @BNF("<Declaracion> ::= <Dec. Variables> <Dec. Métodos>")
		 * @return, Las declaraciones creadas0
		 */
		public Declaracion esDeclaracion()
		{
			DeclaracionVariables variables= esDeclaracionVariables();
			DeclaracionFunciones funciones = esBloquefunciones();
			return new Declaracion(variables, funciones);
		}
	

		/**
		 * funcion encargado de crear un listado  de declaraciones basado en el @BNF
		 * @BNF("<Dec. Variables> ::= <Dec. Variable> <Dec. Variables> | <Dec. Variable>")
		 * @return, Un listado de variables
		 */
		public DeclaracionVariables esDeclaracionVariables()
		{
			ArrayList<DeclaracionVariable> declaraciones= esDeclaracionesVariables();
			return new DeclaracionVariables(declaraciones);

		}
		
		/**
		 * funcion que declara una variable
		 * @BNF <DececlaracionVariable> ::= <visibilidad> TipoDato Variable Terminal
		 * @return. La variable declarada
		 */
		public DeclaracionVariable esdeclaracionVariable()
		{
			DeclaracionVariable declaracionVariable=null;
			SimboloLexico IVariable=null;
			SimboloLexico tipoDato=null;

			Visibilidad tipovisibilidad= esVisibilidad();
			if(tipovisibilidad==null)
			{
				return null;
			}

			if(	tokenActual.getToken().equals("p.r Entero")||
					tokenActual.getToken().equals("p.r Real"))
					
			{
				tipoDato=tokenActual;
				darSiguienteToken();
			}
			else return null;

			if(tokenActual.getToken().equals("Variable")){
				IVariable=tokenActual;
				darSiguienteToken();
			}
			else return null;

			if(tokenActual.getToken().equals("Terminal"))
			{
				darSiguienteToken();
				declaracionVariable=new DeclaracionVariable( tipovisibilidad, tipoDato, IVariable);
			}
			else
			{
				return null;
			}

			return declaracionVariable;
		}

		/**
		 * funcion que se encarga de la cracion de una lista de declaraciones
		 * @BNF <Dec. Variables> ::= <Dec. Variable> <Dec. Variables> | <Dec. Variable>
		 * @return, La lista de declaraciones creada
		 */
		public ArrayList<DeclaracionVariable> esDeclaracionesVariables()
		{
			int ind=indice;
			ArrayList<DeclaracionVariable> declaracionesDeVariable=new ArrayList<>();
			DeclaracionVariable declaracionVariable=esdeclaracionVariable();
			while(declaracionVariable!=null)
			{
				declaracionesDeVariable.add(declaracionVariable);
				ind=indice;
				declaracionVariable=esdeclaracionVariable();
			}
			bactracking(ind);
			return declaracionesDeVariable;
		}

		/**
		 * funcion encargado de verificar la declaraciones de funciones
		 * @BNF("<DeclaracionFunciones> ::= <DeclaracionFunciones>[<DeclaracionFuncion>]")
		 * @return Las declaraciones de metodsos verificadas
		 */
		public DeclaracionFunciones esBloquefunciones()
		{
			ArrayList<DeclaracionFuncion> declaraciones= esDeclaracionesfunciones();
			return new DeclaracionFunciones(declaraciones);
		}

		/**funcion que verifica el listado de declaraciones
		 * @BNF("<DeclaracionFunciones> ::= <DeclaracionFunciones>[<DeclaracionFuncion>]")
		 * @return, Las verificaciones de las declaraciones de funciones
		 */
		public ArrayList<DeclaracionFuncion> esDeclaracionesfunciones()
		{
			ArrayList<DeclaracionFuncion> declaracionesDefunciones=new ArrayList<>();
			int ind=indice;
			DeclaracionFuncion declaracionfuncion=esDeclaracionfuncion();
			DeclaracionFuncionErronea error=null;
			while(true)
			{
				if(declaracionfuncion!=null)
				{
					declaracionesDefunciones.add(declaracionfuncion);
					ind=indice;
				}
				else
				{
					bactracking(ind);
					error=esDeclaracionfuncionErronea1();
					if(error==null) 
						break;
					else
					{
						declaracionesDefunciones.add(error);
						ind=indice;
					}
				}
				declaracionfuncion=esDeclaracionfuncion();
			}

			return declaracionesDefunciones;
		}
		
		/**
		 * declaracion de funcion sin parentesis de cierre
		 * @BNF("<Dec. Funcion> ::= <Identificador Funcion> <Palabra apertura> [<Parámetros>] 
		 * 		<Tipo retorno><Tipo visibilidad> <Llave apertura> <Sentencias> <Llave de Cierre>")
		 * @return, declaración erronea de funcion
		 */
		public DeclaracionFuncionErronea esDeclaracionfuncionErronea1()
		{
			DeclaracionFuncionErronea declaracionfuncion=null;
			SimboloLexico identificador=null;
			SimboloLexico dato=null;

			if(tokenActual.getToken().equals("Metodo"))
			{
				identificador=tokenActual;
				darSiguienteToken();
			}
			else return null;

			if(tokenActual.getToken().equals("P. Apertura"))
			{
				darSiguienteToken();
			}
			else
			{
				RecuperacionAnivelDeFrase("falta parentesis de apertura en la delcaracion de funcion");
			}

			Parametros parametros= esParametros();
			if(parametros==null)
			{
				//los parametros son opcionales
			}


			if(tokenActual.getToken().equals("p.r Entero")||
					tokenActual.getToken().equals("p.r Real"))
			{
				
				dato=tokenActual;
				darSiguienteToken();
			}else return null;
			if(dato==null)
			{
				modoPanico2("_\\","falta tipo de retorno en el funcion");
				return null;
			}

			Visibilidad tipovisibilidad= esVisibilidad();
			if(tipovisibilidad==null)
			{
				//el tipo de visibilidad es opcional
			}

			if(tokenActual.getToken().equals("L. Apertura"))
			{
				darSiguienteToken();
			}
			else
			{
				RecuperacionAnivelDeFrase("falta lave de apertura en la declaracion de funcion");
			}

			BloqueSentencias senetencias= esSentencias();
			if(senetencias==null)
			{
				//las entencias son  opcionales
			}

			if(tokenActual.getToken().equals("L. Cierre"))
			{
				darSiguienteToken();
				declaracionfuncion=new DeclaracionFuncionErronea(identificador, parametros, dato, tipovisibilidad, senetencias);
			}
			else 
			{
				return null;
			}

			return declaracionfuncion;
		}


		/**
		 * funcion que verifica una declaracion de funcion, que cumpla con el BNF
		 * @BNF("<DeclaracionFuncion> ::= <Visibilidad> tipoRetorno 
		 * I. Funcion (( [<BloqueParametro>] )) {{ <sentencias> }}
		 * @return, La declaración de funcion
		 */
		public DeclaracionFuncion esDeclaracionfuncion()
		{ 
			DeclaracionFuncion declaracionfuncion=null;
			SimboloLexico tipoRetorno=null;
			SimboloLexico IFuncion=null;

			Visibilidad visibilidad=esVisibilidad();
			if(visibilidad ==null)
			{
				return null;
			}

			if(tokenActual.getToken().equals("p.r Entero")||
					tokenActual.getToken().equals("p.r Real"))
			{
				tipoRetorno=tokenActual;
				darSiguienteToken();
			}
			else return null;

			if(tokenActual.getToken().equals("Metodo"))
			{
				IFuncion=tokenActual;
				darSiguienteToken();
			}
			else return null;

			if(tokenActual.getToken().equals("P. apertura"))
			{
				darSiguienteToken();
			}
			else{

				RecuperacionAnivelDeFrase("falta parentesis de apertura");			
			}

			Parametros parametros= esParametros();


			if(tokenActual.getToken().equals("P. Cierre"))
			{
				darSiguienteToken();
			}
			else{

				RecuperacionAnivelDeFrase("falta parentesis de cierre");
				listaErrores.remove(listaErrores.size()-1);
			}

			if(tokenActual.getToken().equals("L. Apertura"))
			{
				darSiguienteToken();
			}
			else{

				RecuperacionAnivelDeFrase("falta Llave de apertura");	
				listaErrores.remove(listaErrores.size()-1);
			}

			BloqueSentencias senetencias= esSentencias();
			
			if(tokenActual.getToken().equals("L. Cierre"))
			{
				darSiguienteToken();
				declaracionfuncion=new DeclaracionFuncion(visibilidad,IFuncion, parametros, tipoRetorno,  senetencias);
			}
			else 
			{
				listaErrores.remove(listaErrores.size()-1);
				return null;
			}

			return declaracionfuncion;
		}

		
		/**
		 * funcion que crea una lista de parametros
		 * @BNF <Parámetros> ::= <Identificador Variable> <Tipo Dato> <Separador> <Parámetros> | <Identificador Variable><Tipo Dato>
		 * @return, Lista de parametros creados
		 */

		public Parametros esParametros()
		{
			ArrayList<Parametro> parametros = esBloqueParametros();
			return new Parametros(parametros);
		}

		/**
		 * funcion que verifica el listado de parametros
		 * @BNF("<Parámetros> ::= <Identificador Variable> <Tipo Dato> <Separador> <Parámetros>
		 *  | <Identificador Variable><Tipo Dato>")
		 * @return, Listado de parametros verificados
		 */
		public ArrayList<Parametro>  esBloqueParametros()
		{
			ArrayList<Parametro> parametros=new ArrayList<>();
			Parametro parametro=esParametro();
			while(parametro!=null)
			{
				if(tokenActual.getToken().equals("Separador"))
				{
					darSiguienteToken();
				}
				parametros.add(parametro);
				parametro=esParametro();

			}
			return parametros;
		}

		//dudad
		/**
		 * @BNF("")
		 * @return
		 */
		public Parametro esParametro()
		{
			SimboloLexico identificador=null;
			Parametro parametro=null;
			SimboloLexico dato=null;

			if(tokenActual.getToken().equals("p.r Entero")||
					tokenActual.getToken().equals("p.r Real"))
			{
				
				dato=tokenActual;
				darSiguienteToken();
			}else return null;

			if(tokenActual.getToken().equals("Variable"))
			{
				identificador=tokenActual;
				darSiguienteToken();
			}
			else return null;

			parametro=new Parametro(identificador, dato);
			return parametro;
		}


		/**
		 * funcion que crea las sentencias dentro del codigo
		 * @BNF("<Sentencias> ::= <Sentencia> < Sentencias> | < Sentencia>")
		 * @return, Los sentencias creadas
		 */
		public BloqueSentencias esSentencias()
		{
			ArrayList<Sentencia> Listasentencias = esBloqueSentecias();
			return new BloqueSentencias(Listasentencias);
		}


		/**
		 * funcion que verifica las sentencias dentro del codigo
		 * @BNF("<Sentencias> ::= <Sentencia> < Sentencias> | < Sentencia>")
		 * @return, Los sentencias verificadas
		 */
		public ArrayList<Sentencia> esBloqueSentecias()
		{
			ArrayList<Sentencia> sentencias=new ArrayList<>();
			Sentencia sentencia=esSentencia();
			while(sentencia!=null)
			{
				sentencias.add(sentencia);
			//	cont=0;
				sentencia=esSentencia();
			}
			return sentencias;
		}
		
		/**
		 * funcion que verifica la categoria sintactica imprimir
		 * @BNF("<Imprimir>::= Imprimir <Dato> Terminal")
		 * @return, Imprimir verificado
		 */
		public Imprimir esImprimir() 
		{
			if(tokenActual.getToken().equals("p.r Return"))
			{ 
				darSiguienteToken(); 
			} 
			else  return null;

			Dato dato = esDato(); 

			if(dato == null)
			{ 
				RecuperacionAnivelDeFrase("no hay dato en la sentencia imprimir");
				return null;
			} 


			if(tokenActual.getToken().equals("Terminal")) 
			{ 
				darSiguienteToken(); 
				return new Imprimir(dato); 
			} 
			else return null;
		}
		
		/**
		 * funcion que verifica un dato, basandose en su @BNF
		 * @BNF("<Dato> ::= Numero Entero | Numero Real | Cadena de Caracteres | I. Variable")
		 * @return, El dato verificado
		 */
		public Dato esDato()
		{
			SimboloLexico identificador = null; 


			if(tokenActual.getToken().equals("p.r Entero") || tokenActual.getToken().equals("p.r Reales") ||
					tokenActual.getToken().equals("Cadena de caracteres") || tokenActual.getToken().equals("Variable"))
			{ 
				identificador = tokenActual; 
				darSiguienteToken(); 
				return new Dato(identificador);
			} 

			return null;
		}
		
		/**
		 * funcion que verifica la invocación de funcion, basado en el @BNF
		 * @BNF("<Invocación funcion> ::= I. Funcion Parentesis Apertura <Datos> Parentesis Cierre  Terminal")
		 * @return, Invocación de funcion verificada
		 */
		public InvocacionFuncion esInvocacionfuncion() 
		{

			SimboloLexico identificador = null;

			if(tokenActual.getToken().equals("Metodo"))
			{ 
				identificador = tokenActual; 
				darSiguienteToken(); 
			} 
			else	
			{
				return null;
			}
			if(tokenActual.getToken().equals("P. apertura"))
			{ 

				darSiguienteToken(); 
			} 
			else  return null;

			Datos datos = esDatos(); 


			if(tokenActual.getToken().equals("P. Cierre"))
			{ 

				darSiguienteToken(); 
			} 
			else  return null;



			if(tokenActual.getToken().equals("Terminal")) 
			{ 
				darSiguienteToken(); 
				return new InvocacionFuncion(datos, identificador); 
			} 
			else  return null;
		}
		

		
		/**
		 * funcion que verifica la categoria sintactica Dato
		 * @BNF("< Datos> ::= < Dato> < Datos> | < Dato>")
		 * @return, El dato verificado
		 */
		public Datos esDatos() 
		{
			ArrayList<Dato> datos = esBloqueDatos();
			return new Datos(datos);
		}
		
		/**
		 * funcion que verifica la lista de datos
		 * @BNF("< Datos> ::= < Dato> [Separador < Datos>]")
		 * @return, Lista de datos verificados
		 */
		public ArrayList<Dato> esBloqueDatos() 
		{ 
			ArrayList<Dato> bloqueDatos = new ArrayList<Dato>(); 

			Dato dato = esDato(); 

			while(dato!=null) 
			{ 
				bloqueDatos.add(dato); 
				if(tokenActual.getToken().equals("Separador"))
				{
					darSiguienteToken();
				}

				dato = esDato(); 
			} 
			return bloqueDatos; 
		} 

		/**
		 * funcion que verifica la categoria sintactica, basandose en el @BNF
		 * @BNF("<Expresión aritmética> ::= <Expresión> | <Termino> | <Factor>")
		 * @return, Expresión aritmetica verificada
		 */
		public ExpresionAritmetica esExpresionAritmetica() 
		{
			Expresion expresion = esExpresion();
			Termino termino = esTermino();
			Factor factor = esFactor();
			if(termino!=null || factor!=null || expresion!=null)
			{
				return new ExpresionAritmetica(expresion, termino, factor);
			}
			else return null;
		}
		
		/**
		 * funcion que verifica la categoria sintactica Expresión,basado en el @BNF 
		 * @BNF <Expresión> ::= <Termino> + <Expresión> | <Termino>
		 * @return, La expresión verificada
		 */
		public Expresion esExpresion()
		{
			return null;
		}
		
		/**
		 * funcion que verifica Termino basado en el @BNF
		 * @BNF <Termino> ::= <Factor> Oper. multiplicativo <Termino> | <Factor>
		 * @return, El termino verificado
		 */
		public Termino esTermino()
		{
			Factor factor=esFactor();
			if(factor==null)
			{
				return null;
			}
			SimboloLexico operadorMultiplicativo=null;
			SimboloLexico operadorSuma = null;
			if(tokenActual.getToken().equals("Multiplicacion"))
			{
				operadorMultiplicativo=tokenActual;
				darSiguienteToken();
				return new Termino(factor, null, operadorMultiplicativo);
			}
			if( tokenActual.getToken().equals("Suma"))
			{
				operadorSuma = tokenActual;
				darSiguienteToken();
				return new Termino(factor, null, operadorSuma);
			}
			Termino termino= esTermino();
			if(termino==null)
			{
				return null;
			}
			else return new Termino(factor, termino, operadorMultiplicativo);
		}

		/**
		 * funcion que verifica la categoria sintactica factor, basado en el @BNF
		 * @BNF <Factor> ::= Numero Entero | Numero Real | <Palabra apertura> <Expresión> <Palabra cierre> | <Identificador Variable>
		 * @return, El factor verificado
		 */
		public Factor esFactor()
		{
			SimboloLexico identificador=null;
			if(tokenActual.getToken().equals("p.r Entero")||tokenActual.getToken().equals("p.r Reales")
					||tokenActual.getToken().equals("Variable"))
			{
				identificador=tokenActual;
				darSiguienteToken();
				return new Factor(identificador, null);
			}
			else return null;
		}
		/**
		 * funcion que verifica una variable
		 * @BNF <Variable> ::= Tipo de Dato I. Variable
		 * @return, La variable verificada
		 */
		public Variable esVariable()
		{
			int ind=indice;
			SimboloLexico identificador=null;
			SimboloLexico dato=null;

			if( esTipoDato() != null)
			{ 
				dato=tokenActual;
				darSiguienteToken(); 
			}else return null;

			if(tokenActual.getToken().equals("Variable"))
			{ 
				identificador=tokenActual;
				darSiguienteToken(); 
			} 
			else
			{
				bactracking(ind);
				return null;
			} 
			
			return new Variable(dato, identificador);
		}

		/**
		 * funcion que verifica la instancia de asignación
		 * @BNF("<Instancia de Asignación> ::= I. Variable Operador de asignacion <Dato> Terminal |I. Variable Operador de asignacion <Expresión Aritmética> Terminal")
		 * @return, La instancia de asignación verificada
		 */
		public InstanciaAsignacion instanciaDeAsignacion() 
		{
			SimboloLexico identificador = null; 

			if(tokenActual.getToken().equals("Variable"))
			{ 
				identificador=tokenActual;
				darSiguienteToken(); 
			} 
			else return null;

			if(tokenActual.getToken().equals("p.r Igual que"))
			{ 
				darSiguienteToken(); 
			} 
			else return null;

			ExpresionAritmetica expresionAritmetica = esExpresionAritmetica();
			Dato dato = esDato(); 

			if(dato == null && expresionAritmetica==null)
			{ 
				RecuperacionAnivelDeFrase("falta dato a asignar en la instancia asignacion");
			} 

			if(tokenActual.getToken().equals("Terminal")) 
			{ 
				darSiguienteToken(); 
				return new InstanciaAsignacion(identificador, dato, expresionAritmetica); 
			} 
			else return null;
		}
		/**
		 * funcion que verifica una sentencia
		 * @BNF("<Sentencia> ::= <SentenciaSi> | <SentenciaMientras> | <InvocaciónMétodo> | <InsAsignación> | <Imprimir> | <Retornar> | <Ex. Aritmética> | <Variables>")
		 * @return, La sentencia verificada
		 */
		public Sentencia esSentencia()
		{
			int ind=indice;
		

			Imprimir imprimir=esImprimir();
			
			if(imprimir!=null && imprimir.getDato()==null)
			{
				ind=indice;
			}
			else if(imprimir!=null)
			{
				return imprimir;
			}
			else bactracking(ind);

			Retorno retorno=esRetorno();
			if(retorno!=null && retorno.getDatoRetornar()==null)
			{
				ind=indice;
				return esSentencia();
			}
			else if(retorno!=null)
			{
				return retorno;
			}
			else bactracking(ind);

			InvocacionFuncion invo=esInvocacionfuncion();
			if(invo!=null && invo.getIdentificadorfuncion()==null)
			{
				ind=indice;
				return esSentencia();
			}
			else if(invo!=null)
			{
				return invo;
			}
			else bactracking(ind);


			Sentencia sentencia=esVariable();
			if(sentencia!=null)
			{
				return sentencia;
			}
			else bactracking(ind);

			sentencia=instanciaDeAsignacion();
			if(sentencia!=null)
			{
				return sentencia;
			}		
			else bactracking(ind);

			sentencia=esExpresionAritmetica();
			if(sentencia!=null)
			{
				return sentencia;
			}
			else bactracking(ind);

			cont ++;
			
			if(cont==3)
			{
				modoPanico(indice);
			}
			
			return sentencia;
		}
		
		/**
		 * funcion que verifica un retornno, basado en su @BNf
		 * @BNF("<Retorno> ::= @return <Dato> Terminal")
		 * @return, Retorno verificado
		 */
		public Retorno esRetorno() 
		{		 
			if(tokenActual.getToken().equals("p.r Return"))
			{ 
				darSiguienteToken(); 
			} 
			else return null;

			Dato datoRetorno = esDato(); 
			if(datoRetorno == null)
			{ 
				RecuperacionAnivelDeFrase("no hay dato en la sentencia retorno");
				return null;
			} 

			if(tokenActual.getToken().equals("Terminal")) 
			{ 
				darSiguienteToken(); 
				return new Retorno(datoRetorno); 
			} 
			else return null;
		}
		
		/**funcion que verifica la categoria sintactica tipo de visibilidad
		 * @BNF("<esVisibilidad> ::= @public | @private | @protected")
		 * @return, Tipo de visibilidad verificado
		 */
		public TipoDato esTipoDato()
		{
			TipoDato tipoDato=null;
			SimboloLexico TipoDato=null;
			if(tokenActual.getToken().equals("p.r Entero") || tokenActual.getToken().equals("p.r Reales") )
			{
				TipoDato=tokenActual;
				darSiguienteToken();
				tipoDato=new TipoDato(TipoDato);
			}
			else return null;

			return tipoDato;
		}
		

		/**
		 * @param msgError El mensaje de error	
		 * @param fila La fila en la que está el error
		 * @param columna La columna en la que está el error
		 */
		public void reportarError( String msgError, int fila, int columna ) 
		{ 
			listaErrores.add(new ErrorSintactico ( msgError, fila, columna) ); 
		} 

		//Getters And Setters
		public ArrayList<ErrorSintactico> getListaErrores()
		{
			return listaErrores;
		}

		public UnidadCompilacion getUnidadDeCompilacion() {
			return unidadDeCompilacion;
		}
		
		/**funcion que verifica la categoria sintactica tipo de visibilidad
		 * @BNF("<esVisibilidad> ::= @public | @private | @protected")
		 * @return, Tipo de visibilidad verificado
		 */
		public Visibilidad esVisibilidad()
		{
			Visibilidad visibilidad=null;
			SimboloLexico Visibilidad=null;
			if(tokenActual.getToken().equals("p.r Public") || tokenActual.getToken().equals("p.r Private") )
			{
				Visibilidad=tokenActual;
				darSiguienteToken();
				visibilidad=new Visibilidad(Visibilidad);
			}
			else return null;

			return visibilidad;
		}
		

		/**
		 * @param msgError
		 */
		public void RecuperacionAnivelDeFrase(String msgError)
		{
			SimboloLexico aux=tokenActual;
			reportarError(msgError, aux.getFila(), aux.getColumna());
		}

}
