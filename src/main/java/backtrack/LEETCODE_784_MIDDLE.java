package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-24 19:55
 */
public class LEETCODE_784_MIDDLE {
    public List<String> letterCasePermutation(String s) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z'))
                list.add(i);
        }

        List<String> res = new ArrayList<>();
        dfs(res, ch, 0, list);
        return res;
    }

    public void dfs(List<String> res, char[] ch, int cur, List<Integer> list) {
        if (cur == list.size()) res.add(new String(ch));
        if (cur>=list.size()) return;
        dfs(res, ch, cur + 1, list);
        change(ch, cur, list);
        dfs(res, ch, cur + 1, list);
        change(ch, cur, list);
    }


    public void change(char[] ch, int i, List<Integer> list) {
        if (ch[list.get(i)] >= 'a' && ch[list.get(i)] <= 'z')
            ch[list.get(i)] += 'A' - 'a';
        else
            ch[list.get(i)] -= 'A' - 'a';
    }
}
