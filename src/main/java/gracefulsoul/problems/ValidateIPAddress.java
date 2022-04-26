package gracefulsoul.problems;

public class ValidateIPAddress {

	// https://leetcode.com/submissions/detail/687572415/
	public static void main(String[] args) {
		ValidateIPAddress test = new ValidateIPAddress();
		System.out.println(test.validIPAddress("172.16.254.1"));
		System.out.println(test.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(test.validIPAddress("256.256.256.256"));
	}

	public String validIPAddress(String queryIP) {
		if (this.isIPv4(queryIP)) {
			return "IPv4";
		} else if (this.isIPv6(queryIP)) {
			return "IPv6";
		} else {
			return "Neither";
		}
	}

	private boolean isIPv4(String queryIP) {
		String[] octets = queryIP.split("\\.", -1);
		if (octets.length != 4) {
			return false;
		}
		for (String octet : octets) {
			if (octet.length() == 0 || octet.length() > 3 || (octet.charAt(0) == '0' && octet.length() != 1)) {
				return false;
			}
			int num = 0;
			for (int c : octet.toCharArray()) {
				if (c >= '0' && c <= '9') {
					num = (num * 10) + (c - '0');
				} else {
					return false;
				}
			}
			if (num > 255) {
				return false;
			}
		}
		return true;
	}

	private boolean isIPv6(String queryIP) {
		String[] octets = queryIP.split(":", -1);
		if (octets.length != 8) {
			return false;
		}
		for (String octet : octets) {
			if (octet.length() > 4 || octet.length() == 0) {
				return false;
			}
			for (int c : octet.toCharArray()) {
				if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
					return false;
				}
			}
		}
		return true;
	}

}
