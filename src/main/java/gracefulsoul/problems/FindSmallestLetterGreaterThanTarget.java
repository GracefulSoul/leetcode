package gracefulsoul.problems;

public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		FindSmallestLetterGreaterThanTarget test = new FindSmallestLetterGreaterThanTarget();
		System.out.println(test.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a'));
		System.out.println(test.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'c'));
		System.out.println(test.nextGreatestLetter(new char[] { 'x', 'x', 'y', 'y' }, 'z'));
	}

	public char nextGreatestLetter(char[] letters, char target) {
		int length = letters.length;
		int left = 0;
		int right = length;
		while (left < right) {
			int mid = left + ((right - left) / 2);
			if (letters[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return letters[left % length];
	}

}
