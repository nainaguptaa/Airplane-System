package model.util;

/**
 * Represents a promotion with an associated promotion ID, discount percentage, and price for discount.
 */
public class Promotion {
    private int promotionId;
    private double discount;
    private double priceForDiscount;

    /**
     * Constructs a Promotion object with the specified promotion details.
     *
     * @param promotionId      The unique identifier for the promotion.
     * @param discount         The discount percentage for the promotion.
     * @param priceForDiscount The price at which the discount is applied.
     */
    public Promotion(int promotionId, double discount, double priceForDiscount) {
        this.promotionId = promotionId;
        this.discount = discount;
        this.priceForDiscount = priceForDiscount;
    }

    /**
     * Gets the unique identifier for the promotion.
     *
     * @return The promotion ID.
     */
    public int getPromotionId() {
        return promotionId;
    }

    /**
     * Gets the discount percentage for the promotion.
     *
     * @return The discount percentage.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Gets the price at which the discount is applied.
     *
     * @return The price for discount.
     */
    public double getPriceForDiscount() {
        return priceForDiscount;
    }
}
