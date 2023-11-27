package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {

	// https://leetcode.com/submissions/detail/821560823/
	public static void main(String[] args) {
		TopKFrequentWords test = new TopKFrequentWords();
		System.out.println(test.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
		System.out.println(test.topKFrequent(new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		Queue<String> queue = new PriorityQueue<>((String str1, String str2) -> {
			if (map.get(str1) == map.get(str2)) {
				return str1.compareTo(str2);
			} else {
				return map.get(str2) - map.get(str1);
			}
		});
		queue.addAll(map.keySet());
		List<String> result = new ArrayList<>();
		while (k-- > 0) {
			if (!queue.isEmpty()) {
				result.add(queue.poll());
			}
		}
		return result;
	}

}
