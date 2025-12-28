package bd.edu.seu.scenepractice.model;


public class OtherOptionModel {
    private String identity;
    private String dateOther;
    private int numberRoomOther;
    private String telephone;
    private String name;
    private String otherQuality;
    private double price;


    //after adding price
    public OtherOptionModel(String identity, String dateOther, int numberRoomOther, String telephone, String name, String otherQuality, double price) {
        this.identity = identity;
        this.dateOther = dateOther;
        this.numberRoomOther = numberRoomOther;
        this.telephone = telephone;
        this.name = name;
        this.otherQuality = otherQuality;
        this.price = price;
    }
    //

    public OtherOptionModel(String identity, String dateOther, int numberRoomOther, String telephone, String name, String otherQuality) {
        this.identity = identity;
        this.dateOther = dateOther;
        this.numberRoomOther = numberRoomOther;
        this.telephone = telephone;
        this.name = name;
        this.otherQuality = otherQuality;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDateOther() {
        return dateOther;
    }

    public void setDateOther(String dateOther) {
        this.dateOther = dateOther;
    }

    public int getNumberRoomOther() {
        return numberRoomOther;
    }

    public void setNumberRoomOther(int numberRoomOther) {
        this.numberRoomOther = numberRoomOther;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherQuality() {
        return otherQuality;
    }

    public void setOtherQuality(String otherQuality) {
        this.otherQuality = otherQuality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
