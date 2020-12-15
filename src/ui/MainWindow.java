package ui;

import logic.decks.Deck;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import logic.*;

public class MainWindow extends javax.swing.JFrame {
    DefaultListModel cDecksListModel;
    DefaultListModel aDecksListModel;
      
    public MainWindow() {
        aDecksListModel = new DefaultListModel();
        cDecksListModel = new DefaultListModel();
        initComponents();
        cDecksListbox.setModel(cDecksListModel);
        aDecksListbox.setModel(aDecksListModel);
        setTitle("Hearthstone Stats Tracker");
        setIconImage((new ImageIcon(getClass().getResource("/resources/hs_icon.png"))).getImage());
        centerWindow();
    }
    
    private void centerWindow(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width-this.getSize().width)/2,(dim.height-this.getSize().height)/2);
    }
    
    private void updateLabelGroup(JLabel winrateLabel, JLabel winsLabel, JLabel lossesLabel, String gameType){
        Logic logic = Logic.getInstance();
        try{
            winrateLabel.setText(Integer.toString(Math.round(logic.getWLPercent(gameType)))+"%");
            winsLabel.setText(Integer.toString(logic.getWins(gameType))+" W");
            lossesLabel.setText(Integer.toString(logic.getLosses(gameType))+" L");
        }catch(Exception e){
            UI.getInstance().displayError(e.getMessage());
        }
    }
    
    private void updateLabelGroup(JLabel winrateLabel, JLabel winsLabel, JLabel lossesLabel, String gameType, String key){
        Logic logic = Logic.getInstance();
        try{
            winrateLabel.setText(Integer.toString(Math.round(logic.getWLPercent(gameType, key)))+"%");
            winsLabel.setText(Integer.toString(logic.getWins(gameType, key))+" W");
            lossesLabel.setText(Integer.toString(logic.getLosses(gameType, key))+" L");
        }catch(Exception e){
            UI.getInstance().displayError(e.getMessage());
        }
    }
    
    public final void update(){
        Logic logic = Logic.getInstance();
        //overall tab updates
        updateLabelGroup(oTotalWinrateLabel, oTotalWinsLabel, oTotalLossesLabel, Logic.OVERALL);
        updateLabelGroup(oCoinWinrateLabel, oCoinWinsLabel, oCoinLossesLabel, Logic.OVERALL, Deck.COIN);
        updateLabelGroup(oNoCoinWinrateLabel, oNoCoinWinsLabel, oNoCoinLossesLabel, Logic.OVERALL, Deck.NO_COIN);
        updateLabelGroup(oDruidWinrateLabel, oDruidWinsLabel, oDruidLossesLabel, Logic.OVERALL, Deck.DRUID);
        updateLabelGroup(oHunterWinrateLabel, oHunterWinsLabel, oHunterLossesLabel, Logic.OVERALL, Deck.HUNTER);
        updateLabelGroup(oMageWinrateLabel, oMageWinsLabel, oMageLossesLabel, Logic.OVERALL, Deck.MAGE);
        updateLabelGroup(oPaladinWinrateLabel, oPaladinWinsLabel, oPaladinLossesLabel, Logic.OVERALL, Deck.PALADIN);
        updateLabelGroup(oPriestWinrateLabel, oPriestWinsLabel, oPriestLossesLabel, Logic.OVERALL, Deck.PRIEST);
        updateLabelGroup(oRogueWinrateLabel, oRogueWinsLabel, oRogueLossesLabel, Logic.OVERALL, Deck.ROGUE);
        updateLabelGroup(oShamanWinrateLabel, oShamanWinsLabel, oShamanLossesLabel, Logic.OVERALL, Deck.SHAMAN);
        updateLabelGroup(oWarlockWinrateLabel, oWarlockWinsLabel, oWarlockLossesLabel, Logic.OVERALL, Deck.WARLOCK);
        updateLabelGroup(oWarriorWinrateLabel, oWarriorWinsLabel, oWarriorLossesLabel, Logic.OVERALL, Deck.WARRIOR);
        
        //arena tab updates
        updateLabelGroup(aTotalWinrateLabel, aTotalWinsLabel, aTotalLossesLabel, Logic.ARENA);
        updateLabelGroup(aCoinWinrateLabel, aCoinWinsLabel, aCoinLossesLabel, Logic.ARENA, Deck.COIN);
        updateLabelGroup(aNoCoinWinrateLabel, aNoCoinWinsLabel, aNoCoinLossesLabel, Logic.ARENA, Deck.NO_COIN);
        updateLabelGroup(aDruidWinrateLabel, aDruidWinsLabel, aDruidLossesLabel, Logic.ARENA, Deck.DRUID);
        updateLabelGroup(aHunterWinrateLabel, aHunterWinsLabel, aHunterLossesLabel, Logic.ARENA, Deck.HUNTER);
        updateLabelGroup(aMageWinrateLabel, aMageWinsLabel, aMageLossesLabel, Logic.ARENA, Deck.MAGE);
        updateLabelGroup(aPaladinWinrateLabel, aPaladinWinsLabel, aPaladinLossesLabel, Logic.ARENA, Deck.PALADIN);
        updateLabelGroup(aPriestWinrateLabel, aPriestWinsLabel, aPriestLossesLabel, Logic.ARENA, Deck.PRIEST);
        updateLabelGroup(aRogueWinrateLabel, aRogueWinsLabel, aRogueLossesLabel, Logic.ARENA, Deck.ROGUE);
        updateLabelGroup(aShamanWinrateLabel, aShamanWinsLabel, aShamanLossesLabel, Logic.ARENA, Deck.SHAMAN);
        updateLabelGroup(aWarlockWinrateLabel, aWarlockWinsLabel, aWarlockLossesLabel, Logic.ARENA, Deck.WARLOCK);
        updateLabelGroup(aWarriorWinrateLabel, aWarriorWinsLabel, aWarriorLossesLabel, Logic.ARENA, Deck.WARRIOR);
        
        aDecksListModel.clear();
        for(Deck deck : logic.getArenaDecks())
            aDecksListModel.addElement(deck);
            
        //constructed tab updates
        updateLabelGroup(cTotalWinrateLabel, cTotalWinsLabel, cTotalLossesLabel, Logic.CONSTRUCTED);
        updateLabelGroup(cCoinWinrateLabel, cCoinWinsLabel, cCoinLossesLabel, Logic.CONSTRUCTED, Deck.COIN);
        updateLabelGroup(cNoCoinWinrateLabel, cNoCoinWinsLabel, cNoCoinLossesLabel, Logic.CONSTRUCTED, Deck.NO_COIN);
        updateLabelGroup(cDruidWinrateLabel, cDruidWinsLabel, cDruidLossesLabel, Logic.CONSTRUCTED, Deck.DRUID);
        updateLabelGroup(cHunterWinrateLabel, cHunterWinsLabel, cHunterLossesLabel, Logic.CONSTRUCTED, Deck.HUNTER);
        updateLabelGroup(cMageWinrateLabel, cMageWinsLabel, cMageLossesLabel, Logic.CONSTRUCTED, Deck.MAGE);
        updateLabelGroup(cPaladinWinrateLabel, cPaladinWinsLabel, cPaladinLossesLabel, Logic.CONSTRUCTED, Deck.PALADIN);
        updateLabelGroup(cPriestWinrateLabel, cPriestWinsLabel, cPriestLossesLabel, Logic.CONSTRUCTED, Deck.PRIEST);
        updateLabelGroup(cRogueWinrateLabel, cRogueWinsLabel, cRogueLossesLabel, Logic.CONSTRUCTED, Deck.ROGUE);
        updateLabelGroup(cShamanWinrateLabel, cShamanWinsLabel, cShamanLossesLabel, Logic.CONSTRUCTED, Deck.SHAMAN);
        updateLabelGroup(cWarlockWinrateLabel, cWarlockWinsLabel, cWarlockLossesLabel, Logic.CONSTRUCTED, Deck.WARLOCK);
        updateLabelGroup(cWarriorWinrateLabel, cWarriorWinsLabel, cWarriorLossesLabel, Logic.CONSTRUCTED, Deck.WARRIOR);
        
        cDecksListModel.clear();
        for(Deck deck : logic.getConstructedDecks())
            cDecksListModel.addElement(deck);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aDecksPopupMenu = new javax.swing.JPopupMenu();
        aOpenDeckMenuItem = new javax.swing.JMenuItem();
        aSeparator = new javax.swing.JPopupMenu.Separator();
        aAddDeckMenuItem = new javax.swing.JMenuItem();
        aDeleteDeckMenuItem = new javax.swing.JMenuItem();
        cDecksPopupMenu = new javax.swing.JPopupMenu();
        cOpenDeck = new javax.swing.JMenuItem();
        cSeparator = new javax.swing.JPopupMenu.Separator();
        cAddDeckMenuItem = new javax.swing.JMenuItem();
        cDeleteDeckMenuItem = new javax.swing.JMenuItem();
        tabbedPane = new javax.swing.JTabbedPane();
        oPanel = new javax.swing.JPanel();
        oGeneralLabel = new javax.swing.JLabel();
        oGeneralPane = new javax.swing.JLayeredPane();
        oTotalWinrateLabel = new javax.swing.JLabel();
        oTotalWinsLabel = new javax.swing.JLabel();
        oTotalLossesLabel = new javax.swing.JLabel();
        oTotalWinPercentageLabel = new javax.swing.JLabel();
        oCoinButton = new javax.swing.JButton();
        oCoinWinsLabel = new javax.swing.JLabel();
        oCoinLossesLabel = new javax.swing.JLabel();
        oCoinWinrateLabel = new javax.swing.JLabel();
        oNoCoinButton = new javax.swing.JButton();
        oNoCoinWinsLabel = new javax.swing.JLabel();
        oNoCoinLossesLabel = new javax.swing.JLabel();
        oNoCoinWinrateLabel = new javax.swing.JLabel();
        oClassesLabel = new javax.swing.JLabel();
        oClassesPane = new javax.swing.JLayeredPane();
        oDruidButton = new javax.swing.JButton();
        oDruidWinsLabel = new javax.swing.JLabel();
        oDruidLossesLabel = new javax.swing.JLabel();
        oDruidWinrateLabel = new javax.swing.JLabel();
        oHunterButton = new javax.swing.JButton();
        oHunterWinsLabel = new javax.swing.JLabel();
        oHunterLossesLabel = new javax.swing.JLabel();
        oHunterWinrateLabel = new javax.swing.JLabel();
        oMageButton = new javax.swing.JButton();
        oMageWinsLabel = new javax.swing.JLabel();
        oMageLossesLabel = new javax.swing.JLabel();
        oMageWinrateLabel = new javax.swing.JLabel();
        oPaladinButton = new javax.swing.JButton();
        oPaladinWinsLabel = new javax.swing.JLabel();
        oPaladinLossesLabel = new javax.swing.JLabel();
        oPaladinWinrateLabel = new javax.swing.JLabel();
        oPriestButton = new javax.swing.JButton();
        oPriestWinsLabel = new javax.swing.JLabel();
        oPriestLossesLabel = new javax.swing.JLabel();
        oPriestWinrateLabel = new javax.swing.JLabel();
        oRogueButton = new javax.swing.JButton();
        oRogueWinsLabel = new javax.swing.JLabel();
        oRogueLossesLabel = new javax.swing.JLabel();
        oRogueWinrateLabel = new javax.swing.JLabel();
        oShamanButton = new javax.swing.JButton();
        oShamanWinsLabel = new javax.swing.JLabel();
        oShamanLossesLabel = new javax.swing.JLabel();
        oShamanWinrateLabel = new javax.swing.JLabel();
        oWarlockButton = new javax.swing.JButton();
        oWarlockWinsLabel = new javax.swing.JLabel();
        oWarlockLossesLabel = new javax.swing.JLabel();
        oWarlockWinrateLabel = new javax.swing.JLabel();
        oWarriorButton = new javax.swing.JButton();
        oWarriorWinsLabel = new javax.swing.JLabel();
        oWarriorLossesLabel = new javax.swing.JLabel();
        oWarriorWinrateLabel = new javax.swing.JLabel();
        oAccoladesLabel = new javax.swing.JLabel();
        oAccoladesPane = new javax.swing.JPanel();
        oMostPlayedLabel = new javax.swing.JLabel();
        oArenaLabel = new javax.swing.JLabel();
        oMostPlayedArenaButton = new javax.swing.JButton();
        oMostPlayedArenaLabel = new javax.swing.JLabel();
        oConstrucedLabel = new javax.swing.JLabel();
        oMostPlayedConstructedButton = new javax.swing.JButton();
        oMostPlayedConstructedLabel = new javax.swing.JLabel();
        oBestPerformanceLabel = new javax.swing.JLabel();
        oArenaLabel1 = new javax.swing.JLabel();
        oBestPerformanceArenaButton = new javax.swing.JButton();
        oBestPerformanceArenaLabel = new javax.swing.JLabel();
        oConstructedLabel1 = new javax.swing.JLabel();
        oBestPerformanceConstrcutedButton = new javax.swing.JButton();
        oBestPerformanceConstructedLabel = new javax.swing.JLabel();
        oMaxArenaWinsLabel = new javax.swing.JLabel();
        oMaxArenaWinsNumberLabel = new javax.swing.JLabel();
        aPanel = new javax.swing.JPanel();
        aGeneralLabel = new javax.swing.JLabel();
        aGeneralPane = new javax.swing.JLayeredPane();
        aTotalWinrateLabel = new javax.swing.JLabel();
        aTotalWinsLabel = new javax.swing.JLabel();
        aTotalLossesLabel = new javax.swing.JLabel();
        aTotalWinPercentageLabel = new javax.swing.JLabel();
        aCoinButton = new javax.swing.JButton();
        aCoinWinsLabel = new javax.swing.JLabel();
        aCoinLossesLabel = new javax.swing.JLabel();
        aCoinWinrateLabel = new javax.swing.JLabel();
        aNoCoinButton = new javax.swing.JButton();
        aNoCoinWinsLabel = new javax.swing.JLabel();
        aNoCoinLossesLabel = new javax.swing.JLabel();
        aNoCoinWinrateLabel = new javax.swing.JLabel();
        aClassesLabel = new javax.swing.JLabel();
        aClassesPane = new javax.swing.JLayeredPane();
        aDruidButton = new javax.swing.JButton();
        aDruidWinsLabel = new javax.swing.JLabel();
        aDruidLossesLabel = new javax.swing.JLabel();
        aDruidWinrateLabel = new javax.swing.JLabel();
        aHunterButton = new javax.swing.JButton();
        aHunterWinsLabel = new javax.swing.JLabel();
        aHunterLossesLabel = new javax.swing.JLabel();
        aHunterWinrateLabel = new javax.swing.JLabel();
        aMageButton = new javax.swing.JButton();
        aMageWinsLabel = new javax.swing.JLabel();
        aMageLossesLabel = new javax.swing.JLabel();
        aMageWinrateLabel = new javax.swing.JLabel();
        aPaladinButton = new javax.swing.JButton();
        aPaladinWinsLabel = new javax.swing.JLabel();
        aPaladinLossesLabel = new javax.swing.JLabel();
        aPaladinWinrateLabel = new javax.swing.JLabel();
        aPriestButton = new javax.swing.JButton();
        aPriestWinsLabel = new javax.swing.JLabel();
        aPriestLossesLabel = new javax.swing.JLabel();
        aPriestWinrateLabel = new javax.swing.JLabel();
        aRogueButton = new javax.swing.JButton();
        aRogueWinsLabel = new javax.swing.JLabel();
        aRogueLossesLabel = new javax.swing.JLabel();
        aRogueWinrateLabel = new javax.swing.JLabel();
        aShamanButton = new javax.swing.JButton();
        aShamanWinsLabel = new javax.swing.JLabel();
        aShamanLossesLabel = new javax.swing.JLabel();
        aShamanWinrateLabel = new javax.swing.JLabel();
        aWarlockButton = new javax.swing.JButton();
        aWarlockWinsLabel = new javax.swing.JLabel();
        aWarlockLossesLabel = new javax.swing.JLabel();
        aWarlockWinrateLabel = new javax.swing.JLabel();
        aWarriorButton = new javax.swing.JButton();
        aWarriorWinsLabel = new javax.swing.JLabel();
        aWarriorLossesLabel = new javax.swing.JLabel();
        aWarriorWinrateLabel = new javax.swing.JLabel();
        aRunsLabel = new javax.swing.JLabel();
        aDecksScrollPane = new javax.swing.JScrollPane();
        aDecksListbox = new javax.swing.JList();
        cPanel = new javax.swing.JPanel();
        cGeneralLabel = new javax.swing.JLabel();
        cGeneralPane = new javax.swing.JLayeredPane();
        cTotalWinrateLabel = new javax.swing.JLabel();
        cTotalWinsLabel = new javax.swing.JLabel();
        cTotalLossesLabel = new javax.swing.JLabel();
        cTotalWinPercentageLabel = new javax.swing.JLabel();
        cCoinButton = new javax.swing.JButton();
        cCoinWinsLabel = new javax.swing.JLabel();
        cCoinLossesLabel = new javax.swing.JLabel();
        cCoinWinrateLabel = new javax.swing.JLabel();
        cNoCoinButton = new javax.swing.JButton();
        cNoCoinWinsLabel = new javax.swing.JLabel();
        cNoCoinLossesLabel = new javax.swing.JLabel();
        cNoCoinWinrateLabel = new javax.swing.JLabel();
        cClassesLabel = new javax.swing.JLabel();
        cClassesPane = new javax.swing.JLayeredPane();
        cDruidButton = new javax.swing.JButton();
        cDruidWinsLabel = new javax.swing.JLabel();
        cDruidLossesLabel = new javax.swing.JLabel();
        cDruidWinrateLabel = new javax.swing.JLabel();
        cHunterButton = new javax.swing.JButton();
        cHunterWinsLabel = new javax.swing.JLabel();
        cHunterLossesLabel = new javax.swing.JLabel();
        cHunterWinrateLabel = new javax.swing.JLabel();
        cMageButton = new javax.swing.JButton();
        cMageWinsLabel = new javax.swing.JLabel();
        cMageLossesLabel = new javax.swing.JLabel();
        cMageWinrateLabel = new javax.swing.JLabel();
        cPaladinButton = new javax.swing.JButton();
        cPaladinWinsLabel = new javax.swing.JLabel();
        cPaladinLossesLabel = new javax.swing.JLabel();
        cPaladinWinrateLabel = new javax.swing.JLabel();
        cPriestButton = new javax.swing.JButton();
        cPriestWinsLabel = new javax.swing.JLabel();
        cPriestLossesLabel = new javax.swing.JLabel();
        cPriestWinrateLabel = new javax.swing.JLabel();
        cRogueButton = new javax.swing.JButton();
        cRogueWinsLabel = new javax.swing.JLabel();
        cRogueLossesLabel = new javax.swing.JLabel();
        cRogueWinrateLabel = new javax.swing.JLabel();
        cShamanButton = new javax.swing.JButton();
        cShamanWinsLabel = new javax.swing.JLabel();
        cShamanLossesLabel = new javax.swing.JLabel();
        cShamanWinrateLabel = new javax.swing.JLabel();
        cWarlockButton = new javax.swing.JButton();
        cWarlockWinsLabel = new javax.swing.JLabel();
        cWarlockLossesLabel = new javax.swing.JLabel();
        cWarlockWinrateLabel = new javax.swing.JLabel();
        cWarriorButton = new javax.swing.JButton();
        cWarriorWinsLabel = new javax.swing.JLabel();
        cWarriorLossesLabel = new javax.swing.JLabel();
        cWarriorWinrateLabel = new javax.swing.JLabel();
        cDecksLabel = new javax.swing.JLabel();
        cDecksScrollPane = new javax.swing.JScrollPane();
        cDecksListbox = new javax.swing.JList();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        aOpenDeckMenuItem.setText("Open Selected Deck");
        aOpenDeckMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aOpenDeckMenuItemActionPerformed(evt);
            }
        });
        aDecksPopupMenu.add(aOpenDeckMenuItem);
        aDecksPopupMenu.add(aSeparator);

        aAddDeckMenuItem.setText("Add Deck");
        aAddDeckMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aAddDeckMenuItemActionPerformed(evt);
            }
        });
        aDecksPopupMenu.add(aAddDeckMenuItem);

        aDeleteDeckMenuItem.setText("Delete Selected Deck");
        aDeleteDeckMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aDeleteDeckMenuItemActionPerformed(evt);
            }
        });
        aDecksPopupMenu.add(aDeleteDeckMenuItem);

        cOpenDeck.setText("Open Selected Deck");
        cOpenDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cOpenDeckActionPerformed(evt);
            }
        });
        cDecksPopupMenu.add(cOpenDeck);
        cDecksPopupMenu.add(cSeparator);

        cAddDeckMenuItem.setText("Add Deck");
        cAddDeckMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAddDeckMenuItemActionPerformed(evt);
            }
        });
        cDecksPopupMenu.add(cAddDeckMenuItem);

        cDeleteDeckMenuItem.setText("Delete Selected Deck");
        cDeleteDeckMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDeleteDeckMenuItemActionPerformed(evt);
            }
        });
        cDecksPopupMenu.add(cDeleteDeckMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hearthstone Stat Tracker");

        tabbedPane.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabbedPane.setFont(new java.awt.Font("Belwe Bd BT", 0, 11)); // NOI18N

        oGeneralLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oGeneralLabel.setText("General:");

        oGeneralPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        oTotalWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 36)); // NOI18N
        oTotalWinrateLabel.setForeground(new java.awt.Color(0, 153, 51));
        oTotalWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oTotalWinrateLabel.setText("54%");

        oTotalWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oTotalWinsLabel.setText("12 W");

        oTotalLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oTotalLossesLabel.setText("11 L");

        oTotalWinPercentageLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oTotalWinPercentageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oTotalWinPercentageLabel.setText("Win %");

        oCoinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/coin.png"))); // NOI18N
        oCoinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oCoinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oCoinWinsLabel.setText("12 W");

        oCoinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oCoinLossesLabel.setText("11 L");

        oCoinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oCoinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oCoinWinrateLabel.setText("54%");

        oNoCoinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/no_coin.png"))); // NOI18N
        oNoCoinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oNoCoinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oNoCoinWinsLabel.setText("12 W");

        oNoCoinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oNoCoinLossesLabel.setText("11 L");

        oNoCoinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oNoCoinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oNoCoinWinrateLabel.setText("54%");

        javax.swing.GroupLayout oGeneralPaneLayout = new javax.swing.GroupLayout(oGeneralPane);
        oGeneralPane.setLayout(oGeneralPaneLayout);
        oGeneralPaneLayout.setHorizontalGroup(
            oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oGeneralPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                        .addComponent(oTotalWinrateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oTotalLossesLabel)
                            .addComponent(oTotalWinsLabel)))
                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(oTotalWinPercentageLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(oCoinWinrateLabel))
                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                        .addComponent(oCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oCoinWinsLabel)
                            .addComponent(oCoinLossesLabel))))
                .addGap(31, 31, 31)
                .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                        .addComponent(oNoCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oNoCoinWinsLabel)
                            .addComponent(oNoCoinLossesLabel)))
                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(oNoCoinWinrateLabel)))
                .addGap(26, 26, 26))
        );
        oGeneralPaneLayout.setVerticalGroup(
            oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oGeneralPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                        .addComponent(oTotalWinrateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(oTotalWinPercentageLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oGeneralPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oGeneralPaneLayout.createSequentialGroup()
                                .addComponent(oCoinWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oCoinLossesLabel))
                            .addComponent(oCoinButton, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oCoinWinrateLabel))
                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                        .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(oGeneralPaneLayout.createSequentialGroup()
                                .addGroup(oGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(oGeneralPaneLayout.createSequentialGroup()
                                        .addComponent(oNoCoinWinsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(oNoCoinLossesLabel))
                                    .addComponent(oNoCoinButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oNoCoinWinrateLabel))
                            .addGroup(oGeneralPaneLayout.createSequentialGroup()
                                .addComponent(oTotalWinsLabel)
                                .addGap(18, 18, 18)
                                .addComponent(oTotalLossesLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        oGeneralPane.setLayer(oTotalWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oTotalWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oTotalLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oTotalWinPercentageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oCoinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oCoinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oCoinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oCoinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oNoCoinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oNoCoinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oNoCoinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oGeneralPane.setLayer(oNoCoinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        oClassesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oClassesLabel.setText("Class Performance:");

        oClassesPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        oDruidButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/druid_icon.png"))); // NOI18N
        oDruidButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oDruidWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oDruidWinsLabel.setText("12 W");

        oDruidLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oDruidLossesLabel.setText("11 L");

        oDruidWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oDruidWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oDruidWinrateLabel.setText("54%");

        oHunterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hunter_icon.png"))); // NOI18N
        oHunterButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oHunterWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oHunterWinsLabel.setText("12 W");

        oHunterLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oHunterLossesLabel.setText("11 L");

        oHunterWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oHunterWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oHunterWinrateLabel.setText("54%");

        oMageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mage_icon.png"))); // NOI18N
        oMageButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oMageWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oMageWinsLabel.setText("12 W");

        oMageLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oMageLossesLabel.setText("11 L");

        oMageWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oMageWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oMageWinrateLabel.setText("54%");

        oPaladinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/paladin_icon.png"))); // NOI18N
        oPaladinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oPaladinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oPaladinWinsLabel.setText("12 W");

        oPaladinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oPaladinLossesLabel.setText("11 L");

        oPaladinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oPaladinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oPaladinWinrateLabel.setText("54%");

        oPriestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/priest_icon.png"))); // NOI18N
        oPriestButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oPriestWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oPriestWinsLabel.setText("12 W");

        oPriestLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oPriestLossesLabel.setText("11 L");

        oPriestWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oPriestWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oPriestWinrateLabel.setText("54%");

        oRogueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/rogue_icon.png"))); // NOI18N
        oRogueButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oRogueWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oRogueWinsLabel.setText("12 W");

        oRogueLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oRogueLossesLabel.setText("11 L");

        oRogueWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oRogueWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oRogueWinrateLabel.setText("54%");

        oShamanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shaman_icon.png"))); // NOI18N
        oShamanButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oShamanWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oShamanWinsLabel.setText("12 W");

        oShamanLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oShamanLossesLabel.setText("11 L");

        oShamanWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oShamanWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oShamanWinrateLabel.setText("54%");

        oWarlockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warlock_icon.png"))); // NOI18N
        oWarlockButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oWarlockWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oWarlockWinsLabel.setText("12 W");

        oWarlockLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oWarlockLossesLabel.setText("11 L");

        oWarlockWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oWarlockWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oWarlockWinrateLabel.setText("54%");

        oWarriorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warrior_icon.png"))); // NOI18N
        oWarriorButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oWarriorWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oWarriorWinsLabel.setText("12 W");

        oWarriorLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oWarriorLossesLabel.setText("11 L");

        oWarriorWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oWarriorWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oWarriorWinrateLabel.setText("54%");

        javax.swing.GroupLayout oClassesPaneLayout = new javax.swing.GroupLayout(oClassesPane);
        oClassesPane.setLayout(oClassesPaneLayout);
        oClassesPaneLayout.setHorizontalGroup(
            oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oClassesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oDruidButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oDruidLossesLabel)
                            .addComponent(oDruidWinsLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oPaladinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oPaladinLossesLabel)
                            .addComponent(oPaladinWinsLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oShamanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oShamanLossesLabel)
                            .addComponent(oShamanWinsLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oPaladinWinrateLabel)
                            .addComponent(oDruidWinrateLabel)
                            .addComponent(oShamanWinrateLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oPriestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oPriestLossesLabel)
                            .addComponent(oPriestWinsLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oHunterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oHunterLossesLabel)
                            .addComponent(oHunterWinsLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oWarlockButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oWarlockWinsLabel)
                            .addComponent(oWarlockLossesLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oWarlockWinrateLabel)
                            .addComponent(oHunterWinrateLabel)
                            .addComponent(oPriestWinrateLabel))))
                .addGap(27, 27, 27)
                .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oRogueButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oRogueLossesLabel)
                            .addComponent(oRogueWinsLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oWarriorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oWarriorLossesLabel)
                            .addComponent(oWarriorWinsLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oMageWinrateLabel)
                            .addComponent(oRogueWinrateLabel)
                            .addComponent(oWarriorWinrateLabel)))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addComponent(oMageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oMageLossesLabel)
                            .addComponent(oMageWinsLabel))))
                .addGap(27, 27, 27))
        );
        oClassesPaneLayout.setVerticalGroup(
            oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oClassesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oDruidWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oDruidLossesLabel))
                            .addComponent(oDruidButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oDruidWinrateLabel))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oHunterWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oHunterLossesLabel))
                            .addComponent(oHunterButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oHunterWinrateLabel))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oMageWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oMageLossesLabel))
                            .addComponent(oMageButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oMageWinrateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oPaladinWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oPaladinLossesLabel))
                            .addComponent(oPaladinButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oPaladinWinrateLabel))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oPriestWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oPriestLossesLabel))
                            .addComponent(oPriestButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oPriestWinrateLabel))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oRogueWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oRogueLossesLabel))
                            .addComponent(oRogueButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oRogueWinrateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oShamanWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oShamanLossesLabel))
                            .addComponent(oShamanButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oShamanWinrateLabel))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oWarlockWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oWarlockLossesLabel))
                            .addComponent(oWarlockButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oWarlockWinrateLabel))
                    .addGroup(oClassesPaneLayout.createSequentialGroup()
                        .addGroup(oClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(oClassesPaneLayout.createSequentialGroup()
                                .addComponent(oWarriorWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(oWarriorLossesLabel))
                            .addComponent(oWarriorButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oWarriorWinrateLabel)))
                .addContainerGap())
        );
        oClassesPane.setLayer(oDruidButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oDruidWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oDruidLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oDruidWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oHunterButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oHunterWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oHunterLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oHunterWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oMageButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oMageWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oMageLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oMageWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oPaladinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oPaladinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oPaladinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oPaladinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oPriestButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oPriestWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oPriestLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oPriestWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oRogueButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oRogueWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oRogueLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oRogueWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oShamanButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oShamanWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oShamanLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oShamanWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oWarlockButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oWarlockWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oWarlockLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oWarlockWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oWarriorButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oWarriorWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oWarriorLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        oClassesPane.setLayer(oWarriorWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        oAccoladesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oAccoladesLabel.setText("Accolades:");

        oAccoladesPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        oMostPlayedLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oMostPlayedLabel.setText("Most Played:");

        oArenaLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 17)); // NOI18N
        oArenaLabel.setText("Arena");

        oMostPlayedArenaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hunter_icon.png"))); // NOI18N
        oMostPlayedArenaButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oMostPlayedArenaLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oMostPlayedArenaLabel.setText("123 Games");

        oConstrucedLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oConstrucedLabel.setText("Constructed");

        oMostPlayedConstructedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hunter_icon.png"))); // NOI18N
        oMostPlayedConstructedButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oMostPlayedConstructedLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oMostPlayedConstructedLabel.setText("123 Games");

        oBestPerformanceLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oBestPerformanceLabel.setText("Best Performance:");

        oArenaLabel1.setFont(new java.awt.Font("Belwe Bd BT", 0, 17)); // NOI18N
        oArenaLabel1.setText("Arena");

        oBestPerformanceArenaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hunter_icon.png"))); // NOI18N
        oBestPerformanceArenaButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oBestPerformanceArenaLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oBestPerformanceArenaLabel.setText("50 Win %");

        oConstructedLabel1.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        oConstructedLabel1.setText("Constructed");

        oBestPerformanceConstrcutedButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hunter_icon.png"))); // NOI18N
        oBestPerformanceConstrcutedButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        oBestPerformanceConstructedLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oBestPerformanceConstructedLabel.setText("50 Win %");

        oMaxArenaWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        oMaxArenaWinsLabel.setText("Max. Arena Wins:");

        oMaxArenaWinsNumberLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 40)); // NOI18N
        oMaxArenaWinsNumberLabel.setText("12");

        javax.swing.GroupLayout oAccoladesPaneLayout = new javax.swing.GroupLayout(oAccoladesPane);
        oAccoladesPane.setLayout(oAccoladesPaneLayout);
        oAccoladesPaneLayout.setHorizontalGroup(
            oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(oBestPerformanceArenaButton)
                                    .addComponent(oArenaLabel1))
                                .addGap(19, 19, 19))
                            .addComponent(oBestPerformanceArenaLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(oBestPerformanceConstrcutedButton))
                            .addComponent(oBestPerformanceConstructedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oConstructedLabel1)))
                    .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oMostPlayedLabel)
                            .addComponent(oBestPerformanceLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oAccoladesPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oMostPlayedArenaButton)
                            .addComponent(oArenaLabel)))
                    .addComponent(oMostPlayedArenaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(oMostPlayedConstructedButton))
                    .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(oConstrucedLabel))
                    .addComponent(oMostPlayedConstructedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oMaxArenaWinsLabel)
                    .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(oMaxArenaWinsNumberLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        oAccoladesPaneLayout.setVerticalGroup(
            oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oAccoladesPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(oMostPlayedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oArenaLabel)
                    .addComponent(oConstrucedLabel))
                .addGap(2, 2, 2)
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oMostPlayedArenaButton)
                    .addComponent(oMostPlayedConstructedButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oMostPlayedArenaLabel)
                    .addComponent(oMostPlayedConstructedLabel))
                .addGap(18, 18, 18)
                .addComponent(oBestPerformanceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oArenaLabel1)
                    .addComponent(oConstructedLabel1))
                .addGap(2, 2, 2)
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oBestPerformanceArenaButton)
                    .addComponent(oBestPerformanceConstrcutedButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(oAccoladesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oBestPerformanceConstructedLabel)
                    .addComponent(oBestPerformanceArenaLabel))
                .addGap(18, 18, 18)
                .addComponent(oMaxArenaWinsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oMaxArenaWinsNumberLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout oPanelLayout = new javax.swing.GroupLayout(oPanel);
        oPanel.setLayout(oPanelLayout);
        oPanelLayout.setHorizontalGroup(
            oPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(oClassesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oGeneralLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oGeneralPane)
                    .addComponent(oClassesPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(oPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oPanelLayout.createSequentialGroup()
                        .addComponent(oAccoladesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(oAccoladesPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        oPanelLayout.setVerticalGroup(
            oPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oGeneralLabel)
                    .addComponent(oAccoladesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(oPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(oPanelLayout.createSequentialGroup()
                        .addComponent(oGeneralPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oClassesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oClassesPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(oAccoladesPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tabbedPane.addTab("<html><body leftmargin=15 topmargin=10 marginwidth=15 marginheight=73>Overall</body></html>", oPanel);

        aGeneralLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aGeneralLabel.setText("General:");

        aGeneralPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        aTotalWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 36)); // NOI18N
        aTotalWinrateLabel.setForeground(new java.awt.Color(0, 153, 51));
        aTotalWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aTotalWinrateLabel.setText("54%");

        aTotalWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aTotalWinsLabel.setText("12 W");

        aTotalLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aTotalLossesLabel.setText("11 L");

        aTotalWinPercentageLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aTotalWinPercentageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aTotalWinPercentageLabel.setText("Win %");

        aCoinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/coin.png"))); // NOI18N
        aCoinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aCoinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aCoinWinsLabel.setText("12 W");

        aCoinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aCoinLossesLabel.setText("11 L");

        aCoinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aCoinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aCoinWinrateLabel.setText("54%");

        aNoCoinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/no_coin.png"))); // NOI18N
        aNoCoinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aNoCoinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aNoCoinWinsLabel.setText("12 W");

        aNoCoinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aNoCoinLossesLabel.setText("11 L");

        aNoCoinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aNoCoinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aNoCoinWinrateLabel.setText("54%");

        javax.swing.GroupLayout aGeneralPaneLayout = new javax.swing.GroupLayout(aGeneralPane);
        aGeneralPane.setLayout(aGeneralPaneLayout);
        aGeneralPaneLayout.setHorizontalGroup(
            aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aGeneralPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                        .addComponent(aTotalWinrateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aTotalLossesLabel)
                            .addComponent(aTotalWinsLabel)))
                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(aTotalWinPercentageLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(aCoinWinrateLabel))
                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                        .addComponent(aCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aCoinWinsLabel)
                            .addComponent(aCoinLossesLabel))))
                .addGap(31, 31, 31)
                .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                        .addComponent(aNoCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aNoCoinWinsLabel)
                            .addComponent(aNoCoinLossesLabel)))
                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(aNoCoinWinrateLabel)))
                .addGap(26, 26, 26))
        );
        aGeneralPaneLayout.setVerticalGroup(
            aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aGeneralPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                        .addComponent(aTotalWinrateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aTotalWinPercentageLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aGeneralPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aGeneralPaneLayout.createSequentialGroup()
                                .addComponent(aCoinWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aCoinLossesLabel))
                            .addComponent(aCoinButton, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aCoinWinrateLabel))
                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                        .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aGeneralPaneLayout.createSequentialGroup()
                                .addGroup(aGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(aGeneralPaneLayout.createSequentialGroup()
                                        .addComponent(aNoCoinWinsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(aNoCoinLossesLabel))
                                    .addComponent(aNoCoinButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aNoCoinWinrateLabel))
                            .addGroup(aGeneralPaneLayout.createSequentialGroup()
                                .addComponent(aTotalWinsLabel)
                                .addGap(18, 18, 18)
                                .addComponent(aTotalLossesLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        aGeneralPane.setLayer(aTotalWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aTotalWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aTotalLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aTotalWinPercentageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aCoinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aCoinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aCoinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aCoinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aNoCoinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aNoCoinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aNoCoinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aGeneralPane.setLayer(aNoCoinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        aClassesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aClassesLabel.setText("Class Performance:");

        aClassesPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        aDruidButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/druid_icon.png"))); // NOI18N
        aDruidButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aDruidWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aDruidWinsLabel.setText("12 W");

        aDruidLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aDruidLossesLabel.setText("11 L");

        aDruidWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aDruidWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aDruidWinrateLabel.setText("54%");

        aHunterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hunter_icon.png"))); // NOI18N
        aHunterButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aHunterWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aHunterWinsLabel.setText("12 W");

        aHunterLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aHunterLossesLabel.setText("11 L");

        aHunterWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aHunterWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aHunterWinrateLabel.setText("54%");

        aMageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mage_icon.png"))); // NOI18N
        aMageButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aMageWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aMageWinsLabel.setText("12 W");

        aMageLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aMageLossesLabel.setText("11 L");

        aMageWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aMageWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aMageWinrateLabel.setText("54%");

        aPaladinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/paladin_icon.png"))); // NOI18N
        aPaladinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aPaladinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aPaladinWinsLabel.setText("12 W");

        aPaladinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aPaladinLossesLabel.setText("11 L");

        aPaladinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aPaladinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aPaladinWinrateLabel.setText("54%");

        aPriestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/priest_icon.png"))); // NOI18N
        aPriestButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aPriestWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aPriestWinsLabel.setText("12 W");

        aPriestLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aPriestLossesLabel.setText("11 L");

        aPriestWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aPriestWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aPriestWinrateLabel.setText("54%");

        aRogueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/rogue_icon.png"))); // NOI18N
        aRogueButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aRogueWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aRogueWinsLabel.setText("12 W");

        aRogueLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aRogueLossesLabel.setText("11 L");

        aRogueWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aRogueWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aRogueWinrateLabel.setText("54%");

        aShamanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shaman_icon.png"))); // NOI18N
        aShamanButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aShamanWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aShamanWinsLabel.setText("12 W");

        aShamanLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aShamanLossesLabel.setText("11 L");

        aShamanWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aShamanWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aShamanWinrateLabel.setText("54%");

        aWarlockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warlock_icon.png"))); // NOI18N
        aWarlockButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aWarlockWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aWarlockWinsLabel.setText("12 W");

        aWarlockLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aWarlockLossesLabel.setText("11 L");

        aWarlockWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aWarlockWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aWarlockWinrateLabel.setText("54%");

        aWarriorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warrior_icon.png"))); // NOI18N
        aWarriorButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        aWarriorWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aWarriorWinsLabel.setText("12 W");

        aWarriorLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aWarriorLossesLabel.setText("11 L");

        aWarriorWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aWarriorWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aWarriorWinrateLabel.setText("54%");

        javax.swing.GroupLayout aClassesPaneLayout = new javax.swing.GroupLayout(aClassesPane);
        aClassesPane.setLayout(aClassesPaneLayout);
        aClassesPaneLayout.setHorizontalGroup(
            aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aClassesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aDruidButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aDruidLossesLabel)
                            .addComponent(aDruidWinsLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aPaladinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aPaladinLossesLabel)
                            .addComponent(aPaladinWinsLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aShamanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aShamanLossesLabel)
                            .addComponent(aShamanWinsLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aPaladinWinrateLabel)
                            .addComponent(aDruidWinrateLabel)
                            .addComponent(aShamanWinrateLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aPriestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aPriestLossesLabel)
                            .addComponent(aPriestWinsLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aHunterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aHunterLossesLabel)
                            .addComponent(aHunterWinsLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aWarlockButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aWarlockWinsLabel)
                            .addComponent(aWarlockLossesLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aWarlockWinrateLabel)
                            .addComponent(aHunterWinrateLabel)
                            .addComponent(aPriestWinrateLabel))))
                .addGap(27, 27, 27)
                .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aRogueButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aRogueLossesLabel)
                            .addComponent(aRogueWinsLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aWarriorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aWarriorLossesLabel)
                            .addComponent(aWarriorWinsLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aMageWinrateLabel)
                            .addComponent(aRogueWinrateLabel)
                            .addComponent(aWarriorWinrateLabel)))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addComponent(aMageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aMageLossesLabel)
                            .addComponent(aMageWinsLabel))))
                .addGap(27, 27, 27))
        );
        aClassesPaneLayout.setVerticalGroup(
            aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aClassesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aDruidWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aDruidLossesLabel))
                            .addComponent(aDruidButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aDruidWinrateLabel))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aHunterWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aHunterLossesLabel))
                            .addComponent(aHunterButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aHunterWinrateLabel))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aMageWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aMageLossesLabel))
                            .addComponent(aMageButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aMageWinrateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aPaladinWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aPaladinLossesLabel))
                            .addComponent(aPaladinButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aPaladinWinrateLabel))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aPriestWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aPriestLossesLabel))
                            .addComponent(aPriestButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aPriestWinrateLabel))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aRogueWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aRogueLossesLabel))
                            .addComponent(aRogueButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aRogueWinrateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aShamanWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aShamanLossesLabel))
                            .addComponent(aShamanButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aShamanWinrateLabel))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aWarlockWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aWarlockLossesLabel))
                            .addComponent(aWarlockButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aWarlockWinrateLabel))
                    .addGroup(aClassesPaneLayout.createSequentialGroup()
                        .addGroup(aClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(aClassesPaneLayout.createSequentialGroup()
                                .addComponent(aWarriorWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aWarriorLossesLabel))
                            .addComponent(aWarriorButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aWarriorWinrateLabel)))
                .addContainerGap())
        );
        aClassesPane.setLayer(aDruidButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aDruidWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aDruidLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aDruidWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aHunterButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aHunterWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aHunterLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aHunterWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aMageButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aMageWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aMageLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aMageWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aPaladinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aPaladinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aPaladinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aPaladinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aPriestButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aPriestWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aPriestLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aPriestWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aRogueButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aRogueWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aRogueLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aRogueWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aShamanButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aShamanWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aShamanLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aShamanWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aWarlockButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aWarlockWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aWarlockLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aWarlockWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aWarriorButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aWarriorWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aWarriorLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        aClassesPane.setLayer(aWarriorWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        aRunsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        aRunsLabel.setText("Runs:");

        aDecksScrollPane.setComponentPopupMenu(aDecksPopupMenu);

        aDecksListbox.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        aDecksListbox.setInheritsPopupMenu(true);
        aDecksScrollPane.setViewportView(aDecksListbox);

        javax.swing.GroupLayout aPanelLayout = new javax.swing.GroupLayout(aPanel);
        aPanel.setLayout(aPanelLayout);
        aPanelLayout.setHorizontalGroup(
            aPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aGeneralLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aClassesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aGeneralPane)
                    .addComponent(aClassesPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(aPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aDecksScrollPane)
                    .addGroup(aPanelLayout.createSequentialGroup()
                        .addComponent(aRunsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        aPanelLayout.setVerticalGroup(
            aPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aGeneralLabel)
                    .addComponent(aRunsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aPanelLayout.createSequentialGroup()
                        .addComponent(aGeneralPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aClassesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aClassesPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(aDecksScrollPane))
                .addContainerGap())
        );

        tabbedPane.addTab("<html><body leftmargin=15 topmargin=10 marginwidth=15 marginheight=73>Arena</body></html>", aPanel);

        cGeneralLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cGeneralLabel.setText("General:");

        cGeneralPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cTotalWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 36)); // NOI18N
        cTotalWinrateLabel.setForeground(new java.awt.Color(0, 153, 51));
        cTotalWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cTotalWinrateLabel.setText("54%");

        cTotalWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cTotalWinsLabel.setText("12 W");

        cTotalLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cTotalLossesLabel.setText("11 L");

        cTotalWinPercentageLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cTotalWinPercentageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cTotalWinPercentageLabel.setText("Win %");

        cCoinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/coin.png"))); // NOI18N
        cCoinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cCoinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cCoinWinsLabel.setText("12 W");

        cCoinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cCoinLossesLabel.setText("11 L");

        cCoinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cCoinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cCoinWinrateLabel.setText("54%");

        cNoCoinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/no_coin.png"))); // NOI18N
        cNoCoinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cNoCoinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cNoCoinWinsLabel.setText("12 W");

        cNoCoinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cNoCoinLossesLabel.setText("11 L");

        cNoCoinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cNoCoinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cNoCoinWinrateLabel.setText("54%");

        javax.swing.GroupLayout cGeneralPaneLayout = new javax.swing.GroupLayout(cGeneralPane);
        cGeneralPane.setLayout(cGeneralPaneLayout);
        cGeneralPaneLayout.setHorizontalGroup(
            cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cGeneralPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                        .addComponent(cTotalWinrateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cTotalLossesLabel)
                            .addComponent(cTotalWinsLabel)))
                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cTotalWinPercentageLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cCoinWinrateLabel))
                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                        .addComponent(cCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cCoinWinsLabel)
                            .addComponent(cCoinLossesLabel))))
                .addGap(31, 31, 31)
                .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                        .addComponent(cNoCoinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cNoCoinWinsLabel)
                            .addComponent(cNoCoinLossesLabel)))
                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cNoCoinWinrateLabel)))
                .addGap(26, 26, 26))
        );
        cGeneralPaneLayout.setVerticalGroup(
            cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cGeneralPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                        .addComponent(cTotalWinrateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cTotalWinPercentageLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cGeneralPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cGeneralPaneLayout.createSequentialGroup()
                                .addComponent(cCoinWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cCoinLossesLabel))
                            .addComponent(cCoinButton, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCoinWinrateLabel))
                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                        .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cGeneralPaneLayout.createSequentialGroup()
                                .addGroup(cGeneralPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(cGeneralPaneLayout.createSequentialGroup()
                                        .addComponent(cNoCoinWinsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cNoCoinLossesLabel))
                                    .addComponent(cNoCoinButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cNoCoinWinrateLabel))
                            .addGroup(cGeneralPaneLayout.createSequentialGroup()
                                .addComponent(cTotalWinsLabel)
                                .addGap(18, 18, 18)
                                .addComponent(cTotalLossesLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cGeneralPane.setLayer(cTotalWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cTotalWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cTotalLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cTotalWinPercentageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cCoinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cCoinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cCoinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cCoinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cNoCoinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cNoCoinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cNoCoinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cGeneralPane.setLayer(cNoCoinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cClassesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cClassesLabel.setText("Class Performance:");

        cClassesPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cDruidButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/druid_icon.png"))); // NOI18N
        cDruidButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cDruidWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cDruidWinsLabel.setText("12 W");

        cDruidLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cDruidLossesLabel.setText("11 L");

        cDruidWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cDruidWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cDruidWinrateLabel.setText("54%");

        cHunterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hunter_icon.png"))); // NOI18N
        cHunterButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cHunterWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cHunterWinsLabel.setText("12 W");

        cHunterLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cHunterLossesLabel.setText("11 L");

        cHunterWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cHunterWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cHunterWinrateLabel.setText("54%");

        cMageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mage_icon.png"))); // NOI18N
        cMageButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cMageWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cMageWinsLabel.setText("12 W");

        cMageLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cMageLossesLabel.setText("11 L");

        cMageWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cMageWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cMageWinrateLabel.setText("54%");

        cPaladinButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/paladin_icon.png"))); // NOI18N
        cPaladinButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cPaladinWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cPaladinWinsLabel.setText("12 W");

        cPaladinLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cPaladinLossesLabel.setText("11 L");

        cPaladinWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cPaladinWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cPaladinWinrateLabel.setText("54%");

        cPriestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/priest_icon.png"))); // NOI18N
        cPriestButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cPriestWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cPriestWinsLabel.setText("12 W");

        cPriestLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cPriestLossesLabel.setText("11 L");

        cPriestWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cPriestWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cPriestWinrateLabel.setText("54%");

        cRogueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/rogue_icon.png"))); // NOI18N
        cRogueButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cRogueWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cRogueWinsLabel.setText("12 W");

        cRogueLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cRogueLossesLabel.setText("11 L");

        cRogueWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cRogueWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cRogueWinrateLabel.setText("54%");

        cShamanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shaman_icon.png"))); // NOI18N
        cShamanButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cShamanWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cShamanWinsLabel.setText("12 W");

        cShamanLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cShamanLossesLabel.setText("11 L");

        cShamanWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cShamanWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cShamanWinrateLabel.setText("54%");

        cWarlockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warlock_icon.png"))); // NOI18N
        cWarlockButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cWarlockWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cWarlockWinsLabel.setText("12 W");

        cWarlockLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cWarlockLossesLabel.setText("11 L");

        cWarlockWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cWarlockWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cWarlockWinrateLabel.setText("54%");

        cWarriorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warrior_icon.png"))); // NOI18N
        cWarriorButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        cWarriorWinsLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cWarriorWinsLabel.setText("12 W");

        cWarriorLossesLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cWarriorLossesLabel.setText("11 L");

        cWarriorWinrateLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cWarriorWinrateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cWarriorWinrateLabel.setText("54%");

        javax.swing.GroupLayout cClassesPaneLayout = new javax.swing.GroupLayout(cClassesPane);
        cClassesPane.setLayout(cClassesPaneLayout);
        cClassesPaneLayout.setHorizontalGroup(
            cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cClassesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cDruidButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cDruidLossesLabel)
                            .addComponent(cDruidWinsLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cPaladinButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cPaladinLossesLabel)
                            .addComponent(cPaladinWinsLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cShamanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cShamanLossesLabel)
                            .addComponent(cShamanWinsLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cPaladinWinrateLabel)
                            .addComponent(cDruidWinrateLabel)
                            .addComponent(cShamanWinrateLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cPriestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cPriestLossesLabel)
                            .addComponent(cPriestWinsLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cHunterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cHunterLossesLabel)
                            .addComponent(cHunterWinsLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cWarlockButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cWarlockWinsLabel)
                            .addComponent(cWarlockLossesLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cWarlockWinrateLabel)
                            .addComponent(cHunterWinrateLabel)
                            .addComponent(cPriestWinrateLabel))))
                .addGap(27, 27, 27)
                .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cRogueButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cRogueLossesLabel)
                            .addComponent(cRogueWinsLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cWarriorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cWarriorLossesLabel)
                            .addComponent(cWarriorWinsLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cMageWinrateLabel)
                            .addComponent(cRogueWinrateLabel)
                            .addComponent(cWarriorWinrateLabel)))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addComponent(cMageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cMageLossesLabel)
                            .addComponent(cMageWinsLabel))))
                .addGap(27, 27, 27))
        );
        cClassesPaneLayout.setVerticalGroup(
            cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cClassesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cDruidWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cDruidLossesLabel))
                            .addComponent(cDruidButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cDruidWinrateLabel))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cHunterWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cHunterLossesLabel))
                            .addComponent(cHunterButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cHunterWinrateLabel))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cMageWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cMageLossesLabel))
                            .addComponent(cMageButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cMageWinrateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cPaladinWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cPaladinLossesLabel))
                            .addComponent(cPaladinButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPaladinWinrateLabel))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cPriestWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cPriestLossesLabel))
                            .addComponent(cPriestButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPriestWinrateLabel))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cRogueWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cRogueLossesLabel))
                            .addComponent(cRogueButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cRogueWinrateLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cShamanWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cShamanLossesLabel))
                            .addComponent(cShamanButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cShamanWinrateLabel))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cWarlockWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cWarlockLossesLabel))
                            .addComponent(cWarlockButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cWarlockWinrateLabel))
                    .addGroup(cClassesPaneLayout.createSequentialGroup()
                        .addGroup(cClassesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(cClassesPaneLayout.createSequentialGroup()
                                .addComponent(cWarriorWinsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cWarriorLossesLabel))
                            .addComponent(cWarriorButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cWarriorWinrateLabel)))
                .addContainerGap())
        );
        cClassesPane.setLayer(cDruidButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cDruidWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cDruidLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cDruidWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cHunterButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cHunterWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cHunterLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cHunterWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cMageButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cMageWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cMageLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cMageWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cPaladinButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cPaladinWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cPaladinLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cPaladinWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cPriestButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cPriestWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cPriestLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cPriestWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cRogueButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cRogueWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cRogueLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cRogueWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cShamanButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cShamanWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cShamanLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cShamanWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cWarlockButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cWarlockWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cWarlockLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cWarlockWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cWarriorButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cWarriorWinsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cWarriorLossesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        cClassesPane.setLayer(cWarriorWinrateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cDecksLabel.setFont(new java.awt.Font("Belwe Bd BT", 0, 18)); // NOI18N
        cDecksLabel.setText("Decks:");

        cDecksScrollPane.setComponentPopupMenu(cDecksPopupMenu);

        cDecksListbox.setFont(new java.awt.Font("Belwe Bd BT", 0, 14)); // NOI18N
        cDecksListbox.setInheritsPopupMenu(true);
        cDecksScrollPane.setViewportView(cDecksListbox);

        javax.swing.GroupLayout cPanelLayout = new javax.swing.GroupLayout(cPanel);
        cPanel.setLayout(cPanelLayout);
        cPanelLayout.setHorizontalGroup(
            cPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cGeneralLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cClassesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cClassesPane)
                    .addComponent(cGeneralPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cDecksScrollPane)
                    .addGroup(cPanelLayout.createSequentialGroup()
                        .addComponent(cDecksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cPanelLayout.setVerticalGroup(
            cPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cGeneralLabel)
                    .addComponent(cDecksLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cPanelLayout.createSequentialGroup()
                        .addComponent(cGeneralPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cClassesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cClassesPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cDecksScrollPane))
                .addContainerGap())
        );

        tabbedPane.addTab("<html><body leftmargin=15 topmargin=10 marginwidth=15 marginheight=73>Constructed</body></html>", cPanel);

        menu.setText("File");

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        menu.add(helpMenuItem);
        menu.add(jSeparator1);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aOpenDeckMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aOpenDeckMenuItemActionPerformed
        if(aDecksListbox.getSelectedValue() == null){
            UI.getInstance().displayError("No deck is selected.");
        }
        DeckEditWindow deckEditWindow = new DeckEditWindow((Deck)aDecksListbox.getSelectedValue(), this);
        deckEditWindow.setVisible(true);
    }//GEN-LAST:event_aOpenDeckMenuItemActionPerformed

    private void cOpenDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cOpenDeckActionPerformed
        if(cDecksListbox.getSelectedValue() == null){
            UI.getInstance().displayError("No deck is selected.");
        }
        DeckEditWindow deckEditWindow = new DeckEditWindow((Deck)cDecksListbox.getSelectedValue(), this);
        deckEditWindow.setVisible(true);
    }//GEN-LAST:event_cOpenDeckActionPerformed

    private void aAddDeckMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aAddDeckMenuItemActionPerformed
        NewDeckDialog newDeckDialog = new NewDeckDialog("Arena", this, true);
        newDeckDialog.setVisible(true);
    }//GEN-LAST:event_aAddDeckMenuItemActionPerformed

    private void aDeleteDeckMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aDeleteDeckMenuItemActionPerformed
        if(aDecksListbox.getSelectedValue() == null){
            UI.getInstance().displayError("No deck is selected.");
        }
        if(UI.getInstance().displayConfirm("Are you sure you want to delete this deck? All data will be lost.")){
            try {
                Logic.getInstance().deleteDeck((Deck)aDecksListbox.getSelectedValue());
            } catch (Exception ex) {
                UI.getInstance().displayError(ex.getMessage());
                return;
            }
            update();
            UI.getInstance().displayInfo("Deck deleted.");
        }
    }//GEN-LAST:event_aDeleteDeckMenuItemActionPerformed

    private void cAddDeckMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAddDeckMenuItemActionPerformed
        NewDeckDialog newDeckDialog = new NewDeckDialog("Constructed", this, true);
        newDeckDialog.setVisible(true);
    }//GEN-LAST:event_cAddDeckMenuItemActionPerformed

    private void cDeleteDeckMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDeleteDeckMenuItemActionPerformed
        if(cDecksListbox.getSelectedValue() == null){
            UI.getInstance().displayError("No deck is selected.");
        }
        if(UI.getInstance().displayConfirm("Are you sure you want to delete this deck? All data will be lost.")){
            try {
                Logic.getInstance().deleteDeck((Deck)cDecksListbox.getSelectedValue());
                update();
            } catch (Exception ex) {
                UI.getInstance().displayError(ex.getMessage());
                return;
            }
        }
        update();
        UI.getInstance().displayInfo("Deck deleted.");
    }//GEN-LAST:event_cDeleteDeckMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        try {
            Logic.getInstance().openHelpFile();
        } catch (Exception ex) {
            UI.getInstance().displayError(ex.getMessage());
        }
    }//GEN-LAST:event_helpMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aAddDeckMenuItem;
    private javax.swing.JLabel aClassesLabel;
    private javax.swing.JLayeredPane aClassesPane;
    private javax.swing.JButton aCoinButton;
    private javax.swing.JLabel aCoinLossesLabel;
    private javax.swing.JLabel aCoinWinrateLabel;
    private javax.swing.JLabel aCoinWinsLabel;
    private javax.swing.JList aDecksListbox;
    private javax.swing.JPopupMenu aDecksPopupMenu;
    private javax.swing.JScrollPane aDecksScrollPane;
    private javax.swing.JMenuItem aDeleteDeckMenuItem;
    private javax.swing.JButton aDruidButton;
    private javax.swing.JLabel aDruidLossesLabel;
    private javax.swing.JLabel aDruidWinrateLabel;
    private javax.swing.JLabel aDruidWinsLabel;
    private javax.swing.JLabel aGeneralLabel;
    private javax.swing.JLayeredPane aGeneralPane;
    private javax.swing.JButton aHunterButton;
    private javax.swing.JLabel aHunterLossesLabel;
    private javax.swing.JLabel aHunterWinrateLabel;
    private javax.swing.JLabel aHunterWinsLabel;
    private javax.swing.JButton aMageButton;
    private javax.swing.JLabel aMageLossesLabel;
    private javax.swing.JLabel aMageWinrateLabel;
    private javax.swing.JLabel aMageWinsLabel;
    private javax.swing.JButton aNoCoinButton;
    private javax.swing.JLabel aNoCoinLossesLabel;
    private javax.swing.JLabel aNoCoinWinrateLabel;
    private javax.swing.JLabel aNoCoinWinsLabel;
    private javax.swing.JMenuItem aOpenDeckMenuItem;
    private javax.swing.JButton aPaladinButton;
    private javax.swing.JLabel aPaladinLossesLabel;
    private javax.swing.JLabel aPaladinWinrateLabel;
    private javax.swing.JLabel aPaladinWinsLabel;
    private javax.swing.JPanel aPanel;
    private javax.swing.JButton aPriestButton;
    private javax.swing.JLabel aPriestLossesLabel;
    private javax.swing.JLabel aPriestWinrateLabel;
    private javax.swing.JLabel aPriestWinsLabel;
    private javax.swing.JButton aRogueButton;
    private javax.swing.JLabel aRogueLossesLabel;
    private javax.swing.JLabel aRogueWinrateLabel;
    private javax.swing.JLabel aRogueWinsLabel;
    private javax.swing.JLabel aRunsLabel;
    private javax.swing.JPopupMenu.Separator aSeparator;
    private javax.swing.JButton aShamanButton;
    private javax.swing.JLabel aShamanLossesLabel;
    private javax.swing.JLabel aShamanWinrateLabel;
    private javax.swing.JLabel aShamanWinsLabel;
    private javax.swing.JLabel aTotalLossesLabel;
    private javax.swing.JLabel aTotalWinPercentageLabel;
    private javax.swing.JLabel aTotalWinrateLabel;
    private javax.swing.JLabel aTotalWinsLabel;
    private javax.swing.JButton aWarlockButton;
    private javax.swing.JLabel aWarlockLossesLabel;
    private javax.swing.JLabel aWarlockWinrateLabel;
    private javax.swing.JLabel aWarlockWinsLabel;
    private javax.swing.JButton aWarriorButton;
    private javax.swing.JLabel aWarriorLossesLabel;
    private javax.swing.JLabel aWarriorWinrateLabel;
    private javax.swing.JLabel aWarriorWinsLabel;
    private javax.swing.JMenuItem cAddDeckMenuItem;
    private javax.swing.JLabel cClassesLabel;
    private javax.swing.JLayeredPane cClassesPane;
    private javax.swing.JButton cCoinButton;
    private javax.swing.JLabel cCoinLossesLabel;
    private javax.swing.JLabel cCoinWinrateLabel;
    private javax.swing.JLabel cCoinWinsLabel;
    private javax.swing.JLabel cDecksLabel;
    private javax.swing.JList cDecksListbox;
    private javax.swing.JPopupMenu cDecksPopupMenu;
    private javax.swing.JScrollPane cDecksScrollPane;
    private javax.swing.JMenuItem cDeleteDeckMenuItem;
    private javax.swing.JButton cDruidButton;
    private javax.swing.JLabel cDruidLossesLabel;
    private javax.swing.JLabel cDruidWinrateLabel;
    private javax.swing.JLabel cDruidWinsLabel;
    private javax.swing.JLabel cGeneralLabel;
    private javax.swing.JLayeredPane cGeneralPane;
    private javax.swing.JButton cHunterButton;
    private javax.swing.JLabel cHunterLossesLabel;
    private javax.swing.JLabel cHunterWinrateLabel;
    private javax.swing.JLabel cHunterWinsLabel;
    private javax.swing.JButton cMageButton;
    private javax.swing.JLabel cMageLossesLabel;
    private javax.swing.JLabel cMageWinrateLabel;
    private javax.swing.JLabel cMageWinsLabel;
    private javax.swing.JButton cNoCoinButton;
    private javax.swing.JLabel cNoCoinLossesLabel;
    private javax.swing.JLabel cNoCoinWinrateLabel;
    private javax.swing.JLabel cNoCoinWinsLabel;
    private javax.swing.JMenuItem cOpenDeck;
    private javax.swing.JButton cPaladinButton;
    private javax.swing.JLabel cPaladinLossesLabel;
    private javax.swing.JLabel cPaladinWinrateLabel;
    private javax.swing.JLabel cPaladinWinsLabel;
    private javax.swing.JPanel cPanel;
    private javax.swing.JButton cPriestButton;
    private javax.swing.JLabel cPriestLossesLabel;
    private javax.swing.JLabel cPriestWinrateLabel;
    private javax.swing.JLabel cPriestWinsLabel;
    private javax.swing.JButton cRogueButton;
    private javax.swing.JLabel cRogueLossesLabel;
    private javax.swing.JLabel cRogueWinrateLabel;
    private javax.swing.JLabel cRogueWinsLabel;
    private javax.swing.JPopupMenu.Separator cSeparator;
    private javax.swing.JButton cShamanButton;
    private javax.swing.JLabel cShamanLossesLabel;
    private javax.swing.JLabel cShamanWinrateLabel;
    private javax.swing.JLabel cShamanWinsLabel;
    private javax.swing.JLabel cTotalLossesLabel;
    private javax.swing.JLabel cTotalWinPercentageLabel;
    private javax.swing.JLabel cTotalWinrateLabel;
    private javax.swing.JLabel cTotalWinsLabel;
    private javax.swing.JButton cWarlockButton;
    private javax.swing.JLabel cWarlockLossesLabel;
    private javax.swing.JLabel cWarlockWinrateLabel;
    private javax.swing.JLabel cWarlockWinsLabel;
    private javax.swing.JButton cWarriorButton;
    private javax.swing.JLabel cWarriorLossesLabel;
    private javax.swing.JLabel cWarriorWinrateLabel;
    private javax.swing.JLabel cWarriorWinsLabel;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel oAccoladesLabel;
    private javax.swing.JPanel oAccoladesPane;
    private javax.swing.JLabel oArenaLabel;
    private javax.swing.JLabel oArenaLabel1;
    private javax.swing.JButton oBestPerformanceArenaButton;
    private javax.swing.JLabel oBestPerformanceArenaLabel;
    private javax.swing.JButton oBestPerformanceConstrcutedButton;
    private javax.swing.JLabel oBestPerformanceConstructedLabel;
    private javax.swing.JLabel oBestPerformanceLabel;
    private javax.swing.JLabel oClassesLabel;
    private javax.swing.JLayeredPane oClassesPane;
    private javax.swing.JButton oCoinButton;
    private javax.swing.JLabel oCoinLossesLabel;
    private javax.swing.JLabel oCoinWinrateLabel;
    private javax.swing.JLabel oCoinWinsLabel;
    private javax.swing.JLabel oConstrucedLabel;
    private javax.swing.JLabel oConstructedLabel1;
    private javax.swing.JButton oDruidButton;
    private javax.swing.JLabel oDruidLossesLabel;
    private javax.swing.JLabel oDruidWinrateLabel;
    private javax.swing.JLabel oDruidWinsLabel;
    private javax.swing.JLabel oGeneralLabel;
    private javax.swing.JLayeredPane oGeneralPane;
    private javax.swing.JButton oHunterButton;
    private javax.swing.JLabel oHunterLossesLabel;
    private javax.swing.JLabel oHunterWinrateLabel;
    private javax.swing.JLabel oHunterWinsLabel;
    private javax.swing.JButton oMageButton;
    private javax.swing.JLabel oMageLossesLabel;
    private javax.swing.JLabel oMageWinrateLabel;
    private javax.swing.JLabel oMageWinsLabel;
    private javax.swing.JLabel oMaxArenaWinsLabel;
    private javax.swing.JLabel oMaxArenaWinsNumberLabel;
    private javax.swing.JButton oMostPlayedArenaButton;
    private javax.swing.JLabel oMostPlayedArenaLabel;
    private javax.swing.JButton oMostPlayedConstructedButton;
    private javax.swing.JLabel oMostPlayedConstructedLabel;
    private javax.swing.JLabel oMostPlayedLabel;
    private javax.swing.JButton oNoCoinButton;
    private javax.swing.JLabel oNoCoinLossesLabel;
    private javax.swing.JLabel oNoCoinWinrateLabel;
    private javax.swing.JLabel oNoCoinWinsLabel;
    private javax.swing.JButton oPaladinButton;
    private javax.swing.JLabel oPaladinLossesLabel;
    private javax.swing.JLabel oPaladinWinrateLabel;
    private javax.swing.JLabel oPaladinWinsLabel;
    private javax.swing.JPanel oPanel;
    private javax.swing.JButton oPriestButton;
    private javax.swing.JLabel oPriestLossesLabel;
    private javax.swing.JLabel oPriestWinrateLabel;
    private javax.swing.JLabel oPriestWinsLabel;
    private javax.swing.JButton oRogueButton;
    private javax.swing.JLabel oRogueLossesLabel;
    private javax.swing.JLabel oRogueWinrateLabel;
    private javax.swing.JLabel oRogueWinsLabel;
    private javax.swing.JButton oShamanButton;
    private javax.swing.JLabel oShamanLossesLabel;
    private javax.swing.JLabel oShamanWinrateLabel;
    private javax.swing.JLabel oShamanWinsLabel;
    private javax.swing.JLabel oTotalLossesLabel;
    private javax.swing.JLabel oTotalWinPercentageLabel;
    private javax.swing.JLabel oTotalWinrateLabel;
    private javax.swing.JLabel oTotalWinsLabel;
    private javax.swing.JButton oWarlockButton;
    private javax.swing.JLabel oWarlockLossesLabel;
    private javax.swing.JLabel oWarlockWinrateLabel;
    private javax.swing.JLabel oWarlockWinsLabel;
    private javax.swing.JButton oWarriorButton;
    private javax.swing.JLabel oWarriorLossesLabel;
    private javax.swing.JLabel oWarriorWinrateLabel;
    private javax.swing.JLabel oWarriorWinsLabel;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
