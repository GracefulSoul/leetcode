package gracefulsoul.problems;

public class Base7 {

	// https://leetcode.com/submissions/detail/705870441/
	public static void main(String[] args) {
		Base7 test = new Base7();
		System.out.println(test.convertToBase7(100));
		System.out.println(test.convertToBase7(-7));
	}

	public String convertToBase7(int num) {
		if (num == 0) {
			return "0";
		} else {
			StringBuilder sb = new StringBuilder();
			String sign = "";
			if (num < 0) {
				num *= -1;
				sign = "-";
			}
			while (num > 0) {
				sb.append(num % 7);
				num /= 7;
			}
			sb.append(sign);
			return sb.reverse().toString();
		}
	}

}
