package gracefulsoul.problems;

public class ZigZagConversion {

	// https://leetcode.com/submissions/detail/480333369/
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("AB", 1));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		char[] c = s.toCharArray();
		StringBuilder[] sbArr = initStringBuilderArray(numRows);
		int sign = 1;
		int i = 0;
		for (int idx = 0; idx < c.length; idx++) {
			sbArr[i].append(c[idx]);
			if (idx != 0 && idx % (numRows - 1) == 0) {
				sign *= (-1);
			}
			i += sign;
		}
		return getResult(sbArr);
	}

	private static StringBuilder[] initStringBuilderArray(int numRows) {
		StringBuilder[] sbArr = new StringBuilder[numRows];
		for (int idx = 0; idx < sbArr.length; idx++) {
			sbArr[idx] = new StringBuilder();
		}
		return sbArr;
	}

	private static String getResult(StringBuilder[] sbArr) {
		for (int idx = 1; idx < sbArr.length; idx++) {
			sbArr[0].append(sbArr[idx]);
		}
		return sbArr[0].toString();
	}

}
