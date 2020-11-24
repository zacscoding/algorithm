package algorithm.easy.p461;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
