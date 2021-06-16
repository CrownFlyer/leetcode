package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:哈希表+数组
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-14 15:04
 */
class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
    Map<Integer,Integer> map;   // 存储缓存的k-v
    // data[]：用于存储最近被使用的key，下标为0代表最近使用
    int[] data;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        data = new int[capacity];
        size = capacity;
    }

    public int get(int key) {
        Integer v = map.get(key);
        if(v==null) return -1;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if(data[i]==key){
                index = i;
                break;
            }
        }
        System.arraycopy(data,0,data,1,index);
        data[0] = key;
        return v;
    }

    public void put(int key, int value) {
        Integer v = map.get(key);
        if(v!=null){
            int index = 0;
            for(int i=0;i<size;i++){
                if(data[i]==key) {
                    index=i;
                    break;
                }
            }
            map.put(key,value);
            System.arraycopy(data,0,data,1,index);
            data[0] = key;
        }else{
            map.remove(data[size-1]);
            map.put(key,value);
            System.arraycopy(data,0,data,1,size-1);
            data[0] = key;
        }
    }
}
