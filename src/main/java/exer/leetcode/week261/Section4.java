package exer.leetcode.week261;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-03 12:13
 */
public class Section4 {
    @Test
    public void test() {
        String s = "aaabbbcccddd";
        System.out.println(smallestSubsequence(s, 3, 'b', 2));
    }

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length();
        char[] chs = s.toCharArray();

        int targetLen = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == letter) targetLen++;
        }

        int del = 0;    // 删掉letter的个数
        int delNum = n - k; // 删掉字母的个数
        if(delNum == 0) return s;

        // 字典序升序存储
        // First->Last是原字符串的顺序
        LinkedList<Character> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = chs[i];
            // eec
            while (!q.isEmpty() && delNum > 0 && c < q.peekLast()) {
                if (letter == q.peekLast()) {
                    // 表示后面没有更多的target
                    if (targetLen - del == repetition) break;
                    // 后面还有更多的target且当前有更小的字典序子序列
                    del++;
                }
                // 只有在确定字典序的时候才能确切的删除一个char
                delNum--;
                q.pollLast();
            }
            q.offerLast(c);
        }

        // 到这里能保证单调队列里存放了字典序最小，且满足>=repetition条件的子序列
        StringBuilder sb = new StringBuilder();
        // 如果还需要继续删除
        while (delNum > 0) {
            // 按照字典序逆序弹出升序过程中更大的 eg. abcd 按d->c->b->a顺序弹出
            char c = q.pollLast();
            if (c == letter) {
                // 如果单调栈内的tar个数比需要的还多才可以弹出tar，因为后面的子序列的字典序更小，且满足repetition要求
                if (targetLen - del > repetition) {
                    del++;
                    delNum--;
                } else sb.insert(0, c); // 如果刚好剩下，则必须直接加入sb保护起来，由于是按逆序弹出,因此插入头部
            } else delNum--;
        }

        while (!q.isEmpty()) sb.insert(0, q.pollLast());
        return sb.toString();
    }
}
