package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.tabell.TabellMengde;
import no.hvl.dat102.mengde.adt.*;
import datakontakt.Datakontakt;
import hobby.Hobby;
import medlem.*;

public class KlientMedlem {

    public static void main(String[] args) {

        Datakontakt arkiv = new Datakontakt();
        Tekstgrensesnitt ut = new Tekstgrensesnitt();

        ut.meny(arkiv);

    }

}