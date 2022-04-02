package gracefulsoul.problems;

public class StringCompression {

	// https://leetcode.com/submissions/detail/672559481/
	public static void main(String[] args) {
		StringCompression test = new StringCompression();
		System.out.println(test.compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
		System.out.println(test.compress(new char[] { 'a' }));
		System.out.println(test.compress(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }));
	}

	public int compress(char[] chars) {
		int i = 0;
		int j = 0;
		int index = 0;
		int length = chars.length;
		while (j < length) {
			int count = 0;
			char curr = chars[i];
			while (j < length && chars[j] == curr) {
				j++;
				count++;
			}
			chars[index++] = curr;
			if (count > 1) {
				if (count < 10) {
					chars[index++] = (char) (count + '0');
				} else {
					for (char c : String.valueOf(count).toCharArray()) {
						chars[index++] = c;
					}
				}
			}
			i = j;
		}
		return index;
	}

}
