package be.vdab.util;

import java.math.BigDecimal;
import java.util.Arrays;

public interface Statistiek2 {
	public static BigDecimal getGemiddelde(BigDecimal[] getallen) {
		if (getallen.length == 0) {
			throw new IllegalArgumentException("lege array");
		}

		return Arrays.stream(getallen)
				.reduce(BigDecimal.ZERO, (vorigTotaal,getal) -> vorigTotaal.add(getal))
				.divide(BigDecimal.valueOf(getallen.length));
	}
}
