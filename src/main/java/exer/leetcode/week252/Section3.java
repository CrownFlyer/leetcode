package exer.leetcode.week252;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-01 15:22
 */
public class Section3 {
    public long minimumPerimeter(long neededApples) {
        long l = 2, r = 400000;
        while (l < r) {
            long m = (l + r) / 2;
            if (getV1(m) < neededApples) l = m + 1;
            else r = m;
        }
        if (r % 2 == 1) return 4 * (r + 1);
        return 4 * r;
    }

    public long getV1(long n) {
        return n * (n / 2 + 1) * (n + 1);
    }

}
