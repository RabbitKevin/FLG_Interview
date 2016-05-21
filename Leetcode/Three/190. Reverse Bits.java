public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] dic = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int sum = 0;
        for(int i = 0; i < 8; ++i) {
            sum = sum << 4;
            sum  = sum | dic[n&15];
            n = n >> 4;
        }
        return sum;
    }
}
