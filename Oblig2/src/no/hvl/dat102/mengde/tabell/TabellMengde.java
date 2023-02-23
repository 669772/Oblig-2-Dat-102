package no.hvl.dat102.mengde.tabell;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		// S�ker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		for (int i = 0; (i < antall && !funnet); i++) {
			if (tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall - 1];
				// tab[antall-1] = null;
				antall--;
				funnet = true;

			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hashcode-metoden da en del biblioterker brker hashcode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hashcode senere i faget.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object m2) {

        if (this == m2) {
            return true;
        }
        if (m2 == null) {
            return false;
        }
        if (getClass() != m2.getClass()) {
            return false;
        }
        MengdeADT<T> M2 = (TabellMengde<T>) m2;
        if (this.antall != M2.antall()) {
            return false;
        } else {
            T element;
            Iterator<T> teller = M2.iterator();

            while (teller.hasNext()) {
                element = teller.next();
                if (!(inneholder(element))) {
                    return false;
                }
            }
        }
        return true;
    }

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) { 
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.iterator();

		while (teller.hasNext()) {
			T element = teller.next();
			if (!(begge.inneholder(element))) {
				((TabellMengde<T>) begge).settInn(element);
			}
		}
		return (MengdeADT<T>) begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();
		T element = null;
		Iterator<T> teller = m2.iterator();
		
		while (teller.hasNext()) {
			element = teller.next();
			if (this.inneholder(element)) {
				((TabellMengde<T>) snittM).settInn(element);
			}
		}
		
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		T element;
		Iterator<T> teller = this.iterator();
		
		while (teller.hasNext()) {
			element = teller.next();
			if (!(m2.inneholder(element))) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		T element;
		Iterator<T> teller = m2.iterator();
		
		if(m2.equals(this)) {
			return true;
		}
		if(m2.erTom()) {
			return true;
		}
		if(m2.antall() > this.antall) {
			return false;
		}
		
		while( erUnderMengde && teller.hasNext() ) {
			element = teller.next();
			
			if( !(this.inneholder(element)) ) {
				erUnderMengde = false;
			}
		}
		
		return erUnderMengde;
	}

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {// hjelpemetode
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}
	
	@Override
	public String toString() {
		String resultat = "";
		for(int i = 0; i < antall; i++) {
			resultat += tab[i].toString() + "\t";
		}
		return resultat;
	}

}// class