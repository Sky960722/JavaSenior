package com.atguigu.java;

import org.junit.Test;
import sun.security.krb5.internal.ktab.KeyTabInputStream;

import javax.lang.model.element.VariableElement;
import java.util.*;

/**
 * 一、Map的实现结构：
 * /---------------Map:双列数据，存储key-value对的数据  ----类似于高中的函数：y = f(x)
 * /--------HashMap:作为map的主要实现类：线程不安全的，效率高：存储null的key和value
 * /------LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 * 原因：在原有的HashMap底层结构基础上，添加了一堆指针，指向前一个和后一个元素。
 * 对于频繁的遍历操作，此类执行效率高于HashMap。
 * /---------TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。
 * 底层使用红黑树
 * <p>
 * /---------Hashtable:作为古老的实现类：线程安全的，效率低：不能存储null的key和value
 * /-------Properties:常用来处理配置文件。key和value都是String类型
 * <p>
 * <p>
 * HashMap的底层：数组 + 链表（jdk7及之前）
 * 数组 + 链表 + 红黑树 （jdk 8)
 * <p>
 * 面试题：
 * 1.HashMap的底层实现原理？
 * 2.HashMap 和 Hashtable的异同？
 * 3.CurrentHashMap 与 Hashtable的异同（暂时不讲）
 * <p>
 * 二、Map结构的理解：
 * Map中的key：无序的、不可重复的，使用Set存储所有的key  ----> key所在的类要重写equals()和hashCode()  (以HashMap为例)
 * Map中的value：无序的、可重复的，使用Collection存储所有的valye ----> value所在的类要重写equals()
 * 一个键值对：key-value构成了Entry对象。
 * Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 * <p>
 * 三、HashMap的底层实现原理？以jdk7为例说明：
 * HashMap map = new HashMap():
 * 在实例化以后，底层创建了长度是16的一维数组Entry[] table
 * ...可能已经执行过多次put...
 * map.put(key1,value1):
 * 首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到的Entry数组中的存放位置。
 * 如果此位置上的数据为空，此时的key1-value1添加成功。 ---情况一
 * 如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据（以链表形式存在）)，比较key1和已经存在的一个或多个数据的哈希值：
 * 如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。 ----情况2
 * 如果key1的哈希值与已经存在的某一个数据的哈希值相同，继续比较：调用key1所在类的equals()方法，比较：
 * 如果equals()返回false：此时key1-value添加成功  -----情况3
 * 如果equals()返回true：使用value1替换相同key的value值。
 * <p>
 * 补充：关于情况2和情况3：此时的key1-value1和原来的数据以链表的方式存储。
 * <p>
 * 在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 * <p>
 * <p>
 * jdk8 相较于jdk7在底层实现方面的不同：
 * 1.new HashMap():底层没有创建一个为16的数组
 * 2.jdk 8底层的数组是：Node[],而非Entry[]
 * 3.首次调用put()方法时，底层创建长度为16
 * 4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
 * 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时
 * 此时此索引位置上的所有数据改为使用红黑树存储。
 * <p>
 * 四、LinkedHashMap的底层实现原理（了解）
 * <p>
 * <p>
 * 五、Map中定义的方法
 *  添加 、 删除、修改操作 ：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素 查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元 视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 * 总结：常用方法
 * 添加：put(Object key,Object value)
 * 删除：remove(Object key)
 * 修改：put(Object key,Object value)
 * 查询：get(Object key)
 * 长度：size()
 * 遍历：keySet() / values() /entrySet()
 */
public class MapTest {

    @Test
    public void test5() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 1234);
        map.put("BB", 56);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //遍历所有的value集：values()
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }

        //遍历所有的key-value
        //entrySet():
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "------->" + entry.getValue());
        }

        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }

    }

    @Test
    public void test4() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        System.out.println(map.get(45));
        //Object get(Object key)
        System.out.println(map.get(45));
        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        isExist = map.containsValue(123);
        System.out.println(isExist);

        map.clear();

        System.out.println(map.isEmpty());

    }


    @Test
    /*
     *   添加 、 删除、修改操作 ：
     *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *  void putAll(Map m):将m中的所有key-value对存放到当前map中
     *  Object remove(Object key)：移除指定key的key-value对，并返回value
     *  void clear()：清空当前map中的所有数据
     */
    public void test3() {
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put("45", 123);
        map.put("BB", 56);
        //修改
        map.put("AA", 87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);

        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //clear()
        map.clear();
        System.out.println(map.size());
    }

    @Test
    public void test1() {
        Map map = new HashMap();
//        map = new Hashtable();
        map = new LinkedHashMap();
        map.put(null, 123);
        map.put(345, "BB");
        map.put(12, "CC");
        System.out.println(map);
    }
}
