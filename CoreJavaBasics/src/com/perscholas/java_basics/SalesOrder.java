package com.perscholas.java_basics;

public class SalesOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declaring the product variables
		int coffee=2,cappucino=4,greentea=4,espresso=3;
		double subtotal,totalSale;
		final double SALESTAX=6;
		
		/*calculating order” for 3 items of the first product, 
		4 items of the second product, 
		and 2 items of the third product
		and assigning to subtotal
		*/
		subtotal=(3*coffee)+(4*cappucino)+(2*greentea);
		
		
		// calculating totalSale
		totalSale=subtotal+(subtotal*(SALESTAX/100));
		
		//printing the totalSale in format 2 decimal places
		System.out.printf("Total Sale amount to pay :%.02f", + totalSale);
		
	}

}
