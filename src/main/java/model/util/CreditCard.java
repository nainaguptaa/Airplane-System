package  model.util;

public class CreditCard {
    private int cardNumber;
    private String cardHolder;
    private String expiryDate;
    private int cvv;

    public CreditCard(int cardNumber, String cardHolder, String expiryDate, int cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
