public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        for(NestedInteger x : list) {
            if(x.isInteger()) {
                sum+=depth*(x.getInteger());
            }
            else {
                sum+=dfs(x.getList(), depth+1);
            }
        }
        return sum;
    }
}
