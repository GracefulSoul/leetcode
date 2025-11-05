package gracefulsoul.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gracefulsoul.object.nested.integer.NestedInteger;
import gracefulsoul.object.node.ListNode;
import gracefulsoul.object.node.TreeNode;

public class PrintUtil {

	private PrintUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val);
			listNode = listNode.next;
			if (listNode != null) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public static void print(ListNode head, ListNode cycle) {
		int idx = 0;
		while (head != cycle) {
			head = head.next;
			idx++;
		}
		System.out.println(cycle == null ? -1 : idx);
	}

	public static void print(List<TreeNode> treeNodeList) {
		System.out.print("[");
		for (TreeNode treeNode : treeNodeList) {
			if (treeNode != null) {
				System.out.print("(");
				print(treeNode.left, false, true);
				System.out.print("(" + treeNode.val + "), ");
				print(treeNode.right, false, false);
				System.out.print(")");
			} else {
				System.out.print("(null)");
			}
		}
		System.out.println("]");
	}

	public static void print(TreeNode treeNode, boolean isRoot, boolean isLeft) {
		if (treeNode != null) {
			if (!isRoot) {
				System.out.print("(");
			}
			print(treeNode.left, false, true);
			System.out.print("(" + treeNode.val + "), ");
			print(treeNode.right, false, false);
			if (!isRoot) {
				System.out.print(")");
			}
		} else {
			System.out.print("(null)");
		}
		if (isLeft) {
			System.out.print(", ");
		}
		if (isRoot) {
			System.out.println();
		}
	}


	public static void print(gracefulsoul.object.node.quad.Node node) {
		if (node != null) {
			System.out.print("[" + (node.isLeaf ? 1 : 0) + ", " + (node.val ? 1 : 0) + "]");
			print(node.topLeft);
			print(node.topRight);
			print(node.bottomLeft);
			print(node.bottomRight);
		}
	}

	public static void print(gracefulsoul.object.node.neighbor.Node node) {
		print(node, new HashMap<>());
	}

	private static void print(gracefulsoul.object.node.neighbor.Node node, Map<Integer, Boolean> map) {
		for (gracefulsoul.object.node.neighbor.Node neighbor : node.neighbors) {
			if (!map.getOrDefault(neighbor.val, false)) {
				map.put(neighbor.val, true);
				System.out.print(neighbor.neighbors.stream().map(nd -> nd.val).collect(Collectors.toList()));
				print(neighbor, map);
			}
		}
	}

	public static void print(gracefulsoul.object.node.random.Node node) {
		if (node != null) {
			System.out.printf("[%s,%s]", node.val, node.random == null ? "null" : node.random.val);
			print(node.next);
		}
	}

	public static void print(gracefulsoul.object.node.flatten.Node node) {
		while (node != null) {
			System.out.print(node.val);
			node = node.next;
			if (node != null) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public static void print(gracefulsoul.object.node.Node node) {
		List<Object> list = new ArrayList<>();
		getConnectedNodeValues(node, node, list);
		System.out.println(list);
	}

	private static void getConnectedNodeValues(gracefulsoul.object.node.Node start, gracefulsoul.object.node.Node temp,
			List<Object> list) {
		if (temp == null) {
			return;
		}
		list.add(temp.val);
		if (temp.next == null) {
			list.add("#");
			getConnectedNodeValues(start.left, start.left, list);
		} else {
			getConnectedNodeValues(start, temp.next, list);
		}
	}

	public static void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(long[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(double[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(char[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(boolean[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(String[] array) {
		System.out.println(Arrays.toString(array));
	}

	public static void print(ListNode[] array) {
		for (ListNode node : array) {
			print(node);
		}
	}

	public static void print(int[][] matrix) {
		System.out.print("[");
		for (int[] row : matrix) {
			System.out.print(Arrays.toString(row));
		}
		System.out.println("]");
	}

	public static void print(char[][] matrix) {
		System.out.print("[");
		for (char[] row : matrix) {
			System.out.print(Arrays.toString(row));
		}
		System.out.println("]");
	}

	public static void print(NestedInteger nestedInteger) {
		if (nestedInteger.isInteger()) {
			System.out.print(nestedInteger.getInteger());
		}
		for (NestedInteger child : nestedInteger.getList()) {
			print(child);
		}
	}

}
