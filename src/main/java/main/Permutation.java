package main;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public List<List<Integer>> permutations(int[] data) {
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> currPerm = new ArrayList<>();
		permutations(permutations, currPerm, data);
		return permutations;
	}

	public void permutationsDUP(List<List<Integer>> permutations, List<Integer> currPerm, int[] data) {
		if (currPerm.size() == data.length) {
			permutations.add(new ArrayList<>(currPerm));
			return;
		}
		for (int elem: data) {
			currPerm.add(elem);
			permutationsDUP(permutations, currPerm, data);
			currPerm.remove(currPerm.size() - 1);
		}
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
}
