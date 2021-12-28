package exer.leetcode.double68;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-27 22:24
 */
public class Solution3 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2==1) return false;
        // 两次遍历
        // 正向遍历主要查看是否对于所有锁定的右括号左边是否有对应的左括号或者未锁定的匹配
        // 反向遍历主要查看是否对于所有锁定的左括号右边是否有对应的右括号或者未锁定的匹配
        int l = 0,r =0;
        for(int i = 0;i<n;i++){
            if(locked.charAt(i) == '1' && s.charAt(i) == ')'){
                r++;
                if(i+1-r<r) return false;
            }
        }

        for(int i = n-1;i>=0;i--){
            if(locked.charAt(i) == '1' && s.charAt(i) == '('){
                l++;
                if(n-i-l<l) return false;
            }
        }
        return true;
    }
}
