package gracefulsoul.problems;

public class VerifyPreorderSerializationOfABinaryTree {

	// https://leetcode.com/submissions/detail/615326509/
	public static void main(String[] args) {
		VerifyPreorderSerializationOfABinaryTree test = new VerifyPreorderSerializationOfABinaryTree();
		System.out.println(test.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(test.isValidSerialization("1,#"));
		System.out.println(test.isValidSerialization("9,#,#,1"));
	}

	public boolean isValidSerialization(String preorder) {
		char[] nodes = preorder.toCharArray();
		int slots = 1;
		for (int idx = 0; idx < nodes.length; idx++) {
			if (nodes[idx] == ',') {
				--slots;
				if (slots < 0) {
					return false;
				}
				if (nodes[idx - 1] != '#') {
					slots += 2;
				}
			}
		}
		slots = (nodes[nodes.length - 1] == '#') ? slots - 1 : slots + 1;
		return slots == 0;
	}

}
