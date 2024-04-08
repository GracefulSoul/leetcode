package gracefulsoul.problems;

public class NumberOfStudentsUnableToEatLunch {

	// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/submissions/1226602851/
	public static void main(String[] args) {
		NumberOfStudentsUnableToEatLunch test = new NumberOfStudentsUnableToEatLunch();
		System.out.println(test.countStudents(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }));
		System.out.println(test.countStudents(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }));
	}

	public int countStudents(int[] students, int[] sandwiches) {
		int[] count = { 0, 0 };
		int length = students.length;
		for (int student : students) {
			count[student]++;
		}
		for (int k = 0; 0 < length && 0 < count[sandwiches[k]]; k++, length--) {
			count[sandwiches[k]]--;
		}
		return length;
	}

}
