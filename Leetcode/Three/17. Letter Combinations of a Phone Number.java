public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> dic = new ArrayList<>();
        dic.add("");
        dic.add(" ");
        dic.add("abc");
        dic.add("def");
        dic.add("ghi");
        dic.add("jkl");
        dic.add("mno");
        dic.add("pqrs");
        dic.add("tuv");
        dic.add("wxyz");
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        dfs(result, 0, digits, "", dic);
        return result;
    }
    public void dfs(List<String> result, int index, String digits, String str, List<String> dic) {
        if(index == digits.length()) {
            result.add(str);
            return;
        }
        int x = digits.charAt(index)-'0';
        String s = dic.get(x);
        if(s.length() == 0) dfs(result, index+1, digits, str, dic);
        else {
            for(int i = 0; i < s.length(); ++i) {
                dfs(result, index+1, digits, str+s.charAt(i), dic);
            }
        }
    }
}
