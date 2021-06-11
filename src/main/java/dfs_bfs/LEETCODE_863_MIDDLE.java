package dfs_bfs;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-11 20:28
 */
public class LEETCODE_863_MIDDLE {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right= new TreeNode(1);
        root.right.left= new TreeNode(0);
        root.right.right= new TreeNode(8);
        LEETCODE_863_MIDDLE test = new LEETCODE_863_MIDDLE();
        System.out.println(test.distanceK(root, root.left, 2));
    }

    Map<TreeNode, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(null);
        q.add(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(null);
        seen.add(target);

        int dist = 0;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if (node == null) {
                if(dist==K){
                    List<Integer> res = new ArrayList<>();
                    for (TreeNode n : q) {
                        res.add(n.val);
                    }
                    return res;
                }
                q.offer(null);
                dist++;
            }else {
                if(!seen.contains(node.left)){
                    seen.add(node.left);
                    q.offer(node.left);
                }
                if(!seen.contains(node.right)){
                    seen.add(node.right);
                    q.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if(!seen.contains(par)){
                    seen.add(par);
                    q.offer(par);
                }
            }
        }
        return new ArrayList<Integer>();
    }


    public void dfs(TreeNode cur, TreeNode par) {
        if (cur != null) {
            parent.put(cur, par);
            dfs(cur.left, cur);
            dfs(cur.right, cur);
        }
    }
}
