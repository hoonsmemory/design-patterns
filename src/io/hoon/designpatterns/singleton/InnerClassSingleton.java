package io.hoon.designpatterns.singleton;

/**
 * Initialization On Demand Holder idiom pattern(lazy initialization)
 * 장점 : getInstance()를 호출 했을 때 인스턴스가 생성되므로 이른 초기화의 단점을 보완할 수 있으며,
 *       멀티 쓰레드에서도 안전하게 사용 가능하다.
 */
public class InnerClassSingleton {
    private InnerClassSingleton(){}

    private static class Holder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
