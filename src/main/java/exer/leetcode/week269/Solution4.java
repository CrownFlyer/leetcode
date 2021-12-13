package exer.leetcode.week269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-28 17:39
 */
class Solution4 {
    int[] p;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        p = new int[n];
        int m = meetings.length;
        for(int i = 0;i<n;i++) p[i] = i;
        p[firstPerson] = 0;
        Arrays.sort(meetings,(x, y)->x[2]-y[2]);
        int l = 0,r = 0;
        int lastTime;
        // 按会议时间排序
        while(r<=m){
            lastTime = meetings[l][2];
            // 双指针寻找相同会议时间区间 [l,r)
            while(r<m&&lastTime == meetings[r][2]){
                r++;
            }
            List<int[]> list = new ArrayList<>();
            for(int i = l;i<r;i++){
                list.add(meetings[i]);
            }
            l = r;
            // 第一次遍历，合并集合
            for(int[] e:list){
                int a = e[0],b = e[1];
                if(p[find(a)] == 0 || p[find(b)] == 0){
                    p[find(a)] = 0;
                    p[find(b)] = 0;
                }
                p[find(b)] = p[find(a)];
            }
            // 第二次遍历，分场景讨论
            for(int[] e:list){
                int a = e[0],b = e[1];
                if(p[find(a)] == 0 || p[find(b)] == 0){
                    // 两位专家事先都不知道秘密，但后续一个被告知后，瞬时也分享给另一个
                    // 注意，这里是从根节点改，不然下次直接寻址寻不到了
                    p[find(a)] = 0;
                    p[find(b)] = 0;
                }else{
                    // 两位专家事先都不知道秘密，后续也未被告知，拆分合并关系
                    // 这里一定要拆分回去，不然会影响后续的合并
                    p[a] = a;
                    p[b] = b;
                }
            }
            r++;
        }

        List<Integer> res = new ArrayList<>();
        // 每个p[i]实际上记录的仍是与其直接相连的节点，因此用find
        for(int i = 0;i<n;i++) if(p[find(i)] == 0) {
            res.add(i);
        }
        return res;
    }

    public int find(int x){
        while(x != p[x]) {
            x = p[x];
        }
        return x;
    }
}
