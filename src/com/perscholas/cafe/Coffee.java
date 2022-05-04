package com.perscholas.cafe;

import java.util.Scanner;

public class Coffee extends Product {

	private boolean sugar;
	private boolean milk;

	Coffee(String name, double price, String description, boolean sugar, boolean milk) {
		super(name, price, description);
		this.sugar = sugar;
		this.milk = milk;
	}

	Coffee() {
		super("Regular Coffee", 2.70, "Basic but good");
		this.sugar = false;
		this.milk = false;
	}

	public boolean isSugar() {
		return sugar;
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	@Override
	double calculateProductSubtotal(int quantity) {
		return quantity * price;
	}

	@Override
	void addOptions() {
		String addMilk;
		String addSugar;
		Scanner scan = new Scanner(System.in);

		System.out.println("How many coffees would you like?");
		int numCoffees = scan.nextInt();
		this.setQuantity(numCoffees);

		System.out.println("Would you like milk with your coffee? Enter Y or N.");
		addMilk = scan.next();

		if (addMilk.equals("y")) {
			this.setMilk(true);
		}

		System.out.println("Would you like sugar with your coffee? Enter Y or N.");
		addSugar = scan.next().toLowerCase();

		if (addSugar.equals("y")) {
			this.setSugar(true);
		}

	}

	@Override
	void printOptions() {
		System.out.printf("Item:\t%s \tPrice: $%.2f \tQty: %d \tSubtotal: $%.2f\n", getName(), getPrice(),
				getQuantity(), calculateProductSubtotal(quantity));
		System.out.printf("\tSugar: %s \tMilk: %s\n\n", sugar ? "Yes" : "No", milk ? "Yes" : "No");
	}

}