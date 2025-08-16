package gracefulsoul.problems;

public class Maximum69Number {

	// https://leetcode.com/problems/maximum-69-number/submissions/1736770689/
	public static void main(String[] args) {
		Maximum69Number test = new Maximum69Number();
		System.out.println(test.maximum69Number(9669));
		System.out.println(test.maximum69Number(9996));
		System.out.println(test.maximum69Number(9999));
	}

	public int maximum69Number(int num) {
		int position = -1;
		for (int i = 0, temp = num, remainder = temp % 10; temp > 1; i++, temp /= 10, remainder = temp % 10) {
			if (remainder == 6) {
				position = i;
			}
		}
		if (-1 < position) {
			num += (int) (3 * Math.pow(10, position));
		}
		return num;
	}

}
