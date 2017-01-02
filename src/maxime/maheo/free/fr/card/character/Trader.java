package maxime.maheo.free.fr.card.character;

import maxime.maheo.free.fr.card.district.Color;
import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.game.Bank;
import maxime.maheo.free.fr.game.Player;
import maxime.maheo.free.fr.game.Tray;

/**
 * Trader character.
 */
public class Trader extends Character {

    /**
     * Constructor.
     */
    public Trader() {
        super(6, "6-Marchand");
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Marchand";
    }

    /**
     * PowerManager of the character.
     */
    @Override
    public final void power() {
        //do nothing
    }

    /**
     * Specific trader power.
     *
     * @param player        player
     * @param tray          tray
     * @param isFirstPlayer is the first player
     */
    public final void power(final Player player, final Tray tray, final boolean isFirstPlayer) {
        int total = 0;

        if (isFirstPlayer) {
            for (District card : tray.firstPlayerDistrictCards()) {
                if (card.getColor() == Color.GREEN) {
                    total++;
                }
            }
        } else {
            for (District card : tray.secondPlayerDistrictCards()) {
                if (card.getColor() == Color.GREEN) {
                    total++;
                }
            }
        }

        player.setCoins(player.getCoins() + Bank.getInstance().giveCoins(total));
        System.out.println("Vous avez reçu " + total + " pièce(s).");
    }
}
