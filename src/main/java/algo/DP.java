package algo;

import java.util.Arrays;

public class DP {

	public int fib(int n, int[] cache) {
		if (cache[n] != 0) return cache[n];
		cache[n] = fib(n - 2, cache) + fib(n - 1, cache);
		return cache[n];
	}
	
	public int nSum(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++)
			dp[i] = dp[i - 1] + i;
		return dp[n];
	}
	
	public int nSum(int n, int[] cache) {
		if (n == 1) return 1;
		if (cache[n] != 0) return cache[n];
		cache[n] = nSum(n - 1, cache) + n;
		return cache[n];
	}
	
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
	
	public int minCoins(int[] coins, int target) {
		if (target == 0) return 0;
		int minVal = Integer.MAX_VALUE;
		for (int coin: coins) {
			if (target - coin >= 0) {
				int subMinVal = minCoins(coins, target - coin);
				if (subMinVal + 1 < minVal) {
					minVal = subMinVal + 1;
				}
			}
		}
		return minVal;
	}

	public int minCoins(int[] coins, int target, int[] cache) {
		if (target <= 0) return 0;
		if (cache[target] != -1) return cache[target];
		int minVal = Integer.MAX_VALUE;
		for (int coin: coins) {
			if (target - coin >= 0) {
				int subMinVal = minCoins(coins, target - coin, cache);
				minVal = Math.min(subMinVal, minVal);
			}
		}
		return cache[target] = minVal + 1;
	}
	
	public static void main(final String[] args) {
		var dp = new DP();
		//System.out.println(dp.climbStairs(3));
		int[] cache = new int[19];
		Arrays.fill(cache, -1);
		cache[0] = 0;
		System.out.println(dp.minCoins(new int[] {7, 5, 1}, 18, cache));
	}
}
