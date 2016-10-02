public class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int base = 1;
        boolean left = true;
        while(n > 1) {
            if(left || (n&1) == 1) head+=base;
            left = !left;
            base = base << 1;
            n = n >> 1;
        }
        return head;
    }
}
