package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignANumberContainerSystem {

	// https://leetcode.com/problems/design-a-number-container-system/submissions/1535349023/
	public static void main(String[] args) {
		NumberContainers nc = new NumberContainers();
		System.out.println(nc.find(10));	// There is no index that is filled with number 10. Therefore, we return -1.
		nc.change(2, 10); 					// Your container at index 2 will be filled with number 10.
		nc.change(1, 10); 					// Your container at index 1 will be filled with number 10.
		nc.change(3, 10); 					// Your container at index 3 will be filled with number 10.
		nc.change(5, 10); 					// Your container at index 5 will be filled with number 10.
		System.out.println(nc.find(10));	// Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is
											// filled with 10 is 1, we return 1.
		nc.change(1, 20);					// Your container at index 1 will be filled with number 20. Note that index 1
											// was filled with 10 and then replaced with 20.
		System.out.println(nc.find(10));	// Number 10 is at the indices 2, 3, and 5. The smallest index that is filled
											// with 10 is 2. Therefore, we return 2.
	}

}

class NumberContainers {

	private Map<Integer, Integer> indexMap;
	private Map<Integer, TreeSet<Integer>> valueMap;

	public NumberContainers() {
		this.indexMap = new HashMap<>();
		this.valueMap = new HashMap<>();
	}

	public void change(int index, int number) {
		this.indexMap.put(index, number);
		this.valueMap.computeIfAbsent(number, value -> new TreeSet<Integer>()).add(index);
	}

	public int find(int number) {
		if (!this.valueMap.containsKey(number)) {
			return -1;
		}
		for (Integer a : this.valueMap.get(number)) {
			if (this.indexMap.get(a) == number) {
				return a;
			}
		}
		return -1;
	}

}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */