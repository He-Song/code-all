package com.github.basic;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/12/24 15:37
 */
public class StringTest {
    public static void main(String[] args) {
        // test();
        // System.out.println("******");
        // stringEqualsTest();

        Integer i = 127;
        Integer i1 = 127;
        System.out.println(i.equals(i1));
        System.out.println(i == i1);

        // Integer i = 128;
        // Integer i1 = new Integer(128);
        // System.out.println(i.equals(i1));
        // System.out.println(i == i1);

    }

    private static void stringEqualsTest() {
        String str1 = "abc";
        String str1_ = "abc";
        String str2 = new String("abc");
        String str3 = "abcd";

        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);

        System.out.println(str1.equals(str1_));
        System.out.println(str1 == str1_);

        System.out.println(str1.equals(str3));
        System.out.println(str1 == str3);

        String str4 = str2 + "d";
        System.out.println(str4.equals(str3));
        System.out.println(str4 == str3);

        String str5 = str1 + "d";
        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
    }

    private static void test() {
        StringTest test = new StringTest();

        int age = 12;
        test.changeValue1(age);
        System.out.println(age);

        String str = "123";
        test.changeValue2(str);
        System.out.println(str);

        Person person = new Person("张三");
        test.changeValue3(person);
        System.out.println(person.getName());
    }

    private void changeValue3(Person person) {
        person.setName("李四");
    }

    private void changeValue2(String str) {
        str = "456";
    }

    private void changeValue1(int age) {
        age = 30;
    }

}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
