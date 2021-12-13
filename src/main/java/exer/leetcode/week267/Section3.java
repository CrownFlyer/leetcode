package exer.leetcode.week267;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-14 16:55
 */
public class Section3 {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = (int)Math.ceil(n/rows);
        // System.out.println(cols);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx <= cols){
            for(int i = 0;i<rows && idx + i*cols+i < n ;i++) sb.append(encodedText.charAt(idx + i*cols+i));
            idx++;
        }
        idx = sb.length() - 1;
        while(idx>= 0 && sb.charAt(idx) == ' ') sb.deleteCharAt(idx--);
        return sb.toString();

    }
}
