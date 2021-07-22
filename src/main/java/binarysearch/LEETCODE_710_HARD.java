package binarysearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-20 18:06
 */
public class LEETCODE_710_HARD {
    @Test
    public void test() {

    }

    int n;
    int[] b;
    Random random;

    public LEETCODE_710_HARD(int N, int[] blacklist) {
        this.n = N;
        random = new Random();
        Arrays.sort(blacklist);
        this.b = blacklist;
    }

    // 随机生成位于第k位的白名单（排好序）的元素
    public int pick() {
        int k = random.nextInt(n - b.length);
        int l = 0, r = b.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (b[m] - m > k) r = m - 1;
            else l = m;
        }
        // b[l]前面恰好有k个白名单元素
        return l == r && b[l] - l <= k ? k + l + 1 : k;
    }
}
