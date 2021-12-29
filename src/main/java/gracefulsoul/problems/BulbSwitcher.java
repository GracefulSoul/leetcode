package gracefulsoul.problems;

public class BulbSwitcher {

	// https://leetcode.com/submissions/detail/609002764/
	public static void main(String[] args) {
		BulbSwitcher test = new BulbSwitcher();
		System.out.println(test.bulbSwitch(3));
		System.out.println(test.bulbSwitch(0));
		System.out.println(test.bulbSwitch(1));
	}

	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

}
