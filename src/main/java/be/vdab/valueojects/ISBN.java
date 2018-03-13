package be.vdab.valueojects;

import java.util.Arrays;
import java.util.List;

public class ISBN {
	private final long nummer;
	private static final long ONDERGRENS = (long)Math.pow(10, 12);
	private static final long BOVENGRENS = (long)Math.pow(10, 13)-1;
	private static final List<Integer> LIJST_MET_MOGELIJKE_EERSTE_DRIE_CIJFERS = Arrays.asList(978,979);
	
	public ISBN(long nummer) {
		// DEEL 1: controle aantal cijfers
		if (nummer < ONDERGRENS || nummer > BOVENGRENS) {
			throw new IllegalArgumentException("ISBN moet een positief getal zijn met 13 cijfers.");
		}
		// DEEL 2: controle eerste drie cijfers
		int eersteDrieCijfers = (int)(nummer/Math.pow(10, 10));
		if (!LIJST_MET_MOGELIJKE_EERSTE_DRIE_CIJFERS.contains(eersteDrieCijfers)) {
			throw new IllegalArgumentException("ISBN moet beginnen met de cijfers 978 of 979.");
		}
		// DEEL 3: controle laatste cijfer
		long somEvenCijfers = 0;
		long somOnevenCijfers = 0;
		long teVerwerkenCijfers = nummer/10;
		for (int i = 0 ; i != 6 ; i++) {
			somEvenCijfers += teVerwerkenCijfers%10;
			teVerwerkenCijfers /= 10;
			somOnevenCijfers += teVerwerkenCijfers%10;
			teVerwerkenCijfers /= 10;
		}
		long controleSom = somEvenCijfers * 3 + somOnevenCijfers;
		long controleCijfer = (controleSom%10 == 0) ? 0 : 10 - controleSom%10;
		long laatsteCijfer = nummer%10;
		if (controleCijfer != laatsteCijfer) {
			throw new IllegalArgumentException("Het laatste cijfer komt niet overeen met het controlegetal.");
		}
		this.nummer = nummer; 
	}
	
	@Override
	public String toString() {
		return String.valueOf(nummer);
	}

}
