package com.atguigu.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 * <p>
 * 2.通配符的使用
 */
public class GenericTest {
    /*
    1.泛型在继承方面的体现

    类A是类B的父类，G<A> 和 G<B>二者不具备子父类关系，二者是并列关系。

      补充：类A是类B的父类，A<G> 和 B<G>的父类


     */
    @Test
    public void test1() {
        Object obj = null;
        String str = null;

//        obj = str;
//
//        Object[] arr1 = null;
//        Integer[] arr2 = {1,2,3,4,5,6,7};
//        arr1 = arr2;
//
//
//        List<Object> list1 = null;
//        List<String> list2 = null;

        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
//        list1 = list2;


    }

    @Test
    public void test2() {
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        ArrayList<Integer> list4 = null;

        list1 = list3;
        list2 = list3;
    }

    /*
    2.通配符的使用
      通配符：?

      类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类时：G<?>
     */
    @Test
    public void test3() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;
//
//        print(list1);
//        print(list2);

        //
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外
//        list.add("DD");
        list.add(null);

        //获取(读取)
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    3.有限制条件的通配符的使用
      ? extends A:
               G<? extends A> 可以作为G<A> 和 G<B>的父类的，其中B是A的子类
      ? super Person:
               G<? super A> 可以作为G<A> 和 G<B>的父类的，其中B是A的父类
     */
    @Test
    public void test4() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;
        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();
        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        list1 = list4;
        Person p = list1.get(0);
        //编译不通过
//        Student student= list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);

        //写入数据
        //编译不通过
        //list1.add(new Studnet());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());


    }
}
