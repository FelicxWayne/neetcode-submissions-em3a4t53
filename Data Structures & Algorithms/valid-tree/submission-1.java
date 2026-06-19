class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        int graphs = n;

        for(int i = 0;i < n;i++){
            parent[i] = i;
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if(rootU == rootV){
                return false;
            }

            parent[rootU] = rootV;
            graphs--;
        }

        return graphs == 1;
    }
    public int find(int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }
}
