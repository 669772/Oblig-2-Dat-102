package medlem;

import no.hvl.dat102.mengde.adt.*;
import hobby.*;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = -1;
	}

	public Medlem(String navn, MengdeADT<Hobby> hobbyer, int statusIndeks) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = statusIndeks;

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	public boolean passerTil(Medlem medlem2) {
		boolean passer = false;
		
		
		if(this.hobbyer.equals(medlem2.hobbyer)) {
			passer = true;
		}
		return passer;
	}

	public void skrivUt() {

		String str = "Navn: " + navn + "\nHobbyer: " + hobbyer.toString() + "\n";
		System.out.println(str);

	}

}
