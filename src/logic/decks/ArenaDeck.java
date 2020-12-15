package logic.decks;

import logic.Card;
import logic.Match;

public class ArenaDeck extends Deck{

    public ArenaDeck(String name, String heroClass) {
        super(name, heroClass);
    }
    @Override
    public void addCard(Card card){
        cards.add(card);
    }

    @Override
    public void addMatch(Match match) throws Exception{
        if(losses[Deck.CLASS_DICT.get(Deck.TOTAL)] == 3)
            throw new Exception("You've registered 3 losses already for this run. The arena run is over.");
        else if(wins[Deck.CLASS_DICT.get(Deck.TOTAL)] == 12)
            throw new Exception("You've registered 12 wins already for this run. The arena run is over, congratulations!");
        
        else{
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
    }
    
    @Override
    public String toString(){
        return super.toString()+" ("+getWins()+")";
    }
}
