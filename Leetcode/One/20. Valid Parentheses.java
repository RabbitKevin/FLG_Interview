class Solution {
    public boolean isValid(String s) {
        char[] letters = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char letter : letters) {
            if(letter == '(' || letter == '{' || letter == '[') stack.push(letter);
            else {
                if(stack.size() == 0) return false;//if right side occurs first
                char topElement = stack.pop();
                if((topElement == '(' && letter == ')') || (topElement == '{' && letter == '}') ||  (topElement == '[' && letter == ']')) { continue;}
                else return false;
            }
        }
        return stack.size() == 0;
    }
}
