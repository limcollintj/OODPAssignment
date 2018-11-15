package util;

import java.util.Scanner;

public class Scan {
	/**
	 * Reads input integer
	 * @return read integer
	 */
	public static int readInteger() {
		Scanner sc = new Scanner(System.in);
		while(!sc.hasNextInt()) {
			sc.nextLine();
			System.out.print("Please enter an integer: ");
		}
		return sc.nextInt();
	}

	/**
	 * Reads input double
	 * @return read double
	 */
	
	public static double readDouble() {
		Scanner sc = new Scanner(System.in);
		while(!sc.hasNextDouble()) {
			sc.nextLine();
			System.out.print("Please enter a double: ");
		}
		return sc.nextDouble();
	}

	/**
	 * Reads input string
	 * @return read string
	 */
	
	public static String readString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
}
