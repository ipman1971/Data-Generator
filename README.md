### SyntheticDataGenerator: library for synthetic data generation
#### Libreria Java para la generacion sintética de datos
------------------------------
Según la Real Academia de la Lengua, en su definicion de la palabra **"sintético"** define:

 >  ***"dicho de un producto: Que se obtiene por procedimientos industriales y que reproduce la composición y propiedades de uno natural***. 

**SyntheticDatioGenerator** pretende resolver un problema bastante habitual en el trabajo con tecnologias Big Data, aunque su utilidad no esta limitada a este ambito. La librería debería ser capaz de la generar fuentes de datos sinteticas necesarias en multitud de proyectos donde por diferentes motivos no se puede disponer de fuentes de datos ***"naturales"***

Entendemos como ***"natural"*** a la fuente de datos con la que la aplicacion debera trabajar en un entorno de producción, siendo esta librería la encargada de crear fuentes de datos que se ajusten a diversas necesidades en cuanto a sus caracteristicas como son: el origen del dato, su formato, volumetria, forma de calculo o de generacion, etc.

------------------------------------------
#### Ultima versión
**ATENCIÓN: Este proyecto esta en fase de desarrollo y todavia no dispone de una VERSION ESTABLE**

------------------------------------------
#### Versión en desarrollo
La version en desarrollo siempre se construye sobre la rama `master`. La versión actual es la `0.0.1-SNAPSHOT`. 

------------------------------------------
### Forma de uso
El siguiente diagrama de clases presenta los principales interfaces de la libreria:

![](https://api.genmymodel.com/projects/_0xYCECyLEeaytLLEbYPIyA/diagrams/_0xYpIyyLEeaytLLEbYPIyA/jpeg) 

Los pasos para poder generar datos son los siguientes:

+ Crear y configurar el **Sink**, que nos permite el volcado de datos de acuerdo a nuestras necesidades.
+ Crear o utilizar tantos **DataProducer" como sean necesarios.
+ Crear y configurar el **DataGeneratorConfig**, que  configura la generación de datos.
+ Crear el **Generator**, añadirle su configuración y proceder a su ejecución.

#### Crear y configurar el ***Sink***:
La generacion de nuestros datos deben tener configurada una salida determinada o ***"Sink"***. Este interface estable un ciclo de vida para cualquier forma de volcado o salida de los datos, su definicion es:

	/**
	 * Define el ciclo de vida para cualquier posible forma de volcar datos generados
	 * 
	 * @author jcorredera
	 *
	 */
	public interface Sink {
		/**
		 * Realiza cualquier tipo de operación previa al procesamiento de todas las tuplas
		 */
		public void begin();
		/**
		 * Procesa una a una cada tupla de datos generados de acuerdo a la forma de su volcado
		 * 
		 * @param tuple		Este objeto representa el conjunto de datos generados
		 */
		public void process(Tuple tuple);
		/**
		 * Realiza cualquier tipo de operación posterior al procesamiento de todas las tuplas
		 */
		public void end();
	}

Las implementaciones de **Sink** disponibles son:

![](https://api.genmymodel.com/projects/_0xYCECyLEeaytLLEbYPIyA/diagrams/_QyJqMRRnEDSdXdSY3bqItg/jpeg) 

Actualmente disponemos solo de dos implementaciones de este interface: ***ConsoleSink*** para volcado por pantalla, y ***FileSink*** para volcado a fichero

##### Configurando el Sink para volcado a consola:
Tan simple como crear la implementación **ConsoleSink** a traves de su constructor por defecto:

	Sink consoleSink=new ConsoleSink();

##### Configurando el Sink para volcado a fichero:
Utilizaremos la implementación **FileSink** que utiliza el [patrón Fluent Interface](https://en.wikipedia.org/wiki/Fluent_interface) para configurar las opciones especificas de este **Sink**:

+ El path al fichero con el metodo `path(String path)`, si el valor proporcionado es nulo, el valor por defecto sera */tmp*.
+ El nombre de salida del fichero con el método `filename(String filename)`, si el valor proporcionado es nulo, su valor por defecto sera *output*.
+ El separador de datos se establece por el método `withSeparator(String separator)`, si no se utiliza este metodo el separador por defecto es **|**.
+ El fichero es generado por medio de un buffer de memoria, por medio del método `bufferSize(int size)`, el tamaño se establece en bytes. Si no se utiliza este método el valor por defecto es de 8Kb.

Por ejemplo, configuremos un **FileSink** en el directorio */tmp/generator*, con nombre *fakeFile.dat*, usando como separador entre datos el caracter *;* y con un buffer de memoria de *128Kb*:

	Sink sink=FileSink.path("/tmp/generator")
				.filename("fakeFile.dat")
				.withSeparator(";")
				.bufferSize(128*1024)
				.create();
	


