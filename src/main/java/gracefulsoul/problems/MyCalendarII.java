package gracefulsoul.problems;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyCalendarII {

	// https://leetcode.com/submissions/detail/847399702/
	public static void main(String[] args) {
		MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
		System.out.println(myCalendarTwo.book(10, 20)); // return True, The event can be booked. 
		System.out.println(myCalendarTwo.book(50, 60)); // return True, The event can be booked. 
		System.out.println(myCalendarTwo.book(10, 40)); // return True, The event can be double booked. 
		System.out.println(myCalendarTwo.book(5, 15));  // return False, The event cannot be booked, because it would result in a triple booking.
		System.out.println(myCalendarTwo.book(5, 10)); // return True, The event can be booked, as it does not use time 10 which is already double booked.
		System.out.println(myCalendarTwo.book(25, 55)); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
	}

}

class MyCalendarTwo {

	private TreeMap<Integer, Integer> map;

	public MyCalendarTwo() {
		this.map = new TreeMap<>();
		this.map.put(0, 0);
	}

	public boolean book(int start, int end) {
		SortedMap<Integer, Integer> sortedMap = this.map.subMap(start, end);
		for (Map.Entry<Integer, Integer> e : sortedMap.entrySet()) {
			if (e.getValue() == 2) {
				return false;
			}
		}
		Map.Entry<Integer, Integer> entry = this.map.floorEntry(start);
		if (entry.getValue() == 2) {
			return false;
		} else {
			this.map.put(start, entry.getValue());
			entry = this.map.floorEntry(end);
			this.map.put(end, entry.getValue());
			sortedMap = this.map.subMap(start, end);
			for (Map.Entry<Integer, Integer> e : sortedMap.entrySet()) {
				e.setValue(e.getValue() + 1);
			}
			return true;
		}
	}

}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */