/*
    DFS
*/
public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        //----------------------------------//
        int component = 0;
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < n; ++i) {
            if(isVisited[i]) continue;
            dfs(i, graph, isVisited);
            component++;
        }
        return component;
    }

    private void dfs(int index, List<Integer>[] graph, boolean[] isVisited) {
        isVisited[index] = true;
        for(int adj : graph[index]) {
            if(isVisited[adj]) continue;
            dfs(adj, graph, isVisited);
        }
    }
}
/*
    UNION-FIND
*/
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] uf = new int[n];
        for(int i = 0; i < n; ++i) {
            uf[i] = i;
        }
        //--------------------------------//
        int component = n;
        for(int[] edge : edges) {
            if(!find(edge[0], edge[1], uf)) component--;
        }
        return component;
    }
    private boolean find(int i, int j, int[] uf) {
        while(uf[i] != i) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        //----------------//
        while(uf[j] != j) {
            uf[j] = uf[uf[j]];
            j = uf[j];
        }
        if(i != j) {
            uf[i] = j;
            return false;
        }
        return true;
    }
}

public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] isVisited = new boolean[n];
        int component = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            if(isVisited[i]) continue;
            queue.add(i);
            while(!queue.isEmpty()) {
                int node = queue.poll();
                for(int adj : graph[node]) {
                    if(isVisited[adj]) continue;
                    queue.add(adj);
                    isVisited[adj] = true;
                }
            }
            component++;
        }
        return component;
    }
}
