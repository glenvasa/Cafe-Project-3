package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private static List<Product> cart = new ArrayList<>();
	static double purchaseSubtotal;

	public static List<Product> getCart() {
		return cart;
	}

	public static void addToCart(Product product) {
		cart.add(product);
	}

	public static void checkout() {

		getCart().forEach(p -> {
			p.printOptions();
			purchaseSubtotal += p.calculateProductSubtotal(p.quantity);
		});

		System.out.printf("Purchase Subtotal: $%.2f\n", purchaseSubtotal);
		System.out.printf("Sales Tax: $%.2f\n", .0625 * purchaseSubtotal);
		System.out.printf("Purchase Total: $%.2f\n", 1.0625 * purchaseSubtotal);

	}

}
