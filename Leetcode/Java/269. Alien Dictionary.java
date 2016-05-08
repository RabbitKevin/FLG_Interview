public class Solution {
    public String alienOrder(String[] words) {
        if(words.length == 0) return "";
        if(words.length == 1) return words[0];
        //----constructing a graph---//
        boolean[] letters = new boolean[26];
        Set<Character>[] graph = new Set[26];
        for(int i = 0; i < words.length-1; ++i) {
            compareWord(words[i], words[i+1], graph);
        }
        //-----------topo_sort------------//
        boolean[] isVisited = new boolean[26];
        StringBuilder sb = new StringBuilder();
        /*
        for(Set<Character> list : graph) {
            System.out.println(list);
        }
        */
        for(int i = 0; i < 26; ++i) {
            if(graph[i] == null) continue;
            if(!cycle_find(i, graph, new boolean[26])) return "";
        }
        for(int i = 0; i < 26; ++i) {
            if(graph[i] == null || isVisited[i]) continue;
            dfs(sb, i, graph, isVisited);
        }
        return sb.reverse().toString();
    }
    private boolean cycle_find(int index, Set<Character>[] graph, boolean[] isVisited) {
        isVisited[index] = true;
        Set<Character> adj = graph[index];
        for(Character x : adj) {
            if(isVisited[(x-'a')] || !cycle_find((int)(x-'a'), graph, isVisited)) return false;
        }
        return true;
    }
    private void dfs(StringBuilder sb, int index, Set<Character>[] graph, boolean[] isVisited) {
        isVisited[index] = true;
        Set<Character> adj = graph[index];
        for(Character x : adj) {
            if(!isVisited[(x-'a')]) dfs(sb, (int)(x-'a'), graph, isVisited);
        }
        sb.append((char)('a'+index));
    }
    private void compareWord(String one, String two, Set<Character>[] graph) {
        boolean edge = false;
        for(int i = 0; i < Math.max(one.length(), two.length()); ++i) {
            if(i < one.length()) {
                int index = getIndex(one.charAt(i));
                if(graph[index] == null) graph[index] = new HashSet<Character>();
            }
            if(i < two.length()) {
                int index = getIndex(two.charAt(i));
                if(graph[index] == null) graph[index] = new HashSet<Character>();
            }
            if(i < one.length() && i < two.length()) {
                if(!edge && one.charAt(i) != two.charAt(i)) {
                    int first = getIndex(one.charAt(i));
                    graph[first].add(two.charAt(i));
                    edge = true;
                }
            }
        }
    }
    private int getIndex(char x) {
        return x-'a';
    }
}
