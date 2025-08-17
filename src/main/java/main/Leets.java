package main;

import java.util.ArrayList;
import java.util.List;

public class Leets {

	@Leet("448")
	public List<Integer> missingNumbers(List<Integer> nums) {
		var missingNums = new ArrayList<Integer>();
		var exists = new boolean[nums.size() + 1];
		for (int i = 0; i < nums.size(); i++) {
			Integer num = nums.get(i);
			exists[num] = true;
		}
		for (int i = 1; i < exists.length; i++) {
			if (!exists[i])
				missingNums.add(i);
		}
		return missingNums;
	}
	
	@Leet("448")
	public List<Integer> missingNumbers2(int[] nums) {
		var missingNums = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			int markPos = num - 1;
			if (nums[markPos] > 0)
				nums[markPos] = -nums[markPos];
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				missingNums.add(i + 1);
		}
		return missingNums;
	}
	
	@Leet("324")
	public String compressedString(String word) {
		var result = new StringBuilder();
		int i = 1, count = 1;
		char prevChar = word.charAt(0);
		while (true) {
			char currChar = word.charAt(i++);
			if (currChar == prevChar && count < 9) {
				count++;
			} else {
				result.append(count);
				result.append(prevChar);
				count = 1;
			}
			if (i == word.length()) {
				result.append(count);
				result.append(currChar);
				break;
			}
			prevChar = currChar;
		}
		return result.toString();
	}
}
