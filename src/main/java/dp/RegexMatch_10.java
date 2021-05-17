package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-02-16 11:59
 */
public class RegexMatch_10 {

    @Test
    public void test() {
        String s = "ab";
        String p = ".*";

        boolean match = isMatch(s, p);
        System.out.println(match);
    }

//    public boolean isMatch(String s, String p) {
//        if (p.charAt(0) == '*') {
//            return false;
//        }
//        ArrayList<Integer> starIndex = new ArrayList<>(p.length() / 2 + 1);
//
//        starIndex.add(-1);
//        for (int i = 0; i < p.length(); i++) {
//            if (p.charAt(i) == '*') {
//                starIndex.add(i);
//            }
//        }
//
//        if (starIndex.size() == 1) {
//            if (s.length() != p.length()) {
//                return false;
//            }
//            for (int i = 0; i < s.length(); i++) {
//                if ((s.charAt(i) != p.charAt(i)) && (p.charAt(i) != '.')) {
//                    return false;
//                }
//            }
//            return true;
//        } else {
//            int sIndex = 0;
//
//            int begin, end;
//            for (int i = 0; i < starIndex.size() - 1; i++) {
//                begin = starIndex.get(i) + 1;  //最前一个非任意个数的索引
//                end = starIndex.get(i + 1) - 1;  //最后一个非任意个数的索引
//                for (int j = begin; j < end; j++) { //匹配非任意个数的字符
//                    if ((s.charAt(sIndex) != p.charAt(i)) && (p.charAt(i) != '.')) {
//                        return false;
//                    }
//                    sIndex++;
//                }
//                if (p.charAt(starIndex.get(i + 1) - 1) == '.') {
//                    sIndex++;
//                    while (s.charAt(sIndex - 1) == s.charAt(sIndex)) sIndex++;
//                } else {
//                    while (sIndex < s.length() && (s.charAt(sIndex) == p.charAt(starIndex.get(i + 1) - 1))) { //匹配任意个数的字符
//                        sIndex++;
//                    }
//                }
//            }
//            if (sIndex < s.length()){
//                begin = starIndex.get(starIndex.size() - 1) + 1;
//                end = p.length();
//                for (int j = begin; j < end; j++) {
//                    if ((s.charAt(sIndex) != p.charAt(j)) && (p.charAt(j) != '.')) {
//                        return false;
//                    }
//                    sIndex++;
//                }
//            }
//            return sIndex == s.length();
//        }
//
//    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {   //匹配到p的第j个字符为*
                    f[i][j] = f[i][j - 2];  //此处有可能下标超界，避免输入*开头的匹配字符串，保留前面字符串的匹配状态
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];   //或上的是对于a* aa这样的情况
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    /*
     * 功能描述:返回s的第i个字符和p的第j个字符是否匹配
     * @Param: [s, p, i, j]
     * @Return: boolean
     * @Author: ZMC
     * @Date: 2021/2/16 16:48
     */
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {   //不然会使上面匹配单个非任意字符的i=0超界
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
