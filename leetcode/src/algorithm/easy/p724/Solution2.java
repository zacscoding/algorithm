package algorithm.easy.p724;

public class Solution2 {
    public int pivotIndex(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        int total = 0, leftSum = 0;
        for (int num : nums) {
            total += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
