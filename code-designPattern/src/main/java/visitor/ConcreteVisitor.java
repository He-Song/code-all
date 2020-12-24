package visitor;

/**
 * @Author: hesong
 * @Describe: 工资计算
 * @Date: 2020/4/29 16:22
 */
public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(Element element) {
        Employee ee = (Employee) element;
        System.out.println("员工：" + ee.getName() + "的月工资为：" + ee.getBaseIncome() * ee.getDays() + "元");
    }
}
