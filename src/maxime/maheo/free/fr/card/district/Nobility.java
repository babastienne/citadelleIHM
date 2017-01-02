package maxime.maheo.free.fr.card.district;

import maxime.maheo.free.fr.card.district.type.NobilityType;

import java.util.List;

/**
 * Nobility class.
 */
public class Nobility extends District {

    /**
     * Type of the district.
     */
    private final NobilityType type;

    /**
     * Constructor.
     *
     * @param type of the district
     * @param cost of the card
     */
    public Nobility(final NobilityType type, final int cost, final String image) {
        super(Color.YELLOW, cost, "Jaune-" + image);
        this.type = type;
    }

    /**
     * Add religions cards.
     *
     * @param cards table where we want to put the cards
     */
    public static void addCards(final List<District> cards) {
        cards.add(new Nobility(NobilityType.MANOR, 3, "Manoir"));
        cards.add(new Nobility(NobilityType.MANOR, 3, "Manoir"));
        cards.add(new Nobility(NobilityType.MANOR, 3, "Manoir"));
        cards.add(new Nobility(NobilityType.MANOR, 3, "Manoir"));
        cards.add(new Nobility(NobilityType.MANOR, 3, "Manoir"));

        cards.add(new Nobility(NobilityType.PALACE, 5, "Palais"));
        cards.add(new Nobility(NobilityType.PALACE, 5, "Palais"));

        cards.add(new Nobility(NobilityType.CASTLE, 4, "Chateau"));
        cards.add(new Nobility(NobilityType.CASTLE, 4, "Chateau"));
        cards.add(new Nobility(NobilityType.CASTLE, 4, "Chateau"));
        cards.add(new Nobility(NobilityType.CASTLE, 4, "Chateau"));
        cards.add(new Nobility(NobilityType.CASTLE, 4, "Chateau"));
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Carte Noblesse"
                + ", couleur: " + this.color
                + ", prix: " + this.cost
                + ", type: " + this.type;
    }
}
