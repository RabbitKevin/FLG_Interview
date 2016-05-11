/*
    DFS solution, 这里将parent一并带入，优化了时间
    https://leetcode.com/discuss/52568/ac-java-graph-dfs-solution-with-adjacency-list
*/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        // add edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
    // check if an undirected graph has cycle started from vertex u
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);

            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }

        return false;
    }
}

/*
    UNION-FIND
*/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] uf = new int[n];
        for(int i = 0; i < n; ++i) {
            uf[i] = i;
        }
        //------------------------//
        for(int[] edge : edges) {
            int root1 = find(uf, edge[0]);
            int root2 = find(uf, edge[1]);
            if(root1 != root2) {
                uf[root2] = uf[root1];
                n--;
            }
            else return false;
        }
        return n == 1;
    }
    public int find(int[] uf, int num) {
        while(num != uf[num]) {
            uf[num] = uf[uf[num]];
            num = uf[num];
        }
        return num;
    }
}
