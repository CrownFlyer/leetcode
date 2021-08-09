package doublePointer;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-03 10:39
 */
public class LEETCODE_1229_MIDDLE {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // l、r分别指向slot1、slot2
        int l = 0,r = 0;
        int lLen = slots1.length,rLen = slots2.length;
        while(l<lLen&&r<rLen){
            while(l<lLen&&slots1[l][1]-slots1[l][0]<duration) l++;
            while(r<rLen&&slots2[r][1]-slots2[r][0]<duration) r++;
            int start = Math.max(slots1[l][0],slots2[r][0]);
            int end = Math.min(slots1[l][1],slots2[r][1]);
            if(end-start>=duration) return Arrays.asList(start,start+duration);
            else if(slots1[l][0]<slots2[r][0]) l++;
            else r++;
        }
        return Arrays.asList();
    }
}
