package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-23 15:13
 */
public class LEETCODE_13_SIMPLE {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int v = symbolValues.get(s.charAt(i));
            if (i < n - 1 && v < symbolValues.get(s.charAt(i + 1)))
                res -= v;
            else
                res += v;
        }
        return res;
    }
}
