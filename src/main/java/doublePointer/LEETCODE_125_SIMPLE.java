package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-02 15:21
 */
public class LEETCODE_125_SIMPLE {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (inValid(s, l)) l++;
            while (inValid(s, r)) r--;
            char lChar = s.charAt(l++);
            char rChar = s.charAt(r--);
            if (lChar >= 'A' && lChar <= 'Z') lChar -= 'A' - 'a';
            if (rChar >= 'A' && rChar <= 'Z') rChar -= 'A' - 'a';
            if (lChar != rChar) return false;
        }
        return true;
    }

    public boolean inValid(String s, int i) {
        char c = s.charAt(i);
        if (c >= 'a' && c <= 'z') return false;
        else if (c >= 'A' && c <= 'Z') return false;
        else if (c >= '0' && c <= '9') return false;
        else return true;
    }

}
