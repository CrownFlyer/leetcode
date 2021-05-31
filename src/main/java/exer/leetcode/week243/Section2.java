package exer.leetcode.week243;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-30 09:49
 */
public class Section2 {
    public static void main(String[] args) {
        Section2 test = new Section2();
        String s = "469975787943862651173569913153377";

        System.out.println(test.maxValue(s, 3));
    }

    public String maxValue(String n, int x) {
        int len = n.length();
        StringBuilder res = new StringBuilder();
        int temp = 0;
        if (n.charAt(0) != '-') {
            for (int i = 0; i < len; i++) {
                if ((n.charAt(i) - '0') < x) {
                    res.append(n.substring(0, i));
                    res.append(x);
                    res.append(n.substring(i, len));
                    break;
                }
            }
        } else {
            temp = len;
            for (int i = len - 1; i > 0; i--) {
                if ((n.charAt(i) - '0') > x) {
                    temp = i;
                }
            }
        }

        if (n.charAt(0) != '-') {

        } else {
            res.append(n.substring(0, temp));
            res.append(x);
            res.append(n.substring(temp, len));
        }
        if (res.length() == 0) {
            res.append(n);
            res.append(x);
        }

        return res.toString();
    }


}
