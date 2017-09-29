package hello;

import java.util.*;

public class Hello {
	
	
	public static int sumOfOdd(long n) {
		
		if (n<10) {
			return (int) n;
		}
		else {
			int a = (int) (n%10);
			n = n/100;
			return a+sumOfOdd(n);
		}
	}
	
	public static int sumOfDouble(long n) {
		
		if (n<10) {
			return 0;
		}
		else {
			long a = n/10;
			int b =(int) (2*(a%10));
			int c = (int) ( getDigit(b) );
			n = n/100;
			return c+sumOfDouble(n);
		}
	}
	
	public static int getDigit(int a) {
		// to get the result in single digit 
		// even if the number has two digits.
		if (a<10) {
			return a;
		}
		else {
			int b = a/10;
			return b+getDigit(a%10);
		}
	} 
	
	
	public static int getLength(long a) {
		// to get the number of digits
		if (a>0) {
			return 1+getLength(a/10);
		}
		else {
			return 0;
		}
	}
	
	public static long getPrefix(long a, int k) {
		// return the first k digits of the number 
		// which is the beginning one or two digits 
		// of card number.
		//if the first k digits
		if (getLength(a) <= k) {
			return a;
		}
		else {
			return getPrefix(a/10,k);
		}
	}
	
	
	public static void main(String[] args) {
		
		//ask user to enter credit card number. 
		//
		Scanner enter=new Scanner(System.in); //use Scanner class   
		System.out.println("please enter your credit card number");
	    long a=enter.nextLong(); //user input the long type data  
		System.out.println("Your card number is: "+a);
		long firstOneDigit = getPrefix(a,1);
		long firstTwoDigits = getPrefix(a,2);		
		
		int sum = sumOfOdd(a) + sumOfDouble(a);
		int i = sum%10;
		if(i==0) {
			if (firstOneDigit==4) {
				System.out.println("the first digit is "+firstOneDigit+", Visa card.");
				System.out.println(" It is Valid!");
			}
			
			
			else if (firstOneDigit==5) {
				System.out.println("the first digit is "+firstOneDigit+", Master card.");
				System.out.println(" It is Valid!");
			}
			
			
			else if (firstOneDigit==6) {
				System.out.println("the first digit is "+firstOneDigit+", Discover card.");
				System.out.println(" It is Valid!");
			}
			
			
			else if (firstOneDigit==3){
				if (firstTwoDigits==37) {
					System.out.println("the first two digits are "+firstTwoDigits+", American Express card.");
					System.out.println(" It is Valid!");
				}
				else {
					System.out.println("Invalid card!!!");
				}
			}
			
			
			else {
				System.out.println("Invalid card!!!");
			}
		}
		
		else {
			System.out.println("It is NOT Valid!");
		}

	}

}