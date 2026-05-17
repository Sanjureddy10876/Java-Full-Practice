package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKCharacters {
	
	public static int longestKdistrct(String s, int k) {
		
		Map<Character,Integer> res = new HashMap<>();
		
		int left =0;
		int maxx = 0;
		
		for (int right = 0; right < s.length(); right++) {
		res.put(s.charAt(right), res.getOrDefault(s.charAt(right), 0)+1);
		
		while (res.size() > k) {
			char c = s.charAt(left);
			res.put(c, res.get(c)-1);
			if (res.get(c)==0) {
				res.remove(c);
			}
			 
			left ++;
			
		 }
		 maxx = Math.max(maxx, right-left+1);
		}
		
		return maxx;
	}
	
	public static void main(String[] args) {
		String s = "aceba";
		int k = 2;
		int result = longestKdistrct(s,k);
//		for(int str : result) {
//			System.out.println(str +":::::"+result);
//		}
		System.out.println(":::::"+result);
	}

}
