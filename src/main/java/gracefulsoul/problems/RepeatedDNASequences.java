package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

	// https://leetcode.com/submissions/detail/561619480/
	public static void main(String[] args) {
		RepeatedDNASequences test = new RepeatedDNASequences();
		System.out.println(test.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(test.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> result = new HashSet<>();
		Set<String> temp = new HashSet<>();
		for (int idx = 0; idx + 9 < s.length(); idx++) {
			String sequences = s.substring(idx, idx + 10);
			if (!temp.add(sequences)) {
				result.add(sequences);
			}
		}
		return new ArrayList<>(result);
	}

}
