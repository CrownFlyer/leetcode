package dfa;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-15 15:01
 */
public class LEETCODE_393_MIDDLE {

    @Test
    public void test() {
        int[] data = {197, 130, 1};
        System.out.println(validUtf8(data));
    }

    // input types:
    static final int TYPE_0 = 0b0000_0000;
    static final int TYPE_1 = 0b1000_0000;
    static final int TYPE_2 = 0b1100_0000;
    static final int TYPE_3 = 0b1110_0000;
    static final int TYPE_4 = 0b1111_0000;
    static final int[] TYPES = new int[]{TYPE_0, TYPE_1, TYPE_2, TYPE_3, TYPE_4};
    // masks
    static final int[] MASKS = {0b1000_0000, 0b1100_0000, 0b1110_0000, 0b1111_0000, 0b1111_1000};
    // dfa {input_type:next_state}
    static final Map<Integer, Map<Integer, Integer>> dfa = new HashMap<Integer, Map<Integer, Integer>>() {{
        put(0, new HashMap<Integer, Integer>() {{
            put(TYPE_0, 0);
            put(TYPE_2, 1);
            put(TYPE_3, 2);
            put(TYPE_4, 3);
        }});
        put(1, new HashMap<Integer, Integer>() {{
            put(TYPE_1, 0);
        }});
        put(2, new HashMap<Integer, Integer>() {{
            put(TYPE_1, 4);
        }});
        put(4, new HashMap<Integer, Integer>() {{
            put(TYPE_1, 0);
        }});
        put(3, new HashMap<Integer, Integer>() {{
            put(TYPE_1, 5);
        }});
        put(5, new HashMap<Integer, Integer>() {{
            put(TYPE_1, 6);
        }});
        put(6, new HashMap<Integer, Integer>() {{
            put(TYPE_1, 0);
        }});
    }};


    public boolean validUtf8(int[] data) {
        int cur = 0;
        for (int input : data) {
            Integer next = getNext(cur, input);
            if (next == null) return false;
            cur = next;
        }
        return cur == 0;
    }

    private int getType(int input) {
        for (int i = 0; i < TYPES.length; i++) {
            if ((MASKS[i] & input) == TYPES[i]) return TYPES[i];
        }
        // unreachable
        return -1;
    }

    private Integer getNext(int cur, int input) {
        int type = getType(input);
        if (type == -1) return null;
        return dfa.get(cur).get(type);
    }


}
