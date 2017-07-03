
public aspect Recursive {

	pointcut p1(): set(TripleOfIntegers ExtendedEuclideanAlgorithm.result)
	&& within(ExtendedEuclideanAlgorithm);
	
	after(): p1() {
		ExtendedEuclideanAlgorithm.result = recursive(ExtendedEuclideanAlgorithm.result.d, ExtendedEuclideanAlgorithm.result.s);
	}
	
	public static TripleOfIntegers recursive(int a, int b) {
		if (b == 0) {
			return new TripleOfIntegers(a, 1, 0);
		}

		System.out.println("\t" + a + " mod " + b + " = " + a % b);

		TripleOfIntegers triple = recursive(b, a % b);
		int t = triple.s - a / b * triple.t;
		triple.s = triple.t;
		triple.t = t;

		System.out.println("\t" + triple.d + " = " + triple.s + " * " + a + " + " + triple.t + " * " + b);

		return triple;
	}
}
