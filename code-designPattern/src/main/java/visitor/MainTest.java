package visitor;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/29 16:36
 */
public class MainTest {
    public static void main(String[] args) {
        Employees employees = new Employees();

        employees.attach(new Employee("杰里夫", 25, 400f));
        employees.attach(new Employee("克里斯提亚诺", 22, 300f));
        employees.attach(new Employee("詹姆斯", 18, 250f));

        employees.accept(new ConcreteVisitor());
    }
}
