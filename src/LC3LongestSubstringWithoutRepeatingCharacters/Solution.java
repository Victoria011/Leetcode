package LC3LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int currLen = 1;
        int maxLen = 1;
        
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int tmpIdx = s.indexOf(currChar);
            if (tmpIdx < i) { // occur before
                maxLen = Math.max(maxLen, currLen);
                int subIdx = s.substring(i - currLen, i).indexOf(currChar) + (i - currLen);
                if ( subIdx == -1) { // # former substring s[i-currLen, i-1] dont have currChar
                    currLen++;
                } else {
                    maxLen = Math.max(maxLen, currLen);
                    currLen = i - subIdx;
                }
            } else {
                currLen++;
            }
        }
        maxLen = Math.max(maxLen, currLen);
        return maxLen;
    }
}