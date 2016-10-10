/*
    第一次试跑的时候没过某个例子，发现要求数据可以取反用...
    那么就是单向图变成双向图

    标记访问点，本来想搞个hashset, 但是嫌麻烦...
    我直接把对应的path删了，任何一次递归返回前，将path加回去
    如果不是求一串数值的话，只需要在寻路失败的时候将path复原就可以了
*/
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i < values.length; ++i) {
            double val = values[i];
            String[] pair = equations[i];
            addPair(map, pair, val);
        }
        //-------------------------------------//
        double[] result = new double[queries.length];
        for(int j = 0; j < result.length; ++j) {
            if(!map.containsKey(queries[j][0]) || !map.containsKey(queries[j][1])) result[j] = -1;
            else result[j] = dfs(map, queries[j][0], queries[j][1]);
        }
        return result;
    }
    private void addPair(Map<String, Map<String, Double>> map, String[] pair, double value) {
        String upper = pair[0],
            down = pair[1];
        if(!map.containsKey(upper)) {
            map.put(upper, new HashMap<String, Double>());
        }
        Map<String, Double> pathOne = map.get(upper);
        pathOne.put(down, value);
         if(!map.containsKey(down)) {
            map.put(down, new HashMap<String, Double>());
        }
        Map<String, Double> pathTwo = map.get(down);
        pathTwo.put(upper, 1.0/value);
    }
    private double dfs(Map<String, Map<String, Double>> map, String start, String end) {
        if(start.equals(end)) return 1;
        if(!map.containsKey(start)) return -1;
        Map<String, Double> next = map.get(start);
        map.remove(start);
        //---------------------------------------//
        for(String key : next.keySet()) {
            double res = dfs(map, key, end);
            if(res != -1) {
                map.put(start, next);
                return res*next.get(key);
            }
        }
        map.put(start, next);
        return -1;
    }
}
