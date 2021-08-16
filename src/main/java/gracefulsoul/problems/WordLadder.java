package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	// https://leetcode.com/submissions/detail/539221823/
	public static void main(String[] args) {
		WordLadder test = new WordLadder();
		System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
		System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int length = 1;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				char[] wordCharArr = queue.poll().toCharArray();
				for (int j = 0; j < wordCharArr.length; j++) {
					char temp = wordCharArr[j];
					for (char chr = 'a'; chr <= 'z'; chr++) {
						wordCharArr[j] = chr;
						String dest = new String(wordCharArr);
						if (wordSet.contains(dest)) {
							if (dest.equals(endWord)) {
								return length + 1;
							}
							queue.add(dest);
							wordSet.remove(dest);
						}
					}
					wordCharArr[j] = temp;
				}
			}
			length++;
		}
		return 0;
	}

}
