package mediator;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/30 10:39
 */
public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String name;

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void sendMessage(int stateChange);
}
