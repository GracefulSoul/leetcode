package gracefulsoul.problems;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {

	// https://leetcode.com/problems/design-underground-system/submissions/960876346/
	public static void main(String[] args) {
		UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);									// Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
		undergroundSystem.checkOut(27, "Waterloo", 20);									// Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
		undergroundSystem.checkOut(32, "Cambridge", 22);								// Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
		System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));	// return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));		// return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
		undergroundSystem.checkIn(10, "Leyton", 24);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));		// return 11.00000
		undergroundSystem.checkOut(10, "Waterloo", 38);									// Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));		// return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
		System.out.println();
		undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(10, "Leyton", 3);
		undergroundSystem.checkOut(10, "Paradise", 8);								// Customer 10 "Leyton" -> "Paradise" in 8-3 = 5
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));	// return 5.00000, (5) / 1 = 5
		undergroundSystem.checkIn(5, "Leyton", 10);
		undergroundSystem.checkOut(5, "Paradise", 16);								// Customer 5 "Leyton" -> "Paradise" in 16-10 = 6
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));	// return 5.50000, (5 + 6) / 2 = 5.5
		undergroundSystem.checkIn(2, "Leyton", 21);
		undergroundSystem.checkOut(2, "Paradise", 30);								// Customer 2 "Leyton" -> "Paradise" in 30-21 = 9
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));	// return 6.66667, (5 + 6 + 9) / 3 = 6.66667
	}

}

class UndergroundSystem {

	private Map<Integer, Map.Entry<String, Integer>> travel;
	private Map<Map.Entry<String, String>, Map.Entry<Double, Integer>> trip;

	public UndergroundSystem() {
		this.travel = new HashMap<>();
		this.trip = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		this.travel.putIfAbsent(id, new AbstractMap.SimpleEntry<>(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		if (!this.travel.containsKey(id)) {
			return;
		}
		Map.Entry<String, Integer> prev = this.travel.remove(id);
		Map.Entry<String, String> station = new AbstractMap.SimpleEntry<>(prev.getKey(), stationName);
		double time = t - prev.getValue();
		if (this.trip.containsKey(station)) {
			Map.Entry<Double, Integer> curr = this.trip.get(station);
			this.trip.put(station, new AbstractMap.SimpleEntry<>(curr.getKey() + time, curr.getValue() + 1));
		} else {
			this.trip.put(station, new AbstractMap.SimpleEntry<>(time, 1));
		}
	}

	public double getAverageTime(String startStation, String endStation) {
		Map.Entry<Double, Integer> curr = this.trip.get(new AbstractMap.SimpleEntry<>(startStation, endStation));
		return curr.getKey() / curr.getValue();
	}

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */