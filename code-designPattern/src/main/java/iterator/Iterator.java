package iterator;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/29 16:51
 */
public interface Iterator<E> {
    boolean hasNext();

    E next();

    void remove();
}
