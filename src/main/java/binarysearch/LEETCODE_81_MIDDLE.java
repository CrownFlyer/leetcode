package binarysearch;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-26 11:24
 */
public class LEETCODE_81_MIDDLE {
    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 1, 2, 3, 4, 5};
        System.out.println(search(nums, 5));
    }

//    public static boolean search(int[] nums, int target) {
//        int n = nums.length;
//        int l = 0, r = n - 1, mid = (l + r) >> 1;
//        while(l<=r){
//            if(nums[l]==target || nums[r]==target || nums[mid]==target) return true;
//            else if(nums[mid]>target && nums[l]<target) r = mid-1;  // 左侧有序区间
//            else if(nums[mid]<target && nums[r]>target) l = mid+1;  // 右侧有序区间
//            else {l++;r--;};    // 仍在中间无序部分，左右边间往里收缩
//            mid = (l+r)>>1;
//        }
//        return false;
//    }

    public static boolean search1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) return true;
        }
        return false;
    }

//    public static int search(int[] nums, int target) {
//        int n = nums.length;
//        int l = 0, r = n - 1, mid = (l + r) >> 1;
//        while(l<=r){
//            if(nums[l]==target || nums[r]==target || nums[mid]==target) break;
//            else if(nums[mid]>target && nums[l]<target) r = mid-1;  // 左侧有序区间
//            else if(nums[mid]<target && nums[r]>target) l = mid+1;  // 右侧有序区间
//            else {l++;r--;};    // 仍在中间无序部分，左右边间往里收缩
//            mid = (l+r)>>1;
//        }
//
//        if(l>=0&&l<n&&nums[l]==target) {
//            while(l>0&&nums[l-1]==target) l--;
//            return l;
//        }
//        else if(mid>=0&&mid<n&&nums[mid]==target) {
//            while(mid>0&&nums[mid-1]==target) mid--;
//            return mid;
//        }
//        else if(r>=0&&r<n&&nums[r]==target) {
//            while(r>0&&nums[r-1]==target) r--;
//            return r;
//        }
//        else return -1;
//    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        // 这里的控制条件取等号，大多是为了在while中return mid，不取等号就跳出while 返回l的值
        while (l <= r) {
            if (nums[l] == target) return l;
            int mid = (l + r) >> 1;
            // 这里不返回是由于其前面可能仍有相同的元素
            if (nums[mid] == target) r = mid;
            else if (nums[mid] > nums[0]) {
                if (nums[0] <= target && nums[mid] > target) r = mid - 1;
                else l = mid + 1;
            } else if (nums[mid] < nums[0]) {
                if (nums[n - 1] >= target && nums[mid] < target) l = mid + 1;
                else r = mid - 1;
            } else l++;
        }

        return -1;
    }
}
