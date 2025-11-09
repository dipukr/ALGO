package main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Employee(String name, int age, int sal) {}
 
public class Streams {
	public String reverseWords(String sentence) {
		return Stream.of(sentence.split(" "))
			.map(word -> new StringBuilder(word).reverse().toString())
			.collect(Collectors.joining(" "));
	}
	
	public int sumDigits(int number) {
		return String.valueOf(number).chars()
			.map(Character::getNumericValue)
			.sum();
	}
	
	public int nthLargestNumber(List<Integer> numbers, int n) {
		return numbers.stream()
			.distinct()
			.sorted(Comparator.reverseOrder())
			.skip(n - 1)
			.findFirst().orElse(0);
	}
	
	public Map<Character, Long> charsFrequency(String data) {
		return data.chars().mapToObj(c -> (char) c)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	public Map<String, Long> strsFrequency(List<String> strs) {
		return strs.stream()
			.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}











