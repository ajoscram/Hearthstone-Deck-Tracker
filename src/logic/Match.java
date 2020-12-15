package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Match {
    public static final String DATE_FORMAT= "dd/MM/yyyy hh:mm:ss";
    
    private final boolean WON;
    private final boolean COIN;
    private final String HERO_CLASS;
    private final String ENEMY_HERO_CLASS;
    private final Date DATE;

    public Match(boolean WON, boolean COIN, String HERO_CLASS, String ENEMY_HERO_CLASS, Date DATE){
        this.WON = WON;
        this.COIN = COIN;
        this.HERO_CLASS = HERO_CLASS;
        this.ENEMY_HERO_CLASS = ENEMY_HERO_CLASS;
        this.DATE = DATE;
    }

    public boolean wasWON() {
        return WON;
    }

    public boolean hasCOIN() {
        return COIN;
    }

    public String getHERO_CLASS() {
        return HERO_CLASS;
    }

    public String getENEMY_HERO_CLASS() {
        return ENEMY_HERO_CLASS;
    }

    public Date getDATE() {
        return DATE;
    }
    
    public String toString(){
         String string = HERO_CLASS+"\t"+ENEMY_HERO_CLASS+"\t";
        if(WON)
            string += "Won\t";
        else
            string += "Lost\t";
        
        if(COIN)
            string += "Coin\t";
        else
            string += "No Coin\t";
        string += new SimpleDateFormat(Match.DATE_FORMAT).format(DATE);
        return string;
    }
}
