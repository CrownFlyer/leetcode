package stackAndQueue;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
 * 示例1
 * 输入
 * 复制
 * [4,8,6,12,16,14,10]
 * 返回值
 * 复制
 * true
 */

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-10 12:12
 */
public class Offer_JZ23_HARD {
    public static void main(String[] args) {
        // 后序遍历时，最后一个一定为根节点
        int[] sequence = {4, 8, 6, 12, 16, 14, 10};

        Offer_JZ23_HARD test = new Offer_JZ23_HARD();
        System.out.println(test.VerifySquenceOfBST(sequence));

    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return helpVerify(sequence, 0, sequence.length - 1);
    }

    // 递归
    public boolean helpVerify(int[] sequence, int start, int root) {
        if (start >= root) return true;
        int key = sequence[root];
        int i;
        // 找到左右子树的分界点
        for (i = start; i < root; i++) {
            if (sequence[i] > key) break;   // 这里相当于已经判断了左子树!
        }
        // 在右子树中判断是否含有小于root的值，有就返回false
        for (int j = i; j < root; j++) {
            if (sequence[j] < key) return false;
        }
        return helpVerify(sequence, start, i - 1) && helpVerify(sequence, i, root - 1);
    }
}
