package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

	// https://leetcode.com/problems/subdomain-visit-count/submissions/882143428/
	public static void main(String[] args) {
		SubdomainVisitCount test = new SubdomainVisitCount();
		System.out.println(test.subdomainVisits(new String[] { "9001 discuss.leetcode.com" }));
		System.out.println(test.subdomainVisits(new String[] { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" }));
	}

	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<>();
		for (String cpdomain : cpdomains) {
			String[] split = cpdomain.split(" ");
			this.saveCpdomains(map, split[1], Integer.valueOf(split[0]));
		}
		List<String> result = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			result.add(entry.getValue() + " " + entry.getKey());
		}
		return result;
	}

	private void saveCpdomains(Map<String, Integer> map, String domain, int time) {
		map.put(domain, map.getOrDefault(domain, 0) + time);
		int index = domain.indexOf('.');
		if (index != -1) {
			this.saveCpdomains(map, domain.substring(index + 1, domain.length()), time);
		}
	}

}
