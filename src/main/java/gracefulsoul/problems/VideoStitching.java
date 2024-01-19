package gracefulsoul.problems;

public class VideoStitching {

	// https://leetcode.com/problems/video-stitching/submissions/1150594976/
	public static void main(String[] args) {
		VideoStitching test = new VideoStitching();
		System.out.println(test.videoStitching(new int[][] {
			{ 0, 2 },
			{ 4, 6 },
			{ 8, 10 },
			{ 1, 9 },
			{ 1, 5 },
			{ 5, 9 }
		}, 3));
		System.out.println(test.videoStitching(new int[][] {
			{ 0, 1 },
			{ 1, 2 }
		}, 5));
	}

	public int videoStitching(int[][] clips, int time) {
		int min = 0;
		int max = 0;
		int result = 0;
		while (max < time) {
			for (int i = 0; i < clips.length; i++) {
				int[] clip = clips[i];
				if (clip[0] <= min && clip[1] > max) {
					max = clip[1];
				}
			}
			if (min == max) {
				return -1;
			}
			min = max;
			result++;
		}
		return result;
	}

}
