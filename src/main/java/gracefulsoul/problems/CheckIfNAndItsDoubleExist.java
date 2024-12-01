package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

	// https://leetcode.com/problems/check-if-n-and-its-double-exist/submissions/1466894404/
	public static void main(String[] args) {
		CheckIfNAndItsDoubleExist test = new CheckIfNAndItsDoubleExist();
		System.out.println(test.checkIfExist(new int[] { 10, 2, 5, 3 }));
		System.out.println(test.checkIfExist(new int[] { 3, 1, 7, 11 }));
	}

	public boolean checkIfExist(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int num : arr) {
			if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
				return true;
			} else {
				set.add(num);
			}
		}
		return false;
	}

}
