package prefixSum;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-28 21:22
 */
public class LEETCODE_1371_MIDDLE {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        // pos[i]=v:前v个字符构成i的组合
        int[] pos = new int[1 << 5];
        // 初始化为-1，前-1个字符即无效
        Arrays.fill(pos, -1);
        int max = 0, pre = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') pre ^= (1 << 0);
            else if (c == 'e') pre ^= (1 << 1);
            else if (c == 'i') pre ^= (1 << 2);
            else if (c == 'o') pre ^= (1 << 3);
            else if (c == 'u') pre ^= (1 << 4);

            // 如果大于等于0，表示之前有相同的组合
            // 那从之前的组合的后一个到现在的下标组成的子字符串表示为元音字符偶数的字符串
            if (pos[pre] >= 0) max = Math.max(max, i + 1 - pos[pre]);
            else pos[pre] = i + 1;
        }
        return max;
    }
}
