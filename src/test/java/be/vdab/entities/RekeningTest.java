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
		rekening.storten(BigDecimal.valueOf(200));
		assertEquals(0,rekening.getSaldo().compareTo(BigDecimal.valueOf(200)));
	}
	
	@Test
	public void saldo_na_meerdere_stortingen_is_gelijk_aan_het_gecumuleerde_bedrag_van_de_storting() {
		rekening.storten(BigDecimal.valueOf(200));
		rekening.storten(BigDecimal.valueOf(300));
		rekening.storten(BigDecimal.valueOf(100));
		assertEquals(0,rekening.getSaldo().compareTo(BigDecimal.valueOf(600)));
	}
}