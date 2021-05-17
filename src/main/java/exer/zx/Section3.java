package exer.zx;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-24 14:47
 */
public class Section3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<LinkedHashMap<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new LinkedHashMap<>(5));
        }
        int cur = 0;
        int index = 0;
        while (n > 0) {
            n--;

            int num = sc.nextInt();
            if (list.get(cur).get(num) == null) {
                list.get(cur).put(num, index++);
            } else {
                int temp = cur + 1;
                int oldIndex = list.get(cur).get(num);
                list.get(cur).put(num, index++);
                while (list.get(temp).get(num) != null) {
                    temp++;
                }
                list.get(temp).put(num, oldIndex);
            }

            if (list.get(cur).size() == 5) {
                Iterator<Map.Entry<Integer, Integer>> iterator = list.get(cur).entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = iterator.next();
                    System.out.print((entry.getValue() + 1) + " ");

                }
                cur++;
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }

}
