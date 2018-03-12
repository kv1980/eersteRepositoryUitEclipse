package be.vdab.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class RekeningTest {
	Rekening rekening;
	
	@Before
	public void before() {
		rekening = new Rekening();
	}

	@Test
	public void saldo_nieuwe_rekening_is_nul() {
		assertEquals(0,rekening.getSaldo().compareTo(BigDecimal.ZERO));
	}
	
	@Test
	public void saldo_na_eerste_storting_is_gelijk_aan_bedrag_storting() {
		BigDecimal bedrag = BigDecimal.valueOf(200);
		rekening.storten(bedrag);
		assertEquals(0,rekening.getSaldo().compareTo(bedrag));
	}
	
	@Test
	public void saldo_na_meerdere_stortingen_is_gelijk_aan_het_gecumuleerde_bedrag_van_de_storting() {
		BigDecimal bedrag1 = BigDecimal.valueOf(200);
		BigDecimal bedrag2 = BigDecimal.valueOf(300);
		BigDecimal bedrag3 = BigDecimal.valueOf(100);
		BigDecimal som = BigDecimal.valueOf(600);
		rekening.storten(bedrag1);
		rekening.storten(bedrag2);
		rekening.storten(bedrag3);
		assertEquals(0,rekening.getSaldo().compareTo(som));
	}
}