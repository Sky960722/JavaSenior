package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * Collections:操作Collection、Map的工具类
 *
 * 面试题：Collection 和 Collections的区别？
 *
 */
public class CollectionTest {

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

        //报异常：IndexOutOfBoundsException("Source does not fit in dest")
//        ArrayList dest = new ArrayList();
//        Collections.copy(dest,list);
        List<Object> dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest,list);

        System.out.println(dest);


        List list1 = Collections.synchronizedList(list);

    }
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);
        Collections.shuffle(list);
        Collections.sort(list);
        Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 123);

        System.out.println(list);
        System.out.println(frequency);
    }
}
