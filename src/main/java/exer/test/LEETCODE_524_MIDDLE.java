package exer.test;

import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-14 07:52
 */
public class LEETCODE_524_MIDDLE {
    public String findLongestWord(String s, List<String> dictionary) {
        int n1 = s.length();
        Collections.sort(dictionary, (x, y) -> {
            if(x.length()!=y.length()) return y.length()-x.length();
            else return x.compareTo(y);
        });

        String res = "";
        for (String p : dictionary) {
            int n2 = p.length();
            int idx1 = 0,idx2 = 0;
            while(idx1<n1&&idx2<n2){
                if(s.charAt(idx1)==p.charAt(idx2)) idx2++;
                idx1++;
            }
            if(idx2==n2) return p;
        }
        return res;
    }

}
