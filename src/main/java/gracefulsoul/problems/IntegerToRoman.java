package gracefulsoul.problems;

public class IntegerToRoman {

	// https://leetcode.com/submissions/detail/482958970/
	public static void main(String[] args) {
		IntegerToRoman test = new IntegerToRoman();
		System.out.println(test.intToRoman(3));
		System.out.println(test.intToRoman(4));
		System.out.println(test.intToRoman(9));
		System.out.println(test.intToRoman(58));
		System.out.println(test.intToRoman(1994));
	}

	public String intToRoman(int num) {
		String[] romans = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] nums = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while (num > 0) {
			int multiple = num / nums[idx];
			for (int i = 0; i < multiple; i++) {
				num -= nums[idx];
				sb.append(romans[idx]);
			}
			idx++;
		}
		return sb.toString();
	}

}
