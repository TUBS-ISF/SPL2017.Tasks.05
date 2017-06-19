
import java.security.SecureRandom;

public class Random implements interfaces.Calculation{
	
	public String getName() {
		return "random number generator";
	}
	
	public void execute() {
		System.out.println("Random: " + createTwoDigitRandom());
	}

	public static int createTwoDigitRandom() {
		int r = new SecureRandom().nextInt() % 100;
		if(r < 0)
			return r + 100;
		return r;
	}
}