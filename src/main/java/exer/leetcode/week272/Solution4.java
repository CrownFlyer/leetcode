package exer.leetcode.week272;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-19 11:49
 */
public class Solution4 {
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        List[] lists = new List[k];
        for (int i = 0; i < k; i++) {
            lists[i] = new ArrayList();
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            int idx = i;
            while (idx < n) {
                lists[i].add(arr[idx]);
                idx += k;
            }
            res += lists[i].size() - lengthOfLIS(lists[i]);
        }
        return res;
    }

    public int lengthOfLIS(List<Integer> nums) {
        int len = 1, n = nums.size();
        if (n == 0) {
            return 0;
        }
        // d[i]:表示长度为 i 的最长上升子序列的末尾元素的最小值
        int[] d = new int[n + 1];
        d[len] = nums.get(0);
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) >= d[len]) {
                d[++len] = nums.get(i);
            } else {
                int l = 1,r = len;
                // 找到num.get(i)替换的地方，即d[x]第一个大于num.get(i)的地方
                while(l<r){
                    int m = (l+r)/2;
                    if(d[m]<=nums.get(i)) l=m+1;
                    else r = m;
                }
                d[r] = nums.get(i);
            }
        }
        return len;
    }
}
