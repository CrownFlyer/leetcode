package exer.leetcode.double69;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-09 16:20
 */
public class Solution1 {
    public String capitalizeTitle(String title) {
        int n = title.length(), l = 0, r = 0;
        char[] chs = title.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chs[i] >= 'A' && chs[i] <= 'Z')
                chs[i] -= 'A' - 'a';
        }


        while (r < n) {
            chs[l] += 'A' - 'a';
            while (r < n && chs[r] != ' ') r++;
            if (r - l <= 2) chs[l] -= 'A' - 'a';
            l = r + 1;
            r++;
        }
        return new String(chs);
    }
}
