package be.vdab.entities;

import java.math.BigDecimal;

public class Rekening {
	private BigDecimal saldo;

	public void storten(BigDecimal bedrag) {
		saldo = saldo.add(bedrag);
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
}