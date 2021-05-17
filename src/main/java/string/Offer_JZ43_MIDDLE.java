package string;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 14:52
 */
public class Offer_JZ43_MIDDLE {
    public static void main(String[] args) {
        Offer_JZ43_MIDDLE test = new Offer_JZ43_MIDDLE();
        String str = test.LeftRotateString("abcXYZdef", 3);
        System.out.println(str);
    }

    public String LeftRotateString(String str, int n) {
        if(str.length() == 0 || str == null)
            return "";
        int size = str.length();
        n %= size;
        return str.substring(n) + str.substring(0, n);
    }

}
