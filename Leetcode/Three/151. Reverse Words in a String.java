public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int left = s.length()-1;
        int right = s.length()-1;
        while(left >= 0) {
            while(left >= 0 && s.charAt(left) != ' ') left--;
            sb.append(s.substring(left+1, right+1));
            sb.append(' ');
            while(left >= 0 && s.charAt(left) == ' ') left--;
            right = left;
        }
        return sb.toString().trim();
    }
}
