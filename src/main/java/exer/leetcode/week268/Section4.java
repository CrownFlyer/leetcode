package exer.leetcode.week268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-21 14:53
 */
public class Section4 {
    public long kMirror(int k, int n) {
        long res = 0L;
        int cnt = 0;
        for (int i = 1; i < 10 && cnt < n; i++) {
            if (check(toK(i, k))) {
                res += i;
                cnt++;
            }
        }
        List<List<Integer>> last = new ArrayList<>();
        for (int i = 1; i <= 9 && cnt < n; i++) {
            List<Integer> temp = Arrays.asList(i, i);
            if (check(toK(list2Num(temp), k))) {
                cnt++;
                res += list2Num(temp);
            }
            last.add(new ArrayList<>(temp));
        }
        List<List<Integer>> next = new ArrayList<>();
        int pow = 1;
        while (cnt < n) {
            int insertIndex = (pow + 2) / 2;
            for (int i = 0; i < last.size() && cnt < n; i++) {
                if (pow % 2 == 0) {
                    last.get(i).add(insertIndex, last.get(i).get(insertIndex - 1));
                    if (check(toK(list2Num(last.get(i)), k))) {
                        cnt++;
                        res += list2Num(last.get(i));
                    }
                    next.add(new ArrayList<>(last.get(i)));
                    last.get(i).remove(insertIndex);
                } else {
                    for (int j = 0; j < 10 && cnt < n; j++) {
                        last.get(i).add(insertIndex, j);
                        if (check(toK(list2Num(last.get(i)), k))) {
                            cnt++;
                            res += list2Num(last.get(i));
                        }
                        next.add(new ArrayList<>(last.get(i)));
                        last.get(i).remove(insertIndex);
                    }
                }

            }
            last = next;
            next = new ArrayList<>();
            pow++;
        }

        return res;
    }

    public boolean check(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!list.get(i).equals(list.get(size - 1 - i))) return false;
        }
        return true;
    }

    public long list2Num(List<Integer> list) {
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            res = res * 10 + list.get(i);
        }
        return res;
    }

    public List<Integer> toK(long num, int k) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add((int) (num % k));
            num /= k;
        }
        return list;
    }
}
