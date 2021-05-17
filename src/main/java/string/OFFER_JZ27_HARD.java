package string;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 22:33
 */
public class OFFER_JZ27_HARD {

    ArrayList<String> res = new ArrayList<>();
    char[] c;

    @Test
    public void test() {
        String str = "abc";
        ArrayList<String> permutation = permutation(str);
        for (String s : permutation) {
            System.out.println(s);
        }

    }


    public ArrayList<String> permutation(String str) {
        c = str.toCharArray();
        dfs(0);
        return res;
    }

    void dfs(int num) {
        int size = c.length;
        if (num == size - 1) {
            res.add(String.valueOf(c));
            return;
        }
        for (int i = num; i < size; i++) {
            if (c[num] == c[i] && num != i) continue;
            swap(num, i);
            dfs(num + 1);
        }

    }

    void swap(int x, int y) {
        char tmp = c[x];
        c[x] = c[y];
        c[y] = tmp;
    }

}
