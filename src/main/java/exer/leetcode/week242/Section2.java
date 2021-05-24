package exer.leetcode.week242;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-24 10:42
 */
public class Section2 {
    public static void main(String[] args) {
        Section2 test = new Section2();
        int dist[] = {1,3,2};

        double hour = 6;
        System.out.println(test.minSpeedOnTime(dist, hour));
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 0,r = (int)1.e9+10,v=0;
        if(!chk(r,dist,hour)) return -1;
        while(l<r-1){
            v=(l+r+1)>>1;
            if(chk(v,dist,hour)) r = v;
            else l = v;
        }
        return r;
    }

    public static boolean chk(int v, int[] dist, double hour) {
        double res = 0;
        for (int i : dist) res = Math.ceil(res) + ((double) i) / v;
        return res <= hour;
    }
}
