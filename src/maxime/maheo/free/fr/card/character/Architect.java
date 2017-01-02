package maxime.maheo.free.fr.card.character;

import maxime.maheo.free.fr.card.CardManager;
import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.game.Player;

import java.util.List;

/**
 * Architect character.
 */
public class Architect extends Character {

    /**
     * Constructor.
     */
    public Architect() {
        super(7, "7-Architecte");
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Architecte";
    }

    /**
     * PowerManager of the character.
     */
    @Override
    public final void power() {
        //do nothing
    }

    /**
     * Power of the character.
     * @param player character
     */
    public final void power(final Player player) {
        System.out.println("Vous prenez 2 cartes quatiers.");
        List<District> districtCards = CardManager.getInstance().getDistrictCard(2);

        assert districtCards != null;
        for (District card : districtCards) {
            player.getDistrictCards().add(card);
        }
    }
}
