package maxime.maheo.free.fr.card.district;

import java.util.List;

/**
 * Prestige class.
 */
public class Prestige extends District {

    /**
     * Constructor.
     *
     * @param cost of the card
     */
    public Prestige(final int cost, final String image) {
        super(Color.PURPLE, cost, "VIOLET-" + image);
    }

    /**
     * Add religions cards.
     *
     * @param cards table where we want to put the cards
     */
    public static void addCards(final List<District> cards) {
        cards.add(new Prestige(2, "Cour des miracles"));

        cards.add(new Prestige(3, "Donjon"));

        cards.add(new Prestige(5, "Cimetiere"));
        cards.add(new Prestige(5, "Laboratoire"));
        cards.add(new Prestige(5, "Manufacture"));
        cards.add(new Prestige(5, "Observatoire"));

        cards.add(new Prestige(6, "Bibliotheque"));
        cards.add(new Prestige(6, "Dragoport"));
        cards.add(new Prestige(6, "Ecole de magie"));
        cards.add(new Prestige(6, "Université"));
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Carte Merveille"
                + ", couleur: " + this.color
                + ", prix: " + this.cost;
    }
}
