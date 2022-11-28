package com.perscholas.java_basics;

public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] binaries = { "0010", "1001", "00110100", "01110010", "001000011111", "0010110001100111" };
		for (int index = 0; index < binaries.length; index++) {
			String binnum = binaries[index];
			int res = 0;
			for (int i = 0; i < binnum.length(); i++) {
				char bin = binnum.charAt(binnum.length() - (i + 1));
				if (bin == '1') {
					int placeVal = 1;
					for (int j = 0; j < i; j++) {
						placeVal = placeVal * 2;
					}
					res = res + placeVal;
				}

			}
			System.out.println("Decimal of "+binaries[index]+" is: "+res);
		}
	}

}
