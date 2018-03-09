package be.vdab.util;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ConverterTest {

	@Test
	public void eenInchIs2Punt54Centimeter() {
		assertEquals(0,BigDecimal.valueOf(2.54).compareTo(new Converter().inchesNaarCentimeters(BigDecimal.ONE)));
	}
	
	@Test
	public void tweehonderdInchesIs508Centimeter() {
		assertEquals(0,BigDecimal.valueOf(508).compareTo(new Converter().inchesNaarCentimeters(BigDecimal.valueOf(200))));
	}

}
