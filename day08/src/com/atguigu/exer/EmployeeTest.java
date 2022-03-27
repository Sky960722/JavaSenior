package com.atguigu.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {

    //问题二：按生日排序
    @Test
    public void test2() {
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {

            //使用泛型以后的写法
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate o1Birthday = o1.getBirthday();
                MyDate o2Birthday = o2.getBirthday();
                return o1Birthday.compareTo(o2Birthday);
            }

            //            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee) {
//                    Employee e1 = (Employee) o1;
//                    Employee e2 = (Employee) o2;
//
//                    MyDate b1 = e1.getBirthday();
//                    MyDate b2 = e2.getBirthday();
            //方式一
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if (minusYear != 0) {
//                        return minusYear;
//                    }
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    if (minusMonth != 0){
//                        return minusMonth;
//                    }
//                    return b1.getDay()-b2.getDay();
            //方式二
//                    return b1.compareTo(b2);
//                }
//                throw new RuntimeException("传入的数据类型不一致");

        });

        Employee e1 = new Employee("刘德华", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("张学友", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("郭富城", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("黎明", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("梁朝伟", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //问题一：使用自然排序
    @Test
    public void test1() {
        TreeSet<Employee> set = new TreeSet();
        Employee e1 = new Employee("刘德华", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("张学友", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("郭富城", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("黎明", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("梁朝伟", 21, new MyDate(1978, 12, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }

    }
}
