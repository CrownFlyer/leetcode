package exer.test;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-12 11:56
 */
public class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    int minFreq;
    int capacity;
    Map<Integer, Node> key_table;
    Map<Integer, LinkedList<Node>> freq_table;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        key_table = new HashMap<>();
        key_table = new HashMap<>();
        freq_table = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) return -1;
        if (!key_table.containsKey(key)) return -1;

        Node node = key_table.get(key);
        int val = node.value, freq = node.freq;
        freq_table.get(freq).remove(node);
        // 更新freq_table哈希表及最低频次
        // 更新最低频次的双向链表
        if (freq_table.get(freq).size() == 0) {
            freq_table.remove(freq);
            // 如果是minFreq为空 由于minFreq插入到minFreq+1中，因此直接++
            if(minFreq==freq) minFreq++;
        }

        // 插入freq+1
        LinkedList<Node> list = freq_table.getOrDefault(freq + 1, new LinkedList<>());
        list.offerFirst(new Node(key, val, freq + 1));
        freq_table.put(freq + 1, list);
        key_table.put(key, freq_table.get(freq + 1).peekFirst());
        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        // 如果不存在该键值对
        if (!key_table.containsKey(key)) {
            // 缓存已满，由于是新的键值对，直接删除最久不使用的
            if (key_table.size() == capacity) {
                // 通过minFreq拿到最久未使用的节点
                Node node = freq_table.get(minFreq).pollLast();
                key_table.remove(node.key);
                if (freq_table.get(minFreq).size() == 0) freq_table.remove(minFreq);
            }
            LinkedList<Node> list = freq_table.getOrDefault(1, new LinkedList<>());
            list.offerFirst(new Node(key, value, 1));
            freq_table.put(1, list);
            key_table.put(key, freq_table.get(1).peekFirst());
            minFreq = 1;
        } else {
            Node node = key_table.get(key);
            int freq = node.freq;
            freq_table.get(freq).remove(node);
            // 更新最低频次的双向链表
            if (freq_table.get(freq).size() == 0) {
                freq_table.remove(freq);
                // 如果是minFreq为空 由于minFreq插入到minFreq+1中，因此直接++
                if(minFreq==freq) minFreq++;
            }
            // 插入freq+1
            LinkedList<Node> list = freq_table.getOrDefault(freq + 1, new LinkedList<>());
            list.offerFirst(new Node(key, value, freq + 1));
            freq_table.put(freq + 1, list);
            key_table.put(key, freq_table.get(freq + 1).peekFirst());
        }
    }
}
