package dp;

import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-21 08:45
 */
public class LEETCODE_84_HARD {
    // 暴力：O(n^2) O(1) 超时
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && heights[l] >= heights[i]) l--;
            while (r < n && heights[r] >= heights[i]) r++;
            max = Math.max(max, heights[i] * (r - l - 1));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // l[i]:记录height[i]左边恰好比height[i]高的下标
        int[] l = new int[n];
        // r[i]:记录height[i]右边恰好比height[i]高的下标
        int[] r = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            l[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            r[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (r[i] - l[i] - 1) * heights[i]);
        }
        return max;
    }
}
