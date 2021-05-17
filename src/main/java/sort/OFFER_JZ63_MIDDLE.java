package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-21 10:43
 */
public class OFFER_JZ63_MIDDLE {
    @Test
    public void test() {

    }

    ArrayList<Integer> list = new ArrayList<>();
    boolean even = true;

    public void Insert(Integer num) {
        list.add(num);
        even = !even;
    }

    public Double GetMedian() {
        Collections.sort(list);
        int index = list.size() / 2;
        return even ? ((double) list.get(index) + (double) list.get(index - 1)) / 2 : (double) list.get(index);
    }
}
