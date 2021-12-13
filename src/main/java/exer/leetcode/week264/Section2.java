package exer.leetcode.week264;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-24 10:28
 */
public class Section2 {
    @Test
    public void test() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 10e6; i++) {
            if(check(i)) set.add(i);
        }
        System.out.println(set);
    }

    public boolean check(int x){
        HashMap<Integer, Integer> map = new HashMap<>();
        while(x>0){
            int cur = x%10;
            map.put(cur,map.getOrDefault(cur,0)+1);
            x/=10;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getKey()!=entry.getValue()) return false;
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        for (int i = n+1; i <= 10e6; i++) {
            if(check(i)) return i;
        }
        return -1;
    }
}
