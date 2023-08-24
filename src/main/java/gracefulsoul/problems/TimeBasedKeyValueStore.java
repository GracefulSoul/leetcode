package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

	// https://leetcode.com/problems/time-based-key-value-store/submissions/1030382892/
	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("foo", "bar", 1);				// store the key "foo" and value "bar" along with timestamp = 1.
		System.out.println(timeMap.get("foo", 1));	// return "bar"
		System.out.println(timeMap.get("foo", 3));	// return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
		timeMap.set("foo", "bar2", 4);				// store the key "foo" and value "bar2" along with timestamp = 4.
		System.out.println(timeMap.get("foo", 4));	// return "bar2"
		System.out.println(timeMap.get("foo", 5));	// return "bar2"
	}

}

class TimeMap {

	private Map<String, List<Pair>> map;

	public TimeMap() {
		this.map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!this.map.containsKey(key)) {
			this.map.put(key, new ArrayList<>());
		}
		this.map.get(key).add(new Pair(value, timestamp));
	}

	public String get(String key, int timestamp) {
		if (!this.map.containsKey(key)) {
			return "";
		} else {
			return this.binarySearch(this.map.get(key), timestamp);
		}
	}

	protected String binarySearch(List<Pair> list, int timestamp) {
		int left = 0;
		int right = list.size() - 1;
		while (left < right) {
			int mid = (left + right + 1) >> 1;
			if (list.get(mid).timestamp <= timestamp) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return list.get(left).timestamp <= timestamp ? list.get(left).value : "";
	}

}

class Pair {

	String value;
	int timestamp;

	public Pair(String value, int timestamp) {
		this.value = value;
		this.timestamp = timestamp;
	}

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
