package logic.decks;

import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Card;
import logic.Match;

public class ConstructedDeck extends Deck{

    public ConstructedDeck(String name, String heroClass){
        super(name, heroClass);
    }
 
    @Override
    public void addMatch(Match match){
        int[] list;
        if(match.wasWON())
            list = wins;
        else
            list = losses;
        
        list[(int)CLASS_DICT.get(Deck.TOTAL)]++;
        list[(int)CLASS_DICT.get(match.getENEMY_HERO_CLASS())]++;
        if(match.hasCOIN())
            list[(int)CLASS_DICT.get(Deck.COIN)]++;
        else
            list[(int)CLASS_DICT.get(Deck.NO_COIN)]++;
            
        matches.add(match);
    }

    //returns how many copies of a card exist in the deck.
    private int getCardCopyAmount(Card card){
        int amount = 0;
        for(Card deckCard : cards){
            if(card.getNAME().equals(deckCard.getNAME()))
                amount++;
        }
        return amount;
    }
    
    @Override
    public void addCard(Card card) throws Exception{
        int copiesInDeck = getCardCopyAmount(card);
        if(card.getRARITY().equals(Card.LEGENDARY) && copiesInDeck == 1){
            throw new Exception("Error while adding: "+card.getNAME()+" to the deck. "
                                + "You may only have one copy of a legendary card in a constructed deck.");
        }
        else if(copiesInDeck == 2){
            throw new Exception("Error while adding: "+card.getNAME()+" to the deck. "
                                + "You may only have two copies of any non-legendary card in a constructed deck.");
        }else
            cards.add(card);
    }
    
    @Override
    public String toString(){
        try {
            return super.toString()+"("+Integer.toString(Math.round(getWLPercent(Deck.TOTAL)))+"%)";
        } catch (Exception ex) {
            return super.toString();
        }
    }
}
