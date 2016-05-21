public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; ++i) {
            if(!isOperator(tokens[i])) stack.push(Integer.parseInt(tokens[i]));
            else {
                int one = stack.pop();
                int two = stack.pop();
                switch(tokens[i]) {
                    case "+" :
                        stack.push(one+two);
                        break;
                    case "-" :
                        stack.push(two-one);
                        break;
                    case "*" :
                        stack.push(one*two);
                        break;
                    case "/" :
                        stack.push(two/one);
                        break;
                }
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String x) {
        return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/");
    }
}
