package io.hoon.designpatterns.singleton;

/**
 * Double Checked Locking Singleton
 * 장점 : 초기화를 미리 하지 않고 getInstance()를 처음으로 호출했을 때 초기화한다.
 *       또한, 초기 생성과정에서 synchronized를 사용하여 멀티 쓰레드에 안전하다.
 *
 * 단점 : 자바 4버전 이하는 volatile를 사용할 수 없기 때문에 해당 싱글톤 방법을 사용할 수 없다.
 */
public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton INSTANCE;

    private DoubleCheckedLockingSingleton(){}

    public static DoubleCheckedLockingSingleton getInstance() {
        if(INSTANCE == null){
            synchronized (DoubleCheckedLockingSingleton.class) {
                if(INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
