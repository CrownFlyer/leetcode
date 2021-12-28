package exer.leetcode.double60;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-24 14:03
 */
public class Solution3 {
    @Test
    public void test(){
        int[] ps = {-1, 0, 0, 1, 1, 2, 2};
        LockingTree lockingTree = new LockingTree(ps);
        System.out.println(lockingTree.lock(2, 2));
        System.out.println(lockingTree.unlock(2, 3));
        System.out.println(lockingTree.unlock(2, 2));
        System.out.println(lockingTree.lock(4, 5));
        System.out.println(lockingTree.upgrade(0, 1));
        System.out.println(lockingTree.lock(0, 1));
    }
    class LockingTree {
        int[] parent;
        Map<Integer,List<Integer>> childMap;
        Map<Integer,Integer> lockMap;
        public LockingTree(int[] parent) {
            this.parent = parent;
            lockMap = new HashMap<>();
            childMap = new HashMap<>();
            for(int i = 1;i<parent.length;i++){
                childMap.putIfAbsent(parent[i],new ArrayList<>());
                childMap.get(parent[i]).add(i);
            }
        }

        public boolean lock(int num, int user) {
            if(!lockMap.containsKey(num)){
                lockMap.put(num,user);
                return true;
            }
            return false;
        }

        public boolean unlock(int num, int user) {
            if(lockMap.containsKey(num) && lockMap.get(num).equals(user)){
                lockMap.remove(num);
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            // 指定节点未被上锁
            if(lockMap.containsKey(num)) return false;
            // 指定节点至少有一个上锁的子孙节点
            if(!dfsForHavingChildLocked(num)) return false;
            // 指定节点没有任何上锁的祖先节点
            if(dfsForHavingParentLocked(num)) return false;
            // 给用户上锁，并解锁所有子孙节点
            lockMap.put(num,user);
            dfsForUnlockChildren(num);
            return true;
        }

        public boolean dfsForHavingChildLocked(int num){
            if(lockMap.containsKey(num)) return true;
            List<Integer> children = childMap.get(num);
            if(children!=null){
                for(int child:children){
                    if(dfsForHavingChildLocked(child)) return true;
                }
            }
            return false;
        }

        public boolean dfsForHavingParentLocked(int num){
            while(parent[num]!=-1){
                num = parent[num];
                if(lockMap.containsKey(num)) return true;
            }
            return false;
        }

        public void dfsForUnlockChildren(int num){
            List<Integer> children = childMap.get(num);
            if(children!=null){
                for(int child:children){
                    lockMap.remove(child);
                    dfsForUnlockChildren(child);
                }
            }
        }
    }

}
