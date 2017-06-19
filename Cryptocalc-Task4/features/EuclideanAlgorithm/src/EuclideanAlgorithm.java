public class EuclideanAlgorithm implements interfaces.Calculation {
	
	public String getName() {
		return "euclidean algorithm";
	}
	
	public void execute() {

		System.out.print("enter first integer: ");
		Integer firstInteger = Cryptocalc.scanner.nextInt();
		System.out.print("enter second integer: ");
		Integer secondInteger = Cryptocalc.scanner.nextInt();

		Integer gcd = euclideanAlgorithm(firstInteger, secondInteger);
		System.out.println("\n\tgcd(" + firstInteger + ", " + secondInteger + ") = " + gcd);
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
}