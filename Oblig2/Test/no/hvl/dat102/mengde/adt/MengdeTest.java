package no.hvl.dat102.mengde.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public abstract class MengdeTest {
	private MengdeADT<Integer> begge = null;
	private MengdeADT<Integer> m1 = new KjedetMengde<Integer>();
	private MengdeADT<Integer> m2 = new TabellMengde<Integer>();
	private MengdeADT<Integer> m3 = new KjedetMengde<Integer>();
	private MengdeADT<Integer> fasit = new KjedetMengde<Integer>();

	@BeforeEach
	public void reset() {
		m1.leggTil(4);
		m1.leggTil(2);
		m1.leggTil(7);
		m1.leggTil(9);
		m1.leggTil(1);

		m2.leggTil(6);
		m2.leggTil(5);
		m2.leggTil(8);
		m2.leggTil(3);
		m2.leggTil(2);

		m3.leggTil(6);
		m3.leggTil(5);
		m3.leggTil(8);
		m3.leggTil(3);
		m3.leggTil(2);

		fasit.leggTil(4);
		fasit.leggTil(2);
		fasit.leggTil(7);
		fasit.leggTil(9);
		fasit.leggTil(1);
		fasit.leggTil(6);
		fasit.leggTil(5);
		fasit.leggTil(8);
		fasit.leggTil(3);
		fasit.leggTil(2);
	}

	@Test
	public void unionTest() {

		begge = m1.union(m2);

		assertFalse(begge.erTom());
		assertTrue(begge.equals(fasit));

		begge = m2.union(m3);

		assertFalse(begge.erTom());
		assertTrue(begge.equals(m2));

	}

	@Test
	public void SnittTest() {

		MengdeADT<Integer> snitt = new TabellMengde<Integer>();
		snitt.leggTil(2);

		begge = m1.snitt(m2);

		assertFalse(begge.erTom());
		assertTrue(begge.equals(snitt));

		begge = m2.snitt(fasit);

		assertFalse(begge.erTom());
		assertTrue(begge.equals(m2));

	}

	@Test
	public void differensTest() {

		begge = fasit.differens(m2);

		assertFalse(begge.erTom());
		assertTrue(begge.equals(m1));

		begge = m3.differens(m2);

		assertTrue(begge.erTom());

	}
}