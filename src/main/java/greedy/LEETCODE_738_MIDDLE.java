package greedy;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-22 18:26
 */
public class LEETCODE_738_MIDDLE {
    @Test
    public void test() {
        System.out.println(new LEETCODE_738_MIDDLE().monotoneIncreasingDigits(332));
    }

    public int monotoneIncreasingDigits(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(0, n % 10);
            n /= 10;
        }
        int size = list.size();
        int i = 0;
        while (i != size-1) {
            if(list.get(i+1)<list.get(i)){
                int temp_i = i;
                while(list.get(temp_i)==0) temp_i--;
                list.set(temp_i,list.get(temp_i)-1);
                for (int j = temp_i+1; j <size; j++) {
                    list.set(j,9);
                }
                i=-1;
            }
            i++;
        }

        int res = 0;
        for (int j = 0; j < size; j++) {
            res *= 10;
            res += list.get(j);
        }
        return res;
    }
}
