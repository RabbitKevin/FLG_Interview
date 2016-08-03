public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            String key = help(str);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String str : map.keySet()) {
            result.add(map.get(str));
        }
        return result;
    }
    private String help(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.charAt(0)-'a';
        for(char x : str.toCharArray()) {
            x = (char)(x-n);
            if(x < 'a') {
                x = (char)('z'-('a'-x-1));
            }
            sb.append(x);
        }
        return sb.toString();
    }
}
