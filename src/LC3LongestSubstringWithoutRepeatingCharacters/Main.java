package LC3LongestSubstringWithoutRepeatingCharacters;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = " ";
		int result = 0;
//		String s = "dvdf"; // 3
		String s = "pwwkew";
//		if (s == null || s.length() == 0) result = 0;
        int currLen = 1;
        int maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int tmpIdx = s.indexOf(currChar);
            if (tmpIdx < i) { // occur before
                maxLen = Math.max(maxLen, currLen);
                
                int subIdx = s.substring(i - currLen, i).indexOf(currChar) + (i - currLen); // NOTE idx in substring ! need to transform to idx in whole string
                System.out.println("==subIdx: "+Integer.toString(subIdx));
                if ( subIdx == -1) { // # former substring s[i-currLen, i-1] dont have currChar
                    currLen++;
                } else {
                    maxLen = Math.max(maxLen, currLen);
                    currLen = i - subIdx;
                }
                if (i == 5) {
                	System.out.println("--i=5 maxLen: " + Integer.toString(maxLen)+ " currLen: " + Integer.toString(currLen) + " subIdx: " + Integer.toString(subIdx));
                }
            } else {
                currLen++;
            }
            System.out.println("i: " + Integer.toString(i)+ " maxLen: " + Integer.toString(maxLen)+ " currLen: " + Integer.toString(currLen));
        }
		maxLen = Math.max(maxLen, currLen);
		result = maxLen;
		System.out.println("maxLen = " + Integer.toString(maxLen));
	}

}
