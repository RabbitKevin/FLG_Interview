/*
    AC, String可以优化.
*/
public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(char x : s.toCharArray()) {
            if(x == ']') {//it means the sub string is done
                String str = "";
                while(!stack.peek().equals("[")) {
                    str = stack.pop()+str;
                }
                stack.pop();//remove [
                //get number
                int base = 1;
                int num = 0;
                while(!stack.isEmpty() && stack.peek().length() == 1 && isDigit(stack.peek().charAt(0))) {
                    num+=base*(stack.pop().charAt(0)-'0');
                    base*=10;
                }
                //---------------------------------//
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < num; ++i) {
                    sb.append(str);
                }
                stack.push(sb.toString());
            }
            else stack.push(String.valueOf(x));
        }
        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop()+result;
        }
        return result;
    }
    private boolean isDigit(char x) {
        return x >= '0' && x <= '9';
    }
}
