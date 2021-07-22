package string;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-16 09:56
 */
public class LEETCODE_9_SIMPLE {
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        StringBuilder sb = new StringBuilder();
        while (x != 0) {
            sb.append(x % 10);
            x /= 10;
        }
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - 1 - i]) return false;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int revertNumber = 0;
        while(x>revertNumber){
            revertNumber = revertNumber * 10 + x%10;
            x/=10;
        }

        return revertNumber/10 == x || x==revertNumber;
    }
}
