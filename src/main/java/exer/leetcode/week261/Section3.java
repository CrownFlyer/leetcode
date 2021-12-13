package exer.leetcode.week261;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-03 12:13
 */
public class Section3 {
    @Test
    public void test() {

    }

    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int stone : stones) {
            cnt[stone % 3]++;
        }
        // 如果mod0的个数为偶数，两边可以抵消，其余如果只有一种mod模式，不管是mod1还是mod2，在该mod1状态下，连续两次都会输
        if (cnt[0] % 2 == 0) return cnt[1] != 0 && cnt[2] != 0;
        // 如果mod0的个数为奇数，先用mod0的一方可以多用一个mod0，用一次mod1和mod2会使状态进行一次轮回1，因此排除少的一方只后，会剩余一种mod状态
        // 如果要让先手Alice赢，必须多出的状态在第三次的时候用mod0进行躲避，且没有用完所有石头，剩下一个让后手bob输
        return Math.abs(cnt[1] - cnt[2]) > 2;
    }
}
