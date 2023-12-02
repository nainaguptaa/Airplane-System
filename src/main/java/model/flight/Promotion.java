package model.flight;

/**
 * Represents a promotion with a unique promotion ID, a discount percentage, and a minimum price required for the discount.
 */
public class Promotion {
    private int promotionId;
    private double discount;
    private double priceForDiscount;

    /**
     * Constructs a Promotion object with the provided attributes.
     *
     * @param promotionId     The unique identifier for the promotion.
     * @param discount        The discount percentage applied by the promotion.
     * @param priceForDiscount The minimum price required for the discount to be applicable.
     */
    public Promotion(int promotionId, double discount, double priceForDiscount) {
        this.promotionId = promotionId;
        this.discount = discount;
        this.priceForDiscount = priceForDiscount;
    }

    // Getters and Setters

    /**
     * Gets the unique promotion ID.
     *
     * @return The promotion ID.
     */
    public int getPromotionId() {
        return promotionId;
    }

    /**
     * Gets the discount percentage applied by the promotion.
     *
     * @return The discount percentage.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Gets the minimum price required for the discount to be applicable.
     *
     * @return The minimum price for the discount.
     */
    public double getPriceForDiscount() {
        return priceForDiscount;
    }

    /**
     * Sets the unique promotion ID.
     *
     * @param promotionId The promotion ID to set.
     */
    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    /**
     * Sets the discount percentage applied by the promotion.
     *
     * @param discount The discount percentage to set.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Sets the minimum price required for the discount to be applicable.
     *
     * @param priceForDiscount The minimum price for the discount to set.
     */
    public void setPriceForDiscount(double priceForDiscount) {
        this.priceForDiscount = priceForDiscount;
    }
}
