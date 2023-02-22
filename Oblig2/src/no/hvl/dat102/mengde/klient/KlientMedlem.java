package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.tabell.TabellMengde;
import no.hvl.dat102.mengde.adt.*;
import hobby.Hobby;
import medlem.*;

public class KlientMedlem {

	public static void main(String[] args) {

		Hobby fugl = new Hobby("Fugletitting");
		Hobby alpin = new Hobby("Alpin");
		Hobby gaming = new Hobby("Gaming");
		Hobby warhammer = new Hobby("WarHammer");
		Hobby cosplay = new Hobby("Cosplay");

		MengdeADT<Hobby> hob1 = new KjedetMengde<Hobby>();
		MengdeADT<Hobby> hob2 = new TabellMengde<Hobby>();
		hob1.leggTil(fugl);
		hob1.leggTil(alpin);
		hob2.leggTil(gaming);
		hob2.leggTil(warhammer);
		hob2.leggTil(cosplay);

		Medlem medlem1 = new Medlem("Oddgeit", hob1);
		Medlem medlem2 = new Medlem("Hjørn", hob2);
		
		medlem1.skrivUt();
		medlem2.skrivUt();

	}

}
