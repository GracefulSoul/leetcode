package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {

	// https://leetcode.com/submissions/detail/616163322/
	public static void main(String[] args) {
		ReconstructItinerary test = new ReconstructItinerary();
		List<List<String>> tickets1 = new ArrayList<>();
		List<String> ticket1_1 = new ArrayList<String>();
		ticket1_1.add("MUC");
		ticket1_1.add("LHR");
		tickets1.add(ticket1_1);
		List<String> ticket1_2 = new ArrayList<String>();
		ticket1_2.add("JFK");
		ticket1_2.add("MUC");
		tickets1.add(ticket1_2);
		List<String> ticket1_3 = new ArrayList<String>();
		ticket1_3.add("SFO");
		ticket1_3.add("SJC");
		tickets1.add(ticket1_3);
		List<String> ticket1_4 = new ArrayList<String>();
		ticket1_4.add("LHR");
		ticket1_4.add("SFO");
		tickets1.add(ticket1_4);
		System.out.println(test.findItinerary(tickets1));
		test = new ReconstructItinerary();
		List<List<String>> tickets2 = new ArrayList<>();
		List<String> ticket2_1 = new ArrayList<String>();
		ticket2_1.add("JFK");
		ticket2_1.add("SFO");
		tickets2.add(ticket2_1);
		List<String> ticket2_2 = new ArrayList<String>();
		ticket2_2.add("JFK");
		ticket2_2.add("ATL");
		tickets2.add(ticket2_2);
		List<String> ticket2_3 = new ArrayList<String>();
		ticket2_3.add("SFO");
		ticket2_3.add("ATL");
		tickets2.add(ticket2_3);
		List<String> ticket2_4 = new ArrayList<String>();
		ticket2_4.add("ATL");
		ticket2_4.add("JFK");
		tickets2.add(ticket2_4);
		List<String> ticket2_5 = new ArrayList<String>();
		ticket2_5.add("ATL");
		ticket2_5.add("SFO");
		tickets2.add(ticket2_5);
		System.out.println(test.findItinerary(tickets2));
	}

	private Map<String, Queue<String>> targets = new HashMap<>();
	private List<String> result = new LinkedList<>();

	public List<String> findItinerary(List<List<String>> tickets) {
		for (List<String> t : tickets) {
			this.targets.putIfAbsent(t.get(0), new PriorityQueue<>());
			this.targets.get(t.get(0)).add(t.get(1));
		}
		this.recursive("JFK");
		return this.result;
	}

	private void recursive(String departure) {
		while (this.targets.containsKey(departure) && !this.targets.get(departure).isEmpty()) {
			this.recursive(this.targets.get(departure).poll());
		}
		this.result.add(0, departure);
	}

}
