package be.vdab.entities;

import java.math.BigDecimal;

public class Rekening {
	private String rekeningnummer;
	private BigDecimal saldo;
	
	public Rekening() {
		saldo = BigDecimal.ZERO;
	}
	
	public Rekening(String rekeningnummer){
		this.rekeningnummer = rekeningnummer;
		saldo = BigDecimal.ZERO;
	}

	public void storten(BigDecimal bedrag) {
		if (bedrag.compareTo(BigDecimal.ZERO)<1) {
			throw new IllegalArgumentException("Het bedrag moet positief zijn.");
		}
		saldo = saldo.add(bedrag);
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
}