package doublePointer;

import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-23 11:12
 */
public class LEETCODE_1893_SIMPLE {
    @Test
    public void test() {
        int[][] rs = {{20, 40},{21,41},{22,42}};
        System.out.println(isCovered(rs, 19, 42));
    }


    public boolean isCovered(int[][] ranges, int left, int right) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{left, right});
        int i = 0, n = ranges.length;
        while (i < n && !stack.isEmpty()) {
            int size = stack.size();
            for (int j = 0; j < size; j++) {
                int[] cell = stack.pop();
                int t = type(ranges[i], cell);
                switch (t) {
                    case 0:
                        stack.push(cell);
                        break;
                    case 1:
                        stack.push(cell);
                        break;
                    case 2:
                        if (cell[1] >= ranges[i][1] + 1) stack.push(new int[]{ranges[i][1] + 1, cell[1]});
                        break;
                    case 3:
                        if (cell[0] <= ranges[i][0] - 1) stack.push(new int[]{cell[0], ranges[i][0] - 1});
                        if (cell[1] >= ranges[i][1] + 1) stack.push(new int[]{ranges[i][1] + 1, cell[1]});
                        break;
                    case 4:
                        if (cell[0] <= ranges[i][0] - 1) stack.push(new int[]{cell[0], ranges[i][0] - 1});
                        break;
                    case 5:
                        break;
                    default:

                        break;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

    public int type(int[] range, int[] cur) {
        if (range[1] < cur[0]) return 0;
        else if (range[0] > cur[1]) return 1;
        else if (range[0] < cur[0] && range[1] < cur[1]) return 2;
        else if (range[0] >= cur[0] && range[1] <= cur[1]) return 3;
        else if (range[0] <= cur[1] && range[1] > cur[1]) return 4;
        else return 5;
    }
}
