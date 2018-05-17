package com.wyh.knowledge_point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * Created by wb-wyh270612 on 2018/5/17.
 */
public class CollectionTest {
    @Test
    public void testCollectionForeach(){
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            stringList.add("hi" + i);
        }
        long begin = System.currentTimeMillis();
        // 1、for 遍历   1473ms ,2040ms,2096,1944
        /*for (String s : stringList) {
            System.out.print(s);
        }*/
        // 2、lambda    2177ms ,1975ms
        /*stringList.forEach(s -> System.out.print(s));*/
        // 3、Iterator 1860,1814,1932
        /*Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }*/
        //4、stream  2862
       /* stringList.stream().forEach(s -> System.out.print(s));*/
       // 5、parallelStream 3677
       stringList.parallelStream().forEach(s -> System.out.print(s));
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end - begin);
    }
}
