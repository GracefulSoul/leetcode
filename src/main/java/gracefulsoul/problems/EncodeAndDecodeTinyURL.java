package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

	// https://leetcode.com/submissions/detail/724321153/
	public static void main(String[] args) {
		Codec obj = new Codec();
		String tiny = obj.encode("https://leetcode.com/problems/design-tinyurl"); // returns the encoded tiny url.
		System.out.println(tiny);
		String ans = obj.decode(tiny); // returns the original url after deconding it.
		System.out.println(ans);
	}

}

class Codec {

	private Map<Integer, String> map = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		int key = longUrl.hashCode();
		this.map.put(key, longUrl);
		return String.valueOf(key);

	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return this.map.get(Integer.parseInt(shortUrl));
	}

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));