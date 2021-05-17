package tree;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-21 12:21
 */
public class LEETCODE_91_MIDDLE {
    @Test
    public void test() {
        String str = "01";
        System.out.println(numDecodings(str));
    }


    public int numDecodings(String s) {
        int cnt = 0;
        if (s.length() == 1 && isDecodable(s)) cnt += 1;
        if (s.length() == 2 && isDecodable(s)) cnt += 1;
        if (s.length() > 1 && isDecodable(s.substring(0, 1))) cnt += numDecodings(s.substring(1));
        if (s.length() > 2 && isDecodable(s.substring(0, 2))) cnt += numDecodings(s.substring(2));

        return cnt;
    }

    public boolean isDecodable(String s) {
        if (s.length() == 2 && s.charAt(0) == '0') return false;
        int i = Integer.parseInt(s);
        return i >= 1 && i <= 26;
    }


}
