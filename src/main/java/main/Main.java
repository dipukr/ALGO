package main;

import java.util.OptionalInt;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws Exception {
		Streams algo = new Streams();
		Integer a = Integer.valueOf(4378);
		Integer b = Integer.valueOf(4178);
		Stream.of(a, b).mapToInt(e -> e).max().ifPresent(System.out::println);
		
	}
}
