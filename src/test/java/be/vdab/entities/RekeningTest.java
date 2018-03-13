package be.vdab.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class RekeningTest {
	Rekening rekening;

	@Before
	public void before() {
		rekening = new Rekening("063-1547564-61");
	}

	/**
	 * DE TESTEN VOOR HET REKENINGNUMMER BIJ HET OPSTARTEN VAN EEN REKENING
	 */

	@Test
	public void een_rekeningnummer_met_12_cijfers_en_een_correct_controlegetal_is_OK() {
		new Rekening("063-1547564-61");
	}

	@Test
	public void een_rekeningnummer_met_12_cijfers_en_een_controlegetal_0_moet_eindigen_op_97() {
		new Rekening("063-1547503-97");
	}

	@Test(expected = IllegalArgumentException.class)
	public void een_rekeningnummer_met_11_cijfers_is_niet_OK() {
		new Rekening("063-1547564-6");
	}

	@Test(expected = IllegalArgumentException.class)
	public void een_rekeningnummer_met_13_cijfers_is_niet_OK() {
		new Rekening("063-1547564-610");
	}

	@Test(expected = IllegalArgumentException.class)
	public void een_rekeningnummer_met_12_cijfers_zonder_streepjes_is_niet_OK() {
		new Rekening("0631547564610");
	}

	@Test(expected = IllegalArgumentException.class)
	public void een_rekeningnummer_mag_niet_leeg_zijn() {
		new Rekening("");
	}

	@Test(expected = NullPointerException.class)
	public void een_rekeningnummer_mag_niet_null_zijn() {
		new Rekening(null);
	}

	/**
	 * DE TESTEN VOOR HET SALDO BIJ HET OPSTARTEN VAN EEN REKENING
	 */

	@Test
	public void saldo_nieuwe_rekening_is_0() {
		assertEquals(0, rekening.getSaldo().compareTo(BigDecimal.ZERO));
	}

	/**
	 * DE TESTEN VOOR HET STORTEN OP EEN REKENING
	 */

	@Test
	public void saldo_na_eerste_storting_is_gelijk_aan_bedrag_storting() {
		rekening.storten(BigDecimal.valueOf(200));
		assertEquals(0, rekening.getSaldo().compareTo(BigDecimal.valueOf(200)));
	}

	@Test
	public void saldo_na_meerdere_stortingen_is_gelijk_aan_het_gecumuleerde_bedrag_van_de_storting() {
		rekening.storten(BigDecimal.valueOf(200));
		rekening.storten(BigDecimal.valueOf(300));
		rekening.storten(BigDecimal.valueOf(100));
		assertEquals(0, rekening.getSaldo().compareTo(BigDecimal.valueOf(600)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void het_bedrag_van_de_storting_mag_niet_0_zijn() {
		rekening.storten(BigDecimal.ZERO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void het_bedrag_van_de_storting_mag_niet_negatief_zijn() {
		rekening.storten(BigDecimal.valueOf(-5));
	}

	@Test(expected = NullPointerException.class)
	public void het_bedrag_van_de_storting_mag_niet_null_zijn() {
		rekening.storten(null);
	}

	/**
	 * DE TESTEN VOOR METHODS toString, equals en hashCode
	 */

	@Test
	public void toString_moet_het_rekeningnummer_returnen() {
		String nummer = "063-1547564-61";
		assertEquals(nummer, new Rekening(nummer).toString());
	}

	@Test
	public void equals_is_true_bij_twee_gelijke_rekeningnummers() {
		assertEquals(new Rekening("063-1547564-61"), new Rekening("063-1547564-61"));
	}

	@Test
	public void equals_is_false_bij_twee_verschillende_rekeningnummers() {
		String nummer1 = "063-1547564-61";
		String nummer2 = "063-1547503-97";
		assertNotEquals(new Rekening(nummer1), new Rekening(nummer2));
	}

	@Test
	public void hashCode_van_dezelfde_rekeningen_moet_gelijk_zijn() {
		assertEquals(new Rekening("063-1547564-61").hashCode(), new Rekening("063-1547564-61").hashCode());
	}

	@Test
	public void hashCode_van_verschillende_rekeningen_mag_niet_gelijk_zijn() {
		assertNotEquals(new Rekening("063-1547564-61").hashCode(), new Rekening("063-1547503-97").hashCode());
	}

}