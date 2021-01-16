package responsibilitychain;

public class MainTest {
    /**
     * 职责链模式
     * 模拟不同的账单有不同级别的人员处理
     * @param args
     */
    public static void main(String[] args) {
        PurchaseRequest request = new PurchaseRequest(1, 23, 6666f);

        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        ViceSchoolMaster viceSchoolMaster = new ViceSchoolMaster("陈副校长");
        SchoolMaster schoolMaster = new SchoolMaster("何校长");

        departmentApprover.setApprover(viceSchoolMaster);
        viceSchoolMaster.setApprover(schoolMaster);
        schoolMaster.setApprover(departmentApprover);

        departmentApprover.processRequest(request);
        request = new PurchaseRequest(1,22, 44533);
        schoolMaster.processRequest(request);
    }
}
