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
