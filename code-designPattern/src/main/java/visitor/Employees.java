package visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/4/29 16:31
 */
public class Employees {
    private List<Employee> employees;

    public Employees() {
        employees = new ArrayList<>();
    }

    public void attach(Employee employee) {
        employees.add(employee);
    }

    public void detach(Employee employee) {
        employees.remove(employee);
    }

    public void accept(Visitor visitor) {
        for (Employee e : employees) {
            e.accept(visitor);
        }
    }
}
