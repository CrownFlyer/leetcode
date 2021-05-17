package string;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 21:19
 */
public class OFFER_JZ44_HARD {
    @Test
    public void test() {
        String s = "We Are Happy";
        System.out.println(ReverseSentence(s));
    }

    public String ReverseSentence(String str) {
        int size = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        int endIndex = size;
        for (int i = size - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append(str.substring(i + 1, endIndex) + " ");
                endIndex = i;
            }
        }
        stringBuilder.append(str.substring(0, endIndex));
        return stringBuilder.toString();
    }
}
