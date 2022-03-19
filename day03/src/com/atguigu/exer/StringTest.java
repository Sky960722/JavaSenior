package com.atguigu.exer;

/**
 * 一道面试题
 */
public class StringTest {

    int test = 1;
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't' };

    public void change(String str, char ch[], int test) {
        str = "test ok";
        ch[0] = 'b';
        test = 3;
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch,ex.test);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
        System.out.println(ex.test);
    }
}
