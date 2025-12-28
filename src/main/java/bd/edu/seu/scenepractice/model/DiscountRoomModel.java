package bd.edu.seu.scenepractice.model;

public class DiscountRoomModel
{
    private String type;
    private String quantity;
    private String date;

    public DiscountRoomModel(String type, String quantity, String date) {
        this.type = type;
        this.quantity = quantity;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
