package com.github.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/12/17 17:46
 */
public class ForEachTest {

    public static void main(String[] args) {
        // Arrays.asList 返回的List 跟ArrayList不是一个
        // List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
        // "p", "q");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        eval(list, (obj) -> !obj.startsWith("4"));
        // forEachRemaningTest(list);
    }

    private static void forEachRemaningTest(List<String> list) {
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(System.out::println);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(list.size());
    }

    private static void eval(Collection collection, Predicate<String> predicate) {
        for (Object o : collection) {
            if (predicate.test(o.toString())) {
                System.out.println(o);
            }
        }
    }
}
