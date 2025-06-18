package algo;

import java.util.Random;

public class RandUtils {

	public static final Random rand = new Random();
	
	public static int randInt(int upper) {
		return rand.nextInt(upper);
	}
	
	
}
