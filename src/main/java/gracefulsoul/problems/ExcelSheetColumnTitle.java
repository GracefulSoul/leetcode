package gracefulsoul.problems;

public class ExcelSheetColumnTitle {

	// https://leetcode.com/submissions/detail/557233944/
	public static void main(String[] args) {
		ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
		System.out.println(test.convertToTitle(1));
		System.out.println(test.convertToTitle(28));
		System.out.println(test.convertToTitle(701));
		System.out.println(test.convertToTitle(2147483647));
	}

	public String convertToTitle(int columnNumber) {
		StringBuilder result = new StringBuilder();
		while (columnNumber > 0) {
			columnNumber--;
			result.append((char) ('A' + (columnNumber % 26)));
			columnNumber /= 26;
		}
		if (result.length() > 1) {
			result.reverse();
		}
		return result.toString();
	}

}
