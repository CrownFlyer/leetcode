package exer.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-03 09:37
 */
public class LEETCODE_166_MIDDLE {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0)
            return String.valueOf(numeratorLong / denominatorLong);

        // res
        StringBuilder sb = new StringBuilder();
        if (numeratorLong < 0 ^ denominatorLong < 0) sb.append('-');

        // 整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        sb.append(numeratorLong / denominatorLong);

        // 小数部分
        StringBuilder frac = new StringBuilder();
        long remainer = numeratorLong % denominatorLong;
        if(remainer!=0) frac.append('.');
        Map<Long, Integer> map = new HashMap<>();
        int idx = 0;
        while (remainer != 0 && !map.containsKey(remainer)) {
            map.put(remainer, idx);
            remainer *= 10;
            frac.append(remainer / denominatorLong);
            remainer %= denominatorLong;
            idx++;
        }

        // 有循环部分
        if(remainer!=0){
            frac.insert(1+map.get(remainer),'(');
            frac.append(')');
        }
        sb.append(frac);

        return sb.toString();
    }
}
