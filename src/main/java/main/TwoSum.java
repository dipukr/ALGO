package main;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++)
				if (nums[i] + nums[j] == target)
					return new int[] {i, j};
		return null;
	}
	public int[] twoSumOP(int[] nums, int target) {
		var complements = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (complements.containsKey(nums[i]))
				return new int[] {i, complements.get(nums[i])};
			complements.put(target - nums[i], i);
		}
		return null;
	}
}
