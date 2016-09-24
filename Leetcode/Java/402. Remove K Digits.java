/*
    First ac, 26ms.
*/
public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(k != 0 && i != num.length()) {
            char x = num.charAt(i);
            if(stack.size() == 0 || stack.peek() <= x) {
                stack.push(x);
                i++;
            }
            else {
                stack.pop();
                k--;
            }
        }
        while(k != 0) {
            stack.pop();
            k--;
        }
        while(i != num.length()) {
            stack.push(num.charAt(i++));
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() != 0) sb.append(stack.pop());
        String result = sb.reverse().toString();
        i = 0;
        while(i < result.length() && result.charAt(i) == '0') ++i;
        result = result.substring(i);
        return result.length() == 0?"0":result;
    }
}

/*
    Second round, using stringbuilder as stack, 10ms
*/
public class Solution {
    public static String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c : num.toCharArray()) {
            while(k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > c) {
                sb.setLength(sb.length() - 1);
                k--;
            }
            if(sb.length() != 0 || c != '0') sb.append(c);  // Only append when it is not leading zero
        }
        if(k >= sb.length()) return "0";
        sb.setLength(sb.length() - k);  // use all remaining k
        return sb.toString();
    }
}
