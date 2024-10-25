package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {

	// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/submissions/1433207149/
	public static void main(String[] args) {
		RemoveSubFoldersFromTheFilesystem test = new RemoveSubFoldersFromTheFilesystem();
		System.out.println(test.removeSubfolders(new String[] { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" }));
		System.out.println(test.removeSubfolders(new String[] { "/a", "/a/b/c", "/a/b/d" }));
		System.out.println(test.removeSubfolders(new String[] { "/a/b/c", "/a/b/ca", "/a/b/d" }));
	}

	public List<String> removeSubfolders(String[] folder) {
		Arrays.sort(folder);
		List<String> result = new ArrayList<>();
		for (String path : folder) {
			if (result.isEmpty() || !path.startsWith(result.get(result.size() - 1) + "/")) {
				result.add(path);
			}
		}
		return result;
	}

}
