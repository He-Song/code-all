package responsibilitychain;

public class SchoolMaster extends Approver {
    public SchoolMaster(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 30000) {
            System.out.println(String.format(" 请求编号 id = %d,被 %s 处理", request.getId(), name));
        } else {
            super.approver.processRequest(request);
        }
    }
}
