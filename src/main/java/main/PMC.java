package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class PMC {

	public List<int[]> subarrays(int array[]) {
		var subArrays = new ArrayList<int[]>();
		for (int start = 0; start < array.length; start++) {
			for (int end = start; end < array.length; end++) {
				int[] subArray = new int[start - end + 1];
				for (int k = start; k <= end; k++)
					subArray[k - start] = array[k];
				subArrays.add(subArray);
			}
		}
		return subArrays;
	}

	public List<int[]> subsets(int array[]) {
		int powerSetN = (int) Math.pow(2, array.length);
		var subsets = new ArrayList<int[]>();

		return subsets;
	}

	public List<int[]> subsequences(int[] array) {
		return null;
	}

	public void subsequences(int[] array, int index, List<Integer> subsequence, List<int[]> subsequences) {
		if (index == array.length) {
			if (subsequence.size() > 0) {
				for (int i = 0; i < subsequence.size(); i++)
					System.out.print(subsequence.get(i) + " ");
				System.out.println();
			} else {
				System.out.println("[]");
			}
		} else {
			subsequences(array, index + 1, subsequence, subsequences);
			subsequence.add(array[index]);
			subsequences(array, index + 1, subsequence, subsequences);
			subsequence.remove(subsequence.size() - 1);
		}
		return;
	}

	public List<int[]> permutations(int[] array) {
		return null;
	}

	public List<int[]> combinations(int[] array) {
		return null;
	}
	
	public int longestSubstrLength(char[] chars) {
		int maxLen = 0;
		for (int start = 0; start < chars.length; start++) {
			for (int end = start; end < chars.length; end++) {
				var set = new TreeSet<Character>();
				for (int a = start; a <= end; a++)
					set.add(chars[a]);
				if (set.size() == end - start + 1)
					maxLen = Math.max(maxLen, set.size());
			}
		}
		return maxLen;
	}
	
	public int longestSubstrLengthSW(char[] chars) {
		int len = 0;
		for (int i = 0; i < chars.length; i++) {
			for (int j = i; j < chars.length; j++) {
				
			}
		}
		return 0;
	}
	
	public int longestCommonSubstring(String first, String second) {
		return 0;
	}
	
	public List<String> substrs(String str) {
		var substrs = new ArrayList<String>();
		for (int start = 0; start < str.length(); start++) {
			for (int end = start; end < str.length(); end++) {
				String substr = "";
				for (int a = start; a <= end; a++)
					substr += str.charAt(a);
				substrs.add(substr);
			}
		}
		return substrs;
	}
	
	public List<String> subsets(String s) {
		var subsets = new ArrayList<String>();
		subsets(s, 0, "", subsets);
		return subsets;
	}
	
	public void subsets(String s, int i, String current, List<String> subsets) {
		if (i == s.length()) {
			subsets.add(current);
			return;
		}
		subsets(s, i + 1, current + s.charAt(i), subsets);
		subsets(s, i + 1, current, subsets);
	}
	
	public List<String> permutations(String s) {
		var permutations = new ArrayList<String>();
		
		return permutations;
	}
	
	public void permute(String s, int l, int r, List<String> permutations) {
		
	}
	
	public static void main(final String args[]) {
		var pmc = new PMC();
		int array[] = {1, 2, 3};
		pmc.subarrays(array).stream().forEach(elem -> System.out.println(Arrays.toString(elem)));
		pmc.subsets(array).stream().forEach(elem -> System.out.println(Arrays.toString(elem)));
	}
}
