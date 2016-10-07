/*
    Stack的写法:
        一开始跑出来22ms, 看了下是直接用str叠加处理，然后parseInt.
        直接用数字运算会更快，改了以后14ms.
*/
public class Solution {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        Stack<NestedInteger> stack = new Stack<>();
        int num = 0;
        boolean hasNumber = false;
        boolean isNegative = false;
        for(char x : s.toCharArray()) {
            if(x == '[') stack.push(new NestedInteger());
            else if(x == ',') {
                if(hasNumber) {
                    stack.peek().add(new NestedInteger(isNegative?-num:num));
                    hasNumber = false;
                    isNegative = false;
                    num = 0;
                }
            }
            else if(x == ']') {
                if(hasNumber) {
                    List<NestedInteger> tmp = stack.peek().getList();
                    int val = isNegative?-num:num;
                    if(tmp == null) stack.peek().setInteger(val);
                    else tmp.add(new NestedInteger(val));
                    num = 0;
                    hasNumber = false;
                    isNegative = false;
                }
                NestedInteger cur = stack.pop();
                if(!stack.isEmpty()) stack.peek().add(cur);
                else return cur;
            }
            else {
                hasNumber = true;
                if(x == '-') isNegative = true;
                else num = 10*num+(int)(x-'0');
            }
        }
        return null;
    }
}
