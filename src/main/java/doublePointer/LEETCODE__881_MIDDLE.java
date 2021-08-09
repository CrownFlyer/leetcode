package doublePointer;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 08:23
 */
public class LEETCODE__881_MIDDLE {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0,r = people.length-1;
        int res = 0;
        while (l < r) {
            if(people[r]+people[l]<=limit) l++;
            r--;
            res++;
        }
        return res;
    }
}
