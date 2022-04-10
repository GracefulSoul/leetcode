package gracefulsoul.problems;

import java.util.Arrays;

public class SortCharactersByFrequency {

	// https://leetcode.com/submissions/detail/677419296/
	public static void main(String[] args) {
		SortCharactersByFrequency test = new SortCharactersByFrequency();
		System.out.println(test.frequencySort("tree"));
		System.out.println(test.frequencySort("cccaaa"));
		System.out.println(test.frequencySort("Aabb"));
	}

	public String frequencySort(String s) {
		int[][] count = new int[256][2];
		for (char c : s.toCharArray()) {
			count[c][0] = c;
			count[c][1]++;
		}
		Arrays.sort(count, (a, b) -> (b[1] - a[1]));
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < count.length; idx++) {
			while (count[idx][1] > 0) {
				sb.append((char) count[idx][0]);
				count[idx][1]--;
			}
		}
		return sb.toString();
	}

}
