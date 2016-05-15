public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result^=num;
        }
        return result;
    }
}
/*
    HashMap的做法就不写了
*/
