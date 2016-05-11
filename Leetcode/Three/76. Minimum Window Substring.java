/*
    滑动窗口解题
*/
public class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";//corner case
        if(t.length() == 0) return "";
        int[] dic = new int[256];
        int[] window = new int[256];
        int count = 0;
        for(int i = 0;i < t.length(); ++i) {
            int index = (int)t.charAt(i);
            dic[index]++;
            count++;
        }
        //--------------------------------------//
        int num = 0;
        int left = 0;
        int right = 0;
        int leftB = 0;
        int length = Integer.MAX_VALUE;
        while(right < s.length()) {
            while(right < s.length() && num < count) {
                int n = (int)s.charAt(right++);
                if(dic[n] != 0) {//exist
                    if(window[n] < dic[n]) num++;
                    window[n]++;
                }
            }
            if(num < count) break;
            while(num == count) {
                int m = (int)s.charAt(left++);
                if(dic[m] != 0) {
                    if(dic[m] == window[m]) num--;
                    window[m]--;
                }
            }
            if(right-left+1 < length) {
                leftB = left-1;
                length = right-left+1;
            }
        }
        return length == Integer.MAX_VALUE?"":s.substring(leftB, leftB+length);
    }
}
