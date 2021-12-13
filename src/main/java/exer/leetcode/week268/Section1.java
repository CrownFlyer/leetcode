package exer.leetcode.week268;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-22 15:34
 */
public class Section1 {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(colors[i]!=colors[j]) res = Math.max(res,j-i);
            }
        }
        return res;
    }
}
