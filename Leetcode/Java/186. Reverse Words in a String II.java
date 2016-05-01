/*
    Reverse all char,
    reverse each word
*/
public class Solution {
    public void reverseWords(char[] s) {
        swap(s, 0, s.length-1);
        for(int i = 0; i < s.length;) {
            int j = i;
            while(j < s.length && s[j] != ' ') ++j;
            swap(s, i, j-1);
            i = j+1;
        }
    }
    private void swap(char[] s, int i, int j) {
        while(i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            ++i;
            --j;
        }
    }
}
