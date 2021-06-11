package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-10 15:30
 */
public class LEETCODE_287_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        LEETCODE_287_MIDDLE test = new LEETCODE_287_MIDDLE();
        System.out.println(test.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[slow];
        fast = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
