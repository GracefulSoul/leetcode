package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DistantBarcodes {

	// https://leetcode.com/problems/distant-barcodes/submissions/1213348032/
	public static void main(String[] args) {
		DistantBarcodes test = new DistantBarcodes();
		PrintUtil.print(test.rearrangeBarcodes(new int[] { 1, 1, 1, 2, 2, 2 }));
		PrintUtil.print(test.rearrangeBarcodes(new int[] { 1, 1, 1, 1, 2, 2, 3, 3 }));
	}

	public int[] rearrangeBarcodes(int[] barcodes) {
		int length = barcodes.length;
		for (int i = 1; i < length; i++) {
			if (barcodes[i] == barcodes[i - 1]) {
				int j = i + 1;
				while (j < length && barcodes[j] == barcodes[i]) {
					j++;
				}
				if (j < length) {
					barcodes[i] = barcodes[j];
					barcodes[j] = barcodes[i - 1];
				}
			}
		}
		for (int i = length - 2; i >= 0; i--) {
			if (barcodes[i] == barcodes[i + 1]) {
				int j = i - 1;
				while (j >= 0 && barcodes[j] == barcodes[i]) {
					j--;
				}
				if (j >= 0) {
					barcodes[i] = barcodes[j];
					barcodes[j] = barcodes[i + 1];
				}
			}
		}
		return barcodes;
	}

}
