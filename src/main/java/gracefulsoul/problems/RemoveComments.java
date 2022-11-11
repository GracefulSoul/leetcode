package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

	// https://leetcode.com/submissions/detail/841308029/
	public static void main(String[] args) {
		RemoveComments test = new RemoveComments();
		System.out.println(test.removeComments(new String[] {
			"/*Test program */",
			"int main()", "{ ",
			"  // variable declaration ", "int a, b, c;",
			"/* This is a test",
			"   multiline  ",
			"   comment for ",
			"   testing */",
			"a = b + c;", "}"
		}));
		System.out.println(test.removeComments(new String[] {
			"a/*comment",
			"line",
			"more_comment*/b"
		}));
	}

	public List<String> removeComments(String[] source) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean inBlock = false;
		for (String line : source) {
			for (int idx = 0; idx < line.length(); idx++) {
				if (!inBlock) {
					if (line.charAt(idx) == '/' && idx + 1 < line.length() && line.charAt(idx + 1) == '/') {
						break;
					}
					if (line.charAt(idx) == '/' && idx + 1 < line.length() && line.charAt(idx + 1) == '*') {
						inBlock = true;
						idx++;
					} else {
						sb.append(line.charAt(idx));
					}
				} else {
					if (line.charAt(idx) == '*' && idx + 1 < line.length() && line.charAt(idx + 1) == '/') {
						idx++;
						inBlock = false;
					}
				}
			}
			if (!inBlock && sb.length() > 0) {
				result.add(sb.toString());
				sb.setLength(0);
			}
		}
		return result;
	}

}
