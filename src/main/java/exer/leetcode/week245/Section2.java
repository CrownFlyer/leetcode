package exer.leetcode.week245;

import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section2 {
    public static void main(String[] args) {
        Section2 test = new Section2();
        String s = "qlevcvgzfpryiqlwy";
        String p = "qlecfqlw";
        int[] r = {12,5};
        System.out.println(test.maximumRemovals(s, p, r));
    }

    // HashSet优化查找子序列（Map插入和增加复杂度极高，涨姿势了!） + 二分removable
    public int maximumRemovals(String s, String p, int[] removable) {
        TreeSet<Integer>[] sets = new TreeSet[26];
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            int index = s.charAt(i) - 'a';
            if (sets[index] == null) sets[index] = new TreeSet<>();
            sets[index].add(i);
        }

        int rLen = removable.length;
        int pLen = p.length();
        int l = 1, r = rLen;
        int m = (l + r) >> 1;
        // 删除前m个
        for (int i = 0; i < m; i++) {
            sets[s.charAt(removable[i]) - 'a'].remove(removable[i]);
        }
        int pCnt = 0;
        int cnt = 0;
        while (l <= r) {
            int index = 0;
            for (pCnt = 0; pCnt < pLen; pCnt++) {
                Integer ceil = sets[p.charAt(pCnt) - 'a'].ceiling(index);
                if (ceil == null) break;
                index = ceil + 1;
            }

            if (pCnt == pLen) {  //还可以删除或者刚好
                l = m;
                m = (l + r+1) >> 1;
                if(l==m) cnt++;
                if(cnt>2) return l;
                for (int i = l; i < m; i++) {
                    sets[s.charAt(removable[i]) - 'a'].remove(removable[i]);
                }
            } else {
                r = m - 1;
                m = (l + r) >> 1;
                for (int i = m; i <= r; i++) {
                    sets[s.charAt(removable[i]) - 'a'].add(removable[i]);
                }

            }
        }
        return r;
    }

    // 优化查找子序列
    public int maximumRemovals2(String s, String p, int[] removable) {
        TreeSet<Integer>[] sets = new TreeSet[26];
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            int index = s.charAt(i) - 'a';
            if (sets[index] == null) sets[index] = new TreeSet<>();
            sets[index].add(i);
        }

        int rLen = removable.length;
        int pLen = p.length();

        for (int i = 0; i < rLen; i++) {
            sets[s.charAt(removable[i]) - 'a'].remove(removable[i]);
            int index = 0;
            for (int j = 0; j < pLen; j++) {
                Integer ceil = sets[p.charAt(j) - 'a'].ceiling(index);
                if (ceil == null) return i;
                index = ceil + 1;
            }
        }
        return rLen;
    }

    // 二分removable
    public int maximumRemovals1(String s, String p, int[] removable) {
        int sLen = s.length();
        int pLen = p.length();
        int rLen = removable.length;
        int l = 1, r = Math.min(rLen, sLen - pLen);
        while (l <= r) {
            int m = (l + r) >> 1;
            boolean[] v = new boolean[sLen];
            for (int i = 0; i < m; i++) {
                v[removable[i]] = true;
            }
            int[] t = new int[sLen - m];
            int index = 0;
            for (int i = 0; i < sLen; i++) {
                if (!v[i]) t[index++] = s.charAt(i);
            }

            int ptr = 0;
            for (int c : t) {
                if (c == p.charAt(ptr)) {
                    ptr++;
                    if (ptr == pLen) break;
                }
            }
            if (ptr == pLen) l = m + 1;
            else r = m - 1;
        }
        return r;
    }


}
