package exer.leetcode.double55;

import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 22:29
 */
public class Section3 {
    @Test
    public void test() {
        int[] arr = {6, 2, 1, 2, 4};
        System.out.println(maxAlternatingSum(arr));
    }

    // 动态规划+状态优化
    public long maxAlternatingSum1(int[] nums) {
        int n = nums.length;
        // odd选择奇数个数子序列得到的最大交替和
        // even选择偶数个数子序列得到的最大交替和
        long even = 0, odd = nums[0];
        for (int i = 1; i < n; i++) {
            // 增加对nums[i]的选择时
            // even的更新取决于odd添加新元素nums[i]求和的最大值
            // odd的更新取决于even添加新元素nums[i]求和的最大值
            even = Math.max(odd - nums[i], even);
            odd = Math.max(even + nums[i], odd);
        }
        // 由于所有的数均为偶数，所以选取奇数的必定更大
        return odd;
    }

    // 单调栈
    public long maxAlternatingSum(int[] nums) {
        long res =0;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 空的或递减的入栈
            if(stack.isEmpty()||nums[i]<stack.peek()){
                stack.push(nums[i]);
                continue;
            }

            // 当前数字比栈顶的大，清空栈，类似贪心的思想，找到一个单调递减的，最大的-最小的能保证对后面的收益是最大的
            if(nums[i]>stack.peek()){
                int pre = stack.pop();
                while(!stack.isEmpty()){
                    res+=stack.peek()-pre;
                    pre = stack.pop();
                }
                stack.push(nums[i]);
            }
        }

        // 栈没空，说明最后有一个递减序列
        // 此时只需要把栈底最大的元素取出即可
        int max = 0;
        while (!stack.isEmpty()) {
            max = stack.pop();
        }
        return res+max;
    }


}
