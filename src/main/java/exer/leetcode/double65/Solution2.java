package exer.leetcode.double65;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 11:10
 */
public class Solution2 {
    class Robot {
        String[] dirs = {"East", "North", "West", "South"};
        int roundSteps;
        int curDir;
        int[] cur;
        int m;
        int n;

        public Robot(int width, int height) {
            m = width;
            n = height;
            roundSteps = (m + n - 2) << 1;
            curDir = 0;
            cur = new int[2];
        }

        public void step(int num) {
            int maxStep = 0;
            num %= roundSteps;
            if (num == 0 && cur[0] == 0 && cur[1] == 0) {
                curDir = 3;
                return;
            }
            switch (dirs[curDir]) {
                case "East":
                    maxStep = m - 1 - cur[0];
                    if (num <= maxStep) {
                        cur[0] += num;
                    } else {
                        cur[0] = m - 1;
                        curDir++;
                        step(num - maxStep);
                    }
                    break;
                case "North":
                    maxStep = n - 1 - cur[1];
                    if (num <= maxStep) {
                        cur[1] += num;
                    } else {
                        cur[1] = n - 1;
                        curDir++;
                        step(num - maxStep);
                    }
                    break;
                case "West":
                    maxStep = cur[0];
                    if (num <= maxStep) {
                        cur[0] -= num;
                    } else {
                        cur[0] = 0;
                        curDir++;
                        step(num - maxStep);
                    }
                    break;
                case "South":
                    maxStep = cur[1];
                    if (num <= maxStep) {
                        cur[1] -= num;
                    } else {
                        cur[1] = 0;
                        curDir = 0;
                        step(num - maxStep);
                    }
                    break;
                default:
                    break;
            }
        }

        public int[] getPos() {
            return cur;
        }

        public String getDir() {
            return dirs[curDir];
        }
    }
}
