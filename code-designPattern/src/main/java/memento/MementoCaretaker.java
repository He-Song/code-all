package memento;

import java.util.HashMap;

public class MementoCaretaker {
    private HashMap<String, MementoIF> mementoMap;

    public MementoCaretaker() {
        this.mementoMap = new HashMap<>();
    }

    /**
     * 获取保存的备忘录对象
     *
     * @param name
     * @return
     */
    public MementoIF retrieveMemento(String name) {
        return mementoMap.get(name);
    }

    /**
     * 备忘录赋值方法
     *
     * @param name
     * @param memento
     */
    public void saveMemento(String name, MementoIF memento) {
        mementoMap.put(name, memento);
    }
}
