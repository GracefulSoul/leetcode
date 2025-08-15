package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class IteratorForCombination {

	// https://leetcode.com/problems/iterator-for-combination/submissions/1735502042/
	public static void main(String[] args) {
		CombinationIterator itr = new CombinationIterator("abc", 2);
		System.out.println(itr.next());		// return "ab"
		System.out.println(itr.hasNext());	// return True
		System.out.println(itr.next());		// return "ac"
		System.out.println(itr.hasNext());	// return True
		System.out.println(itr.next());		// return "bc"
		System.out.println(itr.hasNext());	// return False
	}

}

class CombinationIterator {

	private List<String> list;
	private int index;

	public CombinationIterator(String characters, int combinationLength) {
		this.list = new ArrayList<>();
		this.index = 0;
		this.dfs(characters.toCharArray(), combinationLength, 0, new StringBuilder());
	}

	public String next() {
		return this.list.get(this.index++);
	}

	public boolean hasNext() {
		return this.index < this.list.size();
	}

	private void dfs(char[] characters, int combinationLength, int start, StringBuilder sb) {
		if (combinationLength == 0) {
			this.list.add(sb.toString());
		} else {
			for (int i = start; i <= characters.length - combinationLength; i++) {
				sb.append(characters[i]);
				this.dfs(characters, combinationLength - 1, i + 1, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */