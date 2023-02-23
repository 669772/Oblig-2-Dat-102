package no.hvl.dat102.mengde.klient;

import java.util.Iterator;
import java.util.Scanner;

import datakontakt.Datakontakt;
import hobby.Hobby;
import medlem.Medlem;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt {
	// Hvis du vil lage meny, kan du også legge det inn i Tekstgrensesnitt
	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {
		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Navn: ");
		String navn = scanner.nextLine();

		while (true) {
			System.out.print("\nSkriv inn hobby: ");
			String hob = scanner.nextLine();
			Hobby hobby = new Hobby(hob);
			hobbyer.leggTil(hobby);
			if(hob == "") {
				break;
			}
		}
		Medlem svar = new Medlem(navn, hobbyer);
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
		int i = 0;

		while (teller.hasNext() && i <= indeks) {
			element = teller.next();
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
				svar += "\n" + element.getNavn() + " og " + finnMedlem(element.getStatusIndeks(), arkiv).getNavn()
						+ "\t ";
				skrivHobbyListe(element);
				antpar++;
			}
		}
		svar += "\nAntall par funnet: " + antpar;
		System.out.println(svar);

		/*
		 * skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre
		 * i medlemstabellen til enhver tid. Et slikt par skal kun vises én gang på
		 * utskriftlisten. Metoden skriver også ut antall par som er funnet. Eksempel på
		 * utskrift: PARNAVN HOBBYER Erna og Jonas <ski, musikk, politikk> Eva og Adam <
		 * epleplukking, paradishopping> ……………………. Antall par funnet: 12
		 */
	}

	public void meny(Datakontakt arkiv) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Skriv inn medlem eller les parliste: ");
		String valg1 = scanner.nextLine();
		valg1 = valg1.toLowerCase();
		
		if (valg1.equals("medlem")) {

			lesMedlem();

		} else if (valg1.equals("parliste")) {

			skrivParListe(arkiv);

		} else {
			System.out.println("Feil innskriving");
		}
	}
}
