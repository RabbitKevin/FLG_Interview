public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() < 2) return s;
        int max = 0;
        for(int i = 0; i <= ((s.length()-1) >> 1); ++i) {
            //-----single-------/
            if(isValid(s, i, i)) {
                max = Math.max(2*i+1, max);
            }
            if(s.length() >= 2*i+2){
                if(isValid(s, i, i+1)) {
                    max = Math.max(2*i+2, max);
                }
            }
        }
        String trail = s.substring(max);
        String tmp = new StringBuilder(trail).reverse().toString();
        return tmp+s;
    }
    private boolean isValid(String s, int left, int right) {
        for(int i = left; i >= 0; --i) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            else return false;
        }
        return true;
    }
}
