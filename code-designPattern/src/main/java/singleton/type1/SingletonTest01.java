package singleton.type1;

/**
 * 饿汉式
 */
public class SingletonTest01 {

    public static void main(String[] args) {
//        Singleton01 singleton01 = Singleton01.getInstance();
//        Singleton01 singleton02 = Singleton01.getInstance();
//        System.out.println(singleton01.equals(singleton02));
//        System.out.println("singleton01 hash: " + singleton01.hashCode());
//        System.out.println("singleton02 hash: " + singleton02.hashCode());

        Singleton02 singleton01 = Singleton02.getInstance();
        Singleton02 singleton02 = Singleton02.getInstance();
        System.out.println(singleton01.equals(singleton02));
        System.out.println("singleton01 hash: " + singleton01.hashCode());
        System.out.println("singleton02 hash: " + singleton02.hashCode());
    }

}

/**
 * 饿汉式方式之一
 */
class Singleton01{
    private final static Singleton01 instance = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getInstance(){
        return  instance;
    }
}


/**
 * 饿汉式方式之二:静态代码块
 */
class Singleton02{
    private final static Singleton02 instance;

    static {
        instance = new Singleton02();
    }
    private Singleton02() {
    }

    public static Singleton02 getInstance(){
        return  instance;
    }
}