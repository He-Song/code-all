package mediator;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/30 10:31
 */
public abstract class Mediator {

    /**
     * 将中介者加入到hashMap中
     */
    public abstract void register(String colleagueName, Colleague colleague);

    public abstract void getMessage(int stateChange, String colleagueName);

    public abstract void sendMessage();
}
