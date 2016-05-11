/*
    这题很有意思，其实就是求最多overlop的范围.
    Greedy的经典用途之一
    需要知道任意一个点的overlap. 找到一个点，不overlap之后，之前范围内点的overlap依然未知.
*/
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length < 2) return intervals.length;
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; ++i) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int max = 1;
        for(int i = 0, j = 0; i < n-1;++i) {
            if(start[i+1] < end[i]) {
                j = i+1;
                while(j < n && start[j] < end[i]) ++j;
                max = Math.max(max, j-i);
            }
        }
        return max;
    }
}
