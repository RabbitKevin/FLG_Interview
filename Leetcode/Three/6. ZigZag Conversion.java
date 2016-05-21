public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int size = (numRows-1) << 1;
        for(int i = 0; i < numRows; ++i) {
            int j = i;
            int gap = size-(i << 1);
            while(j < s.length()) {
                sb.append(s.charAt(j));
                if(gap == 0) {
                    gap = size;
                }
                j+=gap;
                gap = size-gap;
            }
        }
        return sb.toString();
    }
}
