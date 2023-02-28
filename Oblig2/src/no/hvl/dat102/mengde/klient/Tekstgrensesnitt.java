package no.hvl.dat102.mengde.klient;

import java.util.Iterator;
import java.util.Scanner;

import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import hobby.*;
import datakontakt.*;
import medlem.*;

public class Tekstgrensesnitt {
	// Hvis du vil lage meny, kan du ogsÃ¥ legge det inn i Tekstgrensesnitt
	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {
		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Navn: ");
		String navn = scanner.nextLine();

		while (true) {
			System.out.print("\nSkriv inn hobby: ");
			String hob = scanner.nextLine();
			if (hob.equals("")) {
				break;
			}
			Hobby hobby = new Hobby(hob);
			hobbyer.leggTil(hobby);
		}

		Medlem svar = new Medlem(navn, hobbyer);
		System.out.println("\nLagt til dette Medlemet: ");
		svar.skrivUt();
		return svar;
	}

	// Skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}

	private static Medlem finnMedlem(int indeks, Datakontakt arkiv) {
		Medlem element = null;
		Iterator<Medlem> teller = arkiv.getMedlemmer().iterator();
		int i = -1;

		while (teller.hasNext() && i <= indeks) {
			element = teller.next();
			i++;
			if (i == indeks) {
				return element;
			}
		}
		return null;
	}

	public static void skrivParListe(Datakontakt arkiv) {
		Medlem element;
		int antpar = 0;
		Iterator<Medlem> teller = arkiv.getMedlemmer().iterator();
		String svar = "";

		while (teller.hasNext()) {
			element = teller.next();
			if (element.getStatusIndeks() == -1) {
				arkiv.finnPartnerFor(element.getNavn());
				if (element.getStatusIndeks() != -1) {
					svar += "\n" + element.getNavn() + " og " + finnMedlem(element.getStatusIndeks(), arkiv).getNavn()
							+ "\t ";
					System.out.println(svar);
					skrivHobbyListe(element);
					antpar++;
				}
			}
		}
		System.out.print("\nAntall par funnet: " + antpar);
	}

	public void meny(Datakontakt arkiv) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\nSkriv inn medlem eller les parliste: ");
		String valg1 = scanner.nextLine();
		valg1 = valg1.toLowerCase();

		if (valg1.equals("medlem")) {
			arkiv.leggTilMedlem(lesMedlem());
		} else if (valg1.equals("parliste")) {
			skrivParListe(arkiv);
		} else {
			System.out.println("Feil innskriving");
		}

		if (!(valg1.equals("stop"))) {
			meny(arkiv);
		}
	}
}