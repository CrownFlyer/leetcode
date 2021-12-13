package exer.leetcode.week268;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-22 15:34
 */
public class Section2 {

    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int curPlantIndex = 0;
        int curCap = capacity;
        int res = 0;
        while(curPlantIndex < n){
            if(curCap >= plants[curPlantIndex]){
                curCap -= plants[curPlantIndex];
                curPlantIndex++;
                res++;
            }else{
                res += (curPlantIndex) << 1;
                curCap = capacity;
            }
        }
        return res;
    }
}
