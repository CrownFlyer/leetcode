package dfs_bfs;

import org.junit.Test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 19:09
 */
public class LEETCODE_1306_MIDDLE {
    @Test
    public void test() {
        int[] arr = {3, 0, 2, 1, 2};
        System.out.println(canReach(arr, 2));
    }

    Set<Integer> visited = new HashSet<>();

    public boolean canReach1(int[] arr, int start) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        int n = arr.length;
        while (!stack.isEmpty()) {
            if (visited.contains(stack.peek())) {
                stack.pop();
                continue;
            }

            Integer cur = stack.pop();
            visited.add(cur);
            if (arr[cur] == 0) return true;
            if (cur + arr[cur] >= 0 && cur + arr[cur] < n) stack.push(cur + arr[cur]);
            if (cur - arr[cur] >= 0 && cur - arr[cur] < n) stack.push(cur - arr[cur]);
        }
        return false;
    }


    public boolean canReach(int[] arr, int start) {
        return helper(arr, start, new boolean[arr.length]);
    }

    public boolean helper(int[] arr, int start, boolean[] v) {
        if (start < 0 || start >= arr.length) return false;
        if (arr[start] == 0) return true;

        if (v[start]) return false;
        else v[start] = true;

        return helper(arr, start + arr[start], v) || helper(arr, start - arr[start], v);

    }


}
