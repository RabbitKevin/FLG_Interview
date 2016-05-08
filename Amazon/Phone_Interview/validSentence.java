import java.util.*;

class Solution {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("amazon");
        set.add("i");
        set.add("from");
        set.add("am");
        set.add("if");
        set.add("roma");
        set.add("mazon");
        List<String> result = new ArrayList<String>();
        if(getSentence("ifromamazonam", 0, set, result)) {
            for(String str: result) {
                System.out.print(str);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static boolean getSentence(String str, int index, HashSet<String> dic, List<String> list) {
        if(index == str.length()) return true;
        for(int i = index; i < str.length(); ++i) {
            String tmp = str.substring(index, i+1);
            if(!dic.contains(tmp)) continue;
            list.add(tmp);
            if(getSentence(str, i+1, dic, list)) return true;
            list.remove(list.size()-1);
        }
        return false;
    }
}
