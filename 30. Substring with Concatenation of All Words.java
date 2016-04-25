public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || words.length == 0) return result;
        HashMap<String, Integer> dic = new HashMap<String, Integer>();
        for(String str : words) {
            if(dic.containsKey(str)) dic.put(str, dic.get(str)+1);
            else dic.put(str, 1);
        }
        //-----------------------------------------------------------//
        int wl = words[0].length();//size of single word
        for(int start = 0; start < wl; ++start) {
            HashMap<String, Integer> window = new HashMap<>();
            int count = 0;
            int left = start;
            for(int i = start; i +wl <= s.length(); i+=wl) {
                String str = s.substring(i, i+wl);
                if(dic.containsKey(str)) {
                    if(window.containsKey(str)) window.put(str, window.get(str)+1);
                    else window.put(str, 1);
                    count++;
                    //It is possible that may exceeds, try to shrink window if needed
                    int strCount = dic.get(str);//maximum # of occurence of word
                    if(window.get(str) > strCount) {
                        while(window.get(str) > strCount) {
                            String tmp = s.substring(left, left+wl);
                            left+=wl;
                            window.put(tmp, window.get(tmp)-1);
                            count--;
                        }
                    }
                    if(count == words.length) {
                        result.add(left);
                        String head = s.substring(left, left+wl);
                        window.put(head, window.get(head)-1);
                        left+=wl;
                        count--;
                    }
                }
                //not exist in the dic, not useful
                else {
                    count = 0;
                    left = i+wl;
                    window.clear();
                }
            }
        }
        return result;
    }
}
