package string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-19 14:52
 */
public class Offer_JZ45_MIDDLE {

    @Test
    public void test(){
        int[] nums = {0, 3, 2, 6, 4};
        System.out.println(IsContinuous(nums));
    }

    public boolean IsContinuous(int[] numbers) {
        if (numbers.length == 0 || numbers == null)
            return false;

        int size = numbers.length;
        Arrays.sort(numbers);
        int cntZero = 0;
        for (int i = 0; i < size; i++) {
            if (numbers[i] != 0) {
                cntZero = i;
                break;
            }
        }
        int gap = 0;
        for (int j = cntZero; j < size - 1; j++) {
            if (numbers[j] == numbers[j + 1])
                return false;
            gap += numbers[j + 1] - numbers[j] - 1;
        }
        return gap <= cntZero;
    }

}
