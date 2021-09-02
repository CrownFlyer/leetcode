package exer.test;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-01 22:26
 */
public class LEETCODE_165_MIDDLE {
    @Test
    public void test() {
        String s = "s.a";
        String[] split = s.split("\\.");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            int val1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int val2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (val1 != val2) return val1 < val2 ? -1 : 1;
        }
        return 0;
    }


}
