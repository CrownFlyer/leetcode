package greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-21 16:27
 */
public class LEETCODE_56_MIDDLE {
    @Test
    public void test(){

    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==0) return new int[0][2];
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);

        List<int[]> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            int l = intervals[i][0],r = intervals[i][1];
            if(res.size()==0||res.get(res.size()-1)[1]<l) res.add(new int[]{l,r});
            else res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],r);
        }
        return res.toArray(new int[res.size()][]);
    }
}
