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

        Hobby fugl = new Hobby("Fugletitting");
        Hobby alpin = new Hobby("Alpin");
        Hobby gaming = new Hobby("GAMING");
        Hobby warhammer = new Hobby("WarHammer");
        Hobby cosplay = new Hobby("CosPlay");

        MengdeADT<Hobby> hob1 = new KjedetMengde<Hobby>() ;
        MengdeADT<Hobby> hob2 = new TabellMengde<Hobby>();
        hob1.leggTil(fugl);
        hob1.leggTil(alpin);
        hob2.leggTil(gaming);
        hob2.leggTil(warhammer);
        hob2.leggTil(cosplay);

        arkiv.leggTilMedlem(new Medlem("OddGeir", hob1));
        arkiv.leggTilMedlem(new Medlem("Hjørn", hob2));
        arkiv.leggTilMedlem(new Medlem("Birte", hob1));

        ut.meny(arkiv);

    }

}