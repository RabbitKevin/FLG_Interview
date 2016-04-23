public class Solution {
    public String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        int left = 0;
        int right = letters.length-1;
        while(left < right) {
            while(left < right && !isVowels(letters[left])) left++;
            while(left < right && !isVowels(letters[right])) right--;
            char tmp = letters[left];
            letters[left] = letters[right];
            letters[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(letters);
    }
    private boolean isVowels(char x) {
        x = Character.toLowerCase(x);
        return (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u');
    }
}
