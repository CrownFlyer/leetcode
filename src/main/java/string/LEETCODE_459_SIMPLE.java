package string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-13 10:17
 */
public class LEETCODE_459_SIMPLE {
    @Test
    public void test() {
        System.out.println(repeatedSubstringPattern2("abcabc"));
    }

    // 暴力匹配 O(n^2)
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            int i = 0;
            while (i + len + len <= n && s.substring(i, i + len).equals(s.substring(i + len, i + len + len))) i += len;
            if (i + len == n) return true;
        }
        return false;
    }

    // 移位暴力
    /*
        将原字符串拼接，如果原字符串是重复的，那拼接过后的字符串中一定可以找到原字符串（起始下标必须为[1,n-1]
        表示找到的原字符串由两个原字符串中的子字符串拼接而成）
        O(n^2)
     */
    public boolean repeatedSubstringPattern1(String s) {
        String str = s + s;
        return str.indexOf(s, 1) != s.length();
        // return str.substring(1,str.length()-1).contains(s);
    }

    // KMP：O(m+n)
    /*
        寻找子字符串
        利用参与信息，降低比较的次数
        利用字符串的最长公共前后缀数进行过滤，过滤掉绝对不可能成功的
        构建next数组，记录[0,i]最长公共前后缀长度
        构建next数组的精髓是 pattern自己与自己匹配

     */
    public boolean repeatedSubstringPattern2(String s) {
        return kmp(s + s, s);
    }

    public boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        // fail[i]:记录pattern[0]~pattern[i]的最长前后缀长度-1
        int[] fail = new int[m];
        Arrays.fill(fail, -1);

        for (int i = 1; i < m; i++) {
            // 获取前[0~i-1]个字符的最长前后缀长度
            int j = fail[i - 1];
            // 如果新的字符与前缀的后一个字符不匹配，则缩小匹配长度，寻找前缀子字符串和后缀子字符串的最长公共前后缀
            // 由于前缀子字符串和后缀子字符串相同，则相当于找前缀子字符串的最长公共前缀和 即fail[j]
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i))
                j = fail[j];
            // 此时在判断新的字符能否加入最长公共前后缀
            if (pattern.charAt(j + 1) == pattern.charAt(i))
                fail[i] = j + 1;
        }

        int match = -1;
        // 从1开始查找，起始位置最末为n-1
        for (int i = 1; i <= n - 1; i++) {
            // 如果不匹配
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i))
                match = fail[match];
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                match++;
                if (match == m - 1)
                    return true;
            }
        }
        return false;
    }


}
