public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left+((right-left) >> 1);
            int val = guess(mid);
            if(val == 0) return mid;
            else if(val == 1) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}
