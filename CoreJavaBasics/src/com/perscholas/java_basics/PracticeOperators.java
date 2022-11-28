package com.perscholas.java_basics;

public class PracticeOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10,b=3,c,x=5,y=6, q=y/x,r=35;
	    final double PI=3.14;//declaring a constant
		double i=10.0,j=3.0,z;
		c=a+b; //assigning 2 integers to an integer
		
		//printing integer value
		System.out.println("Addition of two integer numbers is an Integer:"+c);
		
		z=i+j;//assigning addition of double to double.
		//printing double value
		System.out.println("Addition of two double numbers is Double:"+z);
		
		//printing addition of double and int
		System.out.println("Addition of double and int numbers is Double:"+(i+a));
		
		//printing division of 2 integers
		System.out.println("Division of two integers is:"+(a/b));
		
		//casting int to double 
		double f=(double) (i/b);
		
		//printing casting value
		System.out.println("Division of decimal and integer is:"+f);
		
		//printing division of 2 double values
		System.out.println("Division of two doubles is Double:"+(i/j));
		
		//casting and printing double to integer
		System.out.println("Casting the division of two doubles to Integer:"+(int)(i/j));
		
		//casting and printing the double division 
		System.out.println("printing q value:"+q);
		System.out.println("Printing q value casting to double:"+((double)(y)/x));
		
		//calculating and printing using the constant value
		System.out.println("Area of circle with radius "+r +" is:"+(PI*r*r));
	}

}
