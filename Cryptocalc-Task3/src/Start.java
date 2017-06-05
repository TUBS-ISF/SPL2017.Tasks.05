import java.util.Scanner;

public class Start {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		printFeatures();
	}

	private static void printFeatures() {

		System.out.println("Enter one of the following letters to start a calculation:");

		// #if FastExponentiation
		System.out.println("\ta\tfast exponentiation");
		// #endif
		// #if EuclideanAlgorithm
		System.out.println("\tb\teuclidean algorithm");
		// #endif
		// #if ExtendedEuclideanAlgorithm
		System.out.println("\tc\textended euclidean algorithm");
		// #endif
		System.out.println("\td\tadd modulo m");
		
		System.out.println("\te\tmultiply modulo m");
		
		System.out.println("\tf\tidea xor");
		
		System.out.println("\tg\tidea addition");
		
		System.out.println("\th\tidea modified multiplication");
		
		System.out.println("\n\tq\tquit");

		String calculation = scanner.next();
		switch (calculation) {
		// #if FastExponentiation
		case "a":
			manageFastExponentiation();
			break;
		// #endif
		// #if EuclideanAlgorithm
		case "b":
			manageEuclideanAlgorithm();
			break;
		// #endif
		// #if ExtendedEuclideanAlgorithm
		case "c":
			manageExtendedEuclideanAlgorithm();
		// #endif
		case "d":
		  manageAdditionModulo();
		case "e":
		  manageMultiplicationModulo();
		case "f":
		  manageIdeaXor();
		case "g":
      manageIdeaAddition();
		case "h":
      manageIdeaMultiplication();
		case "q":
			System.exit(0);
		}
	}

	private static void returnToMenu() {

		System.out.println("\n\npress enter to return to menu");
		scanner.nextLine();
		scanner.nextLine();
		System.out.print("\n\n\n");
		printFeatures();
	}
	
	private static void manageIdeaAddition() {
	  System.out.print("enter first integer: ");
    Integer a = scanner.nextInt();
    System.out.print("enter second integer: ");
    Integer b = scanner.nextInt();
    Integer modulus = 65536;
    
    Integer result = additionModulo(a, b, modulus);
    System.out.println("\n\t" + a + " + " + b + " mod " + modulus + " = " + result);

    System.out.println("\n\t0x" + Integer.toHexString(a).toUpperCase()
        + " + 0x" + Integer.toHexString(b).toUpperCase()
        + " mod 0x" + Integer.toHexString(modulus).toUpperCase()
        + " = 0x" + Integer.toHexString(result).toUpperCase());
    
    returnToMenu();
	}
	
	 private static void manageIdeaMultiplication() {
	    System.out.print("enter first integer: ");
	    Integer a = scanner.nextInt();
	    System.out.print("enter second integer: ");
	    Integer b = scanner.nextInt();
	    Integer modulus = 65536 + 1;
	    
	    if (a == 0)
	      a = 65536;
	    if (b == 0)
	      b = 65536;
	    Integer result = multiplicationModulo(a, b, modulus);
	    if (result == 65536)
	      result = 0;
	    System.out.println("\n\t" + a + " x " + b + " mod " + modulus + " = " + result);

	    System.out.println("\n\t0x" + Integer.toHexString(a).toUpperCase()
	        + " x 0x" + Integer.toHexString(b).toUpperCase()
	        + " mod 0x" + Integer.toHexString(modulus).toUpperCase()
	        + " = 0x" + Integer.toHexString(result).toUpperCase());

	    returnToMenu();
	 }
	 
	  private static void manageIdeaXor() {
	    System.out.print("enter first integer: ");
	    Integer a = scanner.nextInt();
	    System.out.print("enter second integer: ");
	    Integer b = scanner.nextInt();
	    Integer result = a ^ b;
	    System.out.println("\n\t" + a + " xor " + b + " = " + result);

	    System.out.println("\n\t0x" + Integer.toHexString(a).toUpperCase()
	      + " xor 0x" + Integer.toHexString(b).toUpperCase()
	      + " = 0x" + Integer.toHexString(result).toUpperCase());
	    
	    returnToMenu();
	  }
	
	
	private static void manageAdditionModulo() {
	  System.out.print("enter first integer: ");
	  Integer a = scanner.nextInt();
	  System.out.print("enter second integer: ");
    Integer b = scanner.nextInt();
    System.out.print("enter modulus: ");
    Integer modulus = scanner.nextInt();
    
    Integer result = additionModulo(a, b, modulus);
    System.out.println("\n\t" + a + " + " + b + " mod " + modulus + " = " + result);

    returnToMenu();
	}

	private static Integer additionModulo(Integer a, Integer b, Integer modulus) {

	  return (a + b) % modulus;
	}

	private static void manageMultiplicationModulo() {
	  System.out.print("enter first integer: ");
	  Integer a = scanner.nextInt();
	  System.out.print("enter second integer: ");
	  Integer b = scanner.nextInt();
	  System.out.print("enter modulus: ");
	  Integer modulus = scanner.nextInt();

	  Integer result = multiplicationModulo(a, b, modulus);
	  System.out.println("\n\t" + a + " * " + b + " mod " + modulus + " = " + result);

	  returnToMenu();
	}

	private static Integer multiplicationModulo(Integer a, Integer b, Integer modulus) {

	  return (a * b) % modulus;
	}

  // #if FastExponentiation
	private static void manageFastExponentiation() {

		System.out.print("enter base: ");
		Integer base = scanner.nextInt();
		System.out.print("enter exponent: ");
		Integer exponent = scanner.nextInt();
		System.out.print("enter modulus: ");
		Integer modulus = scanner.nextInt();
		
		Integer result = fastExponentiation(base, exponent, modulus);
		System.out.println("\n\t" + base + "^" + exponent + " mod " + modulus + " = " + result);

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
	// #endif

	// #if EuclideanAlgorithm
	private static void manageEuclideanAlgorithm() {

		System.out.print("enter first integer: ");
		Integer firstInteger = scanner.nextInt();
		System.out.print("enter second integer: ");
		Integer secondInteger = scanner.nextInt();

		Integer gcd = euclideanAlgorithm(firstInteger, secondInteger);
		System.out.println("\n\tgcd(" + firstInteger + ", " + secondInteger + ") = " + gcd);

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
	// #endif
	
	// #if ExtendedEuclideanAlgorithm
	private static void manageExtendedEuclideanAlgorithm() {
	
		System.out.print("enter first integer: ");
		Integer firstInteger = scanner.nextInt();
		System.out.print("enter second integer: ");
		Integer secondInteger = scanner.nextInt();
		System.out.println();

		TripleOfIntegers result = extendedEuclideanAlgorithmRecursive(firstInteger, secondInteger);
		// #if ShowResultOnly
//@		System.out.println("\tgcd(" + firstInteger + ", " + secondInteger + ") = "
//@		+ result.s + " * " + firstInteger + " + " + result.t + " * " + secondInteger
//@		+ " = " + result.d);
		// #endif

		returnToMenu();
	}
	
	private static TripleOfIntegers extendedEuclideanAlgorithmRecursive(Integer a, Integer b) {
		if (b==0) {
			return new TripleOfIntegers(a, 1, 0);
		}
		// #if ShowExtendedSolution
		System.out.println("\t" + a + " mod " + b + " = " + a % b);
		// #endif
		TripleOfIntegers triple = extendedEuclideanAlgorithmRecursive(b, a % b);
		int t = triple.s - a / b * triple.t;
		triple.s = triple.t;
		triple.t = t;
		// #if ShowExtendedSolution
		System.out.println("\t" + triple.d + " = " + triple.s + " * " + a + " + " + triple.t + " * " + b);
		// #endif
		return triple;
	}
	// #endif

}

// #if ExtendedEuclideanAlgorithm
class TripleOfIntegers {
	
	public int d, s, t;
	
	public TripleOfIntegers(int d, int s, int t) {
		this.d = d;
		this.s = s;
		this.t = t;
	}
}
// #endif
