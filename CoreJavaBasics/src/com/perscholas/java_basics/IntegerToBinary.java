package com.perscholas.java_basics;

public class IntegerToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ints[] = { 1, 8, 33, 78, 787, 33987 };
		for (int i = 0; i < ints.length; i++) {
			String res = "";
			int x = ints[i];
			while (x != 0) {
				res = (x % 2) + res;
				x = x / 2;
			}
			System.out.println("Binary Value of " + ints[i] + " is: " + res);
		}
	}

}
