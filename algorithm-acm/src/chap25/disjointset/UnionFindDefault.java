package chap25.disjointset;

/**
 *
 */
public class UnionFindDefault {

    static int getParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent, parent[x]);
    }

    static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static boolean sameParent(int[] parent, int a, int b) {
        return getParent(parent, a) == getParent(parent, b);
    }

    public static void main(String[] args) {
        int[] parent = new int[11];

        for (int i = 1; i < 11; i++) {
            parent[i] = i;
        }

        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 5, 6);
        unionParent(parent, 6, 7);
        unionParent(parent, 7, 8);

        for (int i = 1; i <= 8; i++) {
            System.out.printf("%d의 parent ==> %d\n", i, getParent(parent, i));
        }
    }
}
