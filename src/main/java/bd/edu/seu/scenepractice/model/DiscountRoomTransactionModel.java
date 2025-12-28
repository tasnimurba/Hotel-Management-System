package bd.edu.seu.scenepractice.model;

public class DiscountRoomTransactionModel
{
    private String mobile;
    private String service;
    private String amount;

    public DiscountRoomTransactionModel(String mobile, String service, String amount) {
        this.mobile = mobile;
        this.service = service;
        this.amount = amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
