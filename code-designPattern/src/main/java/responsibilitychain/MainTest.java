package responsibilitychain;

public class MainTest {
    public static void main(String[] args) {
        PurchaseRequest request = new PurchaseRequest(1, 23, 666f);

        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        ViceSchoolMaster viceSchoolMaster = new ViceSchoolMaster("陈副校长");
        SchoolMaster schoolMaster = new SchoolMaster("何校长");

        departmentApprover.setApprover(viceSchoolMaster);
        viceSchoolMaster.setApprover(schoolMaster);
        schoolMaster.setApprover(departmentApprover);

        departmentApprover.processRequest(request);

        schoolMaster.processRequest(request);
    }
}
