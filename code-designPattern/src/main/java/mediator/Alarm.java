package mediator;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/30 10:45
 */
public class Alarm extends Colleague {
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }
}
