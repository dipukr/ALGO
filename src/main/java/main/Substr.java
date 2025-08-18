package main;

import java.util.TreeSet;

public class Substr {
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
}
