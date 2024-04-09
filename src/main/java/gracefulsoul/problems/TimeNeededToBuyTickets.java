package gracefulsoul.problems;

public class TimeNeededToBuyTickets {

	// https://leetcode.com/problems/time-needed-to-buy-tickets/submissions/1227468702/
	public static void main(String[] args) {
		TimeNeededToBuyTickets test = new TimeNeededToBuyTickets();
		System.out.println(test.timeRequiredToBuy(new int[] { 2, 3, 2 }, 2));
		System.out.println(test.timeRequiredToBuy(new int[] { 5, 1, 1, 1 }, 0));
	}

	public int timeRequiredToBuy(int[] tickets, int k) {
		int result = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (i <= k) {
				result += Math.min(tickets[i], tickets[k]);
			} else {
				result += Math.min(tickets[i], tickets[k] - 1);
			}
		}
		return result;
	}

}
