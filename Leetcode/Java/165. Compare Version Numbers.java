public class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        //-------//
        while(i < version1.length() || j < version2.length()) {
            //---1st num---//
            int index = i;
            while(index < version1.length() && version1.charAt(index) != '.') ++index;
            int one = i < version1.length()?Integer.parseInt(version1.substring(i, index)):0;
            i = index+1;
            index = j;
            while(index < version2.length() && version2.charAt(index) != '.') ++index;
            int two = j < version2.length()?Integer.parseInt(version2.substring(j, index)):0;
            j = index+1;
            if(one < two) return -1;
            else if(one > two) return 1;

        }
        return 0;
    }
}
