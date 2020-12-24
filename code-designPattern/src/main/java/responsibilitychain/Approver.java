package responsibilitychain;

public abstract class Approver {
    protected Approver approver;

    String name; //名字

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void processRequest(PurchaseRequest request);
}
