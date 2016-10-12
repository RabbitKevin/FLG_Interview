class Solution {
    public static void main(String[] args) {
        List<List<Integer>> graph = constructGraph(edges);
    }
    private List<List<Integer>> constructGraph(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        //-------------------------//
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    public static void shortestPath(int start, int end, List<List<Integer>> graph) {
        Set<Integer> isVisited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> parents = new HashMap<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                int node = queue.poll();
                isVisited.add(node);
                for(int adj : graph.get(node)) {
                    if(!isVisited.contains(adj)) {

                    }
                }
            }
        }
    }
}
