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
            // 遍历过或者前面的未遍历且与前面值相同时，由于与前面的值相同，后面的情况与之前相同，剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,used,path,res);
            used[i]=false;
            path.removeLast();
        }
    }

//    第二次
//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        int n = nums.length;
//        boolean[] v = new boolean[n];
//        Arrays.sort(nums);
//
//        dfs(nums,new ArrayList(),v,n);
//        return res;
//    }
//
//    public void dfs(int[] nums,List<Integer> list,boolean[] v,int n){
//        if(list.size() == n){
//            res.add(new ArrayList(list));
//            return;
//        }
//
//        for(int i=0;i<n;i++){
//            // 遍历过或者前面的未遍历且与前面值相同时，由于与前面的值相同，后面的情况与之前相同，剪枝
//            if(v[i] || (i>0 && nums[i] == nums[i-1] && !v[i-1])) continue;
//            v[i] = true;
//            list.add(nums[i]);
//            dfs(nums,list,v,n);
//            v[i] = false;
//            list.remove(list.size()-1);
//        }
//    }
}
