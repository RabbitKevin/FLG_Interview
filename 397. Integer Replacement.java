public class Solution {
    public int integerReplacement(int n) {
        Map<Long, Integer> map = new HashMap<>();
        return dfs((long)(n), map);
    }
    private int dfs(long n, Map<Long, Integer> map) {
        if(map.containsKey(n)) return map.get(n);
        if(n == 1) return 0;//base condition
        if((n&1) == 0) {
            map.put(n, dfs(n >> 1, map)+1);
        }
        else {
            map.put(n, Math.min(dfs(n-1, map), dfs(n+1, map))+1);
        }
        return map.get(n);
    }
}
/*
    Not sure memory limit in leetocde, but it we could try to pre half the number and replace the Hashmap with array which is faster than hashmap
*/
