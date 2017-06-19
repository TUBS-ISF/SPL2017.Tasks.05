public class FastExponentiation implements interfaces.Calculation {
	
	public String getName() {
		return "fast exponentiation";
	}
	
	public void execute() {

		System.out.print("enter base: ");
		Integer base = Cryptocalc.scanner.nextInt();
		System.out.print("enter exponent: ");
		Integer exponent = Cryptocalc.scanner.nextInt();
		System.out.print("enter modulus: ");
		Integer modulus = Cryptocalc.scanner.nextInt();
		
		Integer result = fastExponentiation(base, exponent, modulus);
		System.out.println("\n\t" + base + "^" + exponent + " mod " + modulus + " = " + result);
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
}