package array;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-16 17:27
 */
public class LEETCODE_41_HARD {
    public static void main(String[] args) {
        LEETCODE_41_HARD test = new LEETCODE_41_HARD();
        int[] nums = {3,4,-2,1};
        System.out.println(test.firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 初始想法是用一个辅助数组的，标记已有的[1,N]之间的元素，然后从小到大遍历一次，找到第一个未标记的则为所求，此处用负数作标记
        // 但要求O(1)常量空间，则借用原数组，此处有一个技巧，则是存储上一个被修改的位置所在的元素x为-|x|，因为后续遍历的时候还会用到
        // eg.[3,4,-1,1] 第一次替换会将 -1 替换为-3，1替换为-4当遍历到index=2处时，该
        // 标记nums[i] 如果在[1,N]之间，则nums[i]-1标记为负数，把小于1的部分替换为n+1是为了避免-2 把 2的位置给标记了的尴尬!
        for(int i=0;i<n;i++){
            if(nums[i]<=0) nums[i] = n+1;
        }
        for(int i=0;i<n;i++){
            int num = Math.abs(nums[i]);
            if(num<=n) nums[num-1] = -Math.abs(nums[num-1]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }

}
