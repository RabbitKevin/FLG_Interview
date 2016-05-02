public class Solution {
    public int myAtoi(String str) {
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' ') ++i;
        if(i == str.length()) return 0;
        boolean isPositive = true;
        char one = str.charAt(i);
        if(one == '-' || one == '+') {
            isPositive = one == '+';
            ++i;
        }
        else if(one > '9' && one < '0') return 0;
        int j = i;
        while(j < str.length() && str.charAt(j) == '0') ++j;
        if(j == str.length()) return 0;//all '0'
        if(!isDigit(str.charAt(j))) return 0;
        i = j;//actual start
        j = i+1;
        while(j < str.length() && isDigit(str.charAt(j))) ++j;
        if(j - i > 10) return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        long num = Long.parseLong(str.substring(i, j));
        if(!isPositive) num*=-1;
        if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) num;
    }
    private boolean isDigit(char x) {
        return x <= '9' && x >= '0';
    }
}
