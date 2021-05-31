package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-28 10:26
 */
public class LEETCODE_08_07_MIDDLE {
    public static void main(String[] args) {
        LEETCODE_08_07_MIDDLE test = new LEETCODE_08_07_MIDDLE();
        String S = "DiLNSr";

    }


    // 暴力
//    List<String> list = new ArrayList<>();
//    StringBuilder sb = new StringBuilder();
//
//    public String[] permutation1(String S) {
//        backtrack(S, list, sb);
//        return list.toArray(new String[list.size()]);
//    }
//
//
//
//    public void backtrack1(String s, List<String> list, StringBuilder sb) {
//        if (s.length() == sb.length()) {
//            list.add(sb.toString());
//            return;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (sb.toString().contains(s.charAt(i) + "")) continue;
//            sb.append(s.charAt(i));
//            backtrack1(s, list, sb);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }


}
