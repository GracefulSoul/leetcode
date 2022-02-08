package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {

	// https://leetcode.com/submissions/detail/636853342/
	public static void main(String[] args) {
		RandomizedSet randomizedSet = new RandomizedSet();
		System.out.println(randomizedSet.insert(1));	// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		System.out.println(randomizedSet.remove(2));	// Returns false as 2 does not exist in the set.
		System.out.println(randomizedSet.insert(2));	// Inserts 2 to the set, returns true. Set now contains [1,2].
		System.out.println(randomizedSet.getRandom());	// getRandom() should return either 1 or 2 randomly.
		System.out.println(randomizedSet.remove(1));	// Removes 1 from the set, returns true. Set now contains [2].
		System.out.println(randomizedSet.insert(2));	// 2 was already in the set, so return false.
		System.out.println(randomizedSet.getRandom());	// Since 2 is the only number in the set, getRandom() will always return 2.
	}

}

class RandomizedSet {

	private Map<Integer, Integer> map;
	private List<Integer> list;
	private Random random = new Random();

	public RandomizedSet() {
		this.map = new HashMap<>();
		this.list = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (this.map.containsKey(val)) {
			return false;
		} else {
			this.map.put(val, this.list.size());
			this.list.add(val);
			return true;
		}
	}

	public boolean remove(int val) {
		if (this.map.containsKey(val)) {
			int index = this.map.get(val);
			int lastIndex = this.list.size() - 1;
			int num = this.list.get(lastIndex);
			this.list.set(index, num);
			this.map.put(num, index);
			this.map.remove(val);
			this.list.remove(lastIndex);
			return true;
		} else {
			return false;
		}
	}

	public int getRandom() {
		return this.list.get(this.random.nextInt(this.list.size()));
	}

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */