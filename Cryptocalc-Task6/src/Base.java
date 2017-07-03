import java.util.Scanner;

public class Base {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		askForFeature();
	}
	
	public static void printFeatures() {
		
		System.out.println("Enter one of the following numbers to start a calculation:");
	}
	
	public static int feature;
	
	public static void askForFeature() {

		printFeatures();
		
		System.out.println("\n\t0\tquit");

		feature = scanner.nextInt();
		if (feature == 0) {
			System.exit(1);
		}
		returnToMenu();
	}
	
	public static void returnToMenu() {

		System.out.println("\n\npress enter to return to menu");
		scanner.nextLine();
		scanner.nextLine();
		System.out.print("\n\n\n");
		askForFeature();
	}
}
