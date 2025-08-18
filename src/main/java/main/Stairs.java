package main;

public class Stairs {
	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}
	
	public int climbStairs(int n, int[] cache) {
		if (n < 2) return 1;
		if (cache[n] != 0) return cache[n];
		return cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
	}
}
