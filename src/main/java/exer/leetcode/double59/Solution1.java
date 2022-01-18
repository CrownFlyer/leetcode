package exer.leetcode.double59;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-30 18:27
 */
public class Solution1 {
    // 贪心，顺时针/逆时针
    public int minTimeToType(String word) {
        int n = word.length(),res = n;
        char cur = 'a';
        for(int i = 0;i<n;i++){
            char c = word.charAt(i);
            res += Math.min(Math.abs(cur-c),-Math.abs(cur-c)+26);
            cur = c;
        }
        return res;
    }

}
