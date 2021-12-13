package exer.test;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-09 09:52
 */
public class LEETCODE_352_HARD {
    @Test
    public void test() {
        SummaryRanges test = new SummaryRanges();
        test.addNum(6);
        test.addNum(6);
        test.addNum(0);
        test.addNum(4);
        test.addNum(8);
        test.addNum(7);
        test.addNum(6);
        test.addNum(4);
        test.addNum(7);
        test.addNum(5);
        System.out.println();
    }

    class SummaryRanges {
        // <k,v>:<range_left,range_right>
        TreeMap<Integer, Integer> intervals;

        public SummaryRanges() {
            intervals = new TreeMap<>();
        }

        public void addNum(int val) {
            // 找到
            Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);
            Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);
            //
            if (interval0 != null && interval0.getKey() <= val && val <= interval0.getValue()) return;
            else {
                boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
                boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;
                if (leftAside && rightAside) {
                    // 情况四
                    int left = interval0.getKey(), right = interval1.getValue();
                    intervals.remove(interval0.getKey());
                    intervals.remove(interval1.getKey());
                    intervals.put(left, right);
                } else if (leftAside) {
                    intervals.put(interval0.getKey(), val);
                } else if (rightAside) {
                    intervals.put(val, interval1.getValue());
                    intervals.remove(interval1.getKey());
                } else {
                    intervals.put(val, val);
                }
            }
        }

        public int[][] getIntervals() {
            int n = intervals.size();
            int[][] res = new int[n][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                res[i][0] = entry.getKey();
                res[i++][1] = entry.getValue();
            }
            return res;
        }
    }
}
