package memento;

public class MainTest {
    public static void main(String[] args) {
        MementoCaretaker caretaker = new MementoCaretaker();
        Originator originator = new Originator();
        System.out.println("状态切换到state1");
        originator.state1();
        originator.showState();
        System.out.println("保存当前状态");
        caretaker.saveMemento("memento", originator.createMemento());
        System.out.println("状态切换到state2");
        originator.state2();
        originator.showState();
        System.out.println("恢复状态");
        originator.restoreMemento(caretaker.retrieveMemento("memento"));
        originator.showState();
    }
}
