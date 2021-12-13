package tree;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-16 09:04
 */
public class LEETCODE_212_HARD {
    @Test
    public void test() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords2(board, words));
    }

    // 方法一：回溯dfs O(m*n*3^(m+n)) O(m*n)
    // 解释下这里为什么底数为3，由于任何一个递归来的地方都是从一个相邻的格子来的，来的那个方向肯定不能继续递归了
    int m;
    int n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        boolean[][] v = new boolean[m][n];
        for (String word : words) {
            for (int i = 0; i < m; i++)
                Arrays.fill(v[i], false);
            boolean flag = false;
            for (int i = 0; i < m && !flag; i++) {
                for (int j = 0; j < n && !flag; j++) {
                    if (dfs(board, v, word, i, j, 0)) {
                        flag = true;
                        res.add(word);
                    }

                }
            }

        }
        return res;
    }

    // 返回第cur及之后的word的所有字符是否能匹配
    public boolean dfs(char[][] board, boolean[][] v, String word, int i, int j, int cur) {
        if (!v[i][j] && word.charAt(cur) == board[i][j]) {
            if (cur == word.length() - 1) return true;
            v[i][j] = true;
            int k;
            for (k = 0; k < 4; k++) {
                int ni = i + dirs[k][0], nj = j + dirs[k][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n)
                    return dfs(board, v, word, ni, nj, cur + 1);
            }
            v[i][j] = k == 4;
            return false;
        }
        return false;
    }

    // --------------------------------------------------------------------------------------------
    // 方法二：回溯 + 字典树:O(m*n*3^(l-1)) l是最长单词的长度 O(k*l):k是需要找的words长度
    public List<String> findWords2(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        // 由于我们是遍历的board的可行字符串，有可能出现重复的情况，直接用Set去重
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs1(board, trie, i, j, res);
            }
        }
        return new ArrayList<>(res);
    }

    //
    public void dfs1(char[][] board, Trie cur, int i, int j, Set<String> res) {
        char c = board[i][j];
        // 没有所需要找的字符串前缀，直接退出
        if (!cur.children.containsKey(c))
            return;
        cur = cur.children.get(c);
        // 如果不是空字符串，说明已经找到了需要找的字符串
        if (!cur.word.equals(""))
            res.add(cur.word);
        // 避免使用标记数组
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length)
                dfs1(board, cur, ni, nj, res);
        }
        board[i][j] = c;
    }


    class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.word = "";
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c))
                    cur.children.put(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.word = word;
        }
    }

}
