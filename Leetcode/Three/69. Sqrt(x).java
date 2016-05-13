public class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while(left < right) {
            int mid = left+((right-left) >> 1);
            long sum = (long)mid*(long)mid;
            if(sum == x) return mid;
            if(sum < x) {
                sum+=(mid << 1)+1;
                if(sum <= x) left = mid+1;
                else return mid;
            }
            else right = mid-1;
        }
        return left;
    }
}
