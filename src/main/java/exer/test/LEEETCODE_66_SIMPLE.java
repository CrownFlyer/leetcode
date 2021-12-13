package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-21 15:29
 */
public class LEEETCODE_66_SIMPLE {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean extension = false;
        int idx = 0;
        while (idx < n && digits[idx] == 9) idx++;
        extension = idx == n;

        int[] res;
        if (extension) res = new int[n + 1];
        else res = new int[n];

        idx = res.length - 1;
        boolean carry;
        while (idx >= 0) {
            if(idx != res.length - 1) carry = digits[extension?idx-1:idx] == 9;
            else carry = true;
            res[idx] = (digits[extension?idx-1:idx] + (carry ? 1 : 0)) % 10;
            idx--;
        }
        return res;
    }
}
