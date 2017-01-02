package maxime.maheo.free.fr.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Game;
import maxime.maheo.free.fr.card.CardManager;
import maxime.maheo.free.fr.card.character.Character;
import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.util.StringUtils;
import view.Window;

/**
 * Player class.
 */
public class Player {

    /**
     * if the character is crowned or not.
     */
    private boolean isCrowned;

    /**
     * Coins of the character.
     */
    private int coins;

    /**
     * Players cards.
     */
    private List<District> districtCards;

    /**
     * First character.
     */
    private Character firstCharacter;

    /**
     * Second character.
     */
    private Character secondCharacter;

    /**
     * Scanner to read user input.
     */
    private Scanner scanner;

    /**
     * Player points.
     */
    private int points;

    /**
     * Constructor.
     */
    public Player(boolean isFirstPlayer) {
        this.isCrowned = false;
        this.coins = 0;
        this.districtCards = new ArrayList<>();
        this.firstCharacter = null;
        this.secondCharacter = null;
        this.scanner = new Scanner(System.in);
        this.points = 0;
        this.isFirstPlayer = isFirstPlayer;
    }

    /**
     * @return if the character is crowned
     */
    public final boolean isCrowned() {
        return this.isCrowned;
    }

    /**
     * Crown the character or not.
     *
     * @param crowned true is we want to crowned the character
     */
    public final void setCrowned(final boolean crowned) {
        this.isCrowned = crowned;
    }

    /**
     * @return coins of the character.
     */
    public final int getCoins() {
        return this.coins;
    }

    /**
     * Set coins of the character.
     *
     * @param coins that we want
     */
    public final void setCoins(final int coins) {
        this.coins = coins;
    }

    /**
     * Give district card to character.
     *
     * @param cardManager to give him cards
     * @param number      of cards to give him
     * @return cards.
     */
    public final List<District> getDistrictCard(final CardManager cardManager, final int number) {
        List<District> cards = cardManager.getDistrictCard(number);
        if (cards != null) {
            this.districtCards.addAll(cards);
        }
        return cards;
    }

    /**
     * @return first character
     */
    public final Character getFirstCharacter() {
        return this.firstCharacter;
    }

    /**
     * Set the fist character.
     *
     * @param firstCharacter to set
     */
    public final void setFirstCharacter(final Character firstCharacter) {
        this.firstCharacter = firstCharacter;
    }

    /**
     * @return second character
     */
    public final Character getSecondCharacter() {
        return this.secondCharacter;
    }

    /**
     * Set the second character.
     *
     * @param secondCharacter to set
     */
    public final void setSecondCharacter(final Character secondCharacter) {
        this.secondCharacter = secondCharacter;
    }

    /**
     * Choose one character at start of the turn.
     *
     * @param cardManager     card manager
     * @param characterNumber the number of the character, if it's 1 it's the first character else the second character
     */
    public final void chooseCharacterCard(final CardManager cardManager, final int characterNumber) {

        List<Integer> authorisedString = new ArrayList<>();

        for (Character character : cardManager.getCharacterCards()) {
            authorisedString.add(character.getNumber());
        }

        System.out.println("Liste des cartes disponible : ");
        System.out.println(cardManager.toStringCharacterCards());
        System.out.println("Choisir une carte : ");

        String choice = scanner.nextLine();

        if (StringUtils.isNumeric(choice)) {
            int numberOfTheCard = Integer.parseInt(choice);
            if (authorisedString.contains(numberOfTheCard)) {

                if (characterNumber == 1) {
                    this.firstCharacter = cardManager.getCharacterCard(numberOfTheCard);
                } else {
                    this.secondCharacter = cardManager.getCharacterCard(numberOfTheCard);
                }
                cardManager.shuffleCharacterCards();
            } else {
                System.out.println("Vous avez tapé un mauvais caractère.");
                this.chooseCharacterCard(cardManager, characterNumber);
            }
        } else {
            System.out.println("Vous avez tapé un mauvais caractère.");
            this.chooseCharacterCard(cardManager, characterNumber);
        }
    }

    /**
     * Discard one character at start of the turn.
     *
     * @param cardManager card manager
     */
    public final void discardCharacterCard(final CardManager cardManager) {
        List<Integer> authorisedString = new ArrayList<>();

        for (Character character : cardManager.getCharacterCards()) {
            authorisedString.add(character.getNumber());
        }

        System.out.println("Choisir une carte à défausser : ");
        System.out.println(cardManager.toStringCharacterCards());
        String numberOfTheCard = scanner.nextLine();

        if (StringUtils.isNumeric(numberOfTheCard)) {
            if (authorisedString.contains(Integer.parseInt(numberOfTheCard))) {
                cardManager.discardCharacterCard(Integer.parseInt(numberOfTheCard));
                cardManager.shuffleCharacterCards();
            } else {
                System.out.println("Vous avez tapé un mauvais caractère.");
                this.discardCharacterCard(cardManager);
            }
        } else {
            System.out.println("Vous avez tapé un mauvais caractère.");
            this.discardCharacterCard(cardManager);
        }

    }

    /**
     * Know if the player has the character with a specific number.
     *
     * @param number of the character
     * @return if the player has the character with a specific number
     */
    public final boolean hasCharacterWithNumber(final int number) {
        return this.firstCharacter.getNumber() == number || this.secondCharacter.getNumber() == number;
    }

    /**
     * Choose one district card and discard one.
     *
     * @param cardManager card manager
     */
    public final void chooseDistrictCard(final CardManager cardManager) {
//        System.out.println("Liste des cartes disponible : ");

//        districtCardsUsedToPick = cardManager.getDistrictCard(2);
//
//        assert districtCards != null;
//        for (int i = 1; i <= districtCards.size(); i++) {
//            System.out.println(i + ") " + districtCards.get(i - 1));
//        }
//        
        // IHM
//        this.setIsPickingCard(true);
//        Window.getInstance().updateStructure(Game.getInstance());
//        
//        while(this.isPickingCard()) {
//        	try {
//    			Thread.sleep(10);
//    		} catch (Exception e) {
//    			System.out.println(e.getMessage());
//    		}
//        }
//        if(this.getNbCardPicking() > -1) {
//        	int cardChoosen = (this.getNbCardPicking() == 0) ? this.getNbCardPicking() : 1;
//        	int cardNotChoosen = (cardChoosen == 0) ? 1 : cardChoosen;
//        	this.getDistrictCards().add(districtCards.get(cardChoosen));
//            cardManager.putDistrictCardToTheEnd(districtCards.get(cardNotChoosen));
//        } else {
//        	System.out.println("ERROR : Impossible to know the card choosen by the player");
//        }
//        
//        this.setNbCardPicking(-1);
//        this.districtCardsUsedToPick = null;
//        Window.getInstance().updateStructure(Game.getInstance());
        // END IHM
        
        System.out.println("Liste des cartes disponible : ");

        List<District> districtCards = cardManager.getDistrictCard(2);

        assert districtCards != null;
        for (int i = 1; i <= districtCards.size(); i++) {
            System.out.println(i + ") " + districtCards.get(i - 1));
        }
    	
        System.out.println("Choisir une carte : ");

        String choice = scanner.nextLine();

        if (StringUtils.isNumeric(choice)) {
            int options = Integer.parseInt(choice);
            if (options == 1) {
                System.out.println("Vous avez choisi cette carte : " + districtCards.get(0));
                this.districtCards.add(districtCards.get(0));
                cardManager.putDistrictCardToTheEnd(districtCards.get(1));
            } else if (options == 2) {
                System.out.println("Vous avez choisi cette carte : " + districtCards.get(1));
                this.districtCards.add(districtCards.get(1));
                cardManager.putDistrictCardToTheEnd(districtCards.get(0));
            } else {
                System.out.println("Vous avez tapé un mauvais caractère.");
                this.chooseDistrictCard(cardManager);
            }
        } else {
            System.out.println("Vous avez tapé un mauvais caractère.");
            this.chooseDistrictCard(cardManager);
        }
    }

    /**
     * Take two coins or one card.
     *
     * @param cardManager card manager
     */
    public final void takeCoinsOrCards(final CardManager cardManager) {
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1) Prendre deux pièces d'or");
        System.out.println("2) Piocher deux cartes et en défausser une");

        String choice = scanner.nextLine();

        if (StringUtils.isNumeric(choice)) {
            int options = Integer.parseInt(choice);

            if (options == 1) { //get coins
                this.setCoins(this.getCoins() + Bank.getInstance().giveCoins(2));
                System.out.println("Vous avez pris deux pièces d'or");
            } else if (options == 2) { //get cards
                this.chooseDistrictCard(cardManager);
            } else {
                System.out.println("Vous avez tapé un mauvais caractère.");
                this.takeCoinsOrCards(cardManager);
            }
        } else {
            System.out.println("Vous avez tapé un mauvais caractère.");
            this.takeCoinsOrCards(cardManager);
        }
    }

    /**
     * Place a district card to the tray.
     *
     * @param tray          to place cards
     * @param isFirstPlayer is the first player
     * @param isArchitect   the player is an architect
     */
    public final void placeDisctrictCard(final Tray tray, final boolean isFirstPlayer, final boolean isArchitect) {

        List<Integer> authorisedString = new ArrayList<>();

        int index = 0;
        String options = "";
        do {
            System.out.println("Vous disposez de " + this.coins + " pièce(s) d'or");
            System.out.println("Vous avez les cartes suivantes :");

            for (int i = 1; i <= this.districtCards.size(); i++) {
                System.out.println(i + ") " + this.districtCards.get(i - 1));
                authorisedString.add(i);
            }
            System.out.println("Si vous voulez poser une carte, tapez son numéro sinon tapez \"n\".");
            options = scanner.nextLine();

            if (options.equals("n")) {
                System.out.println("Vous ne posez aucune carte, au joueur suivant");
            } else {

                if (StringUtils.isNumeric(options)) {

                    if (authorisedString.contains(Integer.parseInt(options))) {
                        index++;
                        int cardNumber = Integer.parseInt(options) - 1;
                        District card = this.districtCards.get(cardNumber);

                        if (this.coins >= card.getCost()) {
                            boolean alreadyOnTray = false;

                            if (isFirstPlayer) {

                                for (District firstPlayerCard : tray.firstPlayerDistrictCards()) {
                                    if (card.getColor() == firstPlayerCard.getColor() && card.getCost() == firstPlayerCard.getCost() && card.getClass() == firstPlayerCard.getClass()) {
                                        alreadyOnTray = true;
                                    }
                                }

                                tray.firstPlayerPlaceCard(card);
                            } else {
                                for (District secondPlayerCard : tray.secondPlayerDistrictCards()) {
                                    if (card.getColor() == secondPlayerCard.getColor() && card.getCost() == secondPlayerCard.getCost() && card.getClass() == secondPlayerCard.getClass()) {
                                        alreadyOnTray = true;
                                    }
                                }

                                tray.secondPlayerPlaceCard(card);
                            }

                            if (!alreadyOnTray) {
                                this.coins -= card.getCost();
                                Bank.getInstance().takeCoins(card.getCost());
                                this.districtCards.remove(cardNumber);

                                System.out.println("Vous avez posé cette carte : " + card);
                                System.out.println("Il vous reste " + this.coins + " pièce(s) d'or");
                            } else {
                                System.out.println("Vous avez déjà cette carte dans votre cité");
                                this.placeDisctrictCard(tray, isFirstPlayer, isArchitect);
                            }

                        } else {
                            System.out.println("Vous n'avez pas assez de pièce d'or, faite une autre action");
                            this.placeDisctrictCard(tray, isFirstPlayer, isArchitect);
                        }
                    } else {
                        System.out.println("Vous n'avez pas assez de pièce d'or, faite une autre action");
                        this.placeDisctrictCard(tray, isFirstPlayer, isArchitect);
                    }
                } else {
                    System.out.println("Vous avez tapé un mauvais caractère.");
                    this.placeDisctrictCard(tray, isFirstPlayer, isArchitect);
                }
            }
            Window.getInstance().updateStructure(Game.getInstance());
        } while (!options.equals("n") && isArchitect && index < 3);
    }

    /**
     * Getter.
     *
     * @return points
     */
    public final int getPoints() {
        return this.points;
    }

    /**
     * Setter.
     *
     * @param points to set
     */
    public final void setPoints(final int points) {
        this.points = points;
    }

    /**
     * Getter.
     *
     * @return district cards
     */
    public final List<District> getDistrictCards() {
        return this.districtCards;
    }

    /**
     * Setter.
     *
     * @param districtCards districtCards
     */
    public final void setDistrictCards(final List<District> districtCards) {
        this.districtCards = districtCards;
    }

    /**
     * To string.
     *
     * @return character string
     */
    @Override
    public final String toString() {
        return "Possède la couronne: " + this.isCrowned
                + "\npièce d'or: " + this.coins
                + "\nnombre de carte quatiers: " + this.districtCards.size()
                + "\npremier personnage: " + this.firstCharacter
                + "\nsecond personnage: " + this.secondCharacter;
    }
    
    // AJOUT DE METHODES POUR IHM
    private boolean hadToChooseBetweenGoldAndCards = false;
    private boolean hasUsedHisPower = true;

	public boolean isHadToChooseBetweenGoldAndCards() {
		return hadToChooseBetweenGoldAndCards;
	}

	public void setHadToChooseBetweenGoldAndCards(boolean hadToChooseBetweenGoldAndCards) {
		this.hadToChooseBetweenGoldAndCards = hadToChooseBetweenGoldAndCards;
		Window.getInstance().updateStructure(Game.getInstance());
	}

	public boolean isHasUsedHisPower() {
		return hasUsedHisPower;
	}

	public void setHasUsedHisPower(boolean hasUsedHisPower) {
		this.hasUsedHisPower = hasUsedHisPower;
		Window.getInstance().updateStructure(Game.getInstance());
	}
    
    private String name;
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    private int characterNumberCurrentlyPlaying;
    
    public int isPlayingCharacterNumber() {
    	return this.characterNumberCurrentlyPlaying;
    }
    
    public void setIsPlayingCharacterNumber(int i) {
    	this.characterNumberCurrentlyPlaying = i;
    }
    
    public void endTurn() {
    	this.setHadToChooseBetweenGoldAndCards(false);
    	this.setHasUsedHisPower(true);
    	this.setHasUsedHisSecondPower(true);
    	this.setIsPlayingCharacterNumber(0);
    	this.setPlaying(false);
    	this.nbPlaceCard = 0;
    	Window.getInstance().updateStructure(Game.getInstance());
    }
    
    private boolean finishRound = true;
    
    public void setFinishRound(boolean bool) {
    	this.finishRound = bool;
    	Window.getInstance().updateStructure(Game.getInstance());
    }
    
    public boolean isFinishRound() {
    	return this.finishRound;
    }
    
    private boolean hasUsedHisSecondPower = true;
    
    public boolean isHasUsedHisSecondPower() {
		return hasUsedHisSecondPower;
	}

	public void setHasUsedHisSecondPower(boolean hasUsedHisSecondPower) {
		this.hasUsedHisSecondPower = hasUsedHisSecondPower;
		Window.getInstance().updateStructure(Game.getInstance());
	}
	
	private boolean playing = false;
	
	public boolean isPlaying() {
		return this.playing;
	}
	
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	private boolean isFirstPlayer;
	
	public boolean isFirstPlayer() {
		return this.isFirstPlayer;
	}
	
	private int nbPlaceCard = 0;
	
	/**
	 * 
	 * @param tray
	 * @return true if the card has been placed. Else return false.
	 */
	public boolean placeDistrictCard(District card, Tray tray, int cardNumber) {
		if (this.nbPlaceCard == 0 || (this.isPlayingCharacterNumber() == 7 && this.nbPlaceCard < 3)) {

            if (this.coins >= card.getCost()) {
                boolean alreadyOnTray = false;

                if (this.isFirstPlayer) {

                    for (District firstPlayerCard : tray.firstPlayerDistrictCards()) {
                        if (card.getColor() == firstPlayerCard.getColor() && card.getCost() == firstPlayerCard.getCost() && card.getClass() == firstPlayerCard.getClass()) {
                            alreadyOnTray = true;
                        }
                    }
                    if(!alreadyOnTray)
                    	tray.firstPlayerPlaceCard(card);
                } else {
                    for (District secondPlayerCard : tray.secondPlayerDistrictCards()) {
                        if (card.getColor() == secondPlayerCard.getColor() && card.getCost() == secondPlayerCard.getCost() && card.getClass() == secondPlayerCard.getClass()) {
                            alreadyOnTray = true;
                        }
                    }
                    if(!alreadyOnTray)
                    	tray.secondPlayerPlaceCard(card);
                }

                if (!alreadyOnTray) {
                    this.coins -= card.getCost();
                    Bank.getInstance().takeCoins(card.getCost());
                    this.districtCards.remove(cardNumber);

                    System.out.println("Vous avez posé cette carte : " + card);
                    this.nbPlaceCard++;
                    return true;
                } else {
                    System.out.println("Vous avez déjà cette carte dans votre cité");
                }

            } else {
                System.out.println("Vous n'avez pas assez de pièce d'or, faite une autre action");
            }
    		return false;            
        } else {
            return false;
        }
	}
	
//	private boolean isPickingCard = false;
//	
//	public void setIsPickingCard(boolean bool) {
//		this.isPickingCard = bool;
//	}
//	
//	public boolean isPickingCard() {
//		return this.isPickingCard;
//	}
//	
//	private int nbCardPicking = -1;
//	
//	public void setNbCardPicking(int i) {
//		this.nbCardPicking = i;
//	}
//	
//	private int getNbCardPicking() {
//		return this.nbCardPicking;
//	}
//	
//	private List<District> districtCardsUsedToPick;
//	
//	public List<District> getDistrictCardsUsedToPick() {
//		return this.districtCardsUsedToPick;
//	}
}
