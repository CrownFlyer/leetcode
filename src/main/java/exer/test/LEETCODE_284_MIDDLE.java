package exer.test;

import java.util.Iterator;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-05 22:20
 */
public class LEETCODE_284_MIDDLE {
    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private Integer nextElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            nextElement = iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer res = nextElement;
            nextElement = iterator.hasNext()?iterator.next():null;
            return res;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }
}
