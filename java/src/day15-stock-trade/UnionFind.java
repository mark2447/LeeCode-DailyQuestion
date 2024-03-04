public class UnionFind {
    //并查集
    public int[] father;

    public void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public int find(int n) {
        if (father[n] == n) {
            return n;
        } else {
            father[n] = find(father[n]);
            return father[n];
        }
    }

    public void join (int u, int v) {
        int fu = father[u];
        int fv = father[v];
        if (fu == fv) {
            return;
        }
        father[v] = u;





    }

    public boolean isSame(int u, int v) {
        int fu = father[u];
        int fv = father[v];
        return fu == fv;
    }


}
