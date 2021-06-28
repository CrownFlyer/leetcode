package exer.leetcode.double55;

import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 22:29
 */
public class Section2 {
    @Test
    public void test() {
        String s = "daabcbaabcbc";
        String p = "abc";

        System.out.println(removeOccurrences(s, p));
    }

    public String removeOccurrences(String s, String part) {
        int index = 0;
        while(index!=-1) {
            index = find(s,part);
            if(index!=-1) s = s.substring(0,index)+s.substring(index+part.length(),s.length());
        }
        return s;
    }

    public int find(String s,String t){
        int n = s.length();
        char[] tArr = t.toCharArray();
        for(int i=0;i<n;i++){
            if(s.charAt(i)==tArr[0]){
                int temp_i = i+1;
                int index_t = 1;
                while(index_t<tArr.length&&temp_i<n&&s.charAt(temp_i)==tArr[index_t]){
                    temp_i++;
                    index_t++;
                }
                if(index_t==tArr.length) return i;
            }
        }
        return -1;
    }
}
