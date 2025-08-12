package main;

import java.util.HashSet;

public class SW {
	
	@Leet("3")
	public int lengthOfLongestSubstring(String s) {
		int start = 0, end = 0;
		int maxLen = 0;
		var set = new HashSet<Character>();
		while (end < s.length()) {
			char ch = s.charAt(end);
			if (set.contains(ch)) {
				set.remove(s.charAt(start));
				start++;
			} else {
				set.add(ch);
				maxLen = Math.max(maxLen, end - start + 1);
				end++;
			}
		}
		return maxLen;
	}
	
	
	public static void main(final String[] args) {
		var algo = new SW();
		System.out.println(algo.lengthOfLongestSubstring("abcabcbb"));
	}
}
