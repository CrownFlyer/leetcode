package exer.leetcode.week276;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-16 21:52
 */
public class Solution1 {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int m = (n+k-1)/k;
        String[] res = new String[m];
        int i = 0,idxi = 0;
        for(i = 0;i+k<n; i+=k){
            res[idxi++] = s.substring(i,i+k);
        }
        StringBuilder sb = new StringBuilder();
        if(i<n){
            sb.append(s.substring(i));
            for(int j = 0;n-i+j<k;j++) sb.append(fill);
            res[idxi] = sb.toString();
        }
        return res;
    }
}
