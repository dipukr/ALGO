package main;

import java.util.Random;

public class Tools {
	
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
	
	public static void draw(byte[][] maze) {
		int rows = maze.length;
		int cols = maze[0].length;
		int max = 0;
		for (byte[] r: maze)
			for (byte v: r)
				max = Math.max(max, v);
		int cellW = Math.max(1, String.valueOf(max).length());
		String horiz = "+" + "-".repeat(cellW + 2);
		String rowSep = horiz.repeat(cols) + "+";
		System.out.println(rowSep);
		for (int i = 0; i < rows; i++) {
			var line = new StringBuilder();
			for (int j = 0; j < cols; j++) {
				String s = (maze[i][j] == 0) ? "" : Byte.toString(maze[i][j]);
				line.append("| ").append(padLeft(s, cellW)).append(" ");
			}
			line.append("|");
			System.out.println(line);
			System.out.println(rowSep);
		}
	}

	public static String padLeft(String s, int width) {
		int pad = width - s.length();
		return (pad <= 0) ? s : 
			" ".repeat(pad) + s;
	}
}
