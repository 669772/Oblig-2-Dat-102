package datakontakt;

import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.tabell.TabellMengde;

import java.util.Iterator;

import medlem.*;

public class Datakontakt {

	private int antallMedlemmer;
	private MengdeADT<Medlem> medlemmer;

	public Datakontakt() {
		medlemmer = new TabellMengde<Medlem>();
		antallMedlemmer = 0;
	}
	
	public MengdeADT<Medlem> getMedlemmer() {
		return medlemmer;
	}
	
	public void leggTilMedlem(Medlem medlem) {
		medlemmer.leggTil(medlem);
		antallMedlemmer++;
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		int indeks = -1;
		boolean ikkeFunnet = true;
		Medlem element;
		Iterator<Medlem> teller = medlemmer.iterator();

		while (teller.hasNext() && ikkeFunnet) {
			element = teller.next();
			indeks++;
			if (element.getNavn().equals(medlemsnavn)) {
				ikkeFunnet = false;
				return indeks;
			}
		}
		return -1;
	}

	public int finnPartnerFor(String medlemsnavn) {
		int indeks = -1;
		boolean ikkeFunnet = true;
		Medlem element1 = null;
		Medlem element2 = null;
		Iterator<Medlem> teller = medlemmer.iterator();
		while (teller.hasNext() && ikkeFunnet) {
			element1 = teller.next();
			if (element1.getNavn().equals(medlemsnavn)) {
				ikkeFunnet = false;
			}
		}
		if (ikkeFunnet) {
			return -1;
		}

		teller = medlemmer.iterator();

		while (teller.hasNext()) {
			element2 = teller.next();
			indeks++;
			if (element1.passerTil(element2) && !(element1.getNavn().equals(element2.getNavn()))
					&& (element2.getStatusIndeks() == -1)) {

				element1.setStatusIndeks(indeks);
				element2.setStatusIndeks(finnMedlemsIndeks(element1.getNavn()));
				return indeks;
			}
		}

		return -1;
	}

	public void tilbaksestillStatusIndeks(String medlemsnavn) {
		boolean ikkeFunnet = true;
		Medlem element1 = null;
		Medlem element2 = null;
		Iterator<Medlem> teller = medlemmer.iterator();
		while (teller.hasNext() && ikkeFunnet) {
			element1 = teller.next();
			if (element1.getNavn().equals(medlemsnavn)) {
				element1.setStatusIndeks(-1);
				ikkeFunnet = false;
			}
		}
		teller = medlemmer.iterator();
		ikkeFunnet = true;
		while (teller.hasNext() && ikkeFunnet) {
			element2 = teller.next();
			if(element2.getStatusIndeks() == finnMedlemsIndeks(element1.getNavn())) {
				element2.setStatusIndeks(-1);
				ikkeFunnet = false;
			}
			
		}

	}
}