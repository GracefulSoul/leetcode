package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	// https://leetcode.com/submissions/detail/521632318/
	public static void main(String[] args) {
		RestoreIPAddresses test = new RestoreIPAddresses();
		System.out.println(test.restoreIpAddresses("101023"));

	}

	public List<String> restoreIpAddresses(String s) {
		List<String> ipAddresses = new ArrayList<>();
		this.recursive(s, ipAddresses, new StringBuilder(), 0, 0);
		return ipAddresses;
	}

	private void recursive(String s, List<String> list, StringBuilder sb, int index, int part) {
		if (index > s.length() || part > 4) {
			return;
		} else if (index == s.length() && part == 4) {
			list.add(sb.toString());
			return;
		} else {
			for (int length = 1; length <= 3; length++) {
				if (index + length > s.length()) {
					break;
				}
				int num = Integer.valueOf(s.substring(index, index + length));
				if (length == 1 || (length == 2 && num >= 10 && num <= 99)
						|| (length == 3 && num >= 100 && num <= 255)) {
					sb.append(num);
					if (part < 3) {
						sb.append(".");
					}
					this.recursive(s, list, sb, index + length, part + 1);
					if (part < 3) {
						sb.deleteCharAt(sb.length() - 1);
					}
					sb.delete(sb.length() - length, sb.length());
				}
			}
		}
	}

}
