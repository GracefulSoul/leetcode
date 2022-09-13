package gracefulsoul.problems;

public class RobotReturnToOrigin {

	// https://leetcode.com/submissions/detail/798680337/
	public static void main(String[] args) {
		RobotReturnToOrigin test = new RobotReturnToOrigin();
		System.out.println(test.judgeCircle("UD"));
		System.out.println(test.judgeCircle("LL"));
	}

	public boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		for (char move : moves.toCharArray()) {
			switch (move) {
				case 'U': y++; break;
				case 'R': x++; break;
				case 'L': x--; break;
				case 'D': y--; break;
			}
		}
		return x == 0 && y == 0;
	}

}
