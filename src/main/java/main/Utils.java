package main;

import java.util.Random;

public class Utils {
	
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static final Random rand = new Random();
	
	public static int randInt(int bound) {
		return rand.nextInt(bound);
	}
	
	public static int randInt(int origin, int bound) {
		return rand.nextInt(origin, bound);
	}
	
	public static String randStr(int len) {
		var sb = new StringBuilder();
		for (int i = 0; i < len; i++)
			sb.append(ALPHABET.charAt(randInt(ALPHABET.length())));
		return sb.toString();
	}
}
