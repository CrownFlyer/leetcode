package string;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 22:08
 */
public class OFFER_JZ49_HARD {
    @Test
    public void test() {
        String str = "123";
        System.out.println(StrToInt(str));
    }

//    public int StrToInt(String str) {
//        if (str.length() == 0 || str == null)
//            return 0;
//        if (!Pattern.matches("^[+-]?(\\d+)$", str))
//            return 0;
//        int size = str.length();
//        int i = size - 1;
//        int res = 0;
//        while (i >= 0) {
//            char ch = str.charAt(i);
//            if (ch >= '0' && ch <= '9')
//                res += (ch - '0') * Math.pow(10, size - i - 1);
//            else
//                res *= (ch == '+') ? 1 : -1;
//            i--;
//        }
//        return res;
//    }

    public int StrToInt(String str) {
        if (str.length() == 0 || str == null)
            return 0;
        if (!Pattern.matches("^[+-]?(\\d+)$", str))
            return 0;
        int size = str.length();
        int i = 0;
        int res = 0;
        while (i < size) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9')
                res = (ch - '0') + res * 10;
            i++;
        }
        res *= (str.charAt(0) == '-') ? -1 : 1;
        return res;
    }
}
