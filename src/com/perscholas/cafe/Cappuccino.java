package com.perscholas.cafe;

import java.util.Scanner;

public class Cappuccino extends Product {

	boolean peppermint;
	boolean whippedCream;

	Cappuccino(String name, double price, String description, boolean peppermint, boolean whippedCream) {
		super(name, price, description);
		this.peppermint = peppermint;
		this.whippedCream = whippedCream;
	}

	Cappuccino() {
		super("Regular Cappuccino", 4.50, "Basic but good");
		this.peppermint = false;
		this.whippedCream = false;
	}

	public boolean isPeppermint() {
		return peppermint;
	}

	public void setPeppermint(boolean peppermint) {
		this.peppermint = peppermint;
	}

	public boolean isWhippedCream() {
		return whippedCream;
	}

	public void setWhippedCream(boolean whippedCream) {
		this.whippedCream = whippedCream;
	}

	@Override
	double calculateProductSubtotal(int quantity) {
		double extras = 0;
		if (peppermint)
			extras += quantity * 2.00;
		if (whippedCream)
			extras += quantity * 1.00;
		return price * quantity + extras;
	}

	@Override
	void addOptions() {
		String addPeppermint;
		String addWhippedCream;
		Scanner scan = new Scanner(System.in);

		System.out.println("How many cappuccinos would you like?");
		int numCappucinos = scan.nextInt();
		this.setQuantity(numCappucinos);

		System.out.println("Would you like peppermint with your cappuccino? Enter Y or N.");
		addPeppermint = scan.next();

		if (addPeppermint.equals("y")) {
			this.setPeppermint(true);
		}

		System.out.println("Would you like whipped cream with your cappuccino? Enter Y or N.");
		addWhippedCream = scan.next().toLowerCase();

		if (addWhippedCream.equals("y")) {
			this.setWhippedCream(true);
		}

	}

	@Override
	void printOptions() {
		System.out.printf("Item:\t%s \tPrice: $%.2f \tQty: %d \tSubtotal: $%.2f\n", getName(), getPrice(),
				getQuantity(), calculateProductSubtotal(quantity));
		System.out.printf("\tPeppermint: %s \tWhipped Cream: %s\n\n", peppermint ? "Yes (Add $2 per drink)" : "No",
				whippedCream ? "Yes (Add $1 per drink)" : "No");
	}

}
