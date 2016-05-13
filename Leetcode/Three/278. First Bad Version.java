public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while(left < right) {
            int mid = left+((right-left) >> 1);
            if(isBadVersion(mid)) right = mid;
            else left = mid+1;
        }
        return left;
    }
}
