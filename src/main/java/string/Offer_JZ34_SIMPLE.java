package string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 14:52
 */
public class Offer_JZ34_SIMPLE {
    public static void main(String[] args) {
        Offer_JZ34_SIMPLE test = new Offer_JZ34_SIMPLE();
        int index = test.FirstNotRepeatingChar("google");
        System.out.println(index);
    }

    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0 || str == null) {
            return -1;
        }

        int size = str.length();
        for (int i = 0; i < size; i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i)))
                return i;
        }
        return -1;
    }

//    public int FirstNotRepeatingChar(String str) {
//        if (str.length() == 0 || str == null) {
//            return -1;
//        }
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        int size = str.length();
//        for (int i = 0; i < size; i++) {
//            if (map.get(str.charAt(i)) == null)
//                map.put(str.charAt(i), 1);
//            else
//                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
//        }
//        for (int i = 0; i < size; i++) {
//            if (map.get(str.charAt(i)) == 1)
//                return i;
//        }
//        return -1;
//    }
}
