package gracefulsoul.problems;

import java.util.Arrays;

public class DesignHashSet {

	// https://leetcode.com/submissions/detail/831334350/
	public static void main(String[] args) {
		MyHashSet myHashSet = new MyHashSet();
		myHashSet.add(1);							// set = [1]
		myHashSet.add(2);							// set = [1, 2]
		System.out.println(myHashSet.contains(1));	// return True
		System.out.println(myHashSet.contains(3));	// return False, (not found)
		myHashSet.add(2);							// set = [1, 2]
		System.out.println(myHashSet.contains(2));	// return True
		myHashSet.remove(2);						// set = [1]
		System.out.println(myHashSet.contains(2));	// return False, (already removed)
	}

}

class MyHashSet {

	private boolean[] set;

	public MyHashSet() {
		this.set = new boolean[10];
	}

	public void add(int key) {
		if (key >= this.set.length) {
			this.extend(key);
		}
		this.set[key] = true;
	}

	public void remove(int key) {
		if (key >= this.set.length) {
			this.extend(key);
		}
		this.set[key] = false;
	}

	public boolean contains(int key) {
		if (key >= this.set.length) {
			return false;
		} else {
			return this.set[key];
		}
	}

	private void extend(int key) {
		this.set = Arrays.copyOf(this.set, key + 10);
	}

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */