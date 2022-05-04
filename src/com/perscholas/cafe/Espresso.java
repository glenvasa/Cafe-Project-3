package com.perscholas.cafe;

import java.util.Scanner;

public class Espresso extends Product {
	boolean extraShot;
	boolean macchiato;

	Espresso(String name, double price, String description, boolean extraShot, boolean macchiato) {
		super(name, price, description);
		this.extraShot = extraShot;
		this.macchiato = macchiato;
	}

	Espresso() {
		super("Regular Espresso", 3.80, "Basic but good");
		this.extraShot = false;
		this.macchiato = false;
	}

	public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean isMacchiato() {
		return macchiato;
	}

	public void setMacchiato(boolean macchiato) {
		this.macchiato = macchiato;
	}

	@Override
	double calculateProductSubtotal(int quantity) {
		double extras = 0;
		if (extraShot)
			extras += quantity * 2.00;
		if (macchiato)
			extras += quantity * 1.00;
		return quantity * price + extras;
	}

	@Override
	void addOptions() {
		String addExtraShot;
		String addMacchiato;
		Scanner scan = new Scanner(System.in);

		System.out.println("How many espressos would you like?");
		int numEspressos = scan.nextInt();
		this.setQuantity(numEspressos);

		System.out.println("Would you like an extra shot of espresso? Enter Y or N.");
		addExtraShot = scan.next();

		if (addExtraShot.equals("y")) {
			this.setExtraShot(true);
		}

		System.out.println("Would you like espresso macchiato? Enter Y or N.");
		addMacchiato = scan.next().toLowerCase();

		if (addMacchiato.equals("y")) {
			this.setMacchiato(true);
		}

	}

	@Override
	void printOptions() {
		System.out.printf("Item:\t%s \tPrice: $%.2f \tQty: %d \tSubtotal: $%.2f\n", getName(), getPrice(),
				getQuantity(), calculateProductSubtotal(quantity));
		System.out.printf("\tExtra Shot: %s \tMachiatto: %s\n\n", extraShot ? "Yes (Add $2 per drink)" : "No",
				macchiato ? "Yes (Add $1 per drink)" : "No");
	}

}
