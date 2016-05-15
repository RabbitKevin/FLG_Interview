/*
    总的sum >= 0, 说明必有一点可以。
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0) return -1;
        int index = 0;
        int sum = 0;
        int remain = 0;
        for(int i = 0; i < gas.length; ++i) {
            int dif = gas[i]-cost[i];
            remain+=dif;
            sum+=dif;
            if(sum < 0) {
                sum  = 0;
                index = i+1;
            }
        }
        if(remain < 0) return -1;
        return index;
    }
}
