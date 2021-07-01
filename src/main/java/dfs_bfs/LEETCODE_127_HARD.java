package dfs_bfs;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-30 15:08
 */
public class LEETCODE_127_HARD {
    @Test
    public void test() {
        String b = "hit";
        String e = "cog";
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(b, e, list));
    }

    // 双向bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;

        // 执行双向bfs，左右交替扩散的步数之和为所求
        Set<String> visited = new HashSet<>();
        // 分别用左右和右边扩散的哈希表代替单向bfs里的队列，交替使用（等价于使用队列）
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            // 保证beginVisited是较小的用来遍历的集合
            Set<String> nextLevelVisited = new HashSet<>();
            for (String cur : beginVisited) {
                // 尝试对cur进行修改，如果能得到endVisited集合里的，说明两个集合有交集！
                char[] chars = cur.toCharArray();
                for (int j = 0; j < cur.length(); j++) {
                    char origin = chars[j];
                    for (int k = 0; k < 26; k++) {
                        chars[j] = (char) ('a' + k);
                        // 这里不能用toString，必须new一个新的String才是复制全字符串
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            if (endVisited.contains(newWord)) return step + 1;
                            if(!visited.contains(newWord)){
                                nextLevelVisited.add(newWord);
                                visited.add(newWord);
                            }
                        }
                    }
                    chars[j] = origin;
                }
            }
            step++;
            beginVisited = nextLevelVisited;
        }
        return 0;
    }

    // 单向bfs
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // 1、将List放入哈希表，以便判断是否存在
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;

        // 2、bfs
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        wordSet.remove(beginWord);

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                char[] chars = cur.toCharArray();
                for (int j = 0; j < cur.length(); j++) {
                    char origin = chars[j];
                    for (int k = 0; k < 26; k++) {
                        chars[j] = (char) ('a' + k);
                        // 这里不能用toString，必须new一个新的String才是复制全字符串
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            if (endWord.equals(newWord)) return step + 1;
                            q.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    chars[j] = origin;
                }
            }
            step++;
        }
        return 0;
    }

}
