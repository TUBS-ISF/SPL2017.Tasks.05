
public aspect RSAEncryption {
	
	private int id = 5;
	private String name = "RSA encryption";

	after(): execution(void Base.printFeatures()) {
		System.out.println("\t" + id + "\t" + name);
	}
	
	after(): set(int Base.feature) {
		if (Base.feature == id)
			manage();
	}	
	
	private static void manage() {

		System.out.print("enter message: ");
		Integer message = Base.scanner.nextInt();
		System.out.print("enter public key: ");
		Integer publicKey = Base.scanner.nextInt();
		System.out.print("enter modulus: ");
		Integer modulus = Base.scanner.nextInt();
		
		Integer result = FastExponentiation.fastExponentiation(message, publicKey, modulus);
		System.out.println("\n\t" + message + "^" + publicKey + " mod " + modulus + " = " + result);
		
	}
}
