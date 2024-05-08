package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {

	// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/submissions/1252565174/
	public static void main(String[] args) {
		PathInZigzagLabelledBinaryTree test = new PathInZigzagLabelledBinaryTree();
		System.out.println(test.pathInZigZagTree(14));
		System.out.println(test.pathInZigZagTree(26));
	}

	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> result = new ArrayList<>();
		result.addFirst(label);
		while (label > 1) {
			int depth = (int) (Math.log(label) / Math.log(2));
			label = ((int) Math.pow(2, depth) + ((int) Math.pow(2, depth + 1) - 1 - label)) / 2;
			result.addFirst(label);
		}
		return result;
	}

}
