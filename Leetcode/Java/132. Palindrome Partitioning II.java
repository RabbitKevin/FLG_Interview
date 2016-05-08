public class Solution {
    public int minCut(String s) {
        int size = s.length();
        if(s == null || size == 0) return 0;
        int[] cuts = new int[size+1];
        boolean[][] p = new boolean[size][size];
        for(int i = 0; i < size; ++i) {
            cuts[i] = size-i;
        }
        //-------------------------------//
        for(int i = size-1; i >= 0; --i) {
            for(int j = i; j < size; ++j) {
                if(s.charAt(i) == s.charAt(j) && (j-i < 2 || p[i+1][j-1])) {
                    cuts[i] = Math.min(cuts[i], cuts[j+1]+1);
                    p[i][j] = true;
                }
            }
        }
        return cuts[0]-1;//not need the last cut
    }
}
