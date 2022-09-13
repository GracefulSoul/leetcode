package gracefulsoul.problems;

public class RobotReturnToOrigin {

	// https://leetcode.com/submissions/detail/798677286/
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
				case 'U': x++; break;
				case 'D': x--; break;
				case 'R': y++; break;
				case 'L': y--; break;
			}
		}
		return x == 0 && y == 0;
	}

}
