package gracefulsoul.problems;

public class SmallestDivisibleDigitProductII {

	// https://leetcode.com/problems/smallest-divisible-digit-product-ii/submissions/2098040206/
	public static void main(String[] args) {
		SmallestDivisibleDigitProductII test = new SmallestDivisibleDigitProductII();
		System.out.println(test.smallestNumber("1234", 256l));
		System.out.println(test.smallestNumber("12355", 50l));
		System.out.println(test.smallestNumber("11111", 26l));
	}

	public String smallestNumber(String num, long t) {
		long quotient = t;
		for (int i = 2; i <= 9; i++) {
			while (quotient % i == 0) {
				quotient /= i;
			}
		}
		if (quotient != 1) {
			return "-1";
		}
		int length = num.length();
		char[] charArray = num.toCharArray();
		long[] remaining = new long[length + 1];
		remaining[0] = t;
		int last = length - 1;
		for (int i = 0; i < length; i++) {
			int digit = charArray[i] - '0';
			if (digit == 0) {
				last = i;
				break;
			}
			remaining[i + 1] = remaining[i] / this.getGcd(remaining[i], digit);
		}
		if (remaining[length] == 1) {
			return num;
		}
		for (int i = last; i >= 0; i--) {
			int curr = charArray[i] - '0';
			for (int j = curr + 1; j <= 9; j++) {
				charArray[i] = (char) ('0' + j);
				long need = remaining[i];
				need /= this.getGcd(need, j);
				char[] suffix = new char[length - i - 1];
				int size = 0;
				for (int k = i + 1; k < length; k++) {
					int digit = 9;
					while (digit > 1 && need % digit != 0) {
						digit--;
					}
					if (need % digit == 0) {
						need /= digit;
					}
					suffix[size++] = (char) ('0' + digit);
				}
				if (need == 1) {
					for (int k = 0, l = size - 1; k < l; k++, l--) {
						char temp = suffix[k];
						suffix[k] = suffix[l];
						suffix[l] = temp;
					}
					for (int k = i + 1; k < length; k++) {
						charArray[k] = suffix[k - i - 1];
					}
					return new String(charArray);
				}
			}
			charArray[i] = num.charAt(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 2; i--) {
			while (t % i == 0) {
				sb.append(i);
				t /= i;
			}
		}
		int max = Math.max(length + 1, sb.length());
		while (sb.length() < max) {
			sb.append('1');
		}
		return sb.reverse().toString();
	}

	private long getGcd(long m, long n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
