
public aspect Iterative {

	pointcut p1(): set(TripleOfIntegers ExtendedEuclideanAlgorithm.result)
	&& within(ExtendedEuclideanAlgorithm);
	
	after(): p1() {
		ExtendedEuclideanAlgorithm.result = iterative(ExtendedEuclideanAlgorithm.result.d, ExtendedEuclideanAlgorithm.result.s);
	}
	
	// vgl. Heiss
	public static TripleOfIntegers iterative(Integer a, Integer b) {
		int[] x = {1, 0, a};
		int[] y = {0, 1, b};
		
		while(y[2] != 0){

			int q = x[2] / y[2];
			int[] t = new int[3];
			for (int i = 0; i < 3; i++) {
				t[i] = x[i] - q*y[i];
			}
			x = y;
			//System.out.println(x[0] + "\t" + x[1] + "\t" + x[2]);
			y = t;
		}
		return new TripleOfIntegers(x[2], x[0], x[1]);
	}
}
