package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Array {
	public List<int[]> subarrays(int[] data) {
		var subArrays = new ArrayList<int[]>();
		for (int start = 0; start < data.length; start++) {
			for (int end = start; end < data.length; end++) {
				int[] subArray = new int[end - start + 1];
				for (int k = start; k <= end; k++)
					subArray[k - start] = data[k];
				subArrays.add(subArray);
			}
		}
		return subArrays;
	}
	
	public void print(int[] data, int low, int high) {
		Console.draw("[");
		for (int i = low; i <= high; i++) {
			if (i > low) Console.draw(",");
			Console.draw("%d", data[i]);
		}
		Console.draw("]");
	}
	
	public void print(int[] data) {
		print(data, 0, data.length - 1);
	}
	
	public int sumArray(int[] data, int low, int high) {
		int sum = 0;
		for (int i = low; i <= high; i++)
			sum += data[i];
		return sum;
	}
	
	public int sumArray(int[] data) {
		return sumArray(data, 0, data.length - 1);
	}
	
	public void printSubarray(int[] data) {
		for (int i = 0; i < data.length; i++)
			for (int j = i; j < data.length; j++)
				print(data, i, j);
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
	
	public int[] getPrefixSum(int[] data) {
		int[] sum = new int[data.length];
		sum[0] = data[0];
		for (int i = 1; i < data.length; i++)
			sum[i] = sum[i - 1] + data[i];
		return sum;
	}
	
	public int maxSubarraySumDP(int[] data) {
		int[] sum = getPrefixSum(data);
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < data.length; i++) {
			for (int j = i; j < data.length; j++) {
				int currSum = sum[j] - (i == 0 ? 0 : sum[i - 1]);
				maxSum = Math.max(maxSum, currSum);
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
}
