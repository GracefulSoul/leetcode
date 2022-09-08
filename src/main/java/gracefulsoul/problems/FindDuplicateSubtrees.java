package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class FindDuplicateSubtrees {

	// https://leetcode.com/submissions/detail/794631426/
	public static void main(String[] args) {
		FindDuplicateSubtrees test = new FindDuplicateSubtrees();
		PrintUtil.print(test.findDuplicateSubtrees(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)))));
		PrintUtil.print(test.findDuplicateSubtrees(new TreeNode(2, new TreeNode(1), new TreeNode(1))));
		PrintUtil.print(test.findDuplicateSubtrees(new TreeNode(2, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, new TreeNode(3), null))));
	}

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	    List<TreeNode> result = new ArrayList<>();
	    this.dfs(root, new HashMap<>(), result);
	    return result;
	}

	private String dfs(TreeNode treeNode, Map<String, Integer> map, List<TreeNode> result) {
	    if (treeNode == null) {
	    	return "#";  
	    }
	    String subTree = new StringBuilder()
	    		.append(treeNode.val)
	    		.append(",")
	    		.append(this.dfs(treeNode.left, map, result))
	    		.append(",")
	    		.append(this.dfs(treeNode.right, map, result))
	    		.toString();
	    map.put(subTree, map.getOrDefault(subTree, 0) + 1);
	    if (map.get(subTree) == 2) {
	    	result.add(treeNode);
	    }
	    return subTree;
	}

}
