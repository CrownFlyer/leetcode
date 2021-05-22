package greedy;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-18 18:53
 */
public class LEETCODE_767_MIDDLE {
    public static void main(String[] args) {
        String s = "abbacadddb";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString1(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
            maxCount = Math.max(maxCount, cnt[ch - 'a']);
        }
        if(maxCount>(n+1)/2) return "";

        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> {
            return cnt[c2 - 'a'] - cnt[c1 - 'a'];
        });

        for (char c = 'a'; c <= 'z'; c++) {
            if (cnt[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        StringBuffer sb = new StringBuffer();
        while(queue.size()>1){
            char c1 = queue.poll();
            char c2 = queue.poll();
            sb.append(c1);
            sb.append(c2);
            cnt[c1-'a']--;
            cnt[c2-'a']--;
            if(cnt[c1-'a']>0) queue.offer(c1);
            if(cnt[c2-'a']>0) queue.offer(c2);
        }
        if(queue.size()>0) sb.append(queue.poll());
        return sb.toString();
    }

    public static String reorganizeString(String s) {
        //把字符串S转化为字符数组
        char[] alphabetArr = s.toCharArray();
        //记录每个字符出现的次数
        int[] alphabetCount = new int[26];
        //字符串的长度
        int length = s.length();
        //统计每个字符出现的次数
        for (int i = 0; i < length; i++) {
            alphabetCount[alphabetArr[i] - 'a']++;
        }
        int max = 0, alphabet = 0, threshold = (length + 1) >> 1;
        //找出出现次数最多的那个字符
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] > max) {
                max = alphabetCount[i];
                alphabet = i;
                //如果出现次数最多的那个字符的数量大于阈值，说明他不能使得
                // 两相邻的字符不同，直接返回空字符串即可
                if (max > threshold)
                    return "";
            }
        }
        //到这一步说明他可以使得两相邻的字符不同，我们随便返回一个结果，res就是返回
        //结果的数组形式，最后会再转化为字符串的
        char[] res = new char[length];
        int index = 0;
        //先把出现次数最多的字符存储在数组下标为偶数的位置上
        while (alphabetCount[alphabet]-- > 0) {
            res[index] = (char) (alphabet + 'a');
            index += 2;
        }
        //然后再把剩下的字符存储在其他位置上
        for (int i = 0; i < alphabetCount.length; i++) {
            while (alphabetCount[i]-- > 0) {
                if (index >= res.length) { // 偶数排完奇数排，保证不会覆盖，完全遍历
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }

}
