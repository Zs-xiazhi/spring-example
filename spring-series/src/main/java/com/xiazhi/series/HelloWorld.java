package com.xiazhi.series;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/24
 **/
public class HelloWorld {

    public void say() {
        System.out.println("hello world, 欢迎使用spring");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        HelloWorld helloWorld1 = new HelloWorld();
        String s1 = helloWorld.fun1();
        String s2 = helloWorld1.fun1();
        System.out.println(s1 == s2);

    }

    public String fun1() {
        return "hello";
    }
}
