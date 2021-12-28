package exer.leetcode.week273;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-26 13:37
 */
public class Solution4 {
    public int[] recoverArray(int[] nums) {
        int n = nums.length / 2;
        Arrays.sort(nums);
        int[] res = null;
        for(int i = 1;i<2*n;i++){
            int k = (nums[i] - nums[0])/2;
            if(k>0) res = check(nums,k);
            if(res!=null) return res;
        }
        return null;

    }

    int[] check(int[] arrs,int k){
        int n = arrs.length/2;
        int idx = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n*2;i++){
            map.put(arrs[i],map.getOrDefault(arrs[i],0)+1);
        }
        int[] res = new int[n];
        int cnt = 0;
        while(idx<2*n){
            if(map.containsKey(arrs[idx]+2*k)){
                Integer v1 = map.get(arrs[idx]+2*k);
                Integer v2 = map.get(arrs[idx]);
                if(v1!=null && v2 !=null){
                    if(v1 == 1) map.remove(arrs[idx]+2*k);
                    else map.put(arrs[idx]+2*k,v1-1);
                    if(v2 == 1) map.remove(arrs[idx]);
                    else map.put(arrs[idx],v2-1);
                    res[cnt++] = arrs[idx]+k;
                }
            }
            idx++;
        }
        if(cnt == n) return res;
        return null;
    }
}
