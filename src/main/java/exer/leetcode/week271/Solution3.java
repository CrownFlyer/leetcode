package exer.leetcode.week271;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-12 11:58
 */
public class Solution3 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        if (n < 3) return 0;
        int idxA = 0, idxB = n - 1;
        int curA = capacityA, curB = capacityB;
        int res = 0;
        while (idxA < idxB) {
            if (curA >= plants[idxA]) {
                curA -= plants[idxA++];
            } else {
                curA = capacityA;
                res++;
                curA -= plants[idxA++];
            }
            if (curB >= plants[idxB]) {
                curB -= plants[idxB--];
            } else {
                curB = capacityB;
                res++;
                curB -= plants[idxB--];
            }
        }
        // 两个人到同一株植物
        if (curA < plants[idxA] && curB < plants[idxB] && idxA == idxB) return res + 1;
        else return res;
    }
}
