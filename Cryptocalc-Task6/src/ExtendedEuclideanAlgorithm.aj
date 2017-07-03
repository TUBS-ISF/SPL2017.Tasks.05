
public aspect ExtendedEuclideanAlgorithm {

	private int id = 4;
	private String name = "eea";

	after(): execution(void Base.printFeatures()) {
		System.out.println("\t" + id + "\t" + name);
	}
	
	after(): set(int Base.feature) {
		if (Base.feature == id)
			manageExtendedEuclideanAlgorithm();
	}
	public static TripleOfIntegers result;
	private static void manageExtendedEuclideanAlgorithm() {
		
		System.out.print("enter first integer: ");
		Integer firstInteger = Base.scanner.nextInt();
		System.out.print("enter second integer: ");
		Integer secondInteger = Base.scanner.nextInt();
		System.out.println();

		result = new TripleOfIntegers(firstInteger, secondInteger, 1);
		
		System.out.println("\tgcd(" + firstInteger + ", " + secondInteger + ") = "
		+ result.s + " * " + firstInteger + " + " + result.t + " * " + secondInteger
		+ " = " + result.d);
	}
}
