package gracefulsoul.problems;

public class StringWithoutAAAOrBBB {

	// https://leetcode.com/problems/string-without-aaa-or-bbb/submissions/1037528879/
	public static void main(String[] args) {
		StringWithoutAAAOrBBB test = new StringWithoutAAAOrBBB();
		System.out.println(test.strWithout3a3b(1, 2));
		System.out.println(test.strWithout3a3b(4, 1));
	}

	public String strWithout3a3b(int a, int b) {
		StringBuilder sb = new StringBuilder(a + b);
		char ca = 'a';
		char cb = 'b';
		if (b > a) {
			ca = 'b';
			cb = 'a';
			int temp = a;
			a = b;
			b = temp;
		}
		while (a-- > 0) {
			sb.append(ca);
			if (a > b) {
				sb.append(ca);
				a--;
			}
			if (b-- > 0) {
				sb.append(cb);
			}
		}
		return sb.toString();
	}

}
