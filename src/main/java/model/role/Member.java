package main.java.model.role;
import java.util.Date;
import main.java.model.util.CreditCard;

public class Member extends User{
    private Date registrationDate;
    private CreditCard creditCard;

    public Member(String username, String password, Date registrationDate, CreditCard creditCard) {
        super(username, password);
        this.registrationDate = registrationDate;
        this.creditCard = creditCard;
    }

    public Member(String username, String password, Date registrationDate){
        super(username, password);
        this.registrationDate = registrationDate;
    }

    // Getters and Setters
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public CreditCard getCreditCard() {
        try{
            return creditCard;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
