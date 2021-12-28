package exer.test;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-28 10:38
 */
public class LEETCODE_472_HARD {
    @Test
    public void test() {
        String[] ws = {"a", "b", "ab", "abc"};
        System.out.println(findAllConcatenatedWordsInADict(ws));
    }

    // 哈希字符串
    // 一般使用双哈希，记得要加OFFSET，免得造成碰撞
    // 因子一般选择较大的质数2333333，1313131
    // 溢出模数也应用较大质数
    // 范式：Hash[i]=(Hash[i-1]*p+s[i]-‘a’+1)%mod;

    // 方法一：
    // 双哈希字符串：O(n+m^2):n为words数组长度，m为单个words[i]的长度
    int P1 = 131, P2 = 13333, OFFSET = 1333;
    int mod = 1000_000_007;
    Set<Long> set1 = new HashSet<>(), set2 = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            long hash1 = 0, hash2 = 0;
            for (int j = 0; j < words[i].length(); j++) {
                hash1 = (hash1 * P1 + (words[i].charAt(j) - 'a') + OFFSET) % mod;
                hash2 = (hash2 * P2 + (words[i].charAt(j) - 'a') + OFFSET) % mod;
            }
            set1.add(hash1);
            set2.add(hash2);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check(words[i])) res.add(words[i]);
        }
        return res;
    }

    boolean check(String s) {
        int n = s.length();
        // dp[i]:前i个字符所用的最多的单词个数
        // 由于每个单词肯定会由自己组成，因此要知道其是否由其他单词组合而成，需要将其拆分成个数更多的单词
        int[] dp = new int[n + 1];
        // Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            // if(dp[i] == -1) continue;
            long cur1 = 0, cur2 = 0;
            for (int j = i + 1; j <= n; j++) {
                cur1 = (cur1 * P1 + s.charAt(j - 1) - 'a' + OFFSET) % mod;
                cur2 = (cur2 * P2 + s.charAt(j - 1) - 'a' + OFFSET) % mod;
                if (set1.contains(cur1) && set2.contains(cur2)) dp[j] = Math.max(dp[j], dp[i] + 1);
            }
            if (dp[n] > 1) return true;
        }
        return false;
    }

    // 方法二：
    // 字典树+dfs
    Trie trie = new Trie();
    public List<String> findAllConcatenatedWordsInADict2(String[] words) {
        List<String> res = new ArrayList<>();
        // 这里要从长度进行排序，对于长度长的一定由更短的单词组成
        Arrays.sort(words,(x,y)->x.length()-y.length());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(dfs(word,0)) res.add(word);
            else insert(word);
        }
        return res;
    }

    private void insert(String word) {
        Trie node =trie;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(node.children[idx]==null){
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    // 判断对于word.substring(start)是否是连接词
    private boolean dfs(String word, int start) {
        if(start==word.length()) return true;
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            int idx = word.charAt(i) -'a';
            node = node.children[idx];
            if(node == null) return false;
            // 这里表名node!=null 说明是有相应的单词路径的
            if(node.isEnd){
                // 这里判断是一个单词的结尾，然后再进行dfs，保证有至少两个单词
                if(dfs(word,i+1))
                    return true;
            }
        }
        return false;
    }

    class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }
}
