package exer.leetcode.week242;

import java.util.ArrayList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-24 16:03
 */
public class Section4 {
    public static void main(String[] args) {
        int [] stones = {7,-6,5,10,5,-2,-6};
        System.out.println(stoneGameVIII(stones));
    }

    public static int stoneGameVIII(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int stone:stones) list.add(stone);
        boolean flag = true;
        while(list.size()>1){
            if(flag){
                // Alice
                int score = 0;
                while(list.get(0)>=0){
                    score+=list.get(0);
                    list.remove(0);
                }
            }else {
                // Bob
            }
            flag=!flag;
        }
        return 0;
    }

}
