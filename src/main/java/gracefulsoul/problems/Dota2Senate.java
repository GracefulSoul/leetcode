package gracefulsoul.problems;

public class Dota2Senate {

	// https://leetcode.com/submissions/detail/792595083/
	public static void main(String[] args) {
		Dota2Senate test = new Dota2Senate();
		System.out.println(test.predictPartyVictory("RD"));
		System.out.println(test.predictPartyVictory("RDD"));
	}

	public String predictPartyVictory(String senate) {
		char[] charArray = senate.toCharArray();
		int flag = 0;
		boolean radiant = true;
		boolean dire = true;
		while (radiant && dire) {
			radiant = false;
			dire = false;
			for (int idx = 0; idx < charArray.length; idx++) {
				if (charArray[idx] == 'R') {
					if (flag > 0) {
						charArray[idx] = 'X';
					} else {
						radiant = true;
					}
					flag--;
				} else if (charArray[idx] == 'D') {
					if (flag < 0) {
						charArray[idx] = 'X';
					} else {
						dire = true;
					}
					flag++;
				}
			}
		}
		return radiant ? "Radiant" : "Dire";
	}

}
