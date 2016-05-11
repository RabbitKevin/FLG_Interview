/*
    O(nlogn), sort & merge
*/
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return intervals;
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval x, Interval y) {
                return x.start-y.start;
            }
        });
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); ++i) {
            mergeAdd(result, intervals.get(i));
        }
        return result;
    }
    private void mergeAdd(List<Interval> result, Interval nums) {
        Interval last = result.get(result.size()-1);
        if(last.end < nums.start) result.add(nums);
        else {
            last.end = Math.max(last.end, nums.end);
        }
    }
}

/*
    Still sort, but not sort interval
*/
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for(int i = 0; i < intervals.size(); ++i) {
            Interval x = intervals.get(i);
            start[i] = x.start;
            end[i] = x.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> result = new ArrayList<>();
        for(int i = 0, j = 0; i < intervals.size(); ++i) {
            if(i == end.length-1 || start[i+1] > end[i]) {//last or non-overlap
                result.add(new Interval(start[j], end[i]));
                j = i+1;
            }
        }
        return result;
    }
}
