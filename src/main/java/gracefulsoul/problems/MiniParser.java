package gracefulsoul.problems;

import gracefulsoul.object.nested.NestedInteger;
import gracefulsoul.object.nested.SimpleNestedInteger;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger { // Constructor initializes an empty nested list. public
 * NestedInteger();
 *
 * // Constructor initializes a single integer. public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer. public void
 * setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it. public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class MiniParser {

	// https://leetcode.com/submissions/detail/640405550/
	public static void main(String[] args) {
		print(new MiniParser().deserialize("324"));
		System.out.println();
		print(new MiniParser().deserialize("[123,[456,[789]]]"));
		System.out.println();
	}

	private static void print(NestedInteger nestedInteger) {
		if (nestedInteger.isInteger()) {
			System.out.print(nestedInteger.getInteger());
		}
		for (NestedInteger child : nestedInteger.getList()) {
			print(child);
		}
	}

	private int start;
	private char[] charArray;

	public NestedInteger deserialize(String s) {
		this.start = 0;
		this.charArray = s.toCharArray();
		return this.recursive();
	}

	private NestedInteger recursive() {
		NestedInteger result = new SimpleNestedInteger();
		if (this.charArray[this.start] == '[') {
			this.start++;
			this.dfs(result);
		} else {
			int num = 0;
			int posistion = 1;
			if (charArray[this.start] == '-') {
				posistion = -1;
				this.start++;
			}
			while (this.start < this.charArray.length && this.charArray[this.start] <= '9'
					&& this.charArray[this.start] >= '0') {
				num = (num * 10) + (this.charArray[this.start++] - '0');
			}
			result.setInteger(num * posistion);
		}
		return result;
	}

	private void dfs(NestedInteger parent) {
		while (this.charArray[this.start] != ']') {
			parent.add(this.recursive());
			if (this.charArray[this.start] == ',') {
				this.start++;
			}
		}
		this.start++;
	}

}
