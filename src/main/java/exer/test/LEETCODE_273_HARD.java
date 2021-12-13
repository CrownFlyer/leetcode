package exer.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-11 10:58
 */
public class LEETCODE_273_HARD {
    @Test
    public void test() {
        System.out.println(numberToWords(12345));
    }

    final String[] num2str_small = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    final String[] num2str_medium = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    final String[] num2str_large = {
            "Billion", "Million", "Thousand", "",
    };

    public String num2Str(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(num2str_small[num / 100] + " Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            sb.append(num2str_medium[num / 10]);
            num %= 10;
        }
        if (num != 0) sb.append(num2str_small[num]);
        return sb.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) return num2str_small[0];
        StringBuilder sb = new StringBuilder();
        for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num < i) continue;
            sb.append(num2Str(num / i));
            sb.append(" ");
            sb.append(num2str_large[j]);
            sb.append(" ");
            num %= i;
        }
        int end = sb.length() - 1;
        while (sb.charAt(end) == ' ') sb.deleteCharAt(end--);
        return sb.toString();
    }
}
