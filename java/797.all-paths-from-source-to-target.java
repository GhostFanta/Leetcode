class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> store = new ArrayList<>();
        this.helper(graph, store, new ArrayList<>(), 0);
        return store;
    }

    public void helper(int[][] graph, List<List<Integer>> store, List<Integer> current, int node){
        current.add(node);

        if(graph[node].length == 0){
            if(node == graph.length - 1){
                store.add(current);
                return;
            } else {
                return;
            }
        }

        for(int i : graph[node]){
            List<Integer> future = new ArrayList<>(current);
            helper(graph, store, future, i);
        }
    }
}
