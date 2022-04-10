package gracefulsoul.problems;

import java.util.Arrays;

public class SortCharactersByFrequency {

	// https://leetcode.com/submissions/detail/677415463/
	public static void main(String[] args) {
		SortCharactersByFrequency test = new SortCharactersByFrequency();
		System.out.println(test.frequencySort("tree"));
		System.out.println(test.frequencySort("cccaaa"));
		System.out.println(test.frequencySort("Aabb"));
	}

	public String frequencySort(String s) {
		int[][] counts = new int[256][2];
		for (char c : s.toCharArray()) {
			counts[c][0] = c;
			counts[c][1]++;
		}
		Arrays.sort(counts, (a, b) -> (b[1] - a[1]));
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < counts.length; idx++) {
			while (counts[idx][1] > 0) {
				sb.append((char) counts[idx][0]);
				counts[idx][1]--;
			}
		}
		return sb.toString();
	}

}
