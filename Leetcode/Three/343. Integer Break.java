public class Solution {
    public int integerBreak(int n) {
        if(n < 4) return n-1;
        int two = 2;
        int three = 0;
        for(int i = 5; i <= n; ++i) {
            if(two != 0) {
                three++;
                two--;
            }
            else {
                three--;
                two+=2;
            }
        }
        return (1 << two)*(int)(Math.pow(3, three));
    }
}
