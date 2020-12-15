package logic;

import logic.decks.*;
import ui.UI;
import java.awt.Desktop;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logic{
    public static String OVERALL = "Overall";
    public static String ARENA = "Arena";
    public static String CONSTRUCTED = "Constructed";
    
    private static Logic instance;
    private final ArrayList<Card> cards;
    private final ArrayList<ArenaDeck> arenaDecks;
    private final ArrayList<ConstructedDeck> constructedDecks;
    
    private Logic(){
        cards = new ArrayList();
        arenaDecks = new ArrayList();
        constructedDecks = new ArrayList();
    }
    
    public static Logic getInstance(){
        if(instance == null){
            instance = new Logic();
        }
        return instance;
    }
    
    public Card getCard(String cardName) throws Exception{
        for(Card card : cards){
            if(card.getNAME().equals(cardName))
                return card;
        }
        throw new Exception("Card with name: "+cardName+" was not found in the system.");
    }
    
    public ArrayList<Card> getCards(){
        return cards;
    }
    
    public ArrayList<ArenaDeck> getArenaDecks(){
        return arenaDecks;
    }
    
    public ArrayList<ConstructedDeck> getConstructedDecks(){
        return constructedDecks;
    }
    
    //parameters for this method must always be "Arena" "Constructed" or "Overall"
    private ArrayList<Deck> getDecks(String gameType) throws Exception{
        ArrayList<Deck> decks = new ArrayList();
        if(gameType.equals(Logic.ARENA))
            decks.addAll(arenaDecks);
        else if(gameType.equals(Logic.CONSTRUCTED))
            decks.addAll(constructedDecks);
        else if(gameType.equals(Logic.OVERALL)){
            decks.addAll(arenaDecks);
            decks.addAll(constructedDecks);
        }else
            throw new Exception("getDecks() method accessed with incorrect parameter: "+gameType+".");
        return decks;
    }
    
    //overall wins
    public int getWins(String gameType) throws Exception{
        int wins = 0;
        ArrayList<Deck> decks = getDecks(gameType);
        for(Deck deck : decks){
            wins += deck.getWins();
        }  
        return wins;
    }
    
    //possible keys are constats in class Deck
    public int getWins(String gameType, String key) throws Exception{
        int wins = 0;
        ArrayList<Deck> decks = getDecks(gameType);
        for(Deck deck : decks){
            if(deck.getHeroClass().equals(key)){
                wins += deck.getWins();
            }else if(key.equals(Deck.TOTAL) || key.equals(Deck.COIN) ||key.equals(Deck.NO_COIN)){
                wins += deck.getWins(key);
            }
        }
        return wins;
    }
    
    //overall losses
    public int getLosses(String gameType) throws Exception{
        int losses = 0;
        ArrayList<Deck> decks = getDecks(gameType);
        for(Deck deck : decks){
            losses += deck.getLosses();
        }
        return losses;
    }

    //possible keys are in class Deck
    public int getLosses(String gameType, String key) throws Exception{
        int losses = 0;
        ArrayList<Deck> decks = getDecks(gameType);
        for(Deck deck : decks){
            if(deck.getHeroClass().equals(key)){
                losses += deck.getLosses();
            }else if(key.equals(Deck.TOTAL) || key.equals(Deck.COIN) ||key.equals(Deck.NO_COIN)){
                losses += deck.getLosses(key);
            }
        }
        return losses;
    }
    
    //overall win loss percentage
    public float getWLPercent(String gameType) throws Exception{
        int wins = getWins(gameType);
        int matches = wins+getLosses(gameType);
        if(wins == 0)
            return 0;
        else if(matches == 0)
            return 100;
        else
            return ((float)wins/matches)*100;
    }
    
    //possible keys in class Deck
    public float getWLPercent(String gameType, String key) throws Exception{
        int wins = getWins(gameType, key);
        int matches = wins+getLosses(gameType, key);
        if(wins == 0)
            return 0;
        else if(matches == 0)
            return 100;
        else
            return ((float)wins/matches)*100;
    }
    
    //checks if cards are sorted by mana cost and alphabetically
    private boolean cardsAreSorted(ArrayList<Card> cards) throws Exception{
        for(Card card : cards){
            if(cards.indexOf(card) == cards.size()-1)
                return true;
            else if(card.getCOST() > cards.get(cards.indexOf(card)+1).getCOST())
                return false;
            else if(card.getCOST() == cards.get(cards.indexOf(card)+1).getCOST()
                    &&(card.getNAME().compareToIgnoreCase(cards.get(cards.indexOf(card)+1).getNAME()) > 0))
                return false;
        }
        throw new Exception("cardsAreSorted() process had an error.");
    }
    
    //sorts an arraylist of cards by cost and alphabetically through
    //a really bad sorting algorithm. Might optimize later. Programmer no stoopid :(
    public ArrayList<Card> sortCards(ArrayList<Card> cards) throws Exception{
        Card tmpCardPTR;
        int cip = 0; //card index pointer
        while(!cardsAreSorted(cards)){
            while(cip < cards.size()-1){
                if(cards.get(cip).getCOST() > cards.get(cip+1).getCOST()){
                    tmpCardPTR = cards.set(cip+1, cards.get(cip));
                    cards.set(cip, tmpCardPTR);
                }
                else if(cards.get(cip).getCOST() == cards.get(cip+1).getCOST() &&
                        cards.get(cip).getNAME().compareToIgnoreCase(cards.get(cip+1).getNAME()) > 0){
                    tmpCardPTR = cards.set(cip+1, cards.get(cip));
                    cards.set(cip, tmpCardPTR);
                }
                cip++;
            }
            cip = 0;
        }
        return cards;
    }
    
    //updates deck header files
    private void updateDeckHeaders(String deckType) throws Exception{
        try{
            PrintWriter pw = new PrintWriter("Data\\"+deckType+"\\deck_headers.hst");
            if(deckType.equals("Arena")){
               for(Deck deck : arenaDecks)
                   pw.println(deck.getName()+".hst");
            }else{
                for(Deck deck : constructedDecks)
                    pw.println(deck.getName()+".hst");
            }
            pw.close();
        }catch (IOException e) {
            throw new Exception("There was an issue modifying the "
                                +deckType.toLowerCase()
                                +" header file (deck_headers.hst).");
        }
    }
    
    //Gets deck type. Returns either "Arena" or "Constructed".
    public String getDeckType(Deck deck){
        if(deck instanceof ArenaDeck)
            return Logic.ARENA;
        else
            return Logic.CONSTRUCTED;
    }
    
    //saves deck to disk
    private void saveDeckToDisk(Deck deck) throws Exception{
        String deckType = getDeckType(deck);
        PrintWriter writer = new PrintWriter("Data\\"+deckType+"\\"
                                             +deck.getName()+".hst", "UTF-8");
        writer.println(deck.toSaveString());
        writer.close();
        updateDeckHeaders(deckType);
    }
    
    public void saveDeck(Deck deck) throws Exception{
        String deckType = getDeckType(deck);
        //adds deck to arrayList in memory
        if(deckType.equals(Logic.ARENA) && !arenaDecks.contains((ArenaDeck)deck))
            arenaDecks.add((ArenaDeck)deck);
        else if(deckType.equals(Logic.CONSTRUCTED) && !constructedDecks.contains((ConstructedDeck)deck))
            constructedDecks.add((ConstructedDeck)deck);
        //saves deck to disk
        saveDeckToDisk(deck);
    }
    
    private void validateDeckName(Deck deck, String newName) throws Exception{     
        if(!newName.matches("^[^/./\\:*?\"<>|]+$"))
            throw new Exception("The deck's name cannot include the following characters:\n"
                                + "/, \\, ?, *, ., :, >, <, |");
        
        for(Deck arenaDeck : arenaDecks){
            if(arenaDeck.getName().equals(newName) && deck != arenaDeck)
                throw new Exception("The deck name ("+newName
                    +") is already being used for another deck.");
        }
        for(Deck constructedDeck : constructedDecks){
            if(constructedDeck.getName().equals(newName) && deck != constructedDeck)
                throw new Exception("The deck name ("+newName
                    +") is already being used for another deck.");
        }
    }
    
    public void addDeck(Deck deck) throws Exception{
        validateDeckName(deck, deck.getName());
        if(deck instanceof ArenaDeck)
            arenaDecks.add((ArenaDeck)deck);
        else
            constructedDecks.add((ConstructedDeck)deck);
        saveDeckToDisk(deck);
    }
    
    public void deleteDeck(Deck deck) throws Exception{
        String deckType = getDeckType(deck);
        if(deckType.equals(Logic.ARENA)){
            arenaDecks.remove((ArenaDeck)deck);
        }
        else{
            constructedDecks.remove((ConstructedDeck)deck);
        }
        Files.delete(Paths.get("Data\\"+deckType+"\\"+deck.getName()+".hst"));
        updateDeckHeaders(deckType);
    }
    
    private Deck loadDeck(String deckFilepath, String deckType) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(deckFilepath));

        //loads deck main data and creates deck object
        String deckName = br.readLine();
        String deckClass = br.readLine();
        Deck deck;
        if(deckType.equals(Logic.ARENA))
            deck = new ArenaDeck(deckName, deckClass);
        else if(deckType.equals(Logic.CONSTRUCTED))
            deck = new ConstructedDeck(deckName, deckClass);
        else{
            throw new Exception("Error while loading a deck from disk in function "
                                + "loadDeck. DeckType parameter incorrect: "+deckType);
        }

        //loads decklist
        br.readLine(); //one extra line must be read to get rid of the @Decklist tag
        String cardName;
        while(!(cardName = br.readLine()).equals("@Match History")){
            deck.addCard(getCard(cardName));
        }
        
        //loads match history
        boolean won;
        boolean coin;
        String heroClass;
        String enemyHeroClass;
        Date date;
        String matchDataRaw;
        String[] matchData;
        while((matchDataRaw = br.readLine()) != null){
            matchData = matchDataRaw.split("\t");
            heroClass = matchData[0];
            enemyHeroClass = matchData[1];
            won = matchData[2].equals("Won");
            coin = matchData[3].equals("Coin");
            date = new SimpleDateFormat(Match.DATE_FORMAT).parse(matchData[4]);
            deck.addMatch(new Match(won, coin, heroClass, enemyHeroClass, date));
        }
        br.close();
        return deck;
    }
    
    public void loadData() throws Exception{
        try{
            BufferedReader br = null;
            
            //loads all cards
            try{
                br = new BufferedReader(new FileReader("Data\\hs_cards.hst"));
                String cardDataRaw;
                String[] cardData;
                while((cardDataRaw = br.readLine()) != null){
                    cardData = cardDataRaw.split("\\$");
                    cards.add(new Card(cardData[0],Integer.parseInt(cardData[1]),
                              cardData[2], cardData[3], cardData[4]));
                }
                br.close();
            }catch(Exception e){
                UI.getInstance().displayError("Card data file (hs_cards.hst) "
                        + "is corrupted or was not found. Card data was"
                        + " not loaded. Error:\n"+e.getMessage());
            }
            
            //loads arena user decks
            String deckFilename;
            try{
                br = new BufferedReader(new FileReader("Data\\Arena\\deck_headers.hst"));
            }catch(Exception e){
                UI.getInstance().displayError("The arena deck headers file (deck_headers.hst)"
                        + " is corrupted or was not found. "
                        + "No arena runs were loaded. Error:\n"+e.getMessage());
            }
            while((deckFilename = br.readLine()) != null){
                try{
                    arenaDecks.add((ArenaDeck)loadDeck("Data\\Arena\\"+deckFilename, Logic.ARENA));
                }catch(Exception e){
                    UI.getInstance().displayError("An arena deck file ("+deckFilename+
                            ") was not found or was corrupted, so the"
                            +" deck was not loaded. Error:\n"+e.getMessage());
                }
            }
            br.close();
            
            //loads constructed user decks
            try{
                br = new BufferedReader(new FileReader("Data\\Constructed\\deck_headers.hst"));
            }catch(Exception e){
                UI.getInstance().displayError("The constructed deck headers file (deck_headers.hst)"
                        + " is corrupted or was not found. "
                        + "No constructed decks were loaded. Error:\n"+e.getMessage());
            }
            while((deckFilename = br.readLine()) != null){
                try{
                    constructedDecks.add((ConstructedDeck)loadDeck("Data\\Constructed\\"+deckFilename, Logic.CONSTRUCTED));
                }catch(Exception e){
                    UI.getInstance().displayError("A constructed deck file ("+deckFilename+
                            ") was not found or was corrupted, so the"
                            +" deck was not loaded. Error:\n"+e.getMessage());
                }
            }
            br.close();
        }catch(IOException e){
            UI.getInstance().displayError("Something went horribly while loading the "
                             +"program's data and the program must stop. "
                             +"Notify the developer so he can fix this "
                             + "@ ajoscram@gmail.com. Give him this error message:\n"+e.getMessage());
        }
    }
    
    public void changeDeckName(Deck deck, String newName) throws Exception{
        validateDeckName(deck, newName);
        String oldDeckPath = "Data\\";
        String deckType = getDeckType(deck);
        oldDeckPath += deckType+"\\"+deck.getName()+".hst";       
        Files.delete(Paths.get(oldDeckPath));
        deck.setName(newName);
        saveDeckToDisk(deck);
    }
    
    public void openHelpFile() throws Exception{
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("Data\\help.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException e) {
                throw new Exception("The HST_Help.pdf file was not found or "
                                    + "you don't own a pdf viewing application. "
                                    + "Couldn't open file. Error:\n"+e.getMessage());
            }
        }
    }
}
