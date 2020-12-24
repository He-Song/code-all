package responsibilitychain;

public class PurchaseRequest {
    private int type;
    private int id = 0;
    private float price = 0.0f;

    public PurchaseRequest(int type, int id, float price) {
        this.type = type;
        this.id = id;
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }
}
