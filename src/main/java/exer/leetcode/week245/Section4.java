package exer.leetcode.week245;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section4 {
    public static void main(String[] args) {
        Section4 test = new Section4();
        int[] res = test.earliestAndLatest(7, 3, 4);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        if (firstPlayer + secondPlayer == n + 1) return new int[]{1, 1};
        if (firstPlayer + secondPlayer > n + 1) {
            return earliestAndLatest(n, n + 1 - secondPlayer, n + 1 - firstPlayer);
        }
        int m = (n + 1) >> 1;
        int min = n, max = 0;
        // firstPlayer 和 secondPlayer在同侧
        if (secondPlayer <= m) {
            for (int f = 1; f <= firstPlayer; f++) {
                for (int s = f + 1; s <= secondPlayer - firstPlayer + f; s++) {
                    int[] e1 = earliestAndLatest(m, f, s);
                    min = Math.min(min, e1[0]);
                    max = Math.max(max, e1[1]);
                }
            }
        } else { // 异侧
            int _s = n + 1 - secondPlayer;
            for (int f = 1; f <= firstPlayer; f++) {
                for (int s = f + 1; s <= _s - firstPlayer + f; s++) {
                    // s 到 s'之间必留下m-s'-1个人，所以s的实际站位是 s + m-s'-1+1 = s + m - s'
                    int[] e1 = earliestAndLatest(m, f, s + m - _s);
                    min = Math.min(min, e1[0]);
                    max = Math.max(max, e1[1]);
                }
            }
        }
        return new int[]{min + 1, max + 1};
    }

    // 队列模拟 未能实现!
    public int[] earliestAndLatest1(int n, int firstPlayer, int secondPlayer) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int gapLeft = firstPlayer - 1;
        int gapRight = n - secondPlayer;

        int earlist = 1;
        boolean done = false;
        boolean crossFirst = false;
        boolean crossSecond = false;
        while (!done) {
            int size = q.size();
            ArrayList<Integer> frontE = new ArrayList<>();
            ArrayList<Integer> backE = new ArrayList<>();
            for (int i = 0; i < size / 2; i++) {
                int front = q.pollFirst();
                int back = q.pollLast();
                if (front == firstPlayer && back == secondPlayer) {
                    done = true;
                    break;
                }
                if (front == firstPlayer || front == secondPlayer) {
                    frontE.add(0, front);
                    gapRight--;
                    continue;
                }
                if (back == secondPlayer || back == firstPlayer) {
                    backE.add(0, back);
                    gapLeft--;
                    continue;
                }
                if (gapLeft > 0 && gapLeft <= gapRight) {
                    backE.add(0, back);
                    gapLeft--;
                } else {
                    frontE.add(0, front);
                    gapRight--;
                }
            }
            if (!done) {
                earlist++;
                for (Integer front : frontE) {
                    q.addFirst(front);
                }
                for (Integer back : backE) {
                    q.addLast(back);
                }
            }
        }

        q.clear();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int latest = 1;
        gapLeft = firstPlayer - 1;
        gapRight = n - secondPlayer;
        done = false;
        while (!done) {
            int size = q.size();
            ArrayList<Integer> frontE = new ArrayList<>();
            ArrayList<Integer> backE = new ArrayList<>();
            for (int i = 0; i < size / 2; i++) {
                int front = q.pollFirst();
                int back = q.pollLast();
                if (front == firstPlayer && back == secondPlayer) {
                    done = true;
                    break;
                }
                if (front == firstPlayer || front == secondPlayer) {
                    frontE.add(0, front);
                    gapRight--;
                    continue;
                }
                if (back == secondPlayer || back == firstPlayer) {
                    backE.add(0, back);
                    gapLeft--;
                    continue;
                }
                if (gapLeft > 0 && gapLeft > gapRight) {
                    backE.add(0, back);
                    gapLeft--;
                } else if (gapLeft == 0 && gapLeft < gapRight) {
                    backE.add(0, back);
                } else {
                    frontE.add(0, front);
                    gapRight--;
                }
            }
            if (!done) {
                latest++;
                for (Integer front : frontE) {
                    q.addFirst(front);
                }
                for (Integer back : backE) {
                    q.addLast(back);
                }
            }
        }

        return new int[]{Math.min(earlist, latest), Math.max(earlist, latest)};
    }
}
