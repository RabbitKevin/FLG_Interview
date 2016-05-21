/*
    先用正则拆分，速度略慢，但是更清晰
*/
public class Solution {
    public String simplifyPath(String path) {
        String result = "/";
        String[] folders = path.split("/+");
        List<String> link = new ArrayList<>();
        for(String s : folders) {
            if(s.equals("..")) {
                if(link.size() > 0) link.remove(link.size()-1);
            }
            else if(!s.equals(".") && !s.equals("")) link.add(s);
        }
        if(link.size() == 0) return result;
        StringBuilder sb = new StringBuilder(result);
        for(int i = 0; i < link.size(); ++i) {
            sb.append(link.get(i));
            if(i != link.size()-1) sb.append('/');
        }
        return sb.toString();
    }
}

/*

*/
public class Solution {
    public String simplifyPath(String path) {
        List<String> paths = new ArrayList<>();
        for(int i = 0; i < path.length();) {
            char x = path.charAt(i);
            if(x == '/') {
                ++i;
                while(i < path.length() &&  path.charAt(i) == '/') ++i;
                paths.add("/");
            }
            else {
                int j = i;
                while(j < path.length() && path.charAt(j) != '/') ++j;
                String folder = path.substring(i,j);
                if(folder.equals(".")) {
                    if(paths.size() > 0) paths.remove(paths.size()-1);
                }
                else if(folder.equals("..")) {
                    for(int n = 0; n < 3 && paths.size() != 0; ++n) paths.remove(paths.size()-1);
                }
                else paths.add(folder);
                i = j;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(paths.size() == 0) return "/";
        if(!paths.get(0).equals("/")) sb.append("/");
        for(int i = 0; i < Math.max(paths.size()-1, 1); ++i) {
            sb.append(paths.get(i));
        }
        int index = paths.size()-1;
        if(!paths.get(index).equals("/")) sb.append(paths.get(index));
        return sb.toString();
    }
}
