package be.vdab.util;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class Statistiek2Test {

	@Test
	public void gemiddelde_van_10_en_20_is_15() {
		BigDecimal[] getallen = new BigDecimal[] { BigDecimal.ZERO, BigDecimal.TEN };
		BigDecimal gemiddelde = BigDecimal.valueOf(5);
		assertEquals(0, Statistiek.getGemiddelde(getallen).compareTo(gemiddelde));
	}

	@Test
	public void gemiddelde_van_10_is_10() {
		BigDecimal[] getallen = new BigDecimal[] { BigDecimal.TEN };
		BigDecimal gemiddelde = BigDecimal.TEN;
		assertEquals(0, Statistiek.getGemiddelde(getallen).compareTo(gemiddelde));
	}

	@Test(expected = NullPointerException.class)
	public void gemiddelde_van_array_met_null_bestaat_niet() {
		BigDecimal[] getallen = new BigDecimal[] { null };
		Statistiek.getGemiddelde(getallen);
	}

	@Test(expected = IllegalArgumentException.class)
	public void gemiddelde_van_lege_array_bestaat_niet() {
		BigDecimal[] getallen = new BigDecimal[] {};
		Statistiek.getGemiddelde(getallen);
	}

	@Test(expected = NullPointerException.class)
	public void gemiddelde_van_null_bestaat_niet() {
		Statistiek.getGemiddelde(null);
	}
}
