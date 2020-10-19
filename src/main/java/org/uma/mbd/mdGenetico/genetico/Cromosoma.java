package org.uma.mbd.mdGenetico.genetico;
import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.Random;

public class Cromosoma {
	/**
	 * Datos de un cromosoma, cada posición del array representa un gen del
	 * cromosoma.
	 */
	protected int[] datos;

	/**
	 * Variable de clase de tipo Random.
	 */
	protected static Random gna = new Random();

	/**
	 * Valor por defecto 0 para los genes.
	 */
	protected static int GEN_POR_DEFECTO = 0;

	/**
	 * Constructor de la clase Cromosoma
	 * 
	 * @param longitud
	 *            Número de genes que tiene el cromosoma.
	 * @param aleatorio
	 *            Valor booleano que indica si debe asignar de forma aleatoria
	 *            un valor 0 o 1 a cada gen, o inicializarlos con el valor por
	 *            defecto. Si true se asigna aleatoriamente.
	 * @throws RuntimeException
	 *             si longitud no positiva.
	 */
	public Cromosoma(int longitud, boolean aleatorio) {
		int[] datos = new int[longitud];
		if (aleatorio) {
			for (int dato : datos) {
				Random r = new Random();
				dato = r.nextInt(2);
			}
		}
		else{
			for (int dato : datos) {
				dato = GEN_POR_DEFECTO;
			}
		}

	}

	/**
	 * Consulta el gen en la posición indicada.
	 * 
	 * @param i
	 *            índice del gen que se consulta.
	 * @return Valor del gen en la posición indicada.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public int gen(int i) {
		if (i >= datos.length) {
			throw new RuntimeException("El índice está fuera de rango");
		}
		return datos[i];
	}

	/**
	 * Modifica el i-ésimo gen del cromosoma.
	 * 
	 * @param i
	 *            índice del gen a modificar.
	 * @param val
	 *            Nuevo valor para el gen.
	 * @throws RuntimeException
	 *             si i está fuera del rango de valores válidos o si val no es
	 *             un valor válido.
	 */
	public void gen(int i, int val) {
		if (i >= datos.length) {
			throw new RuntimeException("El índice está fuera de rango");
		}
		else if ((val != 0) && (val != 1)) {
			throw new RuntimeException("El nuevo valor no es válido. Ha de valer 0 o 1");
		}
		datos[i] =val;
	}

	/**
	 * Invierte los valores de los genes aleatoriamente.
	 * 
	 * @param probMutacion
	 *            Probabilidad de mutacion de cada gen.
	 * @throws RuntimeException
	 *             si la probabilidad indicada no es un valor válido.
	 */
	public void mutar(double probMutacion) {
		if (probMutacion > 1 || probMutacion < 0) {
			throw new RuntimeException("La probabilidad de mutación ha de estar comprendida entre 0 y 1");
		}
		Random r = new Random();
		for (int dato : datos) {
			if ( r.nextDouble() < probMutacion) {
				if (dato == 0) { dato = 1; }
				else { dato = 0;}
			}
		}
	}

	/**
	 * Longitud del cromosoma.
	 * 
	 * @return int Longitud del cromosoma.
	 */
	public int longitud() {
		return datos.length;
	}

	/**
	 * Realiza una copia en profundidad del cromosoma.
	 * 
	 * @return Un objeto Cromosoma copia del objeto que recibe el mensaje.
	 */
	public Cromosoma copia() {
		// Creamos un cromosoma igual.
		// los arrays de datos deben ser iguales pero no el mismo!
		Cromosoma copia = new Cromosoma(datos.length, false);
		for (int i = 0; i < datos.length; i++) {
			copia.datos[i] = datos[i];
		}
		return copia;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < datos.length - 1; i++) {
			s.append(datos[i]).append(", ");
		}
		return "Cromosoma(" + s + datos[datos.length - 1] + ")";
	}
}
