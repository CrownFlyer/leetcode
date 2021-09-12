package exer.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-09 09:11
 */
public class LEETCODE_68_HARD {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int r = 0, n = words.length;
        List<String> res = new ArrayList<>();
        while (true) {
            int curLen = 0;
            int l = r;
            while (r < n && curLen + words[r].length() + r - l <= maxWidth) {
                curLen += words[r++].length();
            }
            // 处理到最后一行
            if (r == n) {
                StringBuilder sb = new StringBuilder();
                for (int i = l; i < n - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.append(words[n - 1]);
                for (int i = 0; i < maxWidth - curLen - n + l + 1; i++) sb.append(' ');
                res.add(sb.toString());
                return res;
            }

            // [l,r)是有效的
            int cnt = r - l - 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                sb.append(words[l + i]);
                for (int j = 0; j < (maxWidth - curLen + cnt - i - 1) / cnt; j++) {
                    sb.append(' ');
                }
            }
            sb.append(words[r - 1]);
            if (cnt == 0)
                for (int i = 0; i < maxWidth - curLen; i++) sb.append(' ');
            res.add(sb.toString());
        }
    }
}
