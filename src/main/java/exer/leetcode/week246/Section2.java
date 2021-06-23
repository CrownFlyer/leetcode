package exer.leetcode.week246;

import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section2 {
    public static void main(String[] args) {
        Section2 test = new Section2();
        String s = "00:01";
        String f = "00:00";
        System.out.println(test.numberOfRounds(s, f));
    }
    public int numberOfRounds(String startTime, String finishTime) {
        String[] start = startTime.split(":");
        String[] finish = finishTime.split(":");

        int res = 0;
        int[] startT = new int[2];
        int[] finishT = new int[2];
        startT[0] =Integer.parseInt(start[0]);
        startT[1] =Integer.parseInt(start[1]);
        finishT[0] =Integer.parseInt(finish[0]);
        finishT[1] =Integer.parseInt(finish[1]);
        if(startT[0]>finishT[0] || (startT[0]==finishT[0]&&startT[1]>finishT[1])) finishT[0]+=24;
        res += 4*(finishT[0]-startT[0]);
        res+=finishT[1]/15 -(startT[1]+14)/15;
        return res;
    }
}
