package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-07 18:34
 */
public class LEETCODE_1147_HARD {
    public int longestDecomposition(String text) {
        for (int i = 1; i < text.length() / 2; i++) {
            if (text.substring(0, i).equals(text.substring(text.length() - i)))
                return 2 + longestDecomposition(text.substring(i, text.length() - i));
        }
        return text.length() > 0 ? 1 : 0;
    }
}
