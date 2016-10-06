/*
    用Java in built的treeset作为bst.
    用轻量的bst可以更快，写js的时候实现下.
*/
public class SummaryRanges {

    private TreeSet<Interval> set;
    public SummaryRanges() {
        set = new TreeSet<Interval>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start-b.start;
            }
        });
    }

    public void addNum(int val) {
        Interval num = new Interval(val, val);
        Interval before = set.floor(num);
        if(before != null) {
            if(before.end >= val) return;
            else if(before.end+1 == val) {
                num.start = before.start;
                set.remove(before);
            }
        }
        //---------------------------------//
        Interval after = set.higher(num);
        if(after != null && after.start == num.end+1) {
            num.end = after.end;
            set.remove(after);
        }
        set.add(num);
    }

    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(set);
    }
}
