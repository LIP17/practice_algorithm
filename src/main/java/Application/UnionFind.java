package Application;

/**
 * id: an identifier of obj.
 * components: several ids grouped together by connection
 * connection: if you saw (2,3), which means 2 is connected to 3, and 2 3 are in same group.
 * */

public interface UnionFind {
    /**
     * return number of components.
     * */
    public int count();
    /**
     * check if two ids are in the same components or not.
     * */
    public boolean connected(int p, int q);

    /**
     * @param p id to search group for
     * @return component id
     * */
    public int find(int p);

    /**
     * @param p,q two ids to be connected
     * */
    public void union(int p, int q);
}

class UnionFindWithQuickFind implements UnionFind {

    // index is the id of obj, value is the component id of this obj.
    private int[] ids;
    // number of components.
    private int count;

    public UnionFindWithQuickFind(int N) {
        ids = new int[N];
        for(int i = 0; i < N; i++) {
            ids[i] = i;
        }
        count = N;
    }

    @Override
    public int count() { return count; }

    @Override
    public boolean connected(int p, int q) { return find(p) == find(q); }

    @Override
    public int find(int p) { return ids[p]; }

    // O(N^2) timed if you do like (1,2), (2,3), (3,4)....
    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId) return;

        for(int i = 0; i < ids.length; i++) {
            if(ids[i] == pId) ids[i] = qId;
        }

        count--;
    }
}


class UnionFindWithQuickUnion {


}











