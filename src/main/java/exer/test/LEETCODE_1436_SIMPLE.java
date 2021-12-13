package exer.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-01 11:27
 */
public class LEETCODE_1436_SIMPLE {
    public String destCity(List<List<String>> paths) {
        //<k,v>:<start,end>
        Map<String,String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0),path.get(1));
        }

        String cur = paths.get(0).get(0);
        while(map.get(cur)!=null) cur = map.get(cur);

        return cur;
    }
}
