package gracefulsoul.problems;

public class LongestAbsoluteFilePath {

	// https://leetcode.com/submissions/detail/642270544/
	public static void main(String[] args) {
		LongestAbsoluteFilePath test = new LongestAbsoluteFilePath();
		System.out.println(test.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
		System.out.println(test.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		System.out.println(test.lengthLongestPath("a"));
	}

	public int lengthLongestPath(String input) {
		String[] paths = input.split("\n");
		int[] stack = new int[paths.length + 1];
		int result = 0;
		for (String path : paths) {
			int level = path.lastIndexOf("\t") + 1;
			int curr = stack[level + 1] = stack[level] + path.length() - level + 1;
			if (path.contains(".")) {
				result = Math.max(result, curr - 1);
			}
		}
		return result;
	}

}
