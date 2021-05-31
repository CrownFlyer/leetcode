package backtrack;

import java.util.*;

/**
 * @description:全排列2，有数字重复
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-28 15:25
 */
public class LEETCODE_47_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        LEETCODE_47_MIDDLE test = new LEETCODE_47_MIDDLE();
        System.out.println(test.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len==0) return res;

        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,len,0,used,path,res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,used,path,res);
            used[i]=false;
            path.removeLast();
        }
    }
}
