package exer.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-24 10:17
 */
public class LEETCODE_638_MIDDLE {
    Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        List<List<Integer>> filterSpecial = new ArrayList<>();
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; i++) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n))
                filterSpecial.add(sp);
        }
        return dfs(price, needs, filterSpecial, n);
    }

    // 记忆化搜索计算满足购物清单所需花费的最低价格
    private int dfs(List<Integer> price, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
        if (!memo.containsKey(curNeeds)) {
            int minPrice = 0;
            for (int i = 0; i < n; i++)
                minPrice += curNeeds.get(i) * price.get(i);

            for (List<Integer> curSpecial : filterSpecial) {
                int specialPrice = curSpecial.get(n);
                List<Integer> nextNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (curSpecial.get(i) > curNeeds.get(i))
                        break;
                    nextNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                }
                if (nextNeeds.size() == n)
                    minPrice = Math.min(minPrice, dfs(price, nextNeeds, filterSpecial, n) + specialPrice);
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }
}
