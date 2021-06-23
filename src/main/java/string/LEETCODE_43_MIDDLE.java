package string;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-17 15:25
 */
public class LEETCODE_43_MIDDLE {
    public static void main(String[] args) {
        LEETCODE_43_MIDDLE test = new LEETCODE_43_MIDDLE();
        String s1 = "74132554353313", s2 = "53289479830137914793401";
        System.out.println(new BigInteger(s1).multiply(new BigInteger(s2)));
        System.out.println(test.multiply(s1, s2));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int n1 = num1.length(), n2 = num2.length();
        if (n1 < n2) return multiply(num2, num1);

        // (100 + 20 + 3) * (400 + 50 + 6)
        // 123 456
        // 8
        // 1 + 5 + 2
        // 1 + 1 + 1 + 7

        // num1长度更大
        // 120 * 6
        // 0
        // 2
        // 1 + 6
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int carry = 0;
        int tempRes = 0;
        List<String> list = new ArrayList<>();
        int radix = 0;
        while (true) {
            boolean f = false;
            tempRes = 0;
            for (int i = 0; i <= radix; i++) {
                if (i<n1&&radix - i >= 0 && radix - i < n2){
                    f = true;
                    tempRes += (chars1[n1 - i - 1] - '0') * (chars2[n2 - (radix - i) - 1] - '0');
                }
            }
            if(!f) break;
            tempRes += carry;
            list.add(0,String.valueOf(tempRes % 10));
            carry = tempRes / 10;
            radix++;
        }
        if(carry!=0) list.add(0,String.valueOf(carry));
        return String.join("",list);
    }
}
