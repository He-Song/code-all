package singleton.type3;


public class Singletontest03 {
    public static void main(String[] args) {
        // 双重检查
        Singleton.getInstance();
        // 静态内部类
        Singleton1.getInstance();
        // 枚举方式
        Singleton2 instance = Singleton2.INSTANCE;
    }
}

/**
 * 双重检查
 */
class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


/**
 * 静态内部类
 */
class Singleton1 {
    private Singleton1() {
    }

    private static class SingletonInstance {
        private static volatile Singleton1 INSTANCE = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

/**
 * 枚举
 */
enum Singleton2 {
    INSTANCE;
    public void sayOK() {
        System.out.println("hha");
    }
}
