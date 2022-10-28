package gracefulsoul.problems;

import java.util.Arrays;

public class DesignHashMap {

	// https://leetcode.com/submissions/detail/831981955/
	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap();
		myHashMap.put(1, 1);					// The map is now [[1,1]]
		myHashMap.put(2, 2);					// The map is now [[1,1], [2,2]]
		System.out.println(myHashMap.get(1));	// return 1, The map is now [[1,1], [2,2]]
		System.out.println(myHashMap.get(3));	// return -1 (i.e., not found), The map is now [[1,1], [2,2]]
		myHashMap.put(2, 1);					// The map is now [[1,1], [2,1]] (i.e., update the existing value)
		System.out.println(myHashMap.get(2));	// return 1, The map is now [[1,1], [2,1]]
		myHashMap.remove(2);					// remove the mapping for 2, The map is now [[1,1]]
		System.out.println(myHashMap.get(2));	// return -1 (i.e., not found), The map is now [[1,1]]
	}

}

class MyHashMap {

	private int[] map;

	public MyHashMap() {
		this.map = new int[10];
	}

	public void put(int key, int value) {
		if (key >= this.map.length) {
			this.map = Arrays.copyOf(this.map, key + 1);
		}
		this.map[key] = value == 0 ? -1 : value;
	}

	public int get(int key) {
		if (key >= this.map.length || this.map[key] == 0) {
			return -1;
		} else {
			return this.map[key] == -1 ? 0 : this.map[key];
		}
	}

	public void remove(int key) {
		if (key < this.map.length) {
			this.map[key] = 0;
		}
	}

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */