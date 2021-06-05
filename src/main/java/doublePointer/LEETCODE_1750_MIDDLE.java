package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-05 16:16
 */
public class LEETCODE_1750_MIDDLE {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = n - 1;
        if(n==1) return 1;
        // 避免 aaa:O(n)
        char c = chars[0];
        int i = 1;
        while(i<n&&chars[i]==c) i++;
        if(i==n) return 0;

        while (l < r) {
            if (chars[l] != chars[r]) return r - l + 1;
            char ch = chars[l];
            while(chars[r]==ch) r--;
            while(chars[l]==ch) l++;
            if(l>r) return 0;
        }
        // 只有xax这种情况
        return 1;

    }
}
