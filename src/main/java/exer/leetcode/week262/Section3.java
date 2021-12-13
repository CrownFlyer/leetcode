package exer.leetcode.week262;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-10 10:24
 */
public class Section3 {
    @Test
    public void test() {
        StockPrice test = new StockPrice();
        test.update(1,10);
        test.update(2,5);
        test.update(1,3);

    }


    class StockPrice {
        TreeMap<Integer, Integer> stockMap;
        TreeMap<Integer, Integer> priceMap;

        public StockPrice() {
            stockMap = new TreeMap<>();
            priceMap = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            if (stockMap.containsKey(timestamp)) {
                int prices = stockMap.get(timestamp);
                priceMap.put(prices, priceMap.get(prices) - 1);
                if (priceMap.get(prices) == 0) priceMap.remove(prices);
            }
            stockMap.put(timestamp, price);
            priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return stockMap.get(stockMap.lastKey());
        }

        public int maximum() {
            return priceMap.lastKey();
        }

        public int minimum() {
            return priceMap.firstKey();
        }
    }
}
