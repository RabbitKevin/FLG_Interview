/*

*/
import java.util.*;
class Solution {
    public static void main(String[] args) {
        List<String> result = new ArrayList<String>();
        char n = '4';
        int m = 4;
        char[] nums = new char[m];
        dfs(result, nums, n, 0);
        for(String str : result) {
            System.out.println(str);
        }
    }
    public static void dfs(List<String> result, char[] nums, char n, int m) {
        if(m == nums.length) {
            result.add(String.valueOf(nums));
            return;
        }
        for(char i = '1'; i <= n; ++i) {
            nums[m] = i;
            dfs(result, nums, n, m+1);
        }
    }
}
