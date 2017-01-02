package maxime.maheo.free.fr.card;

import maxime.maheo.free.fr.card.character.Trader;
import maxime.maheo.free.fr.card.character.Architect;
import maxime.maheo.free.fr.card.character.Soldier;
import maxime.maheo.free.fr.card.character.King;
import maxime.maheo.free.fr.card.character.Lord;
import maxime.maheo.free.fr.card.character.Assassin;
import maxime.maheo.free.fr.card.character.Character;
import maxime.maheo.free.fr.card.character.Magician;
import maxime.maheo.free.fr.card.character.Thief;
import maxime.maheo.free.fr.card.district.Nobility;
import maxime.maheo.free.fr.card.district.Prestige;
import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.card.district.Religion;
import maxime.maheo.free.fr.card.district.Soldiery;
import maxime.maheo.free.fr.card.district.Trade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CardManager class.
 */
public final class CardManager {

    /**
     * Instance of our singleton.
     */
    private static final CardManager INSTANCE = new CardManager();

    /**
     * District cards.
     */
    private List<District> districtCards;

    /**
     * Character cards.
     */
    private List<Character> characterCards;

    /**
     * Constructor.
     */
    private CardManager() {
        this.districtCards = new ArrayList<>();
        this.characterCards = new ArrayList<>();
        this.addDistrictCards();
    }

    /**
     * @return our singleton
     */
    public static CardManager getInstance() {
        return INSTANCE;
    }

    /**
     * @return district card
     */
    public List<District> getDistrictCards() {
        return this.districtCards;
    }

    /**
     * @return character card
     */
    public List<Character> getCharacterCards() {
        return this.characterCards;
    }

    /**
     * Add district cards.
     */
    private void addDistrictCards() {
        Religion.addCards(this.getDistrictCards());
        Soldiery.addCards(this.getDistrictCards());
        Trade.addCards(this.getDistrictCards());
        Nobility.addCards(this.getDistrictCards());
        Prestige.addCards(this.getDistrictCards());
    }

    /**
     * Add district cards.
     */
    public void addCharacterCards() {
        this.characterCards.add(new Assassin());
        this.characterCards.add(new Thief());
        this.characterCards.add(new Magician());
        this.characterCards.add(new King());
        this.characterCards.add(new Lord());
        this.characterCards.add(new Trader());
        this.characterCards.add(new Architect());
        this.characterCards.add(new Soldier());
    }

    /**
     * Shuffle district cards.
     */
    public void shuffleDistrictCards() {
        Collections.shuffle(this.getDistrictCards());
    }

    /**
     * Shuffle character cards.
     */
    public void shuffleCharacterCards() {
        Collections.shuffle(this.getCharacterCards());
    }

    /**
     * Give district cards.
     *
     * @param number of cards to give
     * @return district cards
     */
    public List<District> getDistrictCard(final int number) {
        if (number <= this.getDistrictCards().size()) {
            List<District> cards = new ArrayList<>();

            for (int i = 0; i < number; i++) {
                District card = this.getDistrictCards().get(i);
                cards.add(card);
            }

            this.getDistrictCards().removeAll(cards);

            return cards;
        }

        return null;
    }

    /**
     * Put one card at the end of the deck.
     *
     * @param card to put at the end
     */
    public void putDistrictCardToTheEnd(final District card) {
        this.getDistrictCards().add(card);
    }

    /**
     * Give character cards.
     *
     * @param number of the card
     * @return character card
     */
    public Character getCharacterCard(final int number) {
        Character card = null;
        int indexToRemove = -1;

        for (int i = 0; i < this.getCharacterCards().size(); i++) {
            Character character = this.getCharacterCards().get(i);
            if (character.getNumber() == number) {
                card = character;
                indexToRemove = i;
            }
        }

        if (indexToRemove != -1) {
            this.getCharacterCards().remove(indexToRemove);
        }
        return card;
    }

    /**
     * Discard character card.
     *
     * @param number of the card to discard
     */
    public void discardCharacterCard(final int number) {
        int indexToRemove = -1;

        for (int i = 0; i < this.getCharacterCards().size(); i++) {
            Character character = this.getCharacterCards().get(i);
            if (character.getNumber() == number) {
                indexToRemove = i;
            }
        }
        if (indexToRemove != -1) {
            this.getCharacterCards().remove(indexToRemove);
        }
    }

    /**
     * Discard all characters card.
     */
    public void discardAllCharacterCard() {
        this.getCharacterCards().clear();
    }

    /**
     * To string.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        String result = "District cards : \n";
        for (District card : this.getDistrictCards()) {
            result += card + "\n";
        }

        result += "\nCharacter cards : \n";
        for (Character card : this.getCharacterCards()) {
            result += card + "\n";
        }
        return result;
    }

    /**
     * @return characters representation
     */
    public String toStringCharacterCards() {
        String result = "";
        for (Character card : this.getCharacterCards()) {
            result += card.getNumber() + ") " + card + "\n";
        }
        return result;
    }

    /**
     * @return district representation
     */
    public String toStringDistrictCards() {
        String result = "";
        for (District card : this.getDistrictCards()) {
            result += card + "\n";
        }
        return result;
    }
}
