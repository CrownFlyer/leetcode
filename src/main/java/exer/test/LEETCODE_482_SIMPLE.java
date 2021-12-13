package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-04 09:54
 */
public class LEETCODE_482_SIMPLE {
    public String licenseKeyFormatting(String s, int k) {
        char[] sc = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = s.length(), idx = n - 1;
        int start = 0;
        while (start < n && sc[start] == '-') start++;
        while (idx >= 0) {
            int validcnt = 0;
            while (idx >= 0 && validcnt < k) {
                if (sc[idx] != '-') {
                    sb.insert(0, sc[idx] >= 'a' && sc[idx] <= 'z' ? (char) (sc[idx] + 'A' - 'a') : sc[idx]);
                    validcnt++;
                }
                idx--;
            }
            if (idx >= start) sb.insert(0, '-');

        }
        return sb.toString();
    }
}
