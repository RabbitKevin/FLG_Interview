/*
    最基本的解法，考虑新的hash方式
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = getKey(str);
            if(map.containsKey(key)) map.get(key).add(str);
            else {
                List<String> value = new ArrayList<>();
                value.add(str);
                map.put(key, value);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
    private String getKey(String str) {
        int[] count = new int[26];
        for(char x : str.toCharArray()) {
            int i = x-'a';
            count[i]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; ++i) {
            if(count[i] == 0) continue;
            for(int j = 0; j < count[i]; ++j) {
                sb.append(('a'+i));
            }
        }
        return sb.toString();
    }
}
