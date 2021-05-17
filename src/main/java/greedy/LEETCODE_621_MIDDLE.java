package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-12 15:40
 */
public class LEETCODE_621_MIDDLE {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A','B', 'C', 'D','E', 'F', 'G',};
        int n = 2;
        System.out.println(leastInterval(tasks, n));

    }

    public static int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int res = 0;
        if (n <= 1) return len;

        int[] cnt = new int[26];
        for (char ch : tasks) cnt[ch - 'A']++;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) if (cnt[i] != 0) list.add(cnt[i]);

        while (!list.isEmpty()) {
            Collections.sort(list);
            int tLen = list.size();
            int tIndex = tLen - 1;
            int nIndex = n+1;
            while (tIndex >= 0) {
                int curNum = list.get(tIndex);
                list.set(tIndex, --curNum);
                if(list.get(tIndex--)==0) list.remove(tIndex+1);
                nIndex--;
                if (nIndex == 0) break;
            }
            if (list.isEmpty()) {
                res += tLen;
            } else res += n+1;
        }

        return res;
    }
}
