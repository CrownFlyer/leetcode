package counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-14 16:08
 */
public class LEETCODE_373_MIDDLE {
    // 优先队列 O()
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y)->x[0]+x[1]-y[0]-y[1]);
        int n1 = nums1.length,n2 = nums2.length;
        for(int i =0;i<n1;i++) q.offer(new int[]{nums1[i],nums2[0],0});
        for(int i = 0;i<k&&!q.isEmpty();i++){
            int[] cur = q.poll();
            res.add(Arrays.asList(cur[0],cur[1]));
            if(cur[2]<n2-1) q.offer(new int[]{cur[0],nums2[++cur[2]],cur[2]});
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int l = nums1[0] + nums2[0],r=nums1[nums1.length-1]+nums2[nums2.length-1];
        while(l<r){
            int m = l+r>>1;
            if(count(nums1,nums2,m) < k) l = m + 1;
            else r = m;
        }
        // 这里保证选择和为r时，对数和个数>=k
        // 先添加和小于r的
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            for(int j =0;j<nums2.length&&nums1[i]+nums2[j]<r&&res.size()<k;j++){
                res.add(Arrays.asList(nums1[i],nums2[j]));
            }
        }
        // 再添加和等于r的
        for(int i = 0;i<nums1.length&&res.size()<k;i++){
            int ll = 0,rr=nums2.length-1;
            while(ll<rr){
                int m = (ll+rr)/2;
                if(nums1[i]+nums2[m]<r) ll = m + 1;
                else rr = m;
            }
            while(rr<nums2.length&&nums1[i]+nums2[rr]==r&&res.size()<k) res.add(Arrays.asList(nums1[i],nums2[rr++]));
        }
        return res;
    }
    // 小于v的数对数
    int count(int[] nums1,int[] nums2,int v){
        int n1 = nums1.length,n2 = nums2.length;
        int cnt = 0;
        for(int i =0;i<n1;i++){
            int l = 0,r=n2-1;
            if(nums1[i] + nums2[0] > v) continue;
            else if(nums1[i] + nums2[n2-1] <=v){
                cnt += n2;
                continue;
            }
            while(l<r){
                int m = (l+r+1)/2;
                if(nums1[i]+nums2[m]<=v) l = m;
                else r = m-1;
            }
            // [0,r]
            cnt += l+1;
        }
        return cnt;
    }

    boolean check(int[]nums1,int[]nums2,int x, int k) {
        int ans = 0;
        for (int i = 0; i < nums1.length && ans < k; i++) {
            for (int j = 0; j < nums2.length && ans < k; j++) {
                if (nums1[i] + nums2[j] <= x) ans++;
                else break;
            }
        }
        return ans >= k;
    }
}
