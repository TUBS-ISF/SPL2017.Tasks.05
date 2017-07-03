
public aspect FastExponentiation {

	//declare precedence: FastExponentiation, *; 
	private int id = 1;
	private String name = "fast exponentiation";

	after(): execution(void Base.printFeatures()) {
		System.out.println("\t" + id + "\t" + name);
	}
	
	after(): set(int Base.feature) {
		if (Base.feature == id)
			manageFastExponentiation();
	}	
	
	private static void manageFastExponentiation() {

		System.out.print("enter base: ");
		Integer base = Base.scanner.nextInt();
		System.out.print("enter exponent: ");
		Integer exponent = Base.scanner.nextInt();
		System.out.print("enter modulus: ");
		Integer modulus = Base.scanner.nextInt();
		
		Integer result = fastExponentiation(base, exponent, modulus);
		System.out.println("\n\t" + base + "^" + exponent + " mod " + modulus + " = " + result);
		
	}

	public static Integer fastExponentiation(Integer base, Integer exponent, Integer modulus) {

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

}