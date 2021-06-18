package gracefulsoul.problems;

public class SqrtX {

	// https://leetcode.com/submissions/detail/509548768/
	public static void main(String[] args) {
		SqrtX test = new SqrtX();
		System.out.println(test.mySqrt(4));
		System.out.println(test.mySqrt(8));
	}

	public int mySqrt(int x) {
		long result = x;
		while (result * result > x) {
			result = (result + x / result) / 2;
		}
		return (int)result;
	}

}
