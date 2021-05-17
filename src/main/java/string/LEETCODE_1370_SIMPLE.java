package string;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-22 10:36
 */
public class LEETCODE_1370_SIMPLE {
    @Test
    public void test() {
        System.out.println(sortString("leetcode"));
    }

    public String sortString(String s) {
        int size = s.length();
        BitSet used = new BitSet(size);
        BitSet match = new BitSet(size);
        match.set(0, size);   // 全部置一，代表没用过

        StringBuilder res = new StringBuilder();    // store result
        char max = 'a' - 1;
        char min = 'z' + 1;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) > max) max = s.charAt(i);
            if (s.charAt(i) < min) min = s.charAt(i);
        }
        boolean find = true;
        while (!used.equals(match)) {
            char lastChar = ' ';
            char minChar;
            while (find) {
                find = false;
                minChar = 'z' + 1;
                int minIndex = 0;
                for (int i = 0; i < size; i++) {
                    if (!used.get(i) && lastChar < s.charAt(i) && s.charAt(i) < minChar) {
                        minChar = s.charAt(i);
                        minIndex = i;
                        if(min==s.charAt(minIndex)) break;
                    }
                }
                lastChar = s.charAt(minIndex);
                find = minChar != 'z' + 1;
                if (find) {
                    used.set(minIndex);
                    res.append(s.charAt(minIndex));
                }
            }
            find = true;

            char maxChar;
            lastChar = 'z' + 1;
            while (find) {
                find = false;
                maxChar = 'a' - 1;
                int maxIndex = 0;
                for (int i = 0; i < size; i++) {
                    if (!used.get(i) && lastChar > s.charAt(i) && s.charAt(i) > maxChar) {
                        maxChar = s.charAt(i);
                        maxIndex = i;
                        if(max==s.charAt(maxIndex)) break;
                    }
                }
                lastChar = s.charAt(maxIndex);
                find = maxChar != 'a' - 1;
                if (find) {
                    used.set(maxIndex);
                    res.append(s.charAt(maxIndex));
                }
            }
            find = true;
        }
        return res.toString();
    }
}
