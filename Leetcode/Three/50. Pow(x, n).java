/*
    https://leetcode.com/discuss/52800/5-different-choices-when-talk-with-interviewers
*/
public class Solution {
    public double myPow(double x, int n) {
        boolean isPositive = n >= 0;
        if(!isPositive) n = Math.abs(n);
        double r = help(x, n);
        return isPositive?r:1.0/r;
    }
    private double help(double x, int n) {
        if(n == 0) return 1.0;
        double r = myPow(x, n >> 1);
        if((n & 1) == 1) {
            return r*r*x;
        }
        else return r*r;
    }
}
