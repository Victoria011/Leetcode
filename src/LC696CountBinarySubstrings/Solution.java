package LC696CountBinarySubstrings;

// Amazon OA 高频题 
// Approach 1: My solution  只打败了 5.19% 的人 慢了点
public class Solution { 
    public int countBinarySubstrings(String s) {
        // base case
        if ( s == null || s.length() <= 1) {
            return 0;
        }
        
        int count_0 = 0;
        int count_1 = 0;
        int count_sub = 0;
        for ( int i=0; i < s.length(); i++ ) {
            if ( s.charAt(i) == '0' ) {
                if ( i == 0 || s.charAt(i) != s.charAt(i-1) ) {
                    count_0 = 1;
                } else if ( s.charAt(i) == s.charAt(i-1) ) {
                    count_0 += 1;
                }
                if (count_0 <= count_1) {
                    count_sub += 1;
                }
            
            } else {
                if ( i == 0 || s.charAt(i) != s.charAt(i-1) ) {
                    count_1 = 1;
                } else if ( s.charAt(i) == s.charAt(i-1) ) {
                    count_1 += 1;
                }
                if (count_1 <= count_0) {
                    count_sub += 1;
                }
            }
        }
        return count_sub;
    }
}

// Approach 2: 
//Approach 2: Group same char into count
//class Solution {
// public int countBinarySubstrings(String s) {
//     int[] group = new int[s.length()];
//     int t = 0;
//     group[0] = 1;
//     for (int i = 1; i < s.length(); i++) {
//         if (s.charAt(i-1) != s.charAt(i)) {
//             group[++t] = 1;
//         } else {
//             group[t]++;
//         }
//     }
//     
//     int ans = 0;
//     for (int i = 1; i <= t; i++) {
//         ans += Math.min(group[i-1], group[i]);
//     }
//     return ans;
// }
//}


//Approach 3: calculate answer on the fly 实际上不需要保存group[] 只用记得前两位(也就是相同数字的count 就行了)
//class Solution {
// public int countBinarySubstrings(String s) {
//     int ans = 0, prev = 0, curr = 1;
//     for (int i = 1; i < s.length(); i++) { // i start from 1!
//         if ( s.charAt(i-1) != s.charAt(i) ) {
//             ans += Math.min(prev, curr);
//             prev = curr;
//             curr = 1;
//         } else {
//             curr++;
//         }
//     }
//     return ans + Math.min(prev, curr);
// }
//}