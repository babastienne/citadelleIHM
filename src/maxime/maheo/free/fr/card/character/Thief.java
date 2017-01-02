package maxime.maheo.free.fr.card.character;

import maxime.maheo.free.fr.card.CardManager;
import maxime.maheo.free.fr.game.PowerManager;
import maxime.maheo.free.fr.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Thief character.
 */
public class Thief extends Character {

    /**
     * Constructor.
     */
    public Thief() {
        super(2, "2-Voleur");
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Voleur";
    }

    /**
     * PowerManager of the character.
     */
    @Override
    public final void power() {
        List<Integer> authorisedString = new ArrayList<>();

        CardManager.getInstance().getCharacterCards().clear();
        CardManager.getInstance().addCharacterCards();
        CardManager.getInstance().discardCharacterCard(1);
        CardManager.getInstance().discardCharacterCard(2);

        for (Character character : CardManager.getInstance().getCharacterCards()) {
            authorisedString.add(character.getNumber());
        }

        System.out.println("Qui voulez-vous voler ? : ");
        System.out.println(CardManager.getInstance().toStringCharacterCards());

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (StringUtils.isNumeric(choice)) {
            int numberOfTheCard = Integer.parseInt(choice);

            if (authorisedString.contains(numberOfTheCard)) {
                Character character = CardManager.getInstance().getCharacterCard(numberOfTheCard);

                System.out.println("Vous avez volé : " + character);
                PowerManager.getInstance().setCharacterStolen(character);
                CardManager.getInstance().discardAllCharacterCard();
            } else {
                System.out.println("Vous avez tapé un mauvais caractère.");
                this.power();
            }
        } else {
            System.out.println("Vous avez tapé un mauvais caractère.");
            this.power();
        }

    }
}
