package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-30 15:28
 */
public class LEETCODE_1358_MIDDLE {
    public int numberOfSubstrings(String s) {
        return atMostKCharacters(s, 3) - atMostKCharacters(s, 2);
    }

    public int atMostKCharacters(String s, int k) {
        int[] cnt = new int[3];
        int count = 0;
        int n = s.length();
        int l = 0, r = 0;
        int res = 0;
        while (r < n) {
            cnt[s.charAt(r) - 'a']++;
            if (cnt[s.charAt(r++) - 'a'] == 1) count++;
            while (count > k) {
                cnt[s.charAt(l) - 'a']--;
                if (cnt[s.charAt(l++) - 'a'] == 0) count--;
            }
            res += r - l;
        }
        return res;
    }
}
