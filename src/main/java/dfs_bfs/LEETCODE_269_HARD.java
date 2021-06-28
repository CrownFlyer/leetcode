package dfs_bfs;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 20:18
 */
public class LEETCODE_269_HARD {
    @Test
    public void test() {
        String[] s = {"ulbyrlxmdd", "aptvnmuy", "sv", "wrjiosqf", "cwp", "vciu", "mzcnuuhnjd", "viquwnvf", "mza"};
        System.out.println(alienOrder(s));
    }

    public String alienOrder(String[] words) {
        int n = words.length;
        if (n == 0) return "";

        // 1.构建图并统计入度数组
        HashMap<Character, Set<Character>> adj = new HashMap<>(26);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                // 如果c还未在哈希表的key中出现，创建key，并初始化其后继节点列表
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        int[] inDegree = new int[26];
        // 相邻两个单词比较，得出字典序
        for (int i = 0; i < n - 1; i++) {
            char[] chars1 = words[i].toCharArray();
            char[] chars2 = words[i + 1].toCharArray();

            int minLen = Math.min(chars1.length, chars2.length);
            for (int j = 0; j < minLen; j++) {
                if (chars1[j] != chars2[j]) {
                    // 有向边可以被重复添加，因为哈希表可以去重，但是被指向顶点的入度不可用重复添加，为此需要做特殊判断
                    if (!adj.get(chars1[j]).contains(chars2[j])) {
                        // 该Map的value记录字典序在其后的字符
                        adj.get(chars1[j]).add(chars2[j]);
                        // 字典序靠后的字符++，说明入度为0的字典序靠前
                        inDegree[chars2[j] - 'a']++;
                    }
                    // 如果字符不同，该字符的比较则决定了字典序，后面的比较则没有意义
                    break;
                }

                // 针对特殊用例 ["abc","ab"]
                if (j == minLen - 1 && words[i].length() > words[i + 1].length()) return "";
            }
        }

        // 2.基于adj和入度数组进行bfs
        Queue<Character> q = new LinkedList<>();
        for (char c : adj.keySet()) {
            if (inDegree[c - 'a'] == 0) q.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character top = q.poll();
            sb.append(top);

            Set<Character> successors = adj.get(top);
            for (Character successor : successors) {
                inDegree[successor - 'a']--;
                if (inDegree[successor - 'a'] == 0) q.offer(successor);
            }
        }

//        if (adj.size() == sb.length()) return sb.toString();
//        return "";
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] > 0) return "";
        }
        return sb.toString();
    }
}
