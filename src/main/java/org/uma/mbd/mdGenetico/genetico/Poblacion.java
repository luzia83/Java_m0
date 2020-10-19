package org.uma.mbd.mdGenetico.genetico;

import java.security.cert.TrustAnchor;

public class Poblacion {
	private Individuo[] individuos;

	/**
	 * 
	 * @param tamaño
	 *            Número de individuos de la población.
	 * @param longitud
	 *            Tamaño de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema a resolver.
	 * @throws RuntimeException
	 *             si el tamaño de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */
	public Poblacion(int tamaño, int longitud, Problema problema) {
		for (int i = 0 ; i < tamaño; ++i) {
			Cromosoma crom = new Cromosoma(longitud, true);
			Individuo ind = new Individuo(crom, problema);
			individuos[i] = ind;
		}
	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */
	public int numIndividuos() {
		return individuos.length;
	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */
	public Individuo mejorIndividuo() {
		if (numIndividuos() == 0) {
			throw new RuntimeException("El número de individuos es 0");
		}
		Individuo mejor = individuos[0];
		for (Individuo ind : individuos) {
			if (ind.fitness() > mejor.fitness()) {
				mejor = ind;
			}
		}
		return mejor;
	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo a devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public Individuo individuo(int i) {
		if (i < 0 || i >= numIndividuos()) {
			throw new RuntimeException("El índice está fuera de rango");
		}
		return individuos[i];
	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */
	public void reemplaza(Individuo ind) {
		if (numIndividuos() == 0) {
			throw new RuntimeException("El número de individuos es 0");
		}
		int indpeor = 0;
		Individuo peor = individuos[0];
		for (int i = 0; i < numIndividuos(); i++) {
			if (individuos[i].fitness() < peor.fitness()) {
				peor = individuos[i];
				indpeor = i;
			}
		}
		if (peor.fitness() < ind.fitness()) {
			individuos[indpeor] = ind;
		}
	}

}
