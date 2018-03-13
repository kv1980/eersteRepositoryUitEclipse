package be.vdab.valueobjects;

import static org.junit.Assert.*;

import org.junit.Test;

import be.vdab.valueojects.ISBN;

public class ISBNTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void ISBN_mag_niet_negatief_zijn() {
		new ISBN(-9789027439642L);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void ISBN_mag_niet_minder_dan_13_cijfers_bevatten() {
		new ISBN(978902743964L);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void ISBN_mag_niet_meer_dan_13_cijfers_bevatten() {
		new ISBN(97890274396423L);
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void ISBN_zonder_978_en_979_als_begincombinatie_wordt_niet_aanvaard() {
		new ISBN(9709027439642L);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void ISBN_zonder_correct_eindcijfer_wordt_niet_aanvaard() {
		new ISBN(9789027439643L);
	}
	
	@Test 
	public void ISBN_met_13_cijfers_beginnend_met_978_of_979_en_eindigend_op_correct_eindcijfer_wordt_aanvaard() {
		new ISBN(9789027439642L);
		new ISBN(9799027439641L);
	}
	
	@Test
	public void toString_returnt_een_String() {
		assertEquals("9789027439642",new ISBN(9789027439642L).toString());
	}
}
