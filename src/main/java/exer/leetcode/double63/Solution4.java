package exer.leetcode.double63;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-15 19:03
 */
public class Solution4 {
    // 用反函数的图像法更形象
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Long> pos1 = new ArrayList<>(), pos2 = new ArrayList<>();
        List<Long> neg1 = new ArrayList<>(), neg2 = new ArrayList<>();
        for(int num:nums1)
            if(num<0) neg1.add((long)num);
            else pos1.add((long)num);
        for(int num:nums2)
            if(num<0) neg2.add((long)num);
            else pos2.add((long)num);
        long l = (long)-10e10,r=(long)10e10;
        while(l<r){
            long m = l + (r-l)/2;
            long sum = 0;
            for(int i = 0,j=(pos2.size()-1);i<pos1.size();i++){
                while(j>=0 && pos1.get(i)*pos2.get(j) > m) j--;
                sum += j + 1;
            }
            for(int i = 0,j=0;i<neg1.size();i++){
                while(j<pos2.size() && neg1.get(i)*pos2.get(j) > m) j++;
                sum += pos2.size() - j;
            }
            for(int i = 0,j=0;i<pos1.size();i++){
                while(j<neg2.size() && pos1.get(i)*neg2.get(j) <= m) j++;
                sum += j;
            }
            for(int i = 0,j=neg2.size()-1;i<neg1.size();i++){
                while(j>=0 && neg1.get(i)*neg2.get(j) <= m) j--;
                sum += neg2.size() - 1 - j;
            }

            if(sum < k) l = m + 1;
            else r = m;
        }
        return r;
    }
}
