public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < s.length();) {
            //get num//
            int count = 0;
            int j = i;
            while(s.charAt(j) != '#') {
                int bit = s.charAt(j++)-'0';
                count = count*10+bit;
            }
            result.add(s.substring(j+1, j+1+count));
            i = j+1+count;
        }
        return result;
    }
}
