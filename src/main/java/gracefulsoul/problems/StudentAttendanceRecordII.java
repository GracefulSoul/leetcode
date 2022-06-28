package gracefulsoul.problems;

public class StudentAttendanceRecordII {

	// https://leetcode.com/submissions/detail/733342960/
	public static void main(String[] args) {
		StudentAttendanceRecordII test = new StudentAttendanceRecordII();
		System.out.println(test.checkRecord(2));
		System.out.println(test.checkRecord(1));
	}

	public int checkRecord(int n) {
		int[] dp = { 1, 1, 0, 1, 0, 0 };
		for (int idx = 2; idx <= n; idx++) {
			dp = new int[] { this.getSum(dp, 0, 2), dp[0], dp[1], this.getSum(dp, 0, 5), dp[3], dp[4] };
		}
		return this.getSum(dp, 0, 5);
	}

	private int getSum(int[] dp, int low, int high) {
		int sum = 0;
		for (int idx = low; idx <= high; idx++) {
			sum = (sum + dp[idx]) % 1000000007;
		}
		return sum;
	}

}
