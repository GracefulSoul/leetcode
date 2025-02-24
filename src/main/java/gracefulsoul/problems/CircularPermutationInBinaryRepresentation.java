package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationInBinaryRepresentation {

	// https://leetcode.com/problems/circular-permutation-in-binary-representation/submissions/1553509643/
	public static void main(String[] args) {
		CircularPermutationInBinaryRepresentation test = new CircularPermutationInBinaryRepresentation();
		System.out.println(test.circularPermutation(2, 3));
		System.out.println(test.circularPermutation(3, 2));
	}

	public List<Integer> circularPermutation(int n, int start) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 1 << n; i++) {
			result.add(start ^ i ^ i >> 1);
		}
		return result;
	}

}
