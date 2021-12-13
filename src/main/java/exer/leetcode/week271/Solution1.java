package exer.leetcode.week271;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-13 12:25
 */
public class Solution1 {
    public int countPoints(String rings) {
        int n = rings.length();
        Set[] set = new HashSet[10];
        for(int i = 0;i<10;i++) set[i] = new HashSet<>();
        for(int i = 0;i<n/2;i++){
            set[rings.charAt(2*i+1) - '0'].add(rings.charAt(2*i));
        }
        int res = 0;
        for(int i = 0;i<10;i++){
            if(set[i].size() ==  3) res++;
        }
        return res;
    }
}
