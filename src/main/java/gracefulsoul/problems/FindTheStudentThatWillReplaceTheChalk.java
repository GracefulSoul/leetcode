package gracefulsoul.problems;

public class FindTheStudentThatWillReplaceTheChalk {

	// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/submissions/1376274842/
	public static void main(String[] args) {
		FindTheStudentThatWillReplaceTheChalk test = new FindTheStudentThatWillReplaceTheChalk();
		System.out.println(test.chalkReplacer(new int[] { 5, 1, 5 }, 22));
		System.out.println(test.chalkReplacer(new int[] { 3, 4, 1, 2 }, 25));
	}

	public int chalkReplacer(int[] chalk, int k) {
		long sum = 0;
		for (int studentChalkUse : chalk) {
			sum += studentChalkUse;
		}
		k %= sum;
		for (int i = 0; i < chalk.length; i++) {
			if ((k -= chalk[i]) < 0) {
				return i;
			}
		}
		return -1;
	}

}
