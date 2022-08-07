package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

	// https://leetcode.com/submissions/detail/767970590/
	public static void main(String[] args) {
		FindDuplicateFileInSystem test = new FindDuplicateFileInSystem();
		System.out.println(test.findDuplicate(new String[] { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)" }));
		System.out.println(test.findDuplicate(new String[] { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)" }));
	}

	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] splits = path.split("\\s");
			for (int idx = 1; idx < splits.length; idx++) {
				String[] filePath = splits[idx].split("\\(");
				String content = filePath[1].substring(0, filePath[1].length() - 1);
				if (!map.containsKey(content)) {
					map.put(content, new ArrayList<>());
				}
				map.get(content).add(new StringBuilder(splits[0]).append("/").append(filePath[0]).toString());
			}
		}
		List<List<String>> result = new ArrayList<>();
		for (List<String> files : map.values()) {
			if (files.size() > 1) {
				result.add(files);
			}
		}
		return result;
	}

}
