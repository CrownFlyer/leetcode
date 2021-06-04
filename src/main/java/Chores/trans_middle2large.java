package Chores;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-16 09:59
 */
public class trans_middle2large {
    public static void main(String[] args) {
        String s = "[[5,-4,-3,4],[-3,-4,4,5],[5,1,5,-4]]";
        System.out.println(trans(s));
    }

    public static String trans(String s){
        return s.replace('[', '{').replace(']','}');
    }
}
