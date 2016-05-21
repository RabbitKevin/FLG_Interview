public class Solution {
    public String reverseVowels(String s) {
        char[] x = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            while(left <= right && !isVowel(x[left])) ++left;
            while(right >= left && !isVowel(x[right])) --right;
            if(left < right) {
                char tmp = x[right];
                x[right] = x[left];
                x[left] = tmp;
                ++left;
                --right;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        return sb.toString();
    }
    private boolean isVowel(char x) {
        x= Character.toLowerCase(x);
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }
}
