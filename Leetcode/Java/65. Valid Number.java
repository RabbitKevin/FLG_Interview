public class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        if(s.length() == 0) return false;
        int i = 0;
        if(s.charAt(i) == '+' || s.charAt(i) == '-') ++i;
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        //-----------------//
        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = true;
            }
            else if(c == '.') {
                if(exp || dot) return false;
                dot = true;
            }
            else if(c == 'e') {
                if(i+1 == s.length() || exp || !num) return false;
                exp = true;
            }
            else if(c == '+' || c == '-') {
                if(s.charAt(i-1) != 'e') return false;
                if(i+1 == s.length()) return false;
            }
            else return false;
            ++i;
        }
        return num;
    }
}
