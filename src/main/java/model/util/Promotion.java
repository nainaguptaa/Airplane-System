package model.util;

public class Promotion {
    private int promotionId;
    private double discount;
    private double priceForDiscount;

    public Promotion(int promotionId, double discount, double priceForDiscount) {
        this.promotionId = promotionId;
        this.discount = discount;
        this.priceForDiscount = priceForDiscount;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPriceForDiscount() {
        return priceForDiscount;
    }
}