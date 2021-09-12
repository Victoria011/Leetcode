package LC3LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

//public class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) return 0;
//        int currLen = 1;
//        int maxLen = 1;
//        
//        for (int i = 1; i < s.length(); i++) {
//            char currChar = s.charAt(i);
//            int tmpIdx = s.indexOf(currChar);
//            if (tmpIdx < i) { // occur before
//                maxLen = Math.max(maxLen, currLen);
//                int subIdx = s.substring(i - currLen, i).indexOf(currChar) + (i - currLen);
//                if ( subIdx == -1) { // # former substring s[i-currLen, i-1] dont have currChar
//                    currLen++;
//                } else {
//                    maxLen = Math.max(maxLen, currLen);
//                    currLen = i - subIdx;
//                }
//            } else {
//                currLen++;
//            }
//        }
//        maxLen = Math.max(maxLen, currLen);
//        return maxLen;
//    }
//}

//class Solution {
//public int lengthOfLongestSubstring(String s) {
//  int[] chars = new int[128];
//  int left = 0;
//  int right = 0;
//  int res = 0;
 
//  while (right < s.length()) {
//      char r = s.charAt(right);
//      chars[r]++;
     
//      while (chars[r] > 1) { // seen before
//          char l = s.charAt(left);
//          chars[l]--;
//          left++;
//      }
     
//      res = Math.max(res, right - left + 1);
//      right++;
//  }
//  return res;
//}
//}

//public class Solution {
//public int lengthOfLongestSubstring(String s) {
//  int n = s.length(), ans = 0;
//  Map<Character, Integer> map = new HashMap<>(); // current index of character
//  // try to extend the range [i, j]
//  for (int j = 0, i = 0; j < n; j++) {
//      if (map.containsKey(s.charAt(j))) {
//          i = Math.max(map.get(s.charAt(j)), i);
//      }
//      ans = Math.max(ans, j - i + 1);
//      map.put(s.charAt(j), j + 1);
//  }
//  return ans;
//}
//}

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
	 // try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
}