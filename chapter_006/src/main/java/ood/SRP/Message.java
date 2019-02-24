package ood.SRP;

/**
 * @author Marat Zainullin.
 * @version 0.1.
 * @since 12.02.2019.
 */
public class Message {

    static final int ADD = 0;
    static final int SUBTRACT = 1;
    static final int MULTIPLE = 2;
    static final int DIVIDE = 3;
    static final int REPEAT_ACTION = 4;
    static final int EXIT = 5;

    private int menuPoint;
    private String info;

    public Message(int menuPoint, String info) {
        this.menuPoint = menuPoint;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
