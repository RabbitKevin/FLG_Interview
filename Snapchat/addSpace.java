/*
    Given a long string without space, try to split it so that splitted word are
    all in given dictionary
*/
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Set<String> dic = new HashSet<>();
        dic.add("i");
        dic.add("am");
        dic.add("iam");
        dic.add("hero");
        dic.add("amhe");
        dic.add("ro");
        String str = "iamhero";
        List<List<String>> result = addSpace(str, dic);
        for(List<String> list : result) {
            System.out.println(list);
        }
    }
    public static List<List<String>> addSpace(String str, Set<String> dic) {
        List<List<String>>[] dp = new List[str.length()+1];
        dp[0] = new ArrayList<List<String>>();
        dp[0].add(new ArrayList<String>());
        //-----------------------------------------------//
        for(int i = 1; i <= str.length(); ++i) {
            dp[i] = new ArrayList<List<String>>();
            for(int j = 0; j < i; ++j) {
                String trail = str.substring(j, i);
                if(dic.contains(trail)) {
                    for(List<String> list : dp[j]) {
                        List<String> tmp = new ArrayList<>(list);
                        tmp.add(trail);
                        dp[i].add(tmp);
                    }
                }
            }
        }
        return dp[str.length()];
    }
}
