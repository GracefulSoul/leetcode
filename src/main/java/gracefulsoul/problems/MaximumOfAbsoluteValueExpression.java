package gracefulsoul.problems;

public class MaximumOfAbsoluteValueExpression {

	// https://leetcode.com/problems/maximum-of-absolute-value-expression/submissions/1295495354/
	public static void main(String[] args) {
		MaximumOfAbsoluteValueExpression test = new MaximumOfAbsoluteValueExpression();
		System.out.println(test.maxAbsValExpr(new int[] { 1, 2, 3, 4 }, new int[] { -1, 4, 5, 6 }));
		System.out.println(test.maxAbsValExpr(new int[] { 1, -2, -5, 0, 10 }, new int[] { 0, -2, -1, -7, -4 }));
	}

	public int maxAbsValExpr(int[] arr1, int[] arr2) {
		int result = Integer.MIN_VALUE;
		int i1 = -arr1[0] - arr2[0];
		int i2 = -arr1[0] + arr2[0];
		int i3 = arr1[0] - arr2[0];
		int i4 = arr1[0] + arr2[0];
		for (int i = 1; i < arr1.length; i++) {
			result = Math.max(result
					, Math.max(i1 + arr1[i] + arr2[i] + i
							, Math.max(i2 + arr1[i] - arr2[i] + i,
									Math.max(i3 + -arr1[i] + arr2[i] + i
											, i4 + -arr1[i] - arr2[i] + i))));
			i1 = Math.max(i1, -arr1[i] - arr2[i] - i);
			i2 = Math.max(i2, -arr1[i] + arr2[i] - i);
			i3 = Math.max(i3, arr1[i] - arr2[i] - i);
			i4 = Math.max(i4, arr1[i] + arr2[i] - i);
		}
		return result;
	}

}
