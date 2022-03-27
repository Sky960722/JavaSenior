package com.atguigu.java;

import org.junit.Test;

import java.util.*;


/**
 *
 * 泛型的使用
 * 1.jdk5.0新增的特性
 *
 * 2.在集合中使用泛型：
 * 总结：
 * ①集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 * ②在实例化集合类时，可以指明具体的泛型类型
 * ③指明完以后，在集合类或接口中凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型类型。
 *   比如：add(E e) ===> 实例化以后：add(Integer e)
 * ④注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿他的包装类
 * ②如果实例化时，没有指明泛型的类型。默认类型为java.Lang.Object类型。
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见GenericTest1.java
 *
 */
public class GenericTest {

    //在集合中使用泛型之前的情况：
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for (Object score : list) {
            //问题二：强转时，可能出现ClassCastException
            int stuCore = (Integer) score;
            System.out.println(stuCore);
        }
    }

    //在集合中使用泛型的情况
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        for (Integer score : list) {
            //避免了强转操作
            int stuScore = score;
            System.out.println(score);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3() {
        //jdk7新特性：类型推断
        HashMap<String, Integer> map = new HashMap<>();


        map.put("Tom", 87);
        map.put("Jerry", 87);
        map.put("Jack", 67);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "------------->" + value);
        }
    }
}
