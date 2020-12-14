package algorithm.easy.p771;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().permute(new int[] { 1, 2, 3 });
        for (List<Integer> a : ans) {
            System.out.println(
                    a.stream().map(i -> "" + i).collect(Collectors.joining(","))
            );
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(int[] nums, int pos, List<Integer> current, List<List<Integer>> ans) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(current));
            System.out.println("Add:" + new ArrayList<>(current).stream()
                                                                .map(i -> "" + i)
                                                                .collect(Collectors.joining(",")));
            return;
        }

        for (int i = 0; i <= current.size(); i++) {
            current.add(i, nums[pos]);
            System.out.println("Visit:" + nums[pos]);
            dfs(nums, pos + 1, current, ans);
            Integer e = current.remove(i);
            System.out.println("Remove:" + e);
        }
    }
}
