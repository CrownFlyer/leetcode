package stateCompress;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-29 20:51
 */
public class LEETCODE_216_MIDDLE {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int mask = 0; mask < (1 << 9); mask++) {
            if(check(mask,n,k))
                res.add(new ArrayList<>(list));
        }
        return res;
    }

    private boolean check(int mask, int n, int k) {
        list.clear();
        for (int i = 0; i < 9; i++) {
            if((mask&1)!=0) list.add(i+1);
            mask >>=1;
        }
        if(list.size() !=k) return false;

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum == n;
    }


}
