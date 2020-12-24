package mediator;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/30 11:53
 */
public class MainTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Alarm alarm = new Alarm(mediator, "alarm");

        TV tv = new TV(mediator, "changhongTv");

        alarm.sendMessage(0);
        System.out.println("-----------------");
        alarm.sendMessage(1);
        System.out.println("-----------------");
        alarm.sendMessage(2);

    }
}
