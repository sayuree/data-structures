public class UnionFind {
    private int[] parents;
    private int[] size;
    private int totalElements;

    public UnionFind(int totalElements) {
        this.totalElements = totalElements;
        this.parents = new int[totalElements];
        this.size = new int[totalElements];

        for(int i = 0; i < totalElements; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public void unionByRank(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) {
            return;
        }

        if(size[rootA] >= size[rootB]) {
            parents[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parents[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }

    public int find(int node) {
        if(parents[node] == node)    return node;
        return parents[node] = find(parents[node]);
    }

    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
