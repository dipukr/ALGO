package main;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Subs {
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

	public List<List<Integer>> getAllSubsequences(int[] data) {
		List<List<Integer>> result = new ArrayList<>();
		for (int mask = 0; mask < (1 << data.length); mask++) {
			List<Integer> subsequence = new ArrayList<>();
			for (int i = 0; i < data.length; i++)
				if ((mask & (1 << i)) != 0)
					subsequence.add(data[i]);
			result.add(subsequence);
		}
		return result;
	}

	@REM("Duplicates allowed")
	public void getAllPermutations(List<List<Integer>> result, List<Integer> perm, int[] data) {
		if (perm.size() == data.length) {
			result.add(new ArrayList<>(perm));
			return;
		}
		for (int elem: data) {
			perm.add(elem);
			getAllPermutations(result, perm, data);
		}
	}

	public List<List<Integer>> permutations(int[] data) {
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> currPerm = new ArrayList<>();
		permutations(permutations, currPerm, data);
		return permutations;
	}

	public void permutations(List<List<Integer>> permutations, List<Integer> currPerm, int[] data) {
		if (currPerm.size() == data.length) {
			permutations.add(new ArrayList<>(currPerm));
			return;
		}
		for (int elem: data) {
			if (currPerm.contains(elem)) continue;
			currPerm.add(elem);
			permutations(permutations, currPerm, data);
			currPerm.remove(currPerm.size() - 1);
		}
	}

	public List<List<Integer>> combinations(int N, int K) {
		List<List<Integer>> combinations = new ArrayList<>();
		List<Integer> currComb = new ArrayList<>();
		combinations(combinations, currComb, 0, N, K);
		return combinations;
	}

	public void combinations(List<List<Integer>> combinations, List<Integer> currComb, int start, int N, int K) {
		if (currComb.size() == K) {
			combinations.add(new ArrayList<>(currComb));
			return;
		}
		for (int num = start; num <= N; num += 1) {
			currComb.add(num);
			combinations(combinations, currComb, start + 1, N, K);
			currComb.remove(currComb.size() - 1);
		}
	}

	public List<List<Integer>> subsets(int[] data) {
		int powerSetN = (int) Math.pow(2, data.length);
		List<List<Integer>> subsets = new ArrayList<>();

		return subsets;
	}

	public void subsequences(List<List<Integer>> subsequences, List<Integer> current, int[] data, int index) {
		if (index == data.length) {
			subsequences.add(new ArrayList<>(current));
			return;
		}
		current.add(data[index]); // include the current element
		subsequences(subsequences, current, data, index + 1);
		current.remove(current.size() - 1); // exclude the current element (backtrack)
		subsequences(subsequences, current, data, index + 1);
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

	public static void main(String[] args) {
		Subs a = new Subs();
		int[] arr = { 1, 2, 3 };
		List<List<Integer>> subsequences = a.getAllSubsequences(arr);

		System.out.println("Subsequences:");
		for (List<Integer> subseq : subsequences) {
			System.out.println(subseq);
		}
	}
}
