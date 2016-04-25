import java.util.List;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        String str = "abcd a\"bceww addadfga    afafafafg a b c\"ace          f\"g  \"aw \"heheda\"    ";
        List<String> result = stringParse(str);
        System.out.println(result);
    }
    public static List<String> stringParse(String str) {
        List<String> result = new ArrayList<String>();
        str = str.trim();
        boolean isRef = false;
        int i = 0;
        while(i < str.length()) {
            //isRef = str.charAt(index) == '"';
            int index = i;
            while(index < str.length() && !(!isRef && str.charAt(index) == ' ')) {
                if(str.charAt(index) == '"') isRef = !isRef;
                index++;
            }
            result.add(str.charAt(i) == '"'?str.substring(i+1, index-1):str.substring(i, index));
            while(index < str.length() && str.charAt(index) == ' ') index++;
            i = index;
        }
        return result;
    }
}
