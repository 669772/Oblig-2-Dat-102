package datakontakt;

import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import medlem.*;

public class Datakontakt {
	
	private int antallMedlemmer;
	private MengdeADT<Medlem> medlemmer;
	
	public Datakontakt() {
		medlemmer = new KjedetMengde<Medlem>();
		antallMedlemmer = 0;
	}
	
	public void leggTilMedlem(Medlem medlem) {
		medlemmer.leggTil(medlem);
		antallMedlemmer++;
	}

}
