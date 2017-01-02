package maxime.maheo.free.fr.card.character;

import maxime.maheo.free.fr.card.CardManager;
import maxime.maheo.free.fr.game.PowerManager;
import maxime.maheo.free.fr.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Assassin character.
 */
public class Assassin extends Character {

    /**
     * Constructor.
     */
    public Assassin() {
        super(1, "1-Assassin");
    }

    /**
     * @return string representation
     */
    @Override
    public final String toString() {
        return "Assassin";
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

        for (Character character : CardManager.getInstance().getCharacterCards()) {
            authorisedString.add(character.getNumber());
        }

        System.out.println("Qui voulez-vous tuer ? : ");
        System.out.println(CardManager.getInstance().toStringCharacterCards());

        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();
        if (StringUtils.isNumeric(choice)) {
            int numberOfTheCard = Integer.parseInt(choice);

            if (authorisedString.contains(numberOfTheCard)) {
                Character character = CardManager.getInstance().getCharacterCard(numberOfTheCard);

                System.out.println("Vous avez tué : " + character);
                PowerManager.getInstance().setCharacterKilled(character);
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
