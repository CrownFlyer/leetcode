package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-15 16:44
 */
public class LEETCODE_93_MIDDLE {
    public static void main(String[] args) {
        String s = "25525511135";
        LEETCODE_93_MIDDLE test = new LEETCODE_93_MIDDLE();
        System.out.println(test.restoreIpAddresses(s));
    }

    static final int SEG_COUNT = 4;
    List<String> res = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    // backtrack
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return res;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart != s.length()) return;
            StringBuilder ipAddr = new StringBuilder();
            for (int i = 0; i < SEG_COUNT; i++) {
                ipAddr.append(segments[i]);
                if (i != SEG_COUNT - 1) ipAddr.append('.');
            }
            res.add(ipAddr.toString());
        }
        if (segStart == s.length()) return;

        // 避免前导零
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 枚举可能性
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xff) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd+1);
            } else break;
        }

    }

    // 暴力
    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        int[] segs = new int[4];
        for (segs[0] = 1; segs[0] <= 3; segs[0]++) {
            int maxSeg1 = Math.min(3, n - segs[0]);
            for (segs[1] = segs[0] + 1; segs[1] <= segs[0] + maxSeg1; segs[1]++) {
                int maxSeg2 = Math.min(3, n - segs[1]);
                for (segs[2] = segs[1] + 1; segs[2] <= segs[1] + maxSeg2; segs[2]++) {
                    int maxSeg3 = Math.min(3, n - segs[2]);
                    for (segs[3] = segs[2] + 1; segs[3] <= segs[2] + maxSeg3; segs[3]++) {
                        isvalid(segs, s, res);
                    }
                }
            }
        }
        return res;
    }

    public void isvalid(int[] segs, String s, List<String> res) {
        if (segs[3] != s.length()) return;
        String sseg1 = s.substring(0, segs[0]);
        int num1 = Integer.parseInt(sseg1);
        if (num1 > 255 || (sseg1.charAt(0) == '0' && sseg1.length() > 1)) return;
        String sseg2 = s.substring(segs[0], segs[1]);
        int num2 = Integer.parseInt(sseg2);
        if (num2 > 255 || (sseg2.charAt(0) == '0' && sseg2.length() > 1)) return;
        String sseg3 = s.substring(segs[1], segs[2]);
        int num3 = Integer.parseInt(sseg3);
        if (num3 > 255 || (sseg3.charAt(0) == '0' && sseg3.length() > 1)) return;
        String sseg4 = s.substring(segs[2], segs[3]);
        int num4 = Integer.parseInt(sseg4);
        if (num4 > 255 || (sseg4.charAt(0) == '0' && sseg4.length() > 1)) return;
        StringBuilder sb = new StringBuilder();
        sb.append(sseg1);
        sb.append(".");
        sb.append(sseg2);
        sb.append(".");
        sb.append(sseg3);
        sb.append(".");
        sb.append(sseg4);

        res.add(sb.toString());

    }
}
