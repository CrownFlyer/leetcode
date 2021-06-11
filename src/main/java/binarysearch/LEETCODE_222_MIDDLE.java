package binarysearch;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-10 14:49
 */
public class LEETCODE_222_MIDDLE {
    public static void main(String[] args) {
        LEETCODE_222_MIDDLE test = new LEETCODE_222_MIDDLE();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
        System.out.println(test.countNodes(root));
    }


    public int countNodes(TreeNode root) {
        if(root ==null) return 0;

        int h = 0;
        TreeNode cur = root;
        while(cur.left!=null){
            cur = cur.left;
            h++;
        }
        int l = 0, r = (int)Math.pow(2,h) - 1;
        while(l<r){
            int m = (l+r+1)>>1;
            cur = root;
            if(findM(cur,m,h)!=-1) l = m;
            else r = m -1;
        }
        return l + (int)Math.pow(2,h);
    }
    public int findM(TreeNode root,int index,int pow){
        while(pow!=0){
            int mask = 1<<(--pow);
            if((index&mask)!=0) {
                if(root == null) return -1;
                root = root.right;
            }
            else {
                if(root == null) return -1;
                root = root.left;
            }
        }
        return root==null?-1:root.val;

    }
}
