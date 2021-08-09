package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-02 15:04
 */
public class LEETCODE_11_MIDDLE {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0,r=n-1;
        int max = 0;
        while(l<r){
            max = Math.max(max,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]) l++;
            else if(height[l]>height[r]) r--;
            else {
                l++;
                r--;
            }
        }
        return max;
    }
}
