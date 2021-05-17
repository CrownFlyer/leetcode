package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-16 14:55
 */
public class LEETCODE_78_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LEETCODE_78_MIDDLE test = new LEETCODE_78_MIDDLE();
        List<List<Integer>> lists = test.subsets3(nums);
        lists.forEach(System.out::println);
    }

    // 二进制遍历
    // O(n*2^n) & O(n)
    public static List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            list.clear();
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) != 0) list.add(nums[j]);
            }
            res.add(new ArrayList<Integer>(list));
        }
        return res;
    }

    // 逐个枚举
    // O(n*n^2) & O(n*2^n)
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

    // recall
    // O(n*n^2) & O(n*2^n)
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets3(int[] nums) {
        for (int k = 0; k <= nums.length; k++) {
            recall(0,k,new ArrayList<Integer>(),nums);
        }
        return result;
    }

    public void recall(int start,int k,ArrayList<Integer> cur, int[] nums) {
        if(k==0){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            recall(i+1,k-1,cur,nums);
            cur.remove(cur.size()-1);
        }
    }

}
