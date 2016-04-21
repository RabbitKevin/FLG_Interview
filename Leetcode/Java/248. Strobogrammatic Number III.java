/*
    get all those number in this length,
    not efficient
*/
public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> result = new ArrayList<>();
        for(int i = low.length(); i <= high.length(); ++i) {
            result.addAll(help(i,i));
        }
        for(String str: result) {
            if((str.length() == low.length() && str.compareTo(low) < 0) || (str.length() == high.length() && str.compareTo(high) > 0)) continue;
            count++;
        }
        return count;
    }
    private List<String> help(int r, int l) {
        if(r == 0) return new ArrayList<String>(Arrays.asList(""));
        if(r == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        List<String> next = help(r-2, l);
        List<String> result = new ArrayList<String>();
        for(String str : next) {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(str);
            sb.append('0');
            if(r != l) result.add(sb.toString());
            setSb(sb, '1');
            result.add(sb.toString());
            setSb(sb, '8');
            result.add(sb.toString());
            setSb(sb, '6');
            result.add(sb.toString());
            setSb(sb, '9');
            result.add(sb.toString());
        }
        return result;
    }
    private void setSb(StringBuilder sb, char x) {
        sb.setCharAt(0, x);
        if(x == '6') x = '9';
        else if(x == '9') x = '6';
        sb.setCharAt(sb.length()-1, x);
    }
}
/*
    从思路1的解法出发，里面可以优化的部分很多.
    因为不需要去求String， 所以不需要Stringbuilder, 直接换成char[].
    递归的部分做减枝，把不符合数字形式的递归剪除.
    reference: https://leetcode.com/discuss/73721/easiest-20ms-94%25-java-solution
*/
public class Solution {
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    int count = 0;
    int count = 0;

    public int strobogrammaticInRange(String low, String high) {
        for(int len = low.length(); len <= high.length(); len++) {
            dfs(low, high, new char[len], 0, len - 1);
        }
        return count;
    }

    public void dfs(String low, String high, char[] c, int left, int right) {
        if(left > right) {
            String s = new String(c);
            if((s.length() == low.length() && s.compareTo(low) < 0) ||
               (s.length() == high.length() && s.compareTo(high) > 0)) return;
            count++;
            return;
        }

        for(char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if(c.length != 1 && c[0] == '0') continue;
            if(left < right || left == right && p[0] == p[1]) dfs(low, high, c, left + 1, right - 1);
        }
    }
}
/*
    将整体分成三部分.
    1. 长度为low.length()但是小于low;
    2. 长度在low.length~high.lenght-1之间的范围（全包括)
    3. 长度为high.length, 但是小于等于high
    reference: https://leetcode.com/discuss/97011/super-fast-0ms-99-52%25-java-solution-w-explanations
*/
public class Solution {
    private static final char[][] stroPairs = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};

    public int strobogrammaticInRange(String low, String high) {
        char[] h = high.toCharArray(), l = low.toCharArray();
        h[h.length - 1]++;
        if (h.length < l.length || (h.length == l.length && comp(l, h, 0) == 0)) return 0; // low > high
        int sum = 0;
        for (int len = low.length(); len < high.length(); sum += stroN(len), len++);
        return sum + stroSmallerThan(h) - stroSmallerThan(l);
    }

    private int stroFullN(int len) {
        if (len == 0) return 1; // ""
        if (len == 1) return 3; // 0,1,8
        return 5 * stroFullN(len - 2); // 0...0,1...1,8...8,6...9,9...6
    }

    private int stroN(int len) {
        if (len < 2) return stroFullN(len);
        return 4 * stroFullN(len - 2);
    }

    private int stroSmallerThan(char[] limit) { //count the stros WITH limit's length and SMALLER THAN limit.
        int len = limit.length;
        char[] cur = new char[len];
        return stroSmallerThan(0, len - 1, cur, limit);
    }

    private int stroSmallerThan(int i, int j, char[] cur, char[] limit) {
        int sum = 0;
        if (j < i)
            return comp(cur, limit, i);
        if (j == i) {
            for (char[] pair : stroPairs)
                if (pair[0] == pair[1] && pair[0] <= limit[i])
                    if (pair[0] < limit[i])
                        sum++;
                    else {
                        cur[i] = pair[0];
                        sum += comp(cur, limit, i);
                    }
            return sum;
        }

        for (char[]  pair : stroPairs) {
            if (pair[0] < limit[i]) {
                if (i != 0 || pair[0] != '0')
                    sum += stroFullN(j - i - 1);
            } else
            if (pair[0] == limit[i]) {
                cur[i] = pair[0];
                cur[j] = pair[1];
                sum += stroSmallerThan(i + 1, j - 1, cur, limit);
            }
        }
        return sum;
    }

    int comp(char[] cur, char[] limit, int st) { //return 1 if cur < limit else 0
        for (int i = st; i < cur.length; i++) {
            if (cur[i] < limit[i]) return 1;
            else
            if (cur[i] > limit[i]) return 0;
        }
        return 0;
    }
}
