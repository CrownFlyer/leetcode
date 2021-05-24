package exer.leetcode.week242;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-24 10:29
 */
public class Section1 {
    public static void main(String[] args) {
        Section1 test = new Section1();
        String s = "1";
        System.out.println(test.checkZeroOnes(s));
    }

    public boolean checkZeroOnes(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] cnt = new int[2];
        char cur = chars[0];
        cnt[cur - '0'] = 1;
        int index = 1;
        while (index < n) {
            int temp = 1;
            while (index < n && chars[index] == cur) {
                temp++;
                index++;
            }
            cnt[cur - '0'] = Math.max(temp, cnt[cur - '0']);
            if(index<n) cur = chars[index++];
        }
        return cnt[0] < cnt[1];
    }
}
