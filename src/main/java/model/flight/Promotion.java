package model.flight;

public class Promotion {
    private int promotionId;
    private double discount;
    private double priceForDiscount;

    public Promotion(int promotionId, double discount, double priceForDiscount) {
        this.promotionId = promotionId;
        this.discount = discount;
        this.priceForDiscount = priceForDiscount;
    }
}
