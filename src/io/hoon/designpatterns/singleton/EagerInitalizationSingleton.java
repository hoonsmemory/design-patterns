package io.hoon.designpatterns.singleton;

/**
 * 이른 초기화(Eager Initalization)
 * 장점 : 애플리케이션이 기동됨과 동시에 인스턴스를 생성하여 초기화함으로써 멀티 쓰레드 환경에서 안전하다.
 * 단점 : 사용하지 않더라도 인스턴스가 생성되기 때문에 리소스를 낭비할 수 있다.
 */
public class EagerInitalizationSingleton {
    private static final EagerInitalizationSingleton INSTANCE = new EagerInitalizationSingleton();

    private EagerInitalizationSingleton() {}

    public static EagerInitalizationSingleton getInstance() {
        return INSTANCE;
    }
}
