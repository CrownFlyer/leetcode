package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-28 09:54
 */
public class LEETCODE_401_SIMPLE {
    int[] hours = new int[]{1,2,4,8,0,0,0,0,0,0};
    int[] minutes = new int[]{0,0,0,0,1,2,4,8,16,32};
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        LEETCODE_401_SIMPLE test = new LEETCODE_401_SIMPLE();
        List<String> list = test.readBinaryWatch(9);
        list.forEach(System.out::println);

    }

    public List<String> readBinaryWatch(int turnedOn) {
        backtrack(turnedOn,0,0,0);
        return res;
    }

    public void backtrack(int num,int index,int hour,int minute){
        if(hour>11||minute>59) return;
        if(num==0){
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if(minute<10) sb.append('0');
            sb.append(minute);
            res.add(sb.toString());
            return;
        }

        for(int i =index;i<10;i++){
            backtrack(num-1,i+1,hour+hours[i],minute+minutes[i]);
        }
    }
}
