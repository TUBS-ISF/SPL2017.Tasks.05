import java.security.SecureRandom;

public aspect RandomNumberGenerator {

	private int id = 3;
	private String name = "Random number generator";

	after(): execution(void Base.printFeatures()) {
		System.out.println("\t" + id + "\t" + name);
	}
	
	after(): set(int Base.feature) {
		if (Base.feature == id) {
			int r = createTwoDigitRandom();
			System.out.println("Random " + r);
		}
	}
	
	public static int createTwoDigitRandom() {
		int r = new SecureRandom().nextInt() % 100;
		if(r < 0)
			return r + 100;
		return r;
	}
}
