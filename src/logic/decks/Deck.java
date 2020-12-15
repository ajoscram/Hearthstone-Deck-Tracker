package logic.decks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import logic.Card;
import logic.Match;

public abstract class Deck {
    public static final String TOTAL = "Total";
    public static final String COIN = "Coin";
    public static final String NO_COIN = "No Coin";
    public static final String DRUID = "Druid";
    public static final String HUNTER = "Hunter";
    public static final String MAGE = "Mage";
    public static final String PALADIN = "Paladin";
    public static final String PRIEST = "Priest";
    public static final String ROGUE = "Rogue";
    public static final String SHAMAN = "Shaman";
    public static final String WARLOCK = "Warlock";
    public static final String WARRIOR = "Warrior";
    protected static final HashMap<String, Integer> CLASS_DICT = new HashMap();
    static{
        CLASS_DICT.put("Total", 0);
        CLASS_DICT.put("Coin", 1);
        CLASS_DICT.put("No Coin", 2);
        CLASS_DICT.put("Druid", 3);
        CLASS_DICT.put("Hunter", 4);
        CLASS_DICT.put("Mage", 5);
        CLASS_DICT.put("Paladin", 6);
        CLASS_DICT.put("Priest", 7);
        CLASS_DICT.put("Rogue", 8);
        CLASS_DICT.put("Shaman", 9);
        CLASS_DICT.put("Warlock", 10);
        CLASS_DICT.put("Warrior", 11);
    }
    
    protected String name;
    protected String heroClass;
    protected ArrayList<Card> cards;
    protected ArrayList<Match> matches;
    protected int[] wins;
    protected int[] losses;
    
    public Deck(String name, String heroClass){
        this.name = name;
        this.heroClass = heroClass;
        this.matches = new ArrayList();
        this.cards = new ArrayList();
        wins = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        losses = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
    }
    
    //setters
    public void setName(String name){
        this.name = name;
    }
    
    //getters
    public String getName(){
        return name;
    }
    
    public String getHeroClass() {
        return heroClass;
    }
    
    public int getWins(){
        return wins[(int)CLASS_DICT.get("Total")];
    }
    
    public int getWins(String key) throws Exception{
        try{
            return wins[(int)CLASS_DICT.get(key)];
        }catch(Exception e){
            throw new Exception("Error obtaining wins for "
                                +key+" in the deck "+name);
        }   
    }

    public int getLosses(){
        return losses[(int)CLASS_DICT.get("Total")];
    }
    
    public int getLosses(String key) throws Exception{
        try{
            return losses[(int)CLASS_DICT.get(key)];
        }catch(Exception e){
            throw new Exception("Error obtaining wins for "
                                +key+" in the deck "+name);
        }
    }
    
    private int getNumberOfMatches() throws Exception{
        return getLosses()+getWins();
    }

    private int getNumberOfMatches(String key) throws Exception{
        return getLosses(key)+getWins(key);
    }
    
    public float getWLPercent() throws Exception{
        int totalMatches = getNumberOfMatches();
        int totalWins = getWins();
        if(totalWins == 0)
            return 0;
        else if(totalMatches == 0)
            return 100;
        else
            return ((float)totalWins/totalMatches)*100;
    }
    
    public float getWLPercent(String key) throws Exception{
        int totalWins = getWins(key);
        int totalMatches  = getNumberOfMatches(key);
        if(totalWins == 0)
            return 0;
        else if(totalMatches == 0)
            return 100;
        else{
            return ((float)totalWins/totalMatches)*100;
        }
    }

    //containers manipulation
    public ArrayList<Match> getMatches() {
        return matches;
    }
    
    //You cant add past matches past three losses in arena, so this method is implemented
    //by the subclasses.
    public abstract void addMatch(Match match) throws Exception;
    
    public void removeMatch(Match match) throws Exception{
        if(!matches.contains(match))
            throw new Exception("The match is not registered in this deck.");
        else{
            int[] list;
            if(match.wasWON())
                list = wins;
            else
                list = losses;

            list[(int)CLASS_DICT.get("Total")]--;
            list[(int)CLASS_DICT.get(match.getENEMY_HERO_CLASS())]--;
            if(match.hasCOIN())
                list[(int)CLASS_DICT.get(Deck.COIN)]--;
            else
                list[(int)CLASS_DICT.get(Deck.NO_COIN)]--;
            matches.remove(match);
        }
    }
    
    public Match getMatch(boolean won, boolean coin, String enemyHeroClass, Date date)throws Exception{
        for(Match match : matches){
            if(match.getENEMY_HERO_CLASS().equals(enemyHeroClass) &&
               match.wasWON() == won &&
               match.hasCOIN() == coin &&
               new SimpleDateFormat(Match.DATE_FORMAT).format(date).equals(new SimpleDateFormat(Match.DATE_FORMAT).format(match.getDATE())))
                return match;
        }
        throw new Exception("Match was not found in "+this.name+"'s matches list.");
    }
    
    public ArrayList<Card> getCards(){
        return cards;
    }
    
    //You can't add more than 2 copies of each card in constructed, or 1 legendary
    //so it'll be implemented by the subclasses
    public abstract void addCard(Card card) throws Exception;
    
    public double getCurveAverage(){
        if(cards.isEmpty())
            return 0;
        else{
            double answer = 0;
            for(Card card : cards)
                answer += card.getCOST();
            return (new BigDecimal(answer/cards.size()).setScale(2, RoundingMode.HALF_UP)).doubleValue();
        }
    }
    
    @Override
    public String toString(){
        return name+" ["+heroClass+"]";
    }
    
    //different toString used for saving purposes
    public String toSaveString(){
        String string = name+"\r\n"+heroClass+"\r\n@Decklist";
        for(Card card : cards)
            string += ("\r\n"+card.getNAME());
        string+= ("\r\n@Match History");
        for(Match match : matches)
            string += ("\r\n"+match.toString());
        return string;
    }
}