package singleton.type2;

public class SingletonTest02 {
    public static void main(String[] args) {

    }
}

/**
 * 懒汉式方式之一
 */
class Singleton01 {
    private static Singleton01 instance;

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        // 该方法不能保证线程安全
        if (null == instance) {
            instance = new Singleton01();
        }
        return instance;
    }
}

/**
 * 懒汉式方式之二： 同步方法
 */
class Singleton02 {
    private static Singleton02 instance;

    private Singleton02() {
    }

    /*
    方法上加同步锁，效率低
     */
    public static synchronized Singleton02 getInstance() {
        if (null == instance) {
            instance = new Singleton02();
        }
        return instance;
    }
}

/**
 * 懒汉式方式之三：同步代码块
 */
class Singleton03 {
    private static Singleton03 instance;

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        // 该方法不能保证线程安全
        if (null == instance) {
            //此处线程不安全
            synchronized (Singleton03.class) {
                instance = new Singleton03();
            }
        }
        return instance;
    }
}