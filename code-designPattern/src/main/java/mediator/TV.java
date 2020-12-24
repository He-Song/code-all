package mediator;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/30 11:23
 */
public class TV extends Colleague {
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange, name);
    }

    public void startTV(){
        System.out.println(name + "电视机打开了");
    }

    public void stopTV(){
        System.out.println(name + "电视机关闭了");
    }
}
