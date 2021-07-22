package gracefulsoul.problems;

import java.util.List;

import gracefulsoul.object.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
		test.zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
		test.zigzagLevelOrder(new TreeNode(1));
		test.zigzagLevelOrder(new TreeNode());
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
    }

}
