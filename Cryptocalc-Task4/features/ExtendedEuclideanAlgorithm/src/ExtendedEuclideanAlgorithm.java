import tripleOfIntegers.TripleOfIntegers;

public class ExtendedEuclideanAlgorithm implements interfaces.Calculation {
	
	public String getName() {
		return "extended euclidean algorithm";
	}
	
	public void execute() {
		
		System.out.print("enter first integer: ");
		Integer firstInteger = Cryptocalc.scanner.nextInt();
		System.out.print("enter second integer: ");
		Integer secondInteger = Cryptocalc.scanner.nextInt();
		System.out.println();

		
		
		TripleOfIntegers result;
		System.out.println(Cryptocalc.eeaPlugins.size());

		if (Cryptocalc.eeaPlugins.get(0).getName() == "recursive") {
			result = Cryptocalc.eeaPlugins.get(0).execute(firstInteger, secondInteger);
		} else {
			result = null;
		}
		
		System.out.println("\tgcd(" + firstInteger + ", " + secondInteger + ") = "
		+ result.s + " * " + firstInteger + " + " + result.t + " * " + secondInteger
		+ " = " + result.d);
	}
	
}