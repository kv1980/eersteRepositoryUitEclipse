package be.vdab.util;

import java.math.BigDecimal;
import java.util.Arrays;

public class Statistiek {
	public static BigDecimal getGemiddelde(BigDecimal[] getallen) {
		int aantal = getallen.length;
		if (aantal == 0) {
			throw new IllegalArgumentException("lege array");
		}
//		BigDecimal som = BigDecimal.ZERO;
//		boolean arrayMetNull = false;
//		for (int i = 0; i < aantal; i++) {
//			if (getallen[i] == null) {
//				arrayMetNull = true;
//			} else {
//				som = som.add(getallen[i]);
//			}
//		}
//		if (arrayMetNull) {
//			throw new NullPointerException("Er is een null aanwezig in de array.");
//		}
//		return som.divide(BigDecimal.valueOf(aantal));
		
		/**
		 * Opmerking: NullPointerException wordt reeds aan de binnenkant van Arrays.stream ... uitgevoerd
		 *            dit hoef je zelf niet meer te voorzien.
		 */  
		
		return Arrays.stream(getallen)
				.reduce(BigDecimal.ZERO, (vorigTotaal,getal) -> vorigTotaal.add(getal))
				.divide(BigDecimal.valueOf(aantal));
	}
}