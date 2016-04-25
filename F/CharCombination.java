import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        String num = "1024";
        combination(result, num, 0, "");
        System.out.println(result);
    }
    public static void combination(List<String> result, String num, int i, String str) {
        if(i == num.length()) {
            result.add(str);
            return;
        }
        char x = num.charAt(i);
        if(x == '0') return;
        //----Single char----//
        combination(result, num, i+1, str+transfer(x-'0'));
        //----May have two consecutive number----//
        if(i+1 == num.length()) return;
        char y = num.charAt(i+1);
        if(x == '1' || (x == '2' && y < '7')) {
            int count = 10*(x-'0')+(y-'0');
            combination(result, num, i+2, str+transfer(count));
        }
    }
    private static char transfer(int num) {
        num--;
        return (char)('A'+num);
    }
}
