public class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8 && num!=0; ++i) {
            int tmp = num&15;
            num = num >> 4;
            sb.append(help(tmp));
        }
        return sb.reverse().toString();
    }
    private String help(int x) {
        if(x < 10) return String.valueOf(x);
        else return Character.toString((char)('a'+(x-10)));
    }
}
