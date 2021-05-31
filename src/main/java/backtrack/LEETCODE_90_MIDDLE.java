package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-28 18:48
 */
public class LEETCODE_90_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2};
        LEETCODE_90_MIDDLE test = new LEETCODE_90_MIDDLE();
        System.out.println(test.subsetsWithDup(nums));
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        // 这里i>index的条件就很妙，保证了第一次出现重复的时候不会被消去
        // 如果这里的index边为常量0 就会输出不重复元素的子集
        for (int i = index; i < nums.length; i++) {
            if ( i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            dfs(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
