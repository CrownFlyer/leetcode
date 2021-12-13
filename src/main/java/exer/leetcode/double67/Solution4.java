package exer.leetcode.double67;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-13 11:23
 */
public class Solution4 {
    @Test
    public void test() {
        SORTracker tracker = new SORTracker(); // 初始化系统
        tracker.add("bradford", 2); // 添加 name="bradford" 且 score=2 的景点。
        tracker.add("branford", 3); // 添加 name="branford" 且 score=3 的景点。
        tracker.get();              // 从好带坏的景点为：branford ，bradford 。
        // 注意到 branford 比 bradford 好，因为它的 评分更高 (3 > 2) 。
        // 这是第 1 次调用 get() ，所以返回最好的景点："branford" 。
        tracker.add("alps", 2);     // 添加 name="alps" 且 score=2 的景点。
        tracker.get();              // 从好到坏的景点为：branford, alps, bradford 。
        // 注意 alps 比 bradford 好，虽然它们评分相同，都为 2 。
        // 这是因为 "alps" 字典序 比 "bradford" 小。
        // 返回第 2 好的地点 "alps" ，因为当前为第 2 次调用 get() 。
        tracker.add("orland", 2);   // 添加 name="orland" 且 score=2 的景点。
        tracker.get();              // 从好到坏的景点为：branford, alps, bradford, orland 。
        // 返回 "bradford" ，因为当前为第 3 次调用 get() 。
        tracker.add("orlando", 3);  // 添加 name="orlando" 且 score=3 的景点。
        tracker.get();              // 从好到坏的景点为：branford, orlando, alps, bradford, orland 。
        // 返回 "bradford".
        tracker.add("alpine", 2);   // 添加 name="alpine" 且 score=2 的景点。
        tracker.get();              // 从好到坏的景点为：branford, orlando, alpine, alps, bradford, orland 。
        // 返回 "bradford" 。
        tracker.get();              // 从好到坏的景点为：branford, orlando, alpine, alps, bradford, orland 。
        // 返回 "orland" 。
    }

    class SORTracker {
        class State {
            String name;
            Integer score;

            State(String name, Integer score) {
                this.name = name;
                this.score = score;
            }


        }

        PriorityQueue<State> bq;
        PriorityQueue<State> sq;

        public SORTracker() {
            // 大根堆:存放未get过的
            bq = new PriorityQueue<>((x, y) -> {
                if (!x.score.equals(y.score)) return y.score - x.score;
                else return x.name.compareTo(y.name);
            });
            // 小根堆:存放已get的
            sq = new PriorityQueue<>((x, y) -> {
                if (!x.score.equals(y.score)) return x.score - y.score;
                else return y.name.compareTo(x.name);
            });
        }

        public void add(String name, int score) {
            State state = new State(name, score);
            if (!sq.isEmpty() && compare(state, sq.peek()) > 0) {
                bq.offer(sq.poll());
                sq.offer(state);
            } else {
                bq.offer(state);
                // sq.offer(bq.poll());
            }
        }

        public String get() {
            State poll = bq.poll();
            sq.offer(poll);
            return poll.name;
        }

        public int compare(State s1, State s2) {
            if (!s1.score.equals(s2.score)) return s1.score - s2.score;
            else return s2.name.compareTo(s1.name);
        }

    }

}
