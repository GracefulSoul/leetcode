package gracefulsoul.problems;

public class MultiplyStrings {

	// https://leetcode.com/problems/multiply-strings/submissions/
	public static void main(String[] args) {
		MultiplyStrings test = new MultiplyStrings();
		System.out.println(test.multiply("2", "3"));
		System.out.println(test.multiply("123", "456"));
	}
	
    public String multiply(String num1, String num2) {
    	StringBuilder sb = new StringBuilder();
    	for (int num : this.getNumberArray(num1, num2)) {
    		if (sb.length() != 0 || num != 0) {
    			sb.append(num);
    		}
    	}
    	return sb.length() == 0 ? "0" : sb.toString();
    }
    
    private int[] getNumberArray(String num1, String num2) {
    	int[] arr = new int[num1.length() + num2.length()];
    	for (int i = num1.length() - 1; i >= 0; i--) {
    		for (int j = num2.length() - 1; j >= 0; j--) {
    			int sum = ((num1.charAt(i) - '0') * (num2.charAt(j) - '0')) + arr[i + j + 1];
    			arr[i + j] += sum / 10;
    			arr[i + j + 1] = sum % 10;
    		}
    	}
    	return arr;
	}

}
