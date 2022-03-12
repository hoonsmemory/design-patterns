package io.hoon.designpatterns.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws Exception {
        method1();
        method2();
    }

    /**
     *  리플렉션을 사용하여 싱글톤 패턴 구현 방법을 깨트리기
     */
    public static void method1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();

        Constructor<InnerClassSingleton> constructor = InnerClassSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true); //private 키워드도 접근 가능
        InnerClassSingleton instance2 = constructor.newInstance();

        System.out.println(instance1 == instance2);
    }

    /**
     *  직렬화 & 역직렬화를 사용하여 싱글톤 패턴 구현 방법을 깨트리기
     */
    public static void method2() throws IOException {
        EagerInitalizationSingleton instance1 = EagerInitalizationSingleton.getInstance();
        EagerInitalizationSingleton instance2 = null;

        try(ObjectOutput out = new ObjectOutputStream((new FileOutputStream(("EagerInitalizationSingleton.obj"))))) {
            out.writeObject(instance1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInput in = new ObjectInputStream(((new FileInputStream(("EagerInitalizationSingleton.obj")))))) {
            instance2 = (EagerInitalizationSingleton) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(instance1 == instance2);
    }
}
