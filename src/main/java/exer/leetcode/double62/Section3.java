package exer.leetcode.double62;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-04 21:49
 */
public class Section3 {
    @Test
    public void test() {

    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        // cnt_pos[i]:前i个字符中T的个数
        int[] cnt_pos = new int[n + 1];
        // cnt_neg[i]:前i个字符中F的个数
        int[] cnt_neg = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cnt_neg[i + 1] = cnt_neg[i];
            cnt_pos[i + 1] = cnt_pos[i];
            if (answerKey.charAt(i) == 'T') cnt_pos[i + 1]++;
            else cnt_neg[i + 1]++;
        }

        int max = 0;

        int l = 0, r = 0;
        while (r < n) {
            while (r < n && cnt_neg[r] - cnt_neg[l] <= k) r++;
            max = Math.max(max, r - l);
            while (l < r && cnt_neg[r] - cnt_neg[l] > k) l++;
        }

        l = r = 0;
        while (r < n) {
            while (r < n && cnt_pos[r] - cnt_pos[l] <= k) r++;
            max = Math.max(max, r - l);
            while (l < r && cnt_pos[r] - cnt_pos[l] > k) l++;
        }

        return max;
    }
}
