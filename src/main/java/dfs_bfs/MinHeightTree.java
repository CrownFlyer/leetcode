package dfs_bfs;

/**
 * @description:定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-11 19:14
 */
public class MinHeightTree {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        MinHeightTree test = new MinHeightTree();
        System.out.println(test.sortedArrayToBST(nums));
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }

    public TreeNode dfs(int l, int r, int[] nums) {
        if(r<l) return null;
        if (l == r) return new TreeNode(nums[l]);
        int m = (l + r) / 2;
        TreeNode cur = new TreeNode(nums[m]);
        cur.left = dfs(l, m - 1, nums);
        cur.right = dfs(m + 1, r, nums);
        return cur;
    }




}
