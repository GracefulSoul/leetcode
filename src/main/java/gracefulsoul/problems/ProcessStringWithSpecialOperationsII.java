package gracefulsoul.problems;

public class ProcessStringWithSpecialOperationsII {

	// https://leetcode.com/problems/process-string-with-special-operations-ii/submissions/2036304548/
	public static void main(String[] args) {
		ProcessStringWithSpecialOperationsII test = new ProcessStringWithSpecialOperationsII();
		System.out.println(test.processStr("a#b%*", 1));
		System.out.println(test.processStr("cd%#*#", 3));
		System.out.println(test.processStr("z*#", 0));
	}

	public char processStr(String s, long k) {
		long result = 0;
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			if (c == '*') {
				if (0 < result) {
					result--;
				}
			} else if (c == '#') {
				result *= 2;
			} else if (c == '%') {
			} else {
				result++;
			}
		}
		if (k < result) {
			for (int i = charArray.length - 1; i >= 0; i--) {
				char c = charArray[i];
	            switch (c) {
		            case '*':
		            	result++;
		                break;
		            case '#':
		                result /= 2;
		                if (result <= k) {
		                    k -= result;
		                }
		                break;
		            case '%':
		                k = result - 1 - k;
		                break;
		            default:
		                if (k == result - 1) {
		                    return c;
		                }
		                result--;
		        }
			}
		}
		return '.';
	}

}
