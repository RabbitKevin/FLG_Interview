public class Solution {
    public String countAndSay(int n) {
        String num = String.valueOf(1);
        for(int i = 1; i < n; ++i) {
            num = count(num);
        }
        return num;
    }
    private String count(String num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length();) {
            char x = num.charAt(i);
            int j = i+1;
            while(j < num.length() && num.charAt(j) == x) ++j;
            sb.append(j-i);
            sb.append(x);
            i = j;
        }
        return sb.toString();
    }
}
