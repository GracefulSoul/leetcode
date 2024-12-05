package gracefulsoul.problems;

public class MovePiecesToObtainAString {

	// https://leetcode.com/problems/move-pieces-to-obtain-a-string/submissions/1470800610/
	public static void main(String[] args) {
		MovePiecesToObtainAString test = new MovePiecesToObtainAString();
		System.out.println(test.canChange("_L__R__R_", "L______RR"));
		System.out.println(test.canChange("R_L_", "__LR"));
		System.out.println(test.canChange("_R", "R_"));
	}

	public boolean canChange(String start, String target) {
		char[] startCharArray = start.toCharArray();
		char[] targetCharArray = target.toCharArray();
		int length = targetCharArray.length;
		int i = 0;
		int j = 0;
		while (i <= length && j <= length) {
			while (i < length && targetCharArray[i] == '_') {
				i++;
			}
			while (j < length && startCharArray[j] == '_') {
				j++;
			}
			if (i == length || j == length) {
				return i == length && j == length;
			}
			if (targetCharArray[i] != startCharArray[j]) {
				return false;
			}
			if (targetCharArray[i] == 'L') {
				if (j < i) {
					return false;
				}
			} else {
				if (i < j) {
					return false;
				}
			}
			i++;
			j++;
		}
		return true;
	}

}
