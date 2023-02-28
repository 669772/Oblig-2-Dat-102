package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;

		resultat = liste[bak - 1];

		liste[bak] = null;
		bak = bak - 1;

		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;

		resultat = liste[0];
		liste[0] = null;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;

		resultat = liste[bak];

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {

		if (bak + 1 == liste.length) {
			utvid();
		}

		int scan = 0;

		while (scan < bak && element.compareTo(liste[scan]) > 0) {
			scan++;
		}

		for (int i = bak; i > scan; i--) {
			liste[i] = liste[i - 1];
		}

		liste[scan] = element;
		bak++;

	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {

		T resultat;

		int indeks = finn(element);

		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		resultat = liste[indeks];
		bak--;

		for (int i = indeks; i < bak; i++) {
			liste[i] = liste[i + 1];
		}
		liste[bak] = null;
		return resultat;

	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;

		if (!erTom()) {
			while (resultat == IKKE_FUNNET && i < bak) {
				if (el.equals(liste[i])) {
					resultat = i;
				} else {
					i++;
				}
			}
		}

		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
