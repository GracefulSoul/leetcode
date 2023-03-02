package gracefulsoul.problems;

public class MirrorReflection {

	// https://leetcode.com/problems/mirror-reflection/submissions/907663037/
	public static void main(String[] args) {
		MirrorReflection test = new MirrorReflection();
		System.out.println(test.mirrorReflection(2, 1));
		System.out.println(test.mirrorReflection(3, 1));
	}

	public int mirrorReflection(int p, int q) {
		while (p % 2 == 0 && q % 2 == 0) {
			p /= 2;
			q /= 2;
		}
		return 1 - (p % 2) + (q % 2);
	}

}
