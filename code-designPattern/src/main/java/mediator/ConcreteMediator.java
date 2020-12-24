package mediator;

import java.util.HashMap;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/30 10:33
 */
public class ConcreteMediator extends Mediator {

    private HashMap<String, Colleague> colleagueMap;

    // 存储
    private HashMap<String, String> innerMap;

    public ConcreteMediator() {
        this.colleagueMap = new HashMap<>();
        this.innerMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName, colleague);
        if (colleague instanceof Alarm) {
            innerMap.put("Alarm", colleagueName);
        } else if (colleague instanceof TV) {
            innerMap.put("TV", colleagueName);
        }
    }

    /**
     *  1. 根据得到的消息 完成对应任务
     *  2. 协调各个具体的同事对象 完成任务
     * @param stateChange   设定的模式
     * @param colleagueName 具体同事类的名字
     */
    @Override
    public void getMessage(int stateChange, String colleagueName) {
        Colleague colleague = colleagueMap.get(colleagueName);
        if (colleague instanceof Alarm) {
            if (stateChange == 0) {
                System.out.println("闹钟响了，啥也不干！！");
            } else if (stateChange == 1) {
                System.out.println("闹钟响了！稍后打开电视机");
                ((TV) colleagueMap.get(innerMap.get("TV"))).startTV();
            }else if(stateChange == 2){
                System.out.println("闹钟响了！立即关闭电视机");
                ((TV) colleagueMap.get(innerMap.get("TV"))).stopTV();
            }
        }
    }

    @Override
    public void sendMessage() {

    }
}
