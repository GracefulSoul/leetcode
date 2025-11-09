package gracefulsoul.problems;

public class CountOperationsToObtainZero {

	// https://leetcode.com/problems/count-operations-to-obtain-zero/submissions/1824905343/
	public static void main(String[] args) {
		CountOperationsToObtainZero test = new CountOperationsToObtainZero();
		System.out.println(test.countOperations(2, 3));
		System.out.println(test.countOperations(10, 10));
	}

	public int countOperations(int num1, int num2) {
		int result = 0;
		while (num1 != 0 && num2 != 0) {
			result += num1 / num2;
			num1 %= num2;
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		return result;
	}

}
