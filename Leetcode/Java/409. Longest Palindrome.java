public class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[52];
        for(char x : s.toCharArray()) {
            if(Character.isUpperCase(x)) {
                int index = x-'A';
                index+=26;
                map[index]++;
            }
            else {
                int index = x-'a';
                map[index]++;
            }
        }
        //------------------------------//
        int sum = 0;
        boolean isSingle = false;
        for(int num : map) {
            if((num&1) == 0) sum+=num;
            else {
                sum+=(num-1);
                isSingle = true;
            }
        }
        return isSingle?sum+1:sum;
    }
}
