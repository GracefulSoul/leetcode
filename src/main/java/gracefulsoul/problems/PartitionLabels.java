package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	// https://leetcode.com/problems/partition-labels/submissions/859346335/
	public static void main(String[] args) {
		PartitionLabels test = new PartitionLabels();
		System.out.println(test.partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(test.partitionLabels("eccbbbbdec"));
	}

	public List<Integer> partitionLabels(String s) {
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int[] last = new int[26];
		for (int idx = 0; idx < length; idx++) {
			last[charArray[idx] - 'a'] = idx;
		}
		List<Integer> result = new ArrayList<>();
		int start = 0;
		int end = 0;
		for (int idx = 0; idx < charArray.length; idx++) {
			int index = last[charArray[idx] - 'a'];
			if (index > end) {
				end = index;
			}
			if (end == idx) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		return result;
	}

}
