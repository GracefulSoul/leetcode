package gracefulsoul.problems;

public class RomanToInteger {

	// https://leetcode.com/submissions/detail/483747749/
	public static void main(String[] args) {
		RomanToInteger test = new RomanToInteger();
		System.out.println(test.romanToInt("III"));
		System.out.println(test.romanToInt("IV"));
		System.out.println(test.romanToInt("IX"));
		System.out.println(test.romanToInt("LVIII"));
		System.out.println(test.romanToInt("MCMXCIV"));
	}

	public int romanToInt(String s) {
		char[] cArr = s.toCharArray();
		char lastWord = cArr[0];
		int result = this.getRomanValue(lastWord);
		for (int idx = 1; idx < cArr.length; idx++) {
			result += this.getRomanValue(cArr[idx]);
			result -= this.getMultipleRomanValue(new StringBuilder().append(lastWord).append(cArr[idx]).toString());
			lastWord = cArr[idx];
		}
		return result;
	}

	private int getRomanValue(char c) {
		switch (c) {
			case 'M': return 1000;
			case 'D': return 500;
			case 'C': return 100;
			case 'L': return 50;
			case 'X': return 10;
			case 'V': return 5;
			case 'I': return 1;
			default: return 0;
		}
	}

	private int getMultipleRomanValue(String s) {
		switch (s) {
			case "CM": case "CD": return 200;
			case "XC": case "XL": return 20;
			case "IX": case "IV": return 2;
			default: return 0;
		}
	}

}
