package exer.leetcode.week263;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-17 10:22
 */
public class Section2 {
    @Test
    public void test() {

    }

    class Bank {
        long[] balance;
        int n;

        public Bank(long[] balance) {
            n = balance.length;
            this.balance = new long[n + 1];
            for (int i = 0; i < n; i++) {
                this.balance[i + 1] = balance[i];
            }
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 >= 1 && account1 <= n && account2 >= 1 && account2 <= n && balance[account1] >= money) {
                balance[account1] -= money;
                balance[account2] += money;
                return true;
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (account >= 1 && account <= n) {
                balance[account] += money;
                return true;
            }
            return false;
        }

        public boolean withdraw(int account, long money) {
            if (account >= 1 && account <= n && balance[account] >= money) {
                balance[account] -= money;
                return true;
            }
            return false;

        }
    }
}
