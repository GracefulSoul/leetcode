package gracefulsoul.problems;

public class MaskingPersonalInformation {

	// https://leetcode.com/problems/masking-personal-information/submissions/893249093/
	public static void main(String[] args) {
		MaskingPersonalInformation test = new MaskingPersonalInformation();
		System.out.println(test.maskPII("LeetCode@LeetCode.com"));
		System.out.println(test.maskPII("AB@qq.com"));
		System.out.println(test.maskPII("1(234)567-890"));
	}

	public String maskPII(String s) {
		StringBuilder sb = new StringBuilder();
		int position = s.indexOf('@');
		if (position > -1) {
			String temp = s.toLowerCase();
			sb.append(temp.charAt(0));
			for (int i = 0; i < 5; i++) {
				sb.append("*");
			}
			sb.append(temp.substring(position - 1));
		} else {
			String temp = s.replaceAll("\\W", "");
			int code = temp.length() - 10;
			if (code > 0) {
				for (int i = 0; i <= code + 1; i++) {
					if (i == 0) {
						sb.append("+");
					} else if (i == code + 1) {
						sb.append("-");
					} else {
						sb.append("*");
					}
				}
			}
			sb.append("***-***-" + temp.substring(code + 6));
		}
		return sb.toString();
	}

}
