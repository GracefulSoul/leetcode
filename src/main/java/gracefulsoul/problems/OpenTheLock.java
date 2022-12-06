package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenTheLock {

	// https://leetcode.com/problems/open-the-lock/submissions/855412378/
	public static void main(String[] args) {
		OpenTheLock test = new OpenTheLock();
		System.out.println(test.openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202"));
		System.out.println(test.openLock(new String[] { "8888" }, "0009"));
		System.out.println(test.openLock(new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" }, "8888"));
	}

	public int openLock(String[] deadends, String target) {
		Set<String> start = new HashSet<>();
		start.add("0000");
		Set<String> end = new HashSet<>();
		end.add(target);
		Set<String> checked = new HashSet<>(Arrays.asList(deadends));
		int step = 0;
		while (!start.isEmpty() && !end.isEmpty()) {
			Set<String> temp = new HashSet<>();
			for (String curr : start) {
				if (end.contains(curr)) {
					return step;
				} else if (checked.contains(curr)) {
					continue;
				} else {
					checked.add(curr);
					temp.addAll(this.getNexts(curr));
				}
			}
			step++;
			start = end;
			end = temp;
		}
		return -1;
	}

	private List<String> getNexts(String lock) {
		List<String> locks = new ArrayList<>();
		char[] charArray = lock.toCharArray();
		for (int idx = 0; idx < charArray.length; idx++) {
			char c = charArray[idx];
			charArray[idx] = c == '9' ? '0' : (char) (c + 1);
			locks.add(String.valueOf(charArray));
			charArray[idx] = c == '0' ? '9' : (char) (c - 1);
			locks.add(String.valueOf(charArray));
			charArray[idx] = c;
		}
		return locks;
	}

}
