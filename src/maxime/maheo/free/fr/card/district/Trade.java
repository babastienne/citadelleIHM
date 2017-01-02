package maxime.maheo.free.fr.card.district;

import maxime.maheo.free.fr.card.district.type.TradeType;

import java.util.List;

/**
 * Trade class.
 */
public class Trade extends District {

    /**
     * Type of the district.
     */
    private final TradeType type;

    /**
     * Constructor.
     *
     * @param type of the district
     * @param cost of the card
     */
    public Trade(final TradeType type, final int cost, final String image) {
        super(Color.GREEN, cost, "VERT-" + image);
        this.type = type;
    }

    /**
     * Add religions cards.
     *
     * @param cards table where we want to put the cards
     */
    public static void addCards(final List<District> cards) {
        cards.add(new Trade(TradeType.TAVERNS, 1, "Taverne"));
        cards.add(new Trade(TradeType.TAVERNS, 1, "Taverne"));
        cards.add(new Trade(TradeType.TAVERNS, 1, "Taverne"));
        cards.add(new Trade(TradeType.TAVERNS, 1, "Taverne"));
        cards.add(new Trade(TradeType.TAVERNS, 1, "Taverne"));

        cards.add(new Trade(TradeType.SHOP, 2, "Echoppe"));
        cards.add(new Trade(TradeType.SHOP, 2, "Echoppe"));
        cards.add(new Trade(TradeType.SHOP, 2, "Echoppe"));
        cards.add(new Trade(TradeType.SHOP, 2, "Echoppe"));

        cards.add(new Trade(TradeType.MARKET, 2, "Marche"));
        cards.add(new Trade(TradeType.MARKET, 2, "Marche"));
        cards.add(new Trade(TradeType.MARKET, 2, "Marche"));
        cards.add(new Trade(TradeType.MARKET, 2, "Marche"));

        cards.add(new Trade(TradeType.COUNTER, 3, "Comptoir"));
        cards.add(new Trade(TradeType.COUNTER, 3, "Comptoir"));
        cards.add(new Trade(TradeType.COUNTER, 3, "Comptoir"));

        cards.add(new Trade(TradeType.PORT, 4, "Port"));
        cards.add(new Trade(TradeType.PORT, 4, "Port"));
        cards.add(new Trade(TradeType.PORT, 4, "Port"));

        cards.add(new Trade(TradeType.TOWNHALL, 5, "Hotel de ville"));
        cards.add(new Trade(TradeType.TOWNHALL, 5, "Hotel de ville"));
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Carte commerce"
                + ", couleur: " + this.color
                + ", prix: " + this.cost
                + ", type: " + this.type;
    }
}
