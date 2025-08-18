package main;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
	public List<List<Integer>> subsequences(int[] data) {
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
	
	public void subsequences(List<List<Integer>> subsequences, List<Integer> subsequence, int[] data, int index) {
		if (index == data.length) {
			subsequences.add(new ArrayList<>(subsequence));
			return;
		}
		subsequence.add(data[index]); // include the current element
		subsequences(subsequences, subsequence, data, index + 1);
		subsequence.remove(subsequence.size() - 1); // exclude the current element (backtrack)
		subsequences(subsequences, subsequence, data, index + 1);
	}
}
