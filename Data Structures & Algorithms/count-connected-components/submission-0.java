class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n+1];
        int connectedGraphs = n;

        for(int i = 0;i <= n;i++){
            parent[i] = i;
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if(rootU != rootV){
                parent[rootU] = rootV;
                connectedGraphs--;
            }
        }
        return connectedGraphs;
    }
    public int find(int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }
}
