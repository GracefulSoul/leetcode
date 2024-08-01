package gracefulsoul.problems;

public class NumberOfSeniorCitizens {

	// https://leetcode.com/problems/number-of-senior-citizens/submissions/1340480448/
	public static void main(String[] args) {
		NumberOfSeniorCitizens test = new NumberOfSeniorCitizens();
		System.out.println(test.countSeniors(new String[] { "7868190130M7522", "5303914400F9211", "9273338290F4010" }));
		System.out.println(test.countSeniors(new String[] { "1313579440F2036", "2921522980M5644" }));
	}

	public int countSeniors(String[] details) {
		int result = 0;
		for (String detail : details) {
			char ten = detail.charAt(11);
			if (ten > '6' || (ten == '6' && detail.charAt(12) > '0')) {
				result++;
			}
		}
		return result;
	}

}
