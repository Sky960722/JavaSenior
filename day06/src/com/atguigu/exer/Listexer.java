package com.atguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Listexer {
    /*
    区分list中的remove(int index) 和 remove(Object obj)
     */

    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);



    }

    private static void updateList(List list){
        list.remove(2);
    }
}
