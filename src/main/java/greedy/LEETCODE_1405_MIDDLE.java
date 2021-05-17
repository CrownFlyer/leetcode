package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-15 19:21
 */
public class LEETCODE_1405_MIDDLE {
    public static void main(String[] args) {
        int a = 0;
        int b = 8;
        int c = 11;

        System.out.println(longestDiverseString(a, b, c));
    }

    public static String longestDiverseString(int a, int b, int c) {
        int[][] cnt = new int[3][3];
        for (int i = 0; i < 3; i++) cnt[i][0] = i;

        cnt[0][1] = a;
        cnt[1][1] = b;
        cnt[2][1] = c;
        StringBuilder sb = new StringBuilder();

        while (true) {
            Arrays.sort(cnt, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o2[2] == o1[2]) return o2[1] - o1[1];
                    else return o2[2] - o1[2];
                }
            });
            char ch = (char) (cnt[0][0] + 'a');
            if (cnt[0][1] >= 1) {
                if(cnt[0][1]<2||cnt[0][1]<=(cnt[1][1]+1)/2||cnt[0][1]<=(cnt[2][1]+1)/2){
                    cnt[0][1] -= 1;
                    sb.append(ch);
                }else {
                    cnt[0][1] -= 2;
                    sb.append(ch);
                    sb.append(ch);
                }
                cnt[2][2]=0;
                cnt[0][2]=-1;
            } else {
                break;
            }

        }
        return sb.toString();
    }
}
