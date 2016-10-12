/*
    这个写法不是最快的，但是比较直接.
    可以优化递归，不传递String, 直接记录index
*/
public class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            int index = (int)(c-'a');
            count[index]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; ++i) {
            if(count[i] != 0 && count[i] < k) sb.append((char)(i+'a'));
        }
        if(sb.length() == 0) return s.length();
        sb.append(']');
        String regex = "["+sb.toString();
        String[] subList = s.split(regex);
        int max = 0;
        for(String sub : subList) {
            max = Math.max(longestSubstring(sub, k), max);
        }
        return max;
    }
}
