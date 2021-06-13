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
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LEETCODE_863_MIDDLE test = new LEETCODE_863_MIDDLE();
        System.out.println(test.distanceK(root, root.left, 2));
    }
    // 方法一：通过已知target节点，可以得到所有的子节点和父节点，队列代数增加，距离随之增加
//    Map<TreeNode, TreeNode> parent;
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        parent = new HashMap<>();
//        bfs(root, null);
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(null);
//        q.add(target);
//
//        Set<TreeNode> seen = new HashSet<>();
//        seen.add(null);
//        seen.add(target);
//
//        int dist = 0;
//        while(!q.isEmpty()){
//            TreeNode node = q.poll();
//            if (node == null) {
//                if(dist==K){
//                    List<Integer> res = new ArrayList<>();
//                    for (TreeNode n : q) {
//                        res.add(n.val);
//                    }
//                    return res;
//                }
//                q.offer(null);
//                dist++;
//            }else {
//                if(!seen.contains(node.left)){
//                    seen.add(node.left);
//                    q.offer(node.left);
//                }
//                if(!seen.contains(node.right)){
//                    seen.add(node.right);
//                    q.offer(node.right);
//                }
//                TreeNode par = parent.get(node);
//                if(!seen.contains(par)){
//                    seen.add(par);
//                    q.offer(par);
//                }
//            }
//        }
//        return new ArrayList<Integer>();
//    }
//
//
//    public void bfs(TreeNode cur, TreeNode par) {
//        if (cur != null) {
//            parent.put(cur, par);
//            bfs(cur.left, cur);
//            bfs(cur.right, cur);
//        }
//    }

    List<Integer> res;
    TreeNode target;
    int K;

    // 方法二：计算节点之间的距离:如果target在root节点的左子树，且深度为l，则root节点右子树中深度为K-l的节点到target距离为K
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        res = new LinkedList<>();
        this.target = target;
        this.K = K;
        dfs(root);
        return res;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance:the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null) return -1;
        else if (node == target) {
            subtree_add(node, 0);   // 从target的子树开始找
            return 1;  // 这里返回1是返回给target的父节点，该父节点到target的距离为1
        } else {
            int l = dfs(node.left), r = dfs(node.right);
            if (l != -1) {
                if (l == K) res.add(node.val);
                subtree_add(node.right, l + 1); // 从target的另一侧开始找
                return l + 1;   // 由于这里返回的是l+1，表示root到target的距离为l+1，从另一侧找即找K-l-1的节点
            } else if (r != -1) {
                if (r == K) res.add(node.val);
                subtree_add(node.left, r + 1);
                return r + 1;   // 由于这里返回的是r+1，表示root到target的距离为r+1，从另一侧找即找K-r-1的节点
            } else return -1;

        }
    }

    // Add all nodes 'K-dist' from the subTree of the node to res.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K) res.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }


}
