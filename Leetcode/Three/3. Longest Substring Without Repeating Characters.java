/*
    Hash
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < s.length(); ++i) {
            char x = s.charAt(i);
            if(!set.contains(x)) {
                set.add(x);
            }
            else {
                max = Math.max(i-left, max);
                while(s.charAt(left) != x) {
                    set.remove(s.charAt(left++));
                }
                left++;
            }
        }
        return Math.max(s.length()-left, max);
    }
}
