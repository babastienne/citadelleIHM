package maxime.maheo.free.fr.card.district;

import maxime.maheo.free.fr.card.district.type.ReligionType;

import java.util.List;

/**
 * Religion class.
 */
public class Religion extends District {

    /**
     * Type of the district.
     */
    private final ReligionType type;

    /**
     * Constructor.
     *
     * @param type of the district
     * @param cost of the card
     */
    public Religion(final ReligionType type, final int cost, final String image) {
        super(Color.BLUE, cost, "BLEU-" + image);
        this.type = type;
    }

    /**
     * Add religions cards.
     *
     * @param cards table where we want to put the cards
     */
    public static void addCards(final List<District> cards) {
        cards.add(new Religion(ReligionType.TEMPLE, 1, "Temple"));
        cards.add(new Religion(ReligionType.TEMPLE, 1, "Temple"));
        cards.add(new Religion(ReligionType.TEMPLE, 1, "Temple"));

        cards.add(new Religion(ReligionType.CHURCH, 2, "Eglise"));
        cards.add(new Religion(ReligionType.CHURCH, 2, "Eglise"));
        cards.add(new Religion(ReligionType.CHURCH, 2, "Eglise"));

        cards.add(new Religion(ReligionType.MONASTERY, 3, "Monastere"));
        cards.add(new Religion(ReligionType.MONASTERY, 3, "Monastere"));
        cards.add(new Religion(ReligionType.MONASTERY, 3, "Monastere"));
        cards.add(new Religion(ReligionType.MONASTERY, 3, "Monastere"));

        cards.add(new Religion(ReligionType.CATHEDRAL, 5, "Cathedrale"));
        cards.add(new Religion(ReligionType.CATHEDRAL, 5, "Cathedrale"));
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Carte Religion"
                + ", couleur: " + this.color
                + ", prix: " + this.cost
                + ", type: " + this.type;
    }
}
