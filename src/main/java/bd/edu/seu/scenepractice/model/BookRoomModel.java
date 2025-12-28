package bd.edu.seu.scenepractice.model;

public class BookRoomModel
{
    private String telephoneNum;
    private String quality;
    private String date;
    private int quantity;

    private double price;
    private double totalPrice;

    public BookRoomModel(String telephoneNum, String quality, String date, int quantity, double price, double totalPrice) {
        this.telephoneNum = telephoneNum;
        this.quality = quality;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }



    public BookRoomModel(String telephoneNum, double price) {
        this.telephoneNum = telephoneNum;
        this.price = price;
    }

    //after adding price
    public BookRoomModel(String telephoneNum, String quality, String date, int quantity, double price) {
        this.telephoneNum = telephoneNum;
        this.quality = quality;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public BookRoomModel(String telephoneNum, String quality, String date, int quantity) {
        this.telephoneNum = telephoneNum;
        this.quality = quality;
        this.date = date;
        this.quantity = quantity;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

}
