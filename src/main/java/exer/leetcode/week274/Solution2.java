package exer.leetcode.week274;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-02 15:29
 */
public class Solution2 {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<bank[i].length();j++){
                arr[i] += bank[i].charAt(j)-'0';
            }
            System.out.println(arr[i]);
        }
        int res = 0;
        int idx = n-1;
        int last = 0;
        while(idx>=0){
            res += last * arr[idx];
            if(arr[idx]!=0) last = arr[idx];
            idx--;
        }
        return res;
    }
}
