package string;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 21:19
 */
public class OFFER_JZ2_HARD {
    @Test
    public void test() {
        String s ="We Are Happy";
        System.out.println(replaceSpace(s));
    }

    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }
}
