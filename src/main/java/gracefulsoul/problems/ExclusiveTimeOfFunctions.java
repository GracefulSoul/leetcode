package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

	// https://leetcode.com/submissions/detail/782047437/
	public static void main(String[] args) {
		ExclusiveTimeOfFunctions test = new ExclusiveTimeOfFunctions();
		System.out.println(test.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")));
		System.out.println(test.exclusiveTime(1, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7")));
		System.out.println(test.exclusiveTime(2, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7")));
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		Stack<int[]> stack = new Stack<>();
		for (String log : logs) {
			String[] split = log.split(":");
			int id = Integer.valueOf(split[0]);
			int timestamp = Integer.valueOf(split[2]);
			if (split[1].equals("start")) {
				stack.push(new int[] { id, timestamp });
			} else {
				int time = timestamp - stack.pop()[1] + 1;
				result[id] += time;
				if (!stack.empty()) {
					result[stack.peek()[0]] -= time;
				}
			}
		}
		return result;
	}

}
