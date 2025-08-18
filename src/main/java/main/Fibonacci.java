package main;

public class Fibonacci {
	public int fibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public int fibonacci(int n, int[] cache) {
		if (cache[n] != -1) return cache[n];
		cache[n] = fibonacci(n - 2, cache) + fibonacci(n - 1, cache);
		return cache[n];
	}
}
