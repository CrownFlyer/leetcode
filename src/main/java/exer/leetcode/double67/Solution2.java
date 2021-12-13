package exer.leetcode.double67;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int n = security.length;
        int cntDown = 0,cntUp = 0;
        boolean[] down = new boolean[n];
        boolean[] up = new boolean[n];
        if(time == 0) down[0] = true;
        if(time == 0) up[n-1] = true;
        
        for(int i = 1;i<n;i++){
            if(security[i] <= security[i-1]) cntDown++;
            else cntDown = 0;
            if(cntDown >= time) down[i] = true;
        }
        for(int i = n - 2;i>=0;i--){
            if(security[i] <= security[i+1]) cntUp++;
            else cntUp = 0;
            if(cntUp >= time) up[i] = true;
        }
        for(int i = time;i + time < n;i++){
            if(down[i] && up[i]) res.add(i);
        }
        return res;
    }
}