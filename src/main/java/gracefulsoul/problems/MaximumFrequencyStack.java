package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumFrequencyStack {

	// https://leetcode.com/problems/maximum-frequency-stack/submissions/929005726/
	public static void main(String[] args) {
		FreqStack freqStack = new FreqStack();
		freqStack.push(5);						// The stack is [5]
		freqStack.push(7);						// The stack is [5,7]
		freqStack.push(5);						// The stack is [5,7,5]
		freqStack.push(7);						// The stack is [5,7,5,7]
		freqStack.push(4);						// The stack is [5,7,5,7,4]
		freqStack.push(5);						// The stack is [5,7,5,7,4,5]
		System.out.println(freqStack.pop());	// return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
		System.out.println(freqStack.pop());	// return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
		System.out.println(freqStack.pop());	// return 5, as 5 is the most frequent. The stack becomes [5,7,4].
		System.out.println(freqStack.pop());	// return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
	}

}

class FreqStack {

	private int max;
	private Map<Integer, Integer> frequencyMap;
	private List<Deque<Integer>> valList;

	public FreqStack() {
		this.max = 0;
		this.frequencyMap = new HashMap<>();
		this.valList = new ArrayList<>();
	}

	public void push(int val) {
		int frequency = this.frequencyMap.getOrDefault(val, 0) + 1;
		this.frequencyMap.put(val, frequency);
		this.max = Math.max(this.max, frequency);
		if (frequency > this.valList.size()) {
			this.valList.add(new ArrayDeque<>());
		}
		this.valList.get(frequency - 1).push(val);
	}

	public int pop() {
		int val = this.valList.get(this.valList.size() - 1).pop();
		if (this.max == 1) {
			this.frequencyMap.remove(val);
		} else {
			this.frequencyMap.replace(val, this.max - 1);
		}
		if (this.valList.get(this.valList.size() - 1).isEmpty()) {
			this.valList.remove(this.valList.size() - 1);
			this.max--;
		}
		return val;
	}

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */