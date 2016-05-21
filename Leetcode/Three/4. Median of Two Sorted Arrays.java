public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        if(((size1+size2) & 1) == 1) return help(nums1, 0, size1-1, nums2, 0, size2-1, ((size1+size2)>>1)+1);
        else {
            int one = help(nums1, 0, size1-1, nums2, 0, size2-1, ((size1+size2)>>1));
            int two  =help(nums1, 0, size1-1, nums2, 0, size2-1, ((size1+size2)>>1)+1);
            return (one+two)/2.0;
        }
    }
    public int help(int[] one, int i, int j, int[] two, int n, int m, int k) {
        if(m-n > j-i) return help(two, n, m, one, i, j, k);
        if(n > m) return one[i+k-1];
        if(k == 1) return Math.min(one[i], two[n]);
        //----------------------------------------//
        int sizeTwo = Math.min((k >> 1), m-n+1);//for two
        int sizeOne = k-sizeTwo;//for one
        if(two[n+sizeTwo-1] <= one[i+sizeOne-1]) {
            return help(one, i, j, two, n+sizeTwo, m, k-sizeTwo);
        }
        else {
            return help(one, i+sizeOne, j, two, n, m, k-sizeOne);
        }
    }
}
