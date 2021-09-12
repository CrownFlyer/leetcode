package exer.leetcode.week257;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-05 10:28
 */
public class Section4 {
    @Test
    public void test() {
        int[] nums = {10, 5, 9, 3, 15};
        System.out.println(gcdSort(nums));
    }

    class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (root[x] != x) x = root[x];
            return x;
        }

        public boolean isConected(int x, int y) {
            return find(x) == find(y);
        }

        // 将y合并到x
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;
            // 将小的合并到大的
            if (rank[rootX] < rank[rootY]) union(y, x);
            else {
                root[rootY] = rootX;
                // 秩只需要一个大的root节点就够了，全部并进该root
                rank[rootX] += rank[rootY];
            }
        }

        public boolean gcd(int x, int y) {
            if (x < y) return gcd(y, x);
            while (x % y != 0) {
                int temp = y;
                y = x % y;
                x = temp;
            }
            return y > 1;
        }
    }

    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        int[] sort = nums.clone();
        Arrays.sort(sort);

        int max = sort[n - 1];
        UnionFind uf = new UnionFind(max + 1);

        for (int num : nums) {
            int cur = num;
            // 分解素数，将所有能通过素数联系起来的数并起来，因为都可以交换
            // eg. 10 = 2 * 5，如果数组中有2和5或者分解质因数中带有2和5的都可以和10进行交换
            for (int i = 2; i * i <= cur; i++) {
                boolean flag = false;
                while (cur % i == 0) {
                    cur /= i;
                    flag = true;
                }
                if (flag) uf.union(i, num);
            }
            // 如果最后剩了一个素数，直接并进原始的num
            if (cur > 1) uf.union(cur, num);
        }

        for (int i = 0; i < n; i++) {
            // 如果没关联表示不能交换
            if (!uf.isConected(nums[i], sort[i])) return false;
        }
        return true;
    }

}
