package topologySort;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-29 19:16
 */
public class LEETCODE_630_HARD {
    @Test
    public void test() {
        int[][] c = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(c));
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int cur = 0;
        for (int[] c : courses) {
            // 按最紧急的顺序遍历，保证后续替换的时候，后面的任务肯定能满足结束时间的要求，因为其紧急程度比替换的要低
            if (cur + c[0] <= c[1]) {
                q.offer(c[0]);
                cur += c[0];
            } else if (!q.isEmpty() && q.peek() > c[0]) {   // 找一个最浪费时间的替换，为后续课程争取更多的时间（贪心）
                cur += c[0] - q.poll();
                q.offer(c[0]);
            }
        }
        return q.size();
    }
}
