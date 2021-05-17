package exer.zx;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-24 16:36
 */
public class Section5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();

        int op = 1, step = 1;

        int size = 20;
        int x = 0;
        LinkedHashMap<Integer, Integer> trace = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            x += op * step;
            op *= -1;
            step *= 2;
            trace.put(i + 1, x);
        }
        int cnt = 0;
        boolean choice; //1 : jump 0 : reset
        while (s != t) {
            if (trace.containsValue(s - t)) {
                for (int i = 0; i < trace.size(); i++) {

                }
                break;
            }
            // 策略
            if (Math.abs(t - s) > step / 2) {
                choice = true;
            } else {
                choice = false;

            }
            // 策略

            if (choice) {
                s += op * step;
                op *= -1;
                step *= 2;
            } else {
                op = 1;
                step = 1;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

}
