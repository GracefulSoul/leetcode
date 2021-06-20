package gracefulsoul.problems;

import java.util.Stack;

public class SimplifyPath {

	// https://leetcode.com/submissions/detail/510478995/
	public static void main(String[] args) {
		SimplifyPath test = new SimplifyPath();
		System.out.println(test.simplifyPath("/home/"));
		System.out.println(test.simplifyPath("/../"));
		System.out.println(test.simplifyPath("/home//foo/"));
		System.out.println(test.simplifyPath("/a/./b/../../c/"));
	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for (String directory : path.split("/")) {
			switch (directory) {
				case "":case ".": continue;
				case "..": this.popStackIsNotEmpty(stack); break;
				default: stack.push(directory);
			}
		}
		return this.getPath(stack);
	}

	private void popStackIsNotEmpty(Stack<String> stack) {
		if (!stack.isEmpty()) {
			stack.pop();
		}
	}

	private String getPath(Stack<String> stack) {
		StringBuilder sb = new StringBuilder();
		for (String directory : stack) {
			sb.append("/").append(directory);
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}

}
