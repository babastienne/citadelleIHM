package maxime.maheo.free.fr.card.character;

import maxime.maheo.free.fr.card.district.Color;
import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.game.Bank;
import maxime.maheo.free.fr.game.Player;
import maxime.maheo.free.fr.game.Tray;

/**
 * Lord character.
 */
public class Lord extends Character {

    /**
     * Constructor.
     */
    public Lord() {
        super(5, "5-Eveque");
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Evêque";
    }

    /**
     * PowerManager of the character.
     */
    @Override
    public final void power() {
        //do nothing
    }

    /**
     * Specific lord power.
     *
     * @param player        player
     * @param tray          tray
     * @param isFirstPlayer is the first player
     */
    public final void power(final Player player, final Tray tray, final boolean isFirstPlayer) {
        int total = 0;

        if (isFirstPlayer) {
            for (District card : tray.firstPlayerDistrictCards()) {
                if (card.getColor() == Color.BLUE) {
                    total++;
                }
            }
        } else {
            for (District card : tray.secondPlayerDistrictCards()) {
                if (card.getColor() == Color.BLUE) {
                    total++;
                }
            }
        }

        player.setCoins(player.getCoins() + Bank.getInstance().giveCoins(total));
        System.out.println("Vous avez reçu " + total + " pièce(s).");
    }
}
