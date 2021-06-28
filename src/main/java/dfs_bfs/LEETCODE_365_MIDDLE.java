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
 * @create: 2021-06-25 20:42
 */
public class LEETCODE_365_MIDDLE {
    @Test
    public void test() {
        System.out.println(canMeasureWater(3, 5, 4));
    }

    // dfs
    public boolean canMeasureWater1(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<>();

        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }

            seen.add(hash(stack.peek()));
            int[] state = stack.pop();
            int remain_x = state[0], remain_y = state[1];
            if (remain_x == z || remain_y == z || remain_x + remain_y == z) return true;

            // 把X灌满
            stack.push(new int[]{x, remain_y});
            // 把Y灌满
            stack.push(new int[]{remain_x, y});
            // 把X倒空
            stack.push(new int[]{0, remain_y});
            // 把Y倒空
            stack.push(new int[]{remain_x, 0});
            // 把X的水灌进Y，直至灌满或倒空
            stack.push(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
            // 把Y的水灌进X，直至灌满或倒空
            stack.push(new int[]{remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }

    // Math
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z){
            return false;
        }
        if(x == 0 || y == 0){
            return z==0 || x+y==z;
        }
        return z % gcb(x,y) == 0;
    }

    // 求最大公约数
    int gcb(int x,int y){
        return y == 0 ? x : gcb(y,x%y);
    }

}
