package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:全排列，所有数字不重复
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-28 15:01
 */
public class LEETCODE_46_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        LEETCODE_46_MIDDLE test = new LEETCODE_46_MIDDLE();
        List<List<Integer>> res = test.permute(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth,
                    List<Integer> path, boolean[] used,
                    List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
/*  重新做的一遍
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] v = new boolean[nums.length];
        dfs(nums,0,new ArrayList(),v);
        return res;
    }

    public void dfs(int[] nums,int cur,List<Integer> list,boolean[] v){
        if(cur == nums.length){
            res.add(new ArrayList(list));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(!v[i]) {
                v[i] = true;
                list.add(nums[i]);
                dfs(nums,cur+1,list,v);
                v[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
*/
}
