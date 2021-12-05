package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

	// https://leetcode.com/submissions/detail/597040579/
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		PeekingIterator peekingIterator = new PeekingIterator(list.iterator()); // [1,2,3]
		System.out.println(peekingIterator.next());    // return 1, the pointer moves to the next element [1,2,3].
		System.out.println(peekingIterator.peek());    // return 2, the pointer does not move [1,2,3].
		System.out.println(peekingIterator.next());    // return 2, the pointer moves to the next element [1,2,3]
		System.out.println(peekingIterator.next());    // return 3, the pointer moves to the next element [1,2,3]
		System.out.println(peekingIterator.hasNext()); // return False
	}

	private Iterator<Integer> iterator;
	private Integer peekVal;
	private boolean cached;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (!this.cached) {
			this.peekVal = this.iterator.next();
			this.cached = true;
		}
		return this.peekVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (this.cached) {
			this.cached = false;
			return this.peekVal;
		}
		return this.iterator.next();
	}

	@Override
	public boolean hasNext() {
		if (this.cached) {
			return true;
		}
		return this.iterator.hasNext();
	}

}
