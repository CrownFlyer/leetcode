package exer.leetcode.week240;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-10 11:18
 */
public class Section1 {
    public static void main(String[] args) {
//        int[][] logs = {{1993,1999},{2000,2010}};
        int[][] logs = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        System.out.println(maximumPopulation(logs));
    }

    // 暴力
    public static int maximumPopulation1(int[][] logs) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < logs.length; i++) {
            int tempMax = 0;
            int tempRes = logs[i][0];
            for (int j = 0; j < logs.length; j++) {
                if (tempRes >= logs[j][0] && tempRes < logs[j][1]) {
                    tempMax++;
                }
            }
            if (tempMax > max) {
                max = tempMax;
                res = tempRes;
            } else if (tempMax == max) {
                res = Math.min(tempRes, res);
            }
        }
        return res;
    }

    // 差分
    public static int maximumPopulation(int[][] logs) {
        int[] d = new int[110];
        for (int[] log : logs) {     //遍历每个人的出生和死亡年份
            d[log[0] - 1950] += 1;  //出生年份人数+1
            d[log[1] - 1950] -= 1;  //死亡年份人数-1
        }
        int s = 0, res = 0, cnt = 0;
        for (int i = 0; i <= 100; i++) {
            s += d[i];      //s是记录每一年的存活人数
            if (s > cnt) {
                cnt = s;
                res = i;
            }
        }
        return res + 1950;
    }

}
