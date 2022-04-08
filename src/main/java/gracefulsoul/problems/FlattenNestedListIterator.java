package gracefulsoul.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import gracefulsoul.object.nested.integer.NestedInteger;

public class FlattenNestedListIterator {

	// https://leetcode.com/submissions/detail/620004661/
	public static void main(String[] args) {
		// We don't know about implemented class of NestedInteger interface.
	}

}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class NestedIterator implements Iterator<Integer> {

	private LinkedList<Iterator<NestedInteger>> linkedList;
	private Iterator<NestedInteger> currentIterator;
	private Integer next;

	public NestedIterator(List<NestedInteger> nestedList) {
		this.linkedList = new LinkedList<>();
		this.currentIterator = nestedList.iterator();
		this.next = this.getNext();
	}

	@Override
	public Integer next() {
		Integer temp = next;
		this.next = this.getNext();
		return temp;
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	private Integer getNext() {
		while (!this.currentIterator.hasNext()) {
			if (this.linkedList.isEmpty()) {
				return null;
			}
			this.currentIterator = this.linkedList.removeLast();
		}
		NestedInteger nextInteger = this.currentIterator.next();
		if (nextInteger.isInteger()) {
			return nextInteger.getInteger();
		}
		this.linkedList.addLast(this.currentIterator);
		this.currentIterator = nextInteger.getList().iterator();
		return this.getNext();
	}

}
