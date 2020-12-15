package logic;

public class Card {
    public static final String NORMAL = "Normal";
    public static final String RARE = "Rare";
    public static final String EPIC = "Epic";
    public static final String LEGENDARY = "Legendary";
    public static final String SPELL = "Spell";
    public static final String MINION = "Minion";
    public static final String WEAPON = "Weapon";
    
    private final int COST;
    private final String NAME;
    private final String CLASS;
    private final String RARITY;
    private final String TYPE;

    public Card(String NAME, int COST, String CLASS, String RARITY, String TYPE) throws Exception{
        if(!RARITY.equals(Card.NORMAL) &&
           !RARITY.equals(Card.RARE) &&
           !RARITY.equals(Card.EPIC) &&
           !RARITY.equals(Card.LEGENDARY))
            throw new Exception("The card: "+NAME+" has no correct rarity attribute ("+RARITY+").");
        if(!TYPE.equals(Card.SPELL) &&
           !TYPE.equals(Card.MINION)&&
           !TYPE.equals(Card.WEAPON))
            throw new Exception("The card: "+NAME+" has no correct type attribute ("+TYPE+").");
        this.NAME = NAME;
        this.COST = COST;
        this.CLASS = CLASS;
        this.RARITY = RARITY;
        this.TYPE = TYPE;
    }

    public int getCOST() {
        return COST;
    }

    public String getNAME() {
        return NAME;
    }
    
    public String getCLASS(){
        return CLASS;
    }

    public String getRARITY() {
        return RARITY;
    }

    public String getTYPE() {
        return TYPE;
    }
    
    @Override
    public String toString(){
        return NAME+" ["+CLASS+"]"+" ("+COST+")";
    }
}
