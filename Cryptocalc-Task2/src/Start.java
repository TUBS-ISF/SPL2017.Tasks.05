import java.util.Scanner;

import properties.PropertyManager;

public class Start {

	public static void main(String[] args) {

		printFeatures();
	}

	private static void printFeatures() {

		System.out.println("Enter one of the following letters to start a calculation:");

		if (PropertyManager.getProperty("FastExponentiation"))
			System.out.println("\ta\tfast exponentiation");
		if (PropertyManager.getProperty("EuclideanAlgorithm"))
			System.out.println("\tb\teuclidean algorithm");
		System.out.println("\tq\tquit");
		
		String calculation = new Scanner(System.in).next();
		switch (calculation) {
		case "a":
			manageFastExponentiation();
			break;
		case "b":
			manageEuclideanAlgorithm();
			break;
		case "q":
			System.exit(0);
		}
	}

	private static void returnToMenu() {
		
		System.out.println("\n\npress enter to return to menu");
		String input = new Scanner(System.in).nextLine();
		System.out.print("\n\n\n");
		printFeatures();
	}

	private static void manageFastExponentiation() {

		if (PropertyManager.getProperty("FastExponentiation")) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("enter base: ");
			Integer base = scanner.nextInt();
			System.out.print("enter exponent: ");
			Integer exponent = scanner.nextInt();
			System.out.print("enter modulus: ");
			Integer modulus = scanner.nextInt();

			Integer result = fastExponentiation(base, exponent, modulus);
			System.out.println("\n\t" + base + "^" + exponent + " mod " + modulus + " = " + result);
		} else {
			System.out.println("This feature is not available!");
		}

		returnToMenu();
	}


	private static Integer fastExponentiation(Integer base, Integer exponent, Integer modulus) {
	
		Integer result = 1;
	    while(exponent != 0) {
	        while(exponent % 2 == 0) {
	            exponent = exponent/2;
	            base = base*base % modulus;
	        }
	        exponent = exponent-1;
	        result = result*base % modulus;
	    }
		return result;
	}
	
	private static void manageEuclideanAlgorithm() {
		
		if (PropertyManager.getProperty("EuclideanAlgorithm")) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("enter first integer: ");
			Integer firstInteger = scanner.nextInt();
			System.out.print("enter second integer: ");
			Integer secondInteger = scanner.nextInt();
			
			Integer gcd = euclideanAlgorithm(firstInteger, secondInteger);
			System.out.println("\n\tgcd(" + firstInteger + ", " + secondInteger + ") = " + gcd);
		} else {
			System.out.println("This feature is not available!");
		}
		returnToMenu();
	}
	
	private static Integer euclideanAlgorithm(Integer a, Integer b) {
		
		Integer h;
		while (b != 0) {
			h = a % b;
			a = b;
			b = h;
		}
		return a;
	}

}
