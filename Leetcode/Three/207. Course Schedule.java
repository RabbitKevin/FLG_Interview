/*
    DFS, 找环
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; ++i) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        //----------------------------------------------//
        boolean[] isVisited = new boolean[numCourses];//visited node
        for(int i = 0; i < numCourses; ++i) {
            if(isVisited[i]) continue;
            if(hasCycle(graph, i, new boolean[numCourses], isVisited)) return false;
        }
        return true;
    }
    private boolean hasCycle(List<Integer>[] graph, int index, boolean[] nodes, boolean[] isVisited) {
        isVisited[index] = true;
        if(nodes[index]) return true;
        else nodes[index] = true;
        for(int node : graph[index]) {
            if(hasCycle(graph, node, nodes, isVisited)) return true;
        }
        nodes[index] = false;
        return false;
    }
}
/*
    BFS, 找环
    利用入度，简化
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] degree = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; ++i) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            degree[prerequisites[i][1]]++;
        }
        //----------------------------------------------//
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; ++i) {
            if(degree[i] == 0) queue.add(i);
        }
        while(!queeu.isEmpty()) {
            int node = queue.poll();
            for(int next : graph.get(node)) {
                degree[next]--;
                if(degree[next] == 0) {
                    count++;
                    queue.add(next);
                }
            }
        }
        return count == numCourses;
    }
}
