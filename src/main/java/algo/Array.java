package algo;

import java.util.Arrays;
import java.util.Random;

public class Array {
	
	public void printArray(int[] data, int low, int high) {
		System.out.print("[");
		for (int i = low; i <= high; i++) {
			if (i > low) System.out.print(",");
			System.out.printf("%d", data[i]);
		}
		System.out.println("]");
	}
	
	public void printArray(int[] data) {
		printArray(data, 0, data.length - 1);
	}
	
	public int sumArray(int[] data, int lower, int upper) {
		int sum = 0;
		for (int i = lower; i <= upper; i++)
			sum += data[i];
		return sum;
	}
	
	public int sumArray(int[] data) {
		return sumArray(data, 0, data.length - 1);
	}
	
	public void printSubarray(int[] data) {
		for (int i = 0; i < data.length; i++)
			for (int j = i; j < data.length; j++)
				printArray(data, i, j);
	}
	
	public int sumSubarrays(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++)
			for (int j = i; j < data.length; j++)
				sum += sumArray(data, i, j);
		return sum;
	}
	
	public int maxSubarraySum(int[] data) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < data.length; i++)
			for (int j = i; j < data.length; j++)
				maxSum = Math.max(maxSum, sumArray(data, i, j));
		return maxSum;
	}
	
	public int maxSubarraySumDP(int[] data) {
		int maxSum = Integer.MIN_VALUE;
		int[] cache = new int[data.length];
		cache[0] = data[0];
		for (int i = 1; i < data.length; i++)
			cache[i] = cache[i - 1] + data[i];
		for (int i = 0; i < data.length; i++) {
			for (int j = i; j < data.length; j++) {
				int sum = cache[j] - (i == 0 ? 0 : cache[i - 1]);
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}
	
	public int maxSubarraySumSW(int[] data) {
		int[] sum = new int[data.length];
		sum[0] = data[0];
		for (int i = 1; i < data.length; i++)
			sum[i] = sum[i - 1] + data[i];
		int low = 0;
		int high = data.length - 1;
		int max = Integer.MIN_VALUE;
		while (low < high) {
			int r = sum[high] - (low == 0 ? 0 : sum[low - 1]);
			int l = r - data[low];
			int h = r - data[high];
			if (l > h) {
				low++;
				max = Math.max(max, l);
			} else {
				high--;
				max = Math.max(max, h);
			}
		}
		return max;
	}
	
	public int maxSubarraySumSW2(int[] data) {
		int[] sum = getPrefixSum(data);
		int low = 0;
		int high = data.length - 1;
		int max = Integer.MIN_VALUE;
		while (low < high) {
			int wsum = sum[high] - (low == 0 ? 0 : sum[low - 1]);
			int lsum = wsum - data[low];
			int hsum = wsum - data[high];
			if (lsum > hsum) {
				low += 1;
				max = Math.max(max, lsum);
			} else {
				high -= 1;
				max = Math.max(max, hsum);
			}
		}
		return max;
	}
	
	public int[] getPrefixSum(int[] data) {
		int[] sum = new int[data.length];
		sum[0] = data[0];
		for (int i = 1; i < data.length; i++)
			sum[i] = sum[i - 1] + data[i];
		return sum;
	}

	public int[] reverse(int[] data) {
		int[] result = new int[data.length];
		for (int i = 0; i < data.length; i++)
			result[i] = data[data.length - i - 1];
		return result;
	}
	
	public void reverseTP(int[] data) {
		int first = 0;
		int second = data.length - 1; 
		while (first <= second) {
			int saved = data[first];
			data[first] = data[second];
			data[second] = saved;
			first++;
			second--;
		}
	}
	
	public int maxSumPair(int[] data) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++)
				maxSum = Math.max(maxSum, data[i] + data[j]);
		return maxSum;
	}
	
	public void shuffle(int[] data) {
		var rand = new Random();
		for (int i = 0; i < data.length; i++) {
			int j = rand.nextInt(data.length);
			int saved = data[i];
			data[i] = data[j];
			data[j] = saved;
		}
	}
	
	public boolean hasDuplicates(int[] data) {
		for (int i = 0; i < data.length; i++)
			for (int j = i + 1; j < data.length; j++)
				if (data[i] == data[j])
					return true;
		return false;
	}
	
	public int smallestNumberMissing(int[] data) {
		var flag = new boolean[data.length];
		Arrays.fill(flag, false);
		for (int i = 0; i < data.length; i++)
			flag[data[i]] = true;
		int smallest = -1;
		for (int i = 0; i < flag.length; i++)
			if (flag[i] == false)
				smallest = Math.min(smallest, i);
		return smallest;
	}
	
	public int smallestSubarrayWithSumS(int[] data, int S) {
		int ans = Integer.MAX_VALUE;
		int l = 0;
		int r = 0;
		int sum = 0;
		while (l < data.length && r < data.length) {
			if (sum >= S) {
				ans = Math.min(ans, r - l + 1);
				sum -= data[l++];
			} else {
				sum += data[r++];
			}
		}
		return ans;
	}
	
	public void test() {
		int[] data = new int[] {5,1,3,5,10,7,4,9,2,8};
		System.out.println(smallestSubarrayWithSumS(data, 15));
	}
	
	public static void main(String[] args) {
		var array = new Array();
		array.test();
	}
}
