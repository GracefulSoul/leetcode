package gracefulsoul.problems;

import java.util.Stack;

public class TagValidator {

	// https://leetcode.com/submissions/detail/753624184/
	public static void main(String[] args) {
		TagValidator test = new TagValidator();
		System.out.println(test.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
		System.out.println(test.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
		System.out.println(test.isValid("<A>  <B> </A>   </B>"));
	}

	public boolean isValid(String code) {
		Stack<String> stack = new Stack<>();
		int end = 0;
		while (end < code.length()) {
			if (end > 0 && stack.isEmpty()) {
				return false;
			}
			if (code.startsWith("<![CDATA[", end)) {
				int start = end + 9;
				end = code.indexOf("]]>", start);
				if (end < 0) {
					return false;
				}
				end += 3;
			} else if (code.startsWith("</", end)) {
				int start = end + 2;
				end = code.indexOf(">", start);
				if (end < 0 || end == start || end - start > 9 || stack.isEmpty() || !code.substring(start, end++).equals(stack.pop())) {
					return false;
				}
			} else if (code.startsWith("<", end)) {
				int start = end + 1;
				end = code.indexOf(">", start);
				if (end < 0 || end == start || end - start > 9) {
					return false;
				}
				for (int k = start; k < end; k++) {
					if (!Character.isUpperCase(code.charAt(k))) {
						return false;
					}
				}
				stack.push(code.substring(start, end++));
			} else {
				end++;
			}
		}
		return stack.isEmpty();
	}

}
