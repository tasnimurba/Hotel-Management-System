package bd.edu.seu.scenepractice.model;

public class AfterLoginBenefitModel
{
    private String choose;
    private String date;
    private String numberOfPerson;

    public AfterLoginBenefitModel(String choose, String date, String numberOfPerson) {
        this.choose = choose;
        this.date = date;
        this.numberOfPerson = numberOfPerson;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(String numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }
}
