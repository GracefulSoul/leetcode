package gracefulsoul.problems;

public class IntegerToEnglishWords {

	// https://leetcode.com/submissions/detail/592702170/
	public static void main(String[] args) {
		IntegerToEnglishWords test = new IntegerToEnglishWords();
		System.out.println(test.numberToWords(123));
		System.out.println(test.numberToWords(12345));
		System.out.println(test.numberToWords(1234567));
		System.out.println(test.numberToWords(1234567891));
	}

	private static String[] LOWER_THAN_20_WORDS = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	private static String[] TEN_WORDS = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		int hundreds = num % 1000;
		num /= 1000;
		int thousands = num % 1000;
		num /= 1000;
		int millions = num % 1000;
		num /= 1000;
		int billions = num;
		StringBuilder sb = new StringBuilder();
		if (billions > 0) {
			this.hundredsToWord(billions, sb);
			this.addSpace(sb);
			sb.append("Billion ");
		}
		if (millions > 0) {
			this.hundredsToWord(millions, sb);
			this.addSpace(sb);
			sb.append("Million ");
		}
		if (thousands > 0) {
			this.hundredsToWord(thousands, sb);
			this.addSpace(sb);
			sb.append("Thousand ");
		}
		if (hundreds > 0) {
			this.hundredsToWord(hundreds, sb);
		}
		return sb.toString().trim();
	}

	private void addSpace(StringBuilder sb) {
		if (sb.length() - 1 != sb.lastIndexOf(" ")) {
			sb.append(" ");
		}
	}

	private void hundredsToWord(int num, StringBuilder sb) {
		int tens = num % 100;
		num /= 100;
		if (num > 0) {
			this.tensToWord(num, sb);
			sb.append(" Hundred ");
		}
		if (tens > 0) {
			this.tensToWord(tens, sb);
		}
	}

	private void tensToWord(int num, StringBuilder sb) {
		if (num < 20) {
			sb.append(LOWER_THAN_20_WORDS[num]);
		} else {
			int tens = num / 10;
			if (tens > 0) {
				sb.append(TEN_WORDS[tens]).append(" ");
			}
			num %= 10;
			if (num > 0) {
				sb.append(LOWER_THAN_20_WORDS[num]);
			}
		}
	}

}
