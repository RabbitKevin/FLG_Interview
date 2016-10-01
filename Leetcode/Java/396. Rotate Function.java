/*
    0 1 2 3
    1 2 3 0
    2 3 0 1
    3 0 1 2
*/
public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0) return 0;
        int sum = 0;
        int j = 0;
        int result = 0;
        for(int num : A) {
            sum+=num;
            result+=j*num;
            j++;
        }
        int max = Integer.MIN_VALUE;
        for(int i = A.length-1; i >= 0; --i) {
            max = Math.max(result, max);
            result+=sum-(A.length*A[i]);
        }
        return max;
    }
}
