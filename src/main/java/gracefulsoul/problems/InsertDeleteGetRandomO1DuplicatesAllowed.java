package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1DuplicatesAllowed {

	// https://leetcode.com/submissions/detail/637772714/
	public static void main(String[] args) {
		RandomizedCollection randomizedCollection = new RandomizedCollection();
		// return true since the collection does not contain 1.
		// Inserts 1 into the collection.
		System.out.println(randomizedCollection.insert(1));
		// return false since the collection contains 1.
		// Inserts another 1 into the collection. Collection now contains [1,1].
		System.out.println(randomizedCollection.insert(1));
		// return true since the collection does not contain 2.
		// Inserts 2 into the collection. Collection now contains [1,1,2].
		System.out.println(randomizedCollection.insert(2));
		// getRandom should:
		// - return 1 with probability 2/3, or
		// - return 2 with probability 1/3.
		System.out.println(randomizedCollection.getRandom());
		// return true since the collection contains 1.
		// Removes 1 from the collection. Collection now contains [1,2].
		System.out.println(randomizedCollection.remove(1));
		// getRandom should return 1 or 2, both equally likely.
		System.out.println(randomizedCollection.getRandom());
	}

}

class RandomizedCollection {

	private Map<Integer, Set<Integer>> map;
	private List<Integer> list;
	private Random random;

	public RandomizedCollection() {
		this.map = new HashMap<>();
		this.list = new ArrayList<>();
		this.random = new Random();
	}

	public boolean insert(int val) {
		boolean isContains = this.map.containsKey(val);
		if (!isContains) {
			this.map.put(val, new HashSet<Integer>());
		}
		this.map.get(val).add(this.list.size());
		this.list.add(val);
		return !isContains;
	}

	public boolean remove(int val) {
		boolean isContains = this.map.containsKey(val);
		if (isContains) {
			int index = this.map.get(val).iterator().next();
			int lastIndex = this.list.size() - 1;
			int num = this.list.get(lastIndex);
			this.list.set(index, num);
			this.map.get(val).remove(index);
			this.map.get(num).add(index);
			this.map.get(num).remove(lastIndex);
			this.list.remove(lastIndex);
	        if (this.map.get(val).isEmpty()) {
	        	this.map.remove(val);
	        }
		}
		return isContains;
	}

	public int getRandom() {
		return this.list.get(this.random.nextInt(this.list.size()));
	}

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
 * obj.getRandom();
 */