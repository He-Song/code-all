package visitor;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/29 16:19
 */
public class Employee extends Element {

    /**
     * 名字
     */
    private String name;

    /**
     * 工资天数
     */
    private Integer days;

    /**
     * 每日工资
     */
    private Float baseIncome;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public Integer getDays() {
        return days;
    }

    public Float getBaseIncome() {
        return baseIncome;
    }

    public Employee(String name, Integer days, Float baseIncome) {
        this.name = name;
        this.days = days;
        this.baseIncome = baseIncome;
    }
}
