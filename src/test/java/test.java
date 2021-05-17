import org.junit.Test;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-02-17 10:16
 */
public class test {
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>(3);
        list.add(1);
        list.add(2);
        System.out.println(list.size()==1);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
