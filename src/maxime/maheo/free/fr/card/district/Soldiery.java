package maxime.maheo.free.fr.card.district;

import maxime.maheo.free.fr.card.district.type.SoldieryType;

import java.util.List;

/**
 * Soldiery class.
 */
public class Soldiery extends District {

    /**
     * Type of the district.
     */
    private final SoldieryType type;

    /**
     * Constructor.
     *
     * @param type of the district
     * @param cost of the card
     */
    public Soldiery(final  SoldieryType type, final int cost, final String image) {
        super(Color.RED, cost, "ROUGE-" + image);
        this.type = type;
    }

    /**
     * Add religions cards.
     *
     * @param cards table where we want to put the cards
     */
    public static void addCards(final List<District> cards) {
        cards.add(new Soldiery(SoldieryType.WATCHTOWER, 1, "Tour de guet"));
        cards.add(new Soldiery(SoldieryType.WATCHTOWER, 1, "Tour de guet"));
        cards.add(new Soldiery(SoldieryType.WATCHTOWER, 1, "Tour de guet"));

        cards.add(new Soldiery(SoldieryType.PRISON, 2, "Prison"));
        cards.add(new Soldiery(SoldieryType.PRISON, 2, "Prison"));
        cards.add(new Soldiery(SoldieryType.PRISON, 2, "Prison"));

        cards.add(new Soldiery(SoldieryType.BARRACK, 3, "Caserne"));
        cards.add(new Soldiery(SoldieryType.BARRACK, 3, "Caserne"));
        cards.add(new Soldiery(SoldieryType.BARRACK, 3, "Caserne"));

        cards.add(new Soldiery(SoldieryType.FORTRESS, 5, "Forteresse"));
        cards.add(new Soldiery(SoldieryType.FORTRESS, 5, "Forteresse"));
        cards.add(new Soldiery(SoldieryType.FORTRESS, 5, "Forteresse"));
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Carte Condotierre"
                + ", couleur: " + this.color
                + ", prix: " + this.cost
                + ", type: " + this.type;
    }
}
