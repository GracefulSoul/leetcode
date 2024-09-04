package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfValidWordsForEachPuzzle {

	// https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/submissions/1378615107/
	public static void main(String[] args) {
		NumberOfValidWordsForEachPuzzle test = new NumberOfValidWordsForEachPuzzle();
		System.out.println(test.findNumOfValidWords(
			new String[] { "aaaa", "asas", "able", "ability", "actt", "actor", "access" },
			new String[] { "aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz" }));
		System.out.println(test.findNumOfValidWords(
			new String[] { "apple", "pleas", "please" },
			new String[] { "aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy" }));
	}

	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		Map<Integer, Integer> map = new HashMap<>();
		for (String word : words) {
			int mask = 0;
			for (char c : word.toCharArray()) {
				mask |= 1 << (c - 'a');
			}
			map.put(mask, map.getOrDefault(mask, 0) + 1);
		}
		List<Integer> result = new ArrayList<>();
		for (String puzzle : puzzles) {
			int mask = 0;
			for (char c : puzzle.toCharArray()) {
				mask |= 1 << (c - 'a');
			}
			int count = 0;
			int i = puzzle.charAt(0) - 'a';
			for (int j = mask; j > 0; j = (j - 1) & mask) {
				if ((j >> i & 1) == 1) {
					count += map.getOrDefault(j, 0);
				}
			}
			result.add(count);
		}
		return result;
	}

}
