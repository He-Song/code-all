package visitor;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/29 16:16
 */
public abstract class Element {
    abstract public void accept(Visitor visitor);
}
