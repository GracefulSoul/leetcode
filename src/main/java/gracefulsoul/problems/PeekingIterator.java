package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

	// https://leetcode.com/submissions/detail/597032835/
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		PeekingIterator peekingIterator = new PeekingIterator(list.iterator()); // [1,2,3]
		peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
		peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
		peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
		peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
		peekingIterator.hasNext(); // return False
	}

	LinkedList<Integer> iterator = new LinkedList<>();

	public PeekingIterator(Iterator<Integer> iterator) {
		while (iterator.hasNext()) {
			this.iterator.offer(iterator.next());
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return this.iterator.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		return this.iterator.poll();
	}

	@Override
	public boolean hasNext() {
		return !this.iterator.isEmpty();
	}

}
