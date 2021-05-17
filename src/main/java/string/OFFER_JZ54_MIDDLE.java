package string;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 20:12
 */
public class OFFER_JZ54_MIDDLE {
    @Test
    public void test() {

    }

    HashMap<Character, Integer> map = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.get(ch) == null) {
            queue.add(ch);
            map.put(ch, 1);
        } else
            map.put(ch, map.get(ch) + 1);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!queue.isEmpty()) {
            if (map.get(queue.peek()) == 1)
                return queue.peek();
            else
                queue.poll();
        }
        return '#';
    }
}
