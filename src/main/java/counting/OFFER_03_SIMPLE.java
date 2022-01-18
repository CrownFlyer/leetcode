package counting;

import org.junit.Test;

import java.util.Random;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-12 13:45
 */
public class OFFER_03_SIMPLE {
    @Test
    public void test() {
        int[] arrs = {3, 4, 2, 0, 0, 1};
        System.out.println(findRepeatNumber(arrs));
    }

    public int findRepeatNumber(int[] nums) {
        int i = 0, temp1, temp2;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            temp1 = nums[i];
            temp2 = nums[nums[i]];
            nums[nums[i]] = temp1;
            nums[i] = temp2;
        }
        return -1;
    }
}
