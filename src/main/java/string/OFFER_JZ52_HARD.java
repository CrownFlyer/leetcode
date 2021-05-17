package string;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 22:30
 */
public class OFFER_JZ52_HARD {
    @Test
    public void test() {
        String s = "bbbba";
        String p = ".*a*a";
        System.out.println(match(s, p));
    }

    public boolean match(String str, String pattern) {
        if (str == null || pattern == null) return false;

        ArrayList<Integer> list = new ArrayList<>();
        char lastReplacedChar = ' ';
        int i = 0, j = 0;
        for (int k = 0; k < pattern.length(); k++) {
            if (pattern.charAt(k) == '*')
                list.add(k);
        }
        int cnt = 0;
        for (Integer index : list) {
            if (pattern.charAt(index - 1) == '.') { //出现 '.*'
                String p1 = pattern.substring(0, list.get(0) - 1);
                String p2 = pattern.substring(list.get(list.size() - 1) + 1);
                if (p1.length() != 0) {
                    int p_str = 0;
                    int p_p1 = 0;
                    int cntMatch = 0;
                    while (p1.charAt(p_p1) == str.charAt(p_str)) {
                        p_p1++;
                        p_str++;
                        cntMatch++;
                    }
                    return cntMatch == p1.length();
                }
                if (p2.length() != 0) {
                    int p_str = str.length() - 1;
                    int p_p2 = p2.length() - 1;
                    int cntMatch = 0;
                    while (p_p2 >= 0 && p2.charAt(p_p2) == str.charAt(p_str)) {
                        p_p2--;
                        p_str--;
                        cntMatch++;
                    }
                    return cntMatch == p2.length();
                }
                return true;
            }

            // 处理 x* 之前的
            while (i < index - 1 && j < index - 1 && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
                i++;
                j++;
            }
            if (j != index - 1) return false;

            boolean x_xFlag = (j + 2 < pattern.length()) ? pattern.charAt(j + 2) == pattern.charAt(j) : false;
            int temp_j = j + 2;
            if (x_xFlag) {  //处理x*x... *之后的x
                while (temp_j < pattern.length() && pattern.charAt(temp_j) == str.charAt(i)) {
                    i++;
                    temp_j++;
                }
            }
            // 处理x* 中的x
            cnt = (cnt != 0) ? cnt : 0;
            while (i < str.length() && pattern.charAt(index - 1) == str.charAt(i)) {
                lastReplacedChar = pattern.charAt(index - 1);
                i++;
                j++;
                cnt++;
            }
            if (x_xFlag) j = temp_j;
            else j = index + 1;
        }
        // 处理 * 之后的
        while (i < str.length() && j < pattern.length() && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
            i++;
            j++;
        }
        int times = 0;
        while (j < pattern.length() && lastReplacedChar == pattern.charAt(j) && times < cnt) {
            j++;
            times++;
        }

        return i == str.length() && j == pattern.length();
    }
}
