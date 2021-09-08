package LC5LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0)
            return "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int start = 0 , end = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j>=0;j--)
            {
                boolean flag = s.charAt(i)==s.charAt(j);
                if(i==j)
                    dp[i][j] = true;

                else if(i-j==1 && flag)
                    dp[i][j] = true;

                else if(flag && dp[i-1][j+1])
                    dp[i][j] = true;

                if(dp[i][j] && i-j> end - start) // update end & start 
                {
                    end = i;
                    start = j;
                }
            }
        }
        return s.substring(start,end+1);
        
    }
}