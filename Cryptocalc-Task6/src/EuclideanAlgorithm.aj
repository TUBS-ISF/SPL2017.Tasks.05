
public aspect EuclideanAlgorithm {
	
	private int id = 2;
	private String name = "euclidiean algorithm";

	after(): execution(void Base.printFeatures()) {
		System.out.println("\t" + id + "\t" + name);
	}
	
	after(): set(int Base.feature) {
		if (Base.feature == id)
			manageEuclideanAlgorithm();
	}
	
	private static void manageEuclideanAlgorithm() {

		System.out.print("enter first integer: ");
		Integer firstInteger = Base.scanner.nextInt();
		System.out.print("enter second integer: ");
		Integer secondInteger = Base.scanner.nextInt();

		Integer gcd = euclideanAlgorithm(firstInteger, secondInteger);
		System.out.println("\n\tgcd(" + firstInteger + ", " + secondInteger + ") = " + gcd);

	}

	public static Integer euclideanAlgorithm(Integer a, Integer b) {

		Integer h;
		while (b != 0) {
			h = a % b;
			a = b;
			b = h;
		}
		return a;
	}
}
