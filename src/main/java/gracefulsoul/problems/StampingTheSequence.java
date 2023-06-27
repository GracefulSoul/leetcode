package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class StampingTheSequence {

	// https://leetcode.com/problems/stamping-the-sequence/submissions/980737381/
	public static void main(String[] args) {
		StampingTheSequence test = new StampingTheSequence();
		PrintUtil.print(test.movesToStamp("abc", "ababc"));
		PrintUtil.print(test.movesToStamp("abca", "aabcaca"));
	}

	public int[] movesToStamp(String stamp, String target) {
		char[] stampToCharArray = stamp.toCharArray();
		char[] targetToCharArray = target.toCharArray();
		int stampLength = stampToCharArray.length;
		int targetLength = targetToCharArray.length;
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[targetLength];
		int count = 0;
		while (count < targetLength) {
			boolean replaced = false;
			for (int i = 0; i <= targetLength - stampLength; i++) {
				if (!visited[i] && this.canReplace(stampToCharArray, targetToCharArray, i)) {
					count = this.getCount(targetToCharArray, i, stampLength, count);
					replaced = true;
					visited[i] = true;
					list.add(i);
					if (count == targetLength) {
						break;
					}
				}
			}
			if (!replaced) {
				return new int[0];
			}
		}
		int size = list.size();
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = list.get(size - i - 1);
		}
		return result;
	}

	private boolean canReplace(char[] stampToCharArray, char[] targetToCharArray, int index) {
		for (int i = 0; i < stampToCharArray.length; i++) {
			if (targetToCharArray[i + index] != '*' && targetToCharArray[i + index] != stampToCharArray[i]) {
				return false;
			}
		}
		return true;
	}

	private int getCount(char[] targetToCharArray, int index, int limit, int count) {
		for (int i = 0; i < limit; i++) {
			if (targetToCharArray[i + index] != '*') {
				targetToCharArray[i + index] = '*';
				count++;
			}
		}
		return count;
	}

}
