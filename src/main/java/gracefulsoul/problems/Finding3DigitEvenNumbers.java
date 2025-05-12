package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class Finding3DigitEvenNumbers {

	// https://leetcode.com/problems/finding-3-digit-even-numbers/submissions/1631775997/
	public static void main(String[] args) {
		Finding3DigitEvenNumbers test = new Finding3DigitEvenNumbers();
		PrintUtil.print(test.findEvenNumbers(new int[] { 2, 1, 3, 0 }));
		PrintUtil.print(test.findEvenNumbers(new int[] { 2, 2, 8, 8, 2 }));
		PrintUtil.print(test.findEvenNumbers(new int[] { 3, 7, 5 }));
	}

	public int[] findEvenNumbers(int[] digits) {
		int[] counts = new int[10];
		for (int digit : digits) {
			counts[digit]++;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			if (0 < counts[i]) {
				counts[i]--;
				for (int j = 0; j < 10; j++) {
					if (0 < counts[j]) {
						counts[j]--;
						for (int k = 0; k < 10; k += 2) {
							if (0 < counts[k]) {
								list.add(i * 100 + j * 10 + k);
							}
						}
						counts[j]++;
					}
				}
				counts[i]++;
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

}
