package be.vdab.valueobjects;

import static org.junit.Assert.*;
import org.junit.Test;

import be.vdab.valueojects.Jaar;

public class JaarTest {
	@Test
	public void eenJaarDeelbaarDoor400IsEenSchrikkeljaar() {
		Jaar jaar = new Jaar(2000);
		assertTrue(jaar.isSchrikkeljaar());
	}

	@Test
	public void eenJaarDeelbaarDoor100IsGeenSchrikkeljaar() {
		assertFalse(new Jaar(1900).isSchrikkeljaar());
	}

	@Test
	public void eenJaarDeelbaarDoor4IsEenSchrikkeljaar() {
		assertTrue(new Jaar(2016).isSchrikkeljaar());
	}

	@Test
	public void eenJaarOndeelbaarDoor4IsGeenSchrikkeljaar() {
		assertFalse(new Jaar(2018).isSchrikkeljaar());
	}
	
	@Test
	public void equals_op_twee_dezelfde_jaren_moet_true_zijn() {
		assertEquals(new Jaar(2015),new Jaar(2015));
	}
	
	@Test
	public void equals_op_twee_verschillende_jaren_moet_false_zijn() {
		assertNotEquals(new Jaar(2015),new Jaar(2018));
	}
	
	@Test
	public void hashCode_van_dezelfde_jaren_moet_gelijk_zijn() {
		assertEquals(new Jaar(2015).hashCode(),new Jaar(2015).hashCode());
		}
}