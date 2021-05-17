package exer.leetcode.double51;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-13 11:07
 */
public class Section4 {
    public static void main(String[] args) {
        int[][] room = {{2, 3}, {5, 3}, {7, 2}};
        int[][] queries = {{4, 1}, {4, 3}, {5, 3}};
        for (int i : closestRoom(room, queries)) {
            System.out.print(i + " ");
        }
    }

    public static int[] closestRoom1(int[][] rooms, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int[] room : rooms) {
            map.put(room[0], room[1]);
            list.add(room[0]);
        }
        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            int goalId = queries[i][0];
            int goalSize = queries[i][1];
            ArrayList<Integer> temp = new ArrayList<>(list);
            temp.sort((i1, i2) -> {
                return Math.abs(i1 - goalId) - Math.abs(i2 - goalId);
            });
            int index = 0;
            while (index < list.size() && map.get(temp.get(index)) < goalSize) index++;
            res[i] = index == list.size() ? -1 : temp.get(index);
        }
        return res;
    }

    public static int[] closestRoom(int[][] rooms, int[][] queries) {
        int[][] q=new int[queries.length][3];
        for(int i=0;i<q.length;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=i;
        }
        Arrays.sort(q,(x,y)->y[1]-x[1]);
        Arrays.sort(rooms,(x,y)->y[1]-x[1]);
        TreeSet<Integer> set=new TreeSet<>();
        int idx=0;
        int[] ans=new int[q.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<q.length;i++){
            while(idx<rooms.length&&rooms[idx][1]>=q[i][1]){    // 先把大的排除了 其他的保证是可以容纳的
                set.add(rooms[idx][0]);
                idx+=1;
            }
            Integer a=set.floor(q[i][0]);
            Integer b=set.ceiling(q[i][0]);
            if(a==null&&b==null){
                ans[q[i][2]]=-1;
            }else if(b==null||a==null){
                ans[q[i][2]]=(a==null)?b:a;
            }else{
                ans[q[i][2]]=((q[i][0]-a)<=(b-q[i][0]))?a:b;
            }
        }
        return ans;

    }

}
