package exer.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-11 21:55
 */
public class LEETCODE_981_MIDDLE {
    @Test
    public void test() {
    }


    class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            Map.Entry<Integer, String> entry = map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }

}
