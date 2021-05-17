package exer.zx;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-24 16:22
 */
public class Section4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        int n1 = 0, n2 = 0, q = 0;
        n1 = in.nextInt();
        n2 = in.nextInt();
        q = in.nextInt();

        int index = 0;
        int[] arr = new int[q];
        while (index < q && in.hasNextInt()) {
            arr[index++] = in.nextInt();
        }
        for (int i = 0; i < n1; i++) {
            set1.add(i + 1);
        }
        for (int i = 0; i < n2; i++) {
            set2.add(i + 1 + n1);
        }
        for (int i = 0; i < q; i++) {
            if (set1.contains(arr[i])) {
                set1.remove(arr[i]);
                set2.add(arr[i]);
            } else {
                set2.remove(arr[i]);
                set1.add(arr[i]);
            }
        }
        for (Integer integer : set1) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : set2) {
            System.out.print(integer + " ");
        }

    }

}
