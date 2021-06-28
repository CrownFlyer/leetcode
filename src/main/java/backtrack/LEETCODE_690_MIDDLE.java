package backtrack;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-25 20:05
 */
public class LEETCODE_690_MIDDLE {
    @Test
    public void test() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,5, Arrays.asList(2,3)));
        list.add(new Employee(2,3, Arrays.asList(4)));
        list.add(new Employee(3,4, null));
        list.add(new Employee(4,1, null));
        System.out.println(getImportance(list, 1));
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        int n = employees.size();
        Employee target = null;
        for (int i = 0; i < n; i++) {
            Employee e = employees.get(i);
            if (e.id == id) target = e;
            map.put(e.id, e);
        }

        return backtrack(target);
    }

    public int backtrack(Employee e) {
        if (e.subordinates == null) return e.importance;
        int res = 0;
        int size = e.subordinates.size();
        for (int i = 0; i < size; i++) res += backtrack(map.get(e.subordinates.get(i)));
        res += e.importance;
        return res;
    }
}
