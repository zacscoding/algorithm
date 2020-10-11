package algorithm.easy.p724;

public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int[] psum = new int[nums.length];
        int[] rpsum = new int[nums.length];
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            psum[i] = nums[i];
            if (i != 0) {
                psum[i] += psum[i - 1];
            }
            rpsum[j] = nums[j];
            if (j != nums.length - 1) {
                rpsum[j] += rpsum[j + 1];
            }
        }

        int answer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (psum[i] == rpsum[i]) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
