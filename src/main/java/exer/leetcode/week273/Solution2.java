package exer.leetcode.week273;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-27 22:22
 */
public class Solution2 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int x = startPos[0],y=startPos[1];
        int[] res = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            int nx=x,ny=y;
            int step = 0;
            boolean done = false;
            for(int j = i;j<s.length()&&!done;j++){
                char dir = s.charAt(j);
                switch(dir){
                    case('L'):
                        ny-=1;
                        if(ny<0) done = true;
                        break;
                    case('R'):
                        ny+=1;
                        if(ny>=n) done = true;
                        break;
                    case('D'):
                        nx+=1;
                        if(nx>=n) done = true;
                        break;
                    case('U'):
                        nx-=1;
                        if(nx<0) done = true;
                        break;
                    default:break;
                }
                if(done) break;
                step++;
            }
            res[i] = step;
        }
        return res;
    }

}
