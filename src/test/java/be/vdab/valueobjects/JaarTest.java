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
}