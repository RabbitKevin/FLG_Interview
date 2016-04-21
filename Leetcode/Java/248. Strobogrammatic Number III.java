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
