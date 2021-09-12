package exer.leetcode.fall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 14:14
 */
public class Section5 {
    @Test
    public void test() {

    }


    public int trafficCommand(String[] directions) {
        int mult1 = 21 * 21 * 21;
        int mult2 = 21 * 21;
        int mult3 = 21;
        Set<Integer> v = new HashSet<>();
        int target = directions[0].length() * mult1 + directions[1].length() * mult2
                + directions[2].length() * mult3 + directions[3].length();
        v.add(0);
        // 记录所有车的状态
        List<Integer> list = new ArrayList<>();
        // 初始状态为没有车，即所有车都通过，反推
        list.add(0);
        // 记录上一秒的第一种输出状态的下标
        int l = 0;
        // 定义9种可行的通过方案，顺序必须匹配，只和车道有关
        // dirs[i]:char[4]记录了 东西南北的通行方向，' '表示该方向的车阻塞
        char[][] dirs = {
                {'W', ' ', 'E', ' '}, {' ', 'N', ' ', 'S'},
                {'S', 'E', 'N', 'W'}, {'N', 'W', 'S', 'E'}, {'N', 'E', 'S', 'W'},
                {'W', 'E', 'S', ' '}, {'N', 'E', ' ', 'S'}, {'N', ' ', 'E', 'W'}, {' ', 'N', 'S', 'W'}};
        int step = 0;
        int r = 0;
        // l<list.size()表示还没有遍历完
        while (l < list.size()) {
            // 记录新的状态的指针
            int newPtr = r;
            // 遍历上一秒运行后的所有状态
            for (int i = l; i <= r; i++) {
                // 获取上一秒车的状态
                int x = list.get(i);
                // 如果状态同目标状态，表示全部通过
                if (x == target) return step;
                int x1 = x / mult1, x2 = (x % mult1) / mult2, x3 = (x % mult2) / mult3, x4 = x % mult3;
                // 记录每一秒钟可能运行的情况
                for (int j = 0; j < 9; j++) {
                    int[] y = {x1, x2, x3, x4};
                    for (int k = 0; k < 4; k++) {
                        // 状态不能超过目标状态，如车不可能比目标状态还多
                        if (y[k] < directions[k].length() && directions[k].charAt(y[k]) == dirs[j][k])
                            y[k]++;
                    }
                    int hash = y[0] * mult1 + y[1] * mult2 + y[2] * mult3 + y[3];
                    // 如果是新的状态
                    if (!v.contains(hash)) {
                        v.add(hash);
                        // 将上一秒的状态通过hash记录到list中
                        list.add(hash);
                        newPtr++;
                    }
                }
            }
            l = r + 1;
            r = newPtr;
            step++;
        }
        return step;
    }
}
