import tripleOfIntegers.TripleOfIntegers;

public class ExtendedEuclideanAlgorithmRecursive implements interfaces.EEAImplementation {
	
	public TripleOfIntegers execute(int a, int b) {
		if (b==0) {
			return new TripleOfIntegers(a, 1, 0);
		}
		System.out.println("\t" + a + " mod " + b + " = " + a % b);
		TripleOfIntegers triple = execute(b, a % b);
		int t = triple.s - a / b * triple.t;
		triple.s = triple.t;
		triple.t = t;
		System.out.println("\t" + triple.d + " = " + triple.s + " * " + a + " + " + triple.t + " * " + b);
		return triple;
	}
	
	public String getName() {
		return "recursive";
	}
}