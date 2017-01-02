package maxime.maheo.free.fr.card.district;

/**
 * District class.
 */
public class District {

    /**
     * Color of the district.
     */
    protected final Color color;

    /**
     * Price of the card.
     */
    protected final int cost;
    
    protected final String image;

    /**
     * Constructor.
     *
     * @param color of the district
     * @param cost  of the card
     */
    public District(final Color color, final int cost, final String image) {
        this.color = color;
        this.cost = cost;
        this.image = image;
    }

    /**
     * Getter.
     *
     * @return cost of the card
     */
    public final int getCost() {
        return this.cost;
    }

    /**
     * Getter.
     *
     * @return color of the card
     */
    public final Color getColor() {
        return this.color;
    }
    
    public final String getImage() {
    	return "images/" + this.image + ".jpg";
    }
}
