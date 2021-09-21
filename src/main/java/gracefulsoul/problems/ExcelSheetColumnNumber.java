package gracefulsoul.problems;

public class ExcelSheetColumnNumber {

	// https://leetcode.com/submissions/detail/558536318/
	public static void main(String[] args) {
		ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
		System.out.println(test.titleToNumber("A"));
		System.out.println(test.titleToNumber("AB"));
		System.out.println(test.titleToNumber("ZY"));
		System.out.println(test.titleToNumber("FXSHRXW"));
	}

	public int titleToNumber(String columnTitle) {
		int result = 0;
		for (int idx = 0; idx < columnTitle.length(); idx++) {
			result *= 26;
			result += columnTitle.charAt(idx) - 'A' + 1;
		}
		return result;
	}

}
