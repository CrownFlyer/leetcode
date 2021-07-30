package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-26 16:04
 */
public class LEETCODE_995_HARD {

    // 差分数组：O(n) O(n)
    public int minKBitFlips1(int[] nums, int k) {
        int n = nums.length;
        // diff[i]:表示两个相邻元素nums[i-1]和nums[i]的翻转次数的差
        int[] diff = new int[n + 1];
        // revCnt:当前位置需要翻转的次数（由于前面的翻转和本身的翻转累计值）
        // 累计值可以通过累加差分数组反映出真实值
        int res = 0,revCnt=0;
        for (int i = 0; i < n; i++) {
            revCnt+=diff[i];
            if((nums[i]+revCnt)%2==0){
                if(i+k>n) return -1;
                res++;
                // 模2意义下的加减等价于异或
//                revCnt ^= 1;
//                diff[i + k] ^= 1;
                revCnt++;
                diff[i+k]--;
            }
        }
        return res;
    }

    // 滑动窗口：O(n) O(1)
    // 只要遍历到i的位置时，能知道i-k上发生了翻转，即可丢掉diff差分数组的作用
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int res = 0,revCnt = 0;
        for (int i = 0; i < n; i++) {
            if(i>=k&&nums[i-k]>1){
                revCnt ^=1;
                nums[i-k]-=2;   // 复原数组，若允许修改，则可省略
            }
            // 由于revCnt限制在模2意义下 直接==判断
            if(nums[i]==revCnt){    // 经过前面的翻转和本身的元素后，仍需要翻转
                if(i+k>n) return -1;
                res++;
                revCnt ^=1;
                // 这里+2是为了区分0/1 如果是加1 有可能是0+1而来 也有可能是1本身
                nums[i]+=2;
            }
        }
        return res;
    }
}
