package responsibilitychain;

public class ViceSchoolMaster extends Approver {
    public ViceSchoolMaster(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 5000 && request.getPrice() <= 30000) {
            System.out.println(String.format(" 请求编号 id = %d,被 %s 处理", request.getId(), name));
        } else {
            super.approver.processRequest(request);
        }
    }
}
