public class Solution {
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;
        //---------------------------//
        int i = 0;
        boolean isPositive = true;
        char x = str.charAt(0);
        if(x == '+' || x == '-') {// is + or -
            i++;
            isPositive = (x == '+');
            if(i == str.length() || str.charAt(i) > '9' || str.charAt(i) < '0') return 0;//but no left num or no num
        }
        else if(x < '0' || x > '9') return 0;//first char is not +- or num
        //--------Must have number------------//
        //Get the first non-zero num
        while(i < str.length() && str.charAt(i) == '0') ++i;
        if(i == str.length() || (str.charAt(i) < '0' || str.charAt(i) > '9')) return 0;
        int start = i;
        while(i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) ++i;
        String number = str.substring(start, i);
        if(number.length() > 10) return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        long result = Long.parseLong(number);
        if(!isPositive) result = -result;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;
    }
}
