package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.DobbelKjedetOrdnetListe;

public class KlientDobbelKjedetListe {

	public static void main(String[] args) {
		String ord[] = { "o", "s", "a", "m", "g"  };

		DobbelKjedetOrdnetListe<String> liste = new DobbelKjedetOrdnetListe(new String("AAA"), new String("zzz"));

		for (int i = 0; i < ord.length; i++) {
			liste.leggTil(ord[i]);

		}

		System.out.println(liste);

		System.out.println(liste.tilStrengBaklengs());

		liste.fjern("g");

		System.out.println(liste);

		liste.fjern("t");
		System.out.println(liste);

	}

}
