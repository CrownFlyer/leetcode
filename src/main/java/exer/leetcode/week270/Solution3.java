package exer.leetcode.week270;

class Solution3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    StringBuilder sbs = new StringBuilder();
    StringBuilder sbd = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        boolean v1 = false;
        if (root.val == startValue) v1 = true;
        boolean startL = dfs(root.left, startValue, 1);
        boolean startR = false;
        if (!v1) {
            if (startL) sbs.insert(0, 'L');
            else {
                startR = dfs(root.right, startValue, 1);
                sbs.insert(0, 'R');
            }
        }
        boolean v2 = false;
        if (root.val == destValue) v2 = true;
        boolean destL = dfs(root.left, destValue, 2);
        ;
        boolean destR = false;
        if (!v2) {
            if (destL) sbd.insert(0, 'L');
            else {
                destR = dfs(root.right, destValue, 2);
                sbd.insert(0, 'R');
            }
        }

        System.out.println("起点路径" + sbs.toString());
        System.out.println("终点路径" + sbd.toString());
        StringBuilder res = new StringBuilder();
        int m = sbs.length(), n = sbd.length();
        int idxm = 0, idxn = 0;
        // 同边
        if (startL && destL || startR && destR) {
            System.out.println("同边");
            while (idxm < m && idxn < n && sbs.charAt(idxm) == sbd.charAt(idxn)) {
                idxm++;
                idxn++;
            }

            String startPath = (String) sbs.subSequence(idxm, m);
            String destPath = (String) sbd.subSequence(idxn, n);
            for (int idx = startPath.length() - 1; idx >= 0; idx--)
                res.append('U');
            for (int idx = 0; idx < destPath.length(); idx++)
                res.append(destPath.charAt(idx));
        } else if (v1) {
            return sbd.toString();
        } else if (v2) {
            for (int i = 0; i < sbs.length(); i++)
                res.append('U');
        } else {
            // 不同边
            System.out.println("不同边");
            String startPath = sbs.toString();
            String destPath = sbd.toString();
            for (int idx = startPath.length() - 1; idx >= 0; idx--)
                res.append('U');
            for (int idx = 0; idx < destPath.length(); idx++)
                res.append(destPath.charAt(idx));
        }
        return res.toString();
    }


    // 节点，目标值，起始节点（1表示起始，2表示dest），dir上一次是1表示此节点为左子节点，2表示为右子节点
    public boolean dfs(TreeNode node, int goal, int cur) {
        if (node == null) return false;
        if (node.val == goal) return true;
        boolean resL = dfs(node.left, goal, cur);
        if (resL) {
            if (cur == 1)
                sbs.insert(0, "L");
            else
                sbd.insert(0, "L");
            return true;
        }
        if (!resL && dfs(node.right, goal, cur)) {
            if (cur == 1)
                sbs.insert(0, "R");
            else
                sbd.insert(0, "R");
            return true;
        }
        return false;
    }


}