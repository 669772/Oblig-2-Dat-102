package no.hvl.dat102.listeklient;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPerson {

    public static void main(String[] args) {

        Person anne = new Person("Anne", "Iversen", 1996);
        Person ole = new Person("Ole", "Vik", 1995);
        Person bendik = new Person("Bendik", "Ness", 1997);
        Person Berntd = new Person("Berntd", "Oveson", 1996);
        Person Benny = new Person("Benny", "Oveson", 1996);

        OrdnetListeADT<Person> liste = new TabellOrdnetListe<Person>();

        liste.leggTil(anne);
        liste.leggTil(ole);
        liste.leggTil(bendik);
        liste.leggTil(Berntd);
        liste.leggTil(Benny);

        Person person = null;

        while(!liste.erTom()) {
            person = liste.fjernFoerste();
            System.out.println(person);
        }


    }

}