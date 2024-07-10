package gracefulsoul.problems;

public class CrawlerLogFolder {

	// https://leetcode.com/problems/crawler-log-folder/submissions/1316181068/
	public static void main(String[] args) {
		CrawlerLogFolder test = new CrawlerLogFolder();
		System.out.println(test.minOperations(new String[] { "d1/", "d2/", "../", "d21/", "./" }));
		System.out.println(test.minOperations(new String[] { "d1/", "d2/", "./", "d3/", "../", "d31/" }));
		System.out.println(test.minOperations(new String[] { "d1/", "../", "../", "../" }));
	}

	public int minOperations(String[] logs) {
		int result = 0;
		for (String log : logs) {
			switch (log) {
				case "../": result = Math.max(0, --result); break;
				case "./": break;
				default: result++; break;
			}
		}
		return result;
	}

}
