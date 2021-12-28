package exer.leetcode.week272;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-19 11:56
 */
public class Solution2 {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int idx = 0,idxS = 0;;
        StringBuilder sb = new StringBuilder();

        while(idx<n){
            if(idxS < spaces.length&&idx == spaces[idxS]){
                sb.append(" ");
                idxS++;
            }
            sb.append(s.charAt(idx++));
        }
        return sb.toString();
    }
}
