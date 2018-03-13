package be.vdab.entities;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Rekening {
	private final String rekeningnummer;
	private BigDecimal saldo;
	/* Pattern toevoegen zodat die maar een keer gecompiled wordt */
	/* \d is een teken in Regular Expression extra \ om \d te kunnen uitvoeren */
	private static final Pattern REGULAR_EXPRESSION = Pattern.compile("^\\d{3}-\\d{7}-\\d{2}$");
	
	
	public Rekening(String rekeningnummer) {
		if (!REGULAR_EXPRESSION.matcher(rekeningnummer).matches()) {
			throw new IllegalArgumentException("Verkeerd formaat");
		}
		long eerste10cijfers = Long.parseLong(rekeningnummer.substring(0, 3)+rekeningnummer.substring(4,11));
		long laatste2cijfers = Long.parseLong(rekeningnummer.substring(12,14));
		long controlegetal = eerste10cijfers % 97;
		if ((controlegetal == 0 && laatste2cijfers != 97) || (controlegetal != 0 && laatste2cijfers != controlegetal)) {
			throw new IllegalArgumentException("Verkeerd controlegetal");
		}
		this.rekeningnummer = rekeningnummer;
		saldo = BigDecimal.ZERO;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	
	public void storten(BigDecimal bedrag) {
		if (bedrag.compareTo(BigDecimal.ZERO)<1) {
			throw new IllegalArgumentException("Het bedrag moet positief zijn.");
		}
		saldo = saldo.add(bedrag);
	}
	
	@Override
	public String toString() {
		return rekeningnummer;
	}
	
	@Override
	public boolean equals (Object object) {
		if (!(object instanceof Rekening)) {
			return false;
		}
		Rekening andereRekening = (Rekening)object;
		return andereRekening.rekeningnummer.equals(rekeningnummer);
	}
	
	@Override
	public int hashCode() {
		return rekeningnummer.hashCode();
	}

}