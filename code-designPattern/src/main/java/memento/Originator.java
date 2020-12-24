package memento;

import java.util.HashMap;

public class Originator {
    private HashMap<String, String> state;

    public Originator() {
        state = new HashMap<>();
    }

    public void showState() {
        System.out.println("now state:" + state.toString());
    }

    public MementoIF createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(MementoIF memento) {
        state = ((Memento) memento).getState();
    }

    private class Memento implements MementoIF {
        private HashMap<String, String> state;

        public HashMap<String, String> getState() {
            return state;
        }

        public void setState(HashMap<String, String> state) {
            this.state = state;
        }

        public Memento(HashMap<String, String> state) {
            this.state = new HashMap<>(state);
        }

    }

    public void state1() {
        HashMap<String, String> state = new HashMap<>();
        state.put("blood", "100");
        state.put("enemy", "2");
        this.state = state;
    }

    public void state2() {
        HashMap<String, String> state = new HashMap<>();
        state.put("blood", "200");
        state.put("enemy", "1");
        this.state = state;
    }


}
