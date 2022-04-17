package gracefulsoul.problems;

public class PoorPigs {

	// https://leetcode.com/submissions/detail/681944470/
	public static void main(String[] args) {
		PoorPigs test = new PoorPigs();
		System.out.println(test.poorPigs(1000, 15, 60));
		System.out.println(test.poorPigs(4, 15, 15));
		System.out.println(test.poorPigs(4, 15, 30));
	}

	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow((minutesToTest / minutesToDie) + 1, pigs) < buckets) {
            pigs++;
        }
        return pigs;
	}

}
