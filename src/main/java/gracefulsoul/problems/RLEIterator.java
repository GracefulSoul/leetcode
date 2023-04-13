package gracefulsoul.problems;

public class RLEIterator {

	// https://leetcode.com/problems/rle-iterator/submissions/933030339/
	public static void main(String[] args) {
		RLEIterator rLEIterator = new RLEIterator(new int[] {3, 8, 0, 9, 2, 5}); // This maps to the sequence [8,8,8,5,5].
		System.out.println(rLEIterator.next(2)); // exhausts 2 terms of the sequence, returning 8. The remaining sequence is now [8, 5, 5].
		System.out.println(rLEIterator.next(1)); // exhausts 1 term of the sequence, returning 8. The remaining sequence is now [5, 5].
		System.out.println(rLEIterator.next(1)); // exhausts 1 term of the sequence, returning 5. The remaining sequence is now [5].
		System.out.println(rLEIterator.next(2)); // exhausts 2 terms, returning -1. This is because the first term exhausted was 5, but the second term did not exist. Since the last term exhausted does not exist, we return -1.
	}

	private int[] encoding;
	private int index;

	public RLEIterator(int[] encoding) {
		this.encoding = encoding;
		this.index = 0;
	}

	public int next(int n) {
		while (this.index < this.encoding.length) {
			if (n > this.encoding[this.index]) {
				n -= this.encoding[this.index];
				this.index += 2;
			} else {
				this.encoding[this.index] -= n;
				return this.encoding[this.index + 1];
			}
		}
		return -1;
	}

}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */