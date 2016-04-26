/*
    Word Matching
    两个string，S和T，S比T的长度长，求S中能找到多少个T（注：index可以不连续）
    举个例子：S=“abbabc” T="abc".
    答案是4
*/
class Solution {
    public static void main(String[] args) {
        String s = "abbabc";
        String t = "abc";
        System.out.println(dfs(s, 0, t, 0));
        s = "aaaa";
        t = "aa";
        System.out.println(dfs(s, 0, t, 0));
    }
    private static int dfs(String str, int start, String t, int index) {
        if(index == t.length()) return 1;
        int count = 0;
        for(int i = start; i < str.length(); ++i) {
            if(str.charAt(i) == t.charAt(index)) {
                count += dfs(str, i+1, t, index+1);
            }
        }
        return count;
    }
}
