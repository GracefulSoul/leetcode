package gracefulsoul.problems;

public class DefangingAnIPAddress {

	// https://leetcode.com/problems/defanging-an-ip-address/submissions/1260937901/
	public static void main(String[] args) {
		DefangingAnIPAddress test = new DefangingAnIPAddress();
		System.out.println(test.defangIPaddr("1.1.1.1"));
		System.out.println(test.defangIPaddr("255.100.50.0"));
	}

	public String defangIPaddr(String address) {
		StringBuilder sb = new StringBuilder();
		for (char c : address.toCharArray()) {
			sb.append(c == '.' ? "[.]" : c);
		}
		return sb.toString();
	}

}
