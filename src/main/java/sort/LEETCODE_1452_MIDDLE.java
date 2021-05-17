package sort;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-24 10:44
 */
public class LEETCODE_1452_MIDDLE {
    public static void main(String[] args) {
        String[][] favoriteCompanies = {{"leetcode", "google", "facebook"}, {"google", "microsoft"}, {"google", "facebook"}, {"google"}, {"amazon"}};
        ArrayList<List<String>> lists = new ArrayList<>();
        for (String[] favoriteCompany : favoriteCompanies) {
            ArrayList<String> list = new ArrayList<>();
            for (String s : favoriteCompany) {
                list.add(s);
            }
            lists.add(list);
        }
        List<Integer> res = peopleIndexes(lists);
        if (res == null) return;
        for (Integer i : res) {
            System.out.printf("%d ", i);
        }
    }

    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean contains = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j || favoriteCompanies.get(i).size() >= favoriteCompanies.get(j).size()) continue;
                HashSet<String> set = new HashSet<>(favoriteCompanies.get(j));
                if (set.containsAll(favoriteCompanies.get(i)))
                    contains = true; // 判断第i个字符串是否是第j个字符串的子集
            }
            if (!contains) res.add(i);
        }
        return res;
    }

    // 超时
    public static List<Integer> peopleIndexes1(List<List<String>> favoriteCompanies) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean contains = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                int cnt = 0;
                if (i == j || favoriteCompanies.get(i).size() >= favoriteCompanies.get(j).size()) continue;

                for (String s : favoriteCompanies.get(i)) { // 判断第i个字符串是否是第j个字符串的子集
                    if (favoriteCompanies.get(j).contains(s)) {
                        cnt++;
                    }
                }
                if (cnt == favoriteCompanies.get(i).size()) {
                    contains = true;
                    break;
                }
            }
            if (!contains) res.add(i);
        }
        return res;
    }
}
