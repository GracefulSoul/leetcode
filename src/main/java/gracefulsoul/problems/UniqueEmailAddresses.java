package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	// https://leetcode.com/problems/unique-email-addresses/submissions/960198427/
	public static void main(String[] args) {
		UniqueEmailAddresses test = new UniqueEmailAddresses();
		System.out.println(test.numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" }));
		System.out.println(test.numUniqueEmails(new String[] { "a@leetcode.com", "b@leetcode.com", "c@leetcode.com" }));
	}

	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			int length = email.length();
			StringBuilder sb = new StringBuilder(length);
			for (int i = 0; i < length; i++) {
				char c = email.charAt(i);
				switch (c) {
					case '.':
						break;
					case '+':
						while (c != '@') {
							c = email.charAt(++i);
						}
						sb.append(email.substring(i));
						i = length;
						break;
					case '@':
						sb.append(email.substring(i));
						i = length;
						break;
					default:
						sb.append(c);
				}
			}
			set.add(sb.toString());
		}
		return set.size();
	}

}
