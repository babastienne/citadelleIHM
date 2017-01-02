package maxime.maheo.free.fr.card.character;

/**
 * General character class.
 */
public abstract class Character {

    /**
     * Number of the character.
     */
    protected final int number;
    
    protected final String image;

    /**
     * Constructor.
     *
     * @param number of the character
     */
    protected Character(final int number, String image) {
        this.number = number;
        this.image = image;
    }

    /**
     * PowerManager of the character.
     */
    public abstract void power();

    /**
     * Getter.
     *
     * @return number of the card
     */
    public final int getNumber() {
        return this.number;
    }
    
    public final String getImage() {
    	return "images/" + this.image + ".jpg";
    }
}
