package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class DesignSpreadsheet {

	// https://leetcode.com/problems/design-spreadsheet/submissions/1775882717/
	public static void main(String[] args) {
		Spreadsheet spreadsheet = new Spreadsheet(3);		// Initializes a spreadsheet with 3 rows and 26 columns
		System.out.println(spreadsheet.getValue("=5+7"));	// returns 12 (5+7)
		spreadsheet.setCell("A1", 10);						// sets A1 to 10
		System.out.println(spreadsheet.getValue("=A1+6"));	// returns 16 (10+6)
		spreadsheet.setCell("B2", 15);						// sets B2 to 15
		System.out.println(spreadsheet.getValue("=A1+B2"));	// returns 25 (10+15)
		spreadsheet.resetCell("A1");						// resets A1 to 0
		System.out.println(spreadsheet.getValue("=A1+B2"));	// returns 15 (0+15)
	}

}

class Spreadsheet {

	private Map<String, Integer> map = new HashMap<>();

	public Spreadsheet(int rows) {
		this.map = new HashMap<>(rows);
	}

	public void setCell(String cell, int value) {
		this.map.put(cell, value);
	}

	public void resetCell(String cell) {
		this.map.put(cell, 0);
	}

	public int getValue(String formula) {
		formula = formula.substring(1);
		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i) == '+') {
				String s1 = formula.substring(0, i);
				String s2 = formula.substring(i + 1);
				return (Character.isUpperCase(s1.charAt(0)) ? this.map.getOrDefault(s1, 0) : Integer.parseInt(s1))
						+ (Character.isUpperCase(s2.charAt(0)) ? this.map.getOrDefault(s2, 0) : Integer.parseInt(s2));
			}
		}
		return 0;
	}

}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */