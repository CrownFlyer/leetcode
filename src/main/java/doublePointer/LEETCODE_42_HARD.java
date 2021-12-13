package doublePointer;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-05 19:22
 */
public class LEETCODE_42_HARD {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(arr));
    }

    // 单调栈
    // 维护一个从栈底到栈顶递减的下标单调栈，如果遍历到i时，如果大于栈顶的高度，则表示形成一个凹地，可以蓄水
    public static int trap2(int[] height) {
        int res = 0;
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stk.isEmpty() && height[stk.peek()] < height[i]) {
                int top = stk.pop();
                // 左边没有遮挡的
                if (stk.isEmpty()) break;
                int left = stk.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[top];
                res += curHeight * curWidth;
            }
            stk.push(i);
        }
        return res;
    }

    // 有序集合
    public static int trap(int[] height) {
        int n = height.length;
        int total = 0, blockTotal = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(height[i]);
            blockTotal += height[i];
        }
        set.remove(0);
        Iterator<Integer> iter = set.iterator();
        int last = 0;
        while (iter.hasNext()) {
            int h = iter.next();
            int l = 0, r = n - 1;
            while (height[l] < h) l++;
            while (height[r] < h) r--;
            total += (r - l + 1) * (h - last);
            last = h;
        }
        return total - blockTotal;

    }


    // 双指针->动态规划优化空间版
    public int trap1(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            // 能保证的是低水位的可以存储
            if (height[l] <= height[r]) res += lMax - height[l++];
            else res += rMax - height[r--];
        }
        return res;
    }
}
