package no.hvl.dat102.mengde.klient;

import java.util.Scanner;
import datakontakt.Datakontakt;
import medlem.Medlem;

public class Tekstgrensesnitt {

	public static Medlem lesMedlem() {
		Medlem svar = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Søk etter et medlem: ");
		String med = scanner.nextLine();
		
		return svar;
	}
	
	public static void skrivHobbyListe(Medlem medlem) {
		
	}
	
	public static void skrivParliste(Datakontakt arkiv) {
		
	}
}
