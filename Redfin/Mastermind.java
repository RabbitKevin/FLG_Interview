import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] one = {3,1,2,4,5};
        int[] two = {2,1,5,5,5};
        int[] result = mastermind(one,two);
        System.out.println(result[0]+" "+result[1]);
    }
    public static int[] mastermind(int[] one, int[] two) {
        int[] result = new int[2];
        Map<Integer, Integer> cur = new HashMap<>();
        Map<Integer, Integer> guess = new HashMap<>();
        for(int i = 0; i < one.length; ++i) {
            if(one[i] == two[i]) {
                result[0]++;
                continue;
            }
            if(cur.containsKey(one[i])) cur.put(one[i], cur.get(one[i])+1);
            else cur.put(one[i], 1);
            if(guess.containsKey(two[i])) guess.put(two[i], guess.get(two[i]+1));
            else guess.put(two[i], 1);
        }
        //---------------------------------//
        for(int num : cur.keySet()) {
            if(guess.containsKey(num)) {
                result[1]+=Math.min(cur.get(num), guess.get(num));
            }
        }
        return result;
    }
}
